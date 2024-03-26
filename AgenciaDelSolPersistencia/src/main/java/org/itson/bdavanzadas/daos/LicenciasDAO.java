package org.itson.bdavanzadas.daos;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.EstadoLicencia;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta clase implementa la interfaz ILicenciasDAO y proporciona métodos para
 * realizar operaciones relacionadas con la entidad Licencia en la base de
 * datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class LicenciasDAO implements ILicenciasDAO {

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(LicenciasDAO.class.getName());

    /**
     * Constructor de la clase LicenciasDAO.
     *
     * Este constructor inicializa un objeto LicenciasDAO con la conexión a la
     * base de datos proporcionada.
     *
     * @param conexion Objeto que representa la conexión a la base de datos.
     */
    public LicenciasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Tramita una nueva licencia en el sistema.
     *
     * @param licencia Objeto Licencia que se va a tramitar.
     * @return La licencia tramitada.
     */
    @Override
    public Licencia tramitarLicencias(Licencia licencia) {

        EntityManager em = conexion.crearConexion();

        em.getTransaction().begin();

        em.persist(licencia);

        em.getTransaction().commit();

        em.close();

        return licencia;
    }

    /**
     * Desactiva todas las licencias asociadas a una persona.
     *
     * @param persona Objeto Persona para el cual se desactivarán las licencias.
     */
    @Override
    public void desactivarLicencias(Persona persona) {
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteria = cb.createQuery(Licencia.class); 
        Root<Licencia> root = criteria.from(Licencia.class);
        criteria.select(root).where(cb.equal(root.get("persona").get("rfc"),persona.getRfc())); 
        TypedQuery<Licencia> query = entityManager.createQuery(criteria);
        List<Licencia> licencias = query.getResultList(); 
        
        //Commienza a cambiar el estado de las licencias previas
        entityManager.getTransaction().begin();
            for (Licencia licencia : licencias) {
                licencia.setEstado(EstadoLicencia.INACTIVA);
            }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * Verifica si una persona tiene una licencia vigente en el sistema.
     *
     * @param persona La persona de la cual se va a verificar la licencia.
     * @throws PersistenciaException Si ocurre un error durante la verificación.
     */
    @Override
    public void tieneLicenciaVigente(Persona persona) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteria = cb.createQuery(Licencia.class); 
        Root<Licencia> root = criteria.from(Licencia.class);
        criteria.select(root)
                .where(cb.equal(root.get("persona").get("rfc"),persona.getRfc()))
                .orderBy(cb.desc(root.get("fechaEmision"))); 
        TypedQuery<Licencia> query = entityManager.createQuery(criteria);
        List<Licencia> licencias = query.getResultList(); 
        
        //Commienza a cambiar el estado de las licencias previas
            for (Licencia licencia : licencias) {
                if(licencia.getEstado().equals(EstadoLicencia.ACTIVA)){
                    return;
                }
            }
            throw new PersistenciaException("No tiene licencias vigentes para tramitar una placa");
    }
}


