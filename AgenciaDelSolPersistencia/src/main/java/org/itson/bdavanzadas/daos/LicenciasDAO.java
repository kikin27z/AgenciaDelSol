package org.itson.bdavanzadas.daos;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.EstadoLicencia;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;

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
        
        Query query = entityManager.createQuery("SELECT l FROM Logro l ORDER BY l.puntos DESC");
        
        List<Licencia> licencias = (List<Licencia>) query.getResultList();
        
        
//        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//
//        CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
//        Root<Licencia> root = criteria.from(Licencia.class);
//        
//        criteria.select(root).where(builder.equal(root.get("id"), persona.getId())); 
//        TypedQuery<Licencia> query = entityManager.createQuery(criteria);
//        List<Licencia> licencias = query.getResultList();
        
        if(licencias != null){
            for (Licencia licencia : licencias) {
                licencia.setEstado(EstadoLicencia.INACTIVA);
            }
        }
    }
    
}
