package org.itson.bdavanzadas.daos;

import java.util.Calendar;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.encriptar.Encriptacion;
import org.itson.bdavanzadas.entidades.Discapacidad;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta clase implementa la interfaz IPersonasDAO y proporciona métodos para
 * realizar operaciones relacionadas con la entidad Persona en la base de datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class PersonasDAO implements IPersonasDAO {

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(PersonasDAO.class.getName());

    /**
     * Constructor de la clase PersonasDAO.
     *
     * @param conexion La conexión a la base de datos que se utilizará para
     * realizar operaciones de persistencia.
     */
    public PersonasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona Persona nueva a agregar.
     * @return La persona recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la
     * base de datos.
     */
    @Override
    public Persona agregarPersona(Persona persona) throws PersistenciaException {
        // Obtenemos acceso a la Fábrica de entityManagers
        EntityManager entityManager = conexion.crearConexion();

        // Iniciamos una transaccion nueva
        entityManager.getTransaction().begin();

        // Marca el jugador nuevo para guardarlo
        entityManager.persist(persona);
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();

        entityManager.close();
        return persona;
    }

    /**
     * Realiza una inserción masiva de 20 registros de personas, cuando el
     * usuario lo solicita.
     *
     * @throws PersistenciaException Si ocurre un error durante la inserción a
     * la base de datos.
     */
    @Override
    public void insercionMasiva() throws PersistenciaException {
        Calendar fecha = Calendar.getInstance();
        fecha.set(Calendar.YEAR, 2004);
        fecha.set(Calendar.MONTH, Calendar.MARCH); 
        fecha.set(Calendar.DAY_OF_MONTH, 27);
        Persona persona = new Persona("Jose Karim", "Franco", "Valencia", Discapacidad.NORMAL, fecha, "KUBV931119SF4", Encriptacion.encriptar("6442548353"));
        
        Calendar fecha2 = Calendar.getInstance();
        fecha2.set(Calendar.YEAR, 2003);
        fecha2.set(Calendar.MONTH, Calendar.APRIL);
        fecha2.set(Calendar.DAY_OF_MONTH, 4);
        Persona persona2 = new Persona("Adriana", "Gutierrez", "Robles", Discapacidad.DISCAPACITADO, fecha2, "GURA03040431F", Encriptacion.encriptar("6442112147"));
        
        Calendar fecha3 = Calendar.getInstance();
        fecha3.set(Calendar.YEAR, 2017);
        fecha3.set(Calendar.MONTH, Calendar.NOVEMBER);
        fecha3.set(Calendar.DAY_OF_MONTH, 10);
        Persona persona3 = new Persona("Hasbulla", "Magomedovich", "Magomedov", Discapacidad.DISCAPACITADO, fecha3, "HOGJ920518HDF", Encriptacion.encriptar("6621234567"));
        
//        fecha.set(Calendar.YEAR, 1970);
//        fecha.set(Calendar.MONTH, Calendar.APRIL); 
//        fecha.set(Calendar.DAY_OF_MONTH, 19);
//        Persona persona4 = new Persona("Luis Miguel", "Gallego", "Basteri", Discapacidad.NORMAL, fecha, "HEMG880706MDF", Encriptacion.encriptar("6629876543"));
//        
//        fecha.set(Calendar.YEAR, 2004);
//        fecha.set(Calendar.MONTH, Calendar.JUNE); 
//        fecha.set(Calendar.DAY_OF_MONTH, 16);
//        Persona persona5 = new Persona("Victor Humberto", "Encinas", "Guzman", Discapacidad.NORMAL, fecha, "MELM8305281H0", Encriptacion.encriptar("6646787333"));
        
        
        EntityManager entityManager = conexion.crearConexion();

        entityManager.getTransaction().begin();
        entityManager.persist(persona);
        entityManager.persist(persona2);
        entityManager.persist(persona3);
        entityManager.getTransaction().commit();
        
        entityManager.close();
    }

    /**
     * Busca una persona en la base de datos por su RFC.
     *
     * @param persona Objeto Persona que contiene el RFC de la persona a buscar.
     * @return La persona encontrada en la base de datos.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la
     * base de datos.
     */
    @Override
    public Persona consultarPersonaPorRfc(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

            try{
                Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.rfc = :rfc");
                query.setParameter("rfc", persona.getRfc());
                Persona personaConsultada = (Persona) query.getSingleResult();
                return  personaConsultada;
            }catch(NoResultException nre){
                throw new PersistenciaException("RFC inválido, persona inexistente");
            }finally{
                entityManager.close();  
            }
            
    }

}
