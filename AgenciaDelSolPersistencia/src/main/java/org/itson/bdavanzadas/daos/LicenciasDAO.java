package org.itson.bdavanzadas.daos;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.EstadoLicencia;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.entidades.Tramite;

/**
 * Esta clase implementa la interfaz ILicenciasDAO y proporciona métodos para
 * realizar operaciones relacionadas con la entidad Licencia en la base de datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class LicenciasDAO implements ILicenciasDAO{

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(PersonasDAO.class.getName());

    public LicenciasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Licencia tramitarLicencias(Licencia licencia) {
        
        EntityManager em = conexion.crearConexion();
        
        em.getTransaction().begin();
        
        em.persist(licencia);
        
        em.getTransaction().commit();
        
        em.close();
        
        return licencia;
    }

    @Override
    public void desactivarLicencias(Persona persona) {
        EntityManager entityManager = conexion.crearConexion();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteriaQuery = criteriaBuilder.createQuery(Licencia.class);
        Root<Tramite> tramiteRoot = criteriaQuery.from(Tramite.class);
        Join<Tramite, Licencia> licenciaJoin = tramiteRoot.join("licencia");

        Predicate predicate = criteriaBuilder.equal(tramiteRoot.get("persona").get("id"), persona.getId());

        criteriaQuery.select(licenciaJoin).where(predicate);
        
        List<Licencia> licencias = entityManager.createQuery(criteriaQuery).getResultList();
        
        if(licencias != null){
            for (Licencia licencia : licencias) {
                licencia.setEstado(EstadoLicencia.INACTIVA);
            }
        }
    }
    
}
