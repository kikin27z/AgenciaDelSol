package org.itson.bdavanzadas.daos;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.EstadoPlaca;
import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.Vehiculo;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta clase proporciona métodos para interactuar con la entidad Placa en la base de datos.
 * Permite agregar nuevas placas, desactivar placas asociadas a un vehículo, verificar la existencia de un número de placa
 * y buscar un vehículo asociado a una placa.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class PlacasDAO implements IPlacasDAO{

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(PlacasDAO.class.getName());

    /**
     * Constructor de la clase PlacasDAO.
     *
     * Este constructor inicializa un objeto PlacasDAO con la conexión a la
     * base de datos proporcionada.
     *
     * @param conexion Objeto que representa la conexión a la base de datos.
     */
    public PlacasDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Agrega una nueva placa al sistema.
     *
     * @param placa La placa que se va a agregar.
     * @return La placa agregada.
     */
    @Override
    public Placa agregarPlaca(Placa placa) {
        // Obtenemos acceso a la Fábrica de entityManagers
        EntityManager entityManager = conexion.crearConexion();

        // Iniciamos una transaccion nueva
        entityManager.getTransaction().begin();

        // Marca el jugador nuevo para guardarlo
        entityManager.persist(placa);
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();

        entityManager.close();
        return placa;
    }

    /**
     * Desactiva todas las placas asociadas a un vehículo.
     *
     * @param vehiculo El vehículo para la cual se desactivarán las placas.
     */
    @Override
    public void desactivarPlacas(Vehiculo vehiculo) {
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Placa> criteria = cb.createQuery(Placa.class); 
        Root<Placa> root = criteria.from(Placa.class);
        criteria.select(root).where(cb.equal(root.get("vehiculo").get("numeroSerie"),vehiculo.getNumeroSerie())); 
        TypedQuery<Placa> query = entityManager.createQuery(criteria);
        List<Placa> placas = query.getResultList(); 
        
        //Commienza a cambiar el estado de las licencias previas
        entityManager.getTransaction().begin();
            for (Placa placa : placas) {
                placa.setEstado(EstadoPlaca.INHABILITADA);
            }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Verifica si un número de placa ya existe en el sistema.
     *
     * @param placa La placa para la cual se verificará la existencia del número.
     * @return true si el número de placa ya existe, false de lo contrario.
     */
    @Override
    public boolean existeNumero(Placa placa) {
       EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        // Definir una expresión de conteo
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root<Placa> rootCount = criteria.from(Placa.class);
        criteria.select(cb.count(rootCount)).where(cb.equal(rootCount.get("numero"), placa.getNumero()));
        Long countResult = entityManager.createQuery(criteria).getSingleResult();

        // Si el conteo es mayor que 0, significa que hay al menos una placa con el número especificado
        return countResult > 0;
    }

    /**
     * Busca una placa en la base de datos utilizando su número.
     *
     * @param placa La placa con el número a buscar.
     * @return La placa encontrada.
     * @throws PersistenciaException Si no se encuentra la placa con el número especificado.
     */
    @Override
    public Placa buscarPlaca(Placa placa) throws PersistenciaException{
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Placa> criteria = cb.createQuery(Placa.class); 
        Root<Placa> root = criteria.from(Placa.class);
        criteria.select(root).where(cb.equal(root.get("numero"),placa.getNumero())); 
        TypedQuery<Placa> query = entityManager.createQuery(criteria);
        Placa placas;
        try {
            placas = (Placa) query.getSingleResult();

        } catch (NoResultException nre) {
            throw new PersistenciaException("Número de placa inexistente");
        } finally {
            entityManager.close();
        }
        
        return placas;
    }

    /**
     * Busca todas las placas las cuales no se hayan entregado.
     * @return lista de placas sin entregar.
     * @throws PersistenciaException Si no ocurre un error en la consulta.
     */
    @Override
    public List<Placa> consultarPlacasSiEmision() throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Placa> query = builder.createQuery(Placa.class);
        Root<Placa> root = query.from(Placa.class);

        // Crear el predicado para filtrar las placas sin fecha de emisión
        Predicate predicate = builder.isNull(root.get("fechaRecepcion"));

        // Agregar el predicado a la consulta
        query.where(predicate);

        // Ejecutar la consulta
        Query q = entityManager.createQuery(query);
        return q.getResultList();
    }

    /**
     * Establece la fecha de recepción en una placa específica.
     *
     * @param numeroPlaca El número de la placa para la cual se establecerá la
     * fecha de recepción.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    @Override
    public void establecerFechaRecepcion(String numeroPlaca) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("UPDATE Placa p SET p.fechaRecepcion = :fechaRecepcion WHERE p.numero = :numeroPlaca");
            query.setParameter("fechaRecepcion", Calendar.getInstance());
            query.setParameter("numeroPlaca", numeroPlaca);
            query.executeUpdate();

            entityManager.getTransaction().commit();
            logger.log(Level.INFO, "Se recibio la placa");

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            logger.log(Level.SEVERE, "Error al establecer fecha de recepción en placa");
        } finally {
            entityManager.close();
        }
    }
}
