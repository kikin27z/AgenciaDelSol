package org.itson.bdavanzadas.daos;

import java.util.Calendar;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
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
        EntityManager entityManager = conexion.crearConexion();
        
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
        
        Calendar fecha4 = Calendar.getInstance();
        fecha4.set(Calendar.YEAR, 1970);
        fecha4.set(Calendar.MONTH, Calendar.APRIL); 
        fecha4.set(Calendar.DAY_OF_MONTH, 19);
        Persona persona4 = new Persona("Luis Miguel", "Gallego", "Basteri", Discapacidad.NORMAL, fecha4, "HEMG880706MDF", Encriptacion.encriptar("6629876543"));
        
        Calendar fecha5 = Calendar.getInstance();
        fecha5.set(Calendar.YEAR, 2004);
        fecha5.set(Calendar.MONTH, Calendar.JUNE); 
        fecha5.set(Calendar.DAY_OF_MONTH, 15);
        Persona persona5 = new Persona("Victor Humberto", "Encinas", "Guzman", Discapacidad.NORMAL, fecha5, "MELM8305281H0", Encriptacion.encriptar("6646787333"));
        
        Calendar fecha6 = Calendar.getInstance();
        fecha6.set(Calendar.YEAR, 2004);
        fecha6.set(Calendar.MONTH, Calendar.FEBRUARY); 
        fecha6.set(Calendar.DAY_OF_MONTH, 23);
        Persona persona6 = new Persona("Esmeralda", "Molina", "Estrada", Discapacidad.NORMAL, fecha6, "RVJO130213NR3", Encriptacion.encriptar("6447779990"));
        
        Calendar fecha7 = Calendar.getInstance();
        fecha7.set(Calendar.YEAR, 2004);
        fecha7.set(Calendar.MONTH, Calendar.MARCH); 
        fecha7.set(Calendar.DAY_OF_MONTH, 19);
        Persona persona7 = new Persona("Jesus Rene", "Gonzalez", "Castro", Discapacidad.NORMAL, fecha7, "GOCJ040119GHA", Encriptacion.encriptar("6442522642"));
        
        Calendar fecha8 = Calendar.getInstance();
        fecha8.set(Calendar.YEAR, 2004);
        fecha8.set(Calendar.MONTH, Calendar.SEPTEMBER); 
        fecha8.set(Calendar.DAY_OF_MONTH, 2);
        Persona persona8 = new Persona("Gael Rafael", "Castro", "Molina", Discapacidad.NORMAL, fecha8, "CAMG040616IR6", Encriptacion.encriptar("6442266331"));
        
        Calendar fecha9 = Calendar.getInstance();
        fecha9.set(Calendar.YEAR, 2004);
        fecha9.set(Calendar.MONTH, Calendar.DECEMBER); 
        fecha9.set(Calendar.DAY_OF_MONTH, 16);
        Persona persona9 = new Persona("Oliver", "Inzunza", "Valle", Discapacidad.NORMAL, fecha9, "IUVO0407069Z3", Encriptacion.encriptar("6871568089"));
        
        Calendar fecha10 = Calendar.getInstance();
        fecha10.set(Calendar.YEAR, 2004);
        fecha10.set(Calendar.MONTH, Calendar.JANUARY); 
        fecha10.set(Calendar.DAY_OF_MONTH, 5);
        Persona persona10 = new Persona("Marian Isabel", "Valdez", "Villa", Discapacidad.NORMAL, fecha10, "VAVM040105L89", Encriptacion.encriptar("6442522643"));
        
        Calendar fecha11 = Calendar.getInstance();
        fecha11.set(Calendar.YEAR, 2004);
        fecha11.set(Calendar.MONTH, Calendar.NOVEMBER); 
        fecha11.set(Calendar.DAY_OF_MONTH, 27);
        Persona persona11 = new Persona("Jose Angel", "Huerta", "Amparan", Discapacidad.DISCAPACITADO, fecha11, "HAJA040401JC0", Encriptacion.encriptar("6442577645"));
        
        Calendar fecha12 = Calendar.getInstance();
        fecha12.set(Calendar.YEAR, 2004);
        fecha12.set(Calendar.MONTH, Calendar.SEPTEMBER); 
        fecha12.set(Calendar.DAY_OF_MONTH, 21);
        Persona persona12 = new Persona("Hector Alberto", "Espinoza", "Duarte", Discapacidad.NORMAL, fecha12, "ESDH040921GX8", Encriptacion.encriptar("6447879390"));
        
        Calendar fecha13 = Calendar.getInstance();
        fecha13.set(Calendar.YEAR, 2004);
        fecha13.set(Calendar.MONTH, Calendar.MARCH); 
        fecha13.set(Calendar.DAY_OF_MONTH, 21);
        Persona persona13 = new Persona("Ricardo Alan", "Garces", "Gutierrez", Discapacidad.NORMAL, fecha13, "GAGR040321611", Encriptacion.encriptar("6443522643"));
        
        Calendar fecha14 = Calendar.getInstance();
        fecha14.set(Calendar.YEAR, 2004);
        fecha14.set(Calendar.MONTH, Calendar.JULY); 
        fecha14.set(Calendar.DAY_OF_MONTH, 6);
        Persona persona14 = new Persona("Jose Luis", "Madero", "Lopez", Discapacidad.DISCAPACITADO, fecha14, "MALL040626M67", Encriptacion.encriptar("678282828"));
        
        Calendar fecha15 = Calendar.getInstance();
        fecha15.set(Calendar.YEAR, 2004);
        fecha15.set(Calendar.MONTH, Calendar.MARCH); 
        fecha15.set(Calendar.DAY_OF_MONTH, 26);
        Persona persona15 = new Persona("Jose Maria", "Armenta", "Baca", Discapacidad.DISCAPACITADO, fecha15, "ARBM040626MD0", Encriptacion.encriptar("6623856789"));
        
        Calendar fecha16 = Calendar.getInstance();
        fecha16.set(Calendar.YEAR, 1989);
        fecha16.set(Calendar.MONTH, Calendar.FEBRUARY); 
        fecha16.set(Calendar.DAY_OF_MONTH, 10);
        Persona persona16 = new Persona("Christian Gibran", "Duran", "Solano", Discapacidad.NORMAL, fecha16, "DSCG890210MD0", Encriptacion.encriptar("6624567890"));
        
        Calendar fecha17 = Calendar.getInstance();
        fecha17.set(Calendar.YEAR, 2004);
        fecha17.set(Calendar.MONTH, Calendar.MARCH); 
        fecha17.set(Calendar.DAY_OF_MONTH, 4);
        Persona persona17 = new Persona("Enrique", "Rodriguez", "Angulo", Discapacidad.DISCAPACITADO, fecha17, "ROAE040304DD0", Encriptacion.encriptar("6447890123"));
        
        Calendar fecha18 = Calendar.getInstance();
        fecha18.set(Calendar.YEAR, 2004);
        fecha18.set(Calendar.MONTH, Calendar.MAY); 
        fecha18.set(Calendar.DAY_OF_MONTH, 11);
        Persona persona18 = new Persona("Ismael", "Gomez", "Esquer", Discapacidad.NORMAL, fecha18, "GOES040511DD0", Encriptacion.encriptar("6627890123"));
        
        Calendar fecha19 = Calendar.getInstance();
        fecha19.set(Calendar.YEAR, 2004);
        fecha19.set(Calendar.MONTH, Calendar.MAY); 
        fecha19.set(Calendar.DAY_OF_MONTH, 11);
        Persona persona19 = new Persona("David", "Arvizu", "Duarte", Discapacidad.DISCAPACITADO, fecha19, "ARDD041207R43", Encriptacion.encriptar("6442678902"));
        
        Calendar fecha20 = Calendar.getInstance();
        fecha20.set(Calendar.YEAR, 1955);
        fecha20.set(Calendar.MONTH, Calendar.FEBRUARY); 
        fecha20.set(Calendar.DAY_OF_MONTH, 24);
        Persona persona20 = new Persona("Steve", "Jobs", "Paul", Discapacidad.DISCAPACITADO, fecha20, "PAJO550224APP", Encriptacion.encriptar("6552349391"));
        
        
        
        
        entityManager.getTransaction().begin();
        entityManager.persist(persona);
        entityManager.persist(persona2);
        entityManager.persist(persona3);
        entityManager.persist(persona4);
        entityManager.persist(persona5);
        entityManager.persist(persona6);
        entityManager.persist(persona7);
        entityManager.persist(persona8);
        entityManager.persist(persona9);
        entityManager.persist(persona10);
        entityManager.persist(persona11);
        entityManager.persist(persona12);
        entityManager.persist(persona13);
        entityManager.persist(persona14);
        entityManager.persist(persona15);
        entityManager.persist(persona16);
        entityManager.persist(persona17);
        entityManager.persist(persona18);
        entityManager.persist(persona19);
        entityManager.persist(persona20);
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

        try {
            Query query = entityManager.createQuery("SELECT p FROM Persona p WHERE p.rfc = :rfc");
            query.setParameter("rfc", persona.getRfc());
            Persona personaConsultada = (Persona) query.getSingleResult();
            return personaConsultada;
        } catch (NoResultException nre) {
            throw new PersistenciaException("RFC inválido, persona inexistente");
        } finally {
            entityManager.close();
        }
    }
    
    

     /**
     * Verifica si existen registros de personas.
     * 
     * @return true si hay registros de personas, false si la tabla está vacía.
     */
    @Override
    public boolean hayRegistros() {
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

       CriteriaQuery<Long> criteria = builder.createQuery(Long.class); 
        Root<Persona> root = criteria.from(Persona.class);
        criteria.select(builder.count(root)); 
        TypedQuery<Long> query = entityManager.createQuery(criteria);
        Long count = query.getSingleResult(); 

        entityManager.close();
        return count != 0;
    }
}
