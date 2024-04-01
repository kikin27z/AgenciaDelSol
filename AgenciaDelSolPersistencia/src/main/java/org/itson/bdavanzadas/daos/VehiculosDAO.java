package org.itson.bdavanzadas.daos;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.Automovil;
import org.itson.bdavanzadas.entidades.Vehiculo;

/**
 * Clase que proporciona métodos para acceder y manipular la entidad Vehiculo en la base de datos.
 * Esta clase implementa la interfaz IVehiculosDAO.
 * 
 * Los métodos disponibles incluyen agregar un vehículo a la base de datos, buscar un vehículo por su número de serie
 * y verificar si ya existe un vehículo con el mismo número de serie en la base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class VehiculosDAO implements IVehiculosDAO{
    final IConexion conexion;
    static final Logger logger = Logger.getLogger(VehiculosDAO.class.getName());

    /**
    * Constructor de la clase VehiculosDAO.
    *
    * @param conexion La conexión a la base de datos que se utilizará para realizar operaciones de persistencia.
    */
    public VehiculosDAO(IConexion conexion) {
        this.conexion = conexion;
    }
    
    /**
     * Agrega un vehiculo a la base de datos.
     * 
     * @param vehiculo El vehiculo que se va a agregar.
     * @return El automóvil agregado.
     * @throws PersistenceException Si ocurre un error durante la persistencia.
     */
    @Override
    public Vehiculo agregarAutomovil(Vehiculo vehiculo) throws PersistenceException {
        // Obtenemos acceso a la Fábrica de entityManagers
        EntityManager entityManager = conexion.crearConexion();
            
//         Iniciamos una transaccion nueva
        entityManager.getTransaction().begin();
        
        // Marca el jugador nuevo para guardarlo
        entityManager.persist(vehiculo);
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();
        
        entityManager.close();
        return vehiculo;
    }
    
    
 
    /**
     * Busca un vehículo en la base de datos utilizando el número de serie.
     * 
     * @param vehiculo El vehículo con el número de serie a buscar.
     * @return El vehículo encontrado.
     * @throws PersistenceException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Vehiculo buscarVehiculo(Vehiculo vehiculo) throws PersistenceException {
        EntityManager entityManager = conexion.crearConexion();
        //Objeto constructor de consultas
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //Objeto consulta se está construyendo
        CriteriaQuery<Vehiculo> criteria = builder.createQuery(Vehiculo.class);
        
        Root<Vehiculo> root = criteria.from(Vehiculo.class);
        criteria.select(root).
                where( builder.equal(root.get("numeroSerie"),vehiculo.getNumeroSerie()));
        
        //Consulta contruida
        TypedQuery<Vehiculo> query = entityManager.createQuery(criteria);
        
        Vehiculo vehiculoBuscar = query.getSingleResult();
        entityManager.close();
        return vehiculoBuscar;
    }

     /**
     * Verifica si ya existe un vehículo con el mismo número de serie en la base de datos.
     * 
     * @param vehiculo El vehículo con el número de serie a verificar.
     * @return true si ya existe un vehículo con el mismo número de serie, false de lo contrario.
     */
    @Override
    public boolean existeNumeroSerie(Vehiculo vehiculo) {
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Vehiculo> root = criteria.from(Vehiculo.class);
        criteria.select(builder.count(root));
        criteria.where(builder.equal(root.get("numeroSerie"), vehiculo.getNumeroSerie())); 
        TypedQuery<Long> query = entityManager.createQuery(criteria);
        Long count = query.getSingleResult();

        entityManager.close();
        return count > 0;
    }

}
