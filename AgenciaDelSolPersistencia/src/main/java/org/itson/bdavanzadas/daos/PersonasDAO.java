package org.itson.bdavanzadas.daos;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
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
        EntityManager entityManager = conexion.crearConexion();

        StoredProcedureQuery insercion
                = entityManager.createNamedStoredProcedureQuery("insercionMasiva");
        insercion.execute();

        entityManager.close();
    }

    @Override
    public Persona consultarPersonaPorCurp(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();

        Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.curp = :curp");
        query.setParameter("curp", persona.getCurp());

        Persona personaConsultada = (Persona) query.getSingleResult();

        entityManager.close();

        return personaConsultada;
    }

}
