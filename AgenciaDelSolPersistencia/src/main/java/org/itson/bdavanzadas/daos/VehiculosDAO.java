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
            
        // Iniciamos una transaccion nueva
        entityManager.getTransaction().begin();
        
        // Marca el jugador nuevo para guardarlo
        entityManager.persist(vehiculo);
        // Manda los cambios de la transacción
        entityManager.getTransaction().commit();
        
        entityManager.close();
        return vehiculo;
    }
    
    
     /**
     * Busca un automóvil en la base de datos.
     * 
     * @param automovil El automóvil que se va a buscar.
     * @return El automóvil encontrado.
     * @throws PersistenceException Si ocurre un error durante la búsqueda.
     */
    @Override
    public Automovil buscarAutomovil(Automovil automovil) throws PersistenceException {
        EntityManager entityManager = conexion.crearConexion();
        //Objeto constructor de consultas
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //Objeto consulta se está construyendo
        CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
        
        Root<Automovil> root = criteria.from(Automovil.class);
        criteria.select(root).
                where( builder.equal(root.get("numeroSerie"),automovil.getNumeroSerie()));
        
        //Consulta contruida
        TypedQuery<Automovil> query = entityManager.createQuery(criteria);
        
        Automovil automovilBuscar = query.getSingleResult();
        entityManager.close();
        return automovilBuscar;
    }

}
