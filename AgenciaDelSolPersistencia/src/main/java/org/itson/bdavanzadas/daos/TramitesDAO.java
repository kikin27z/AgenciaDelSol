/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.Tramite;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta clase implementa la interfaz ITramitesDAO y proporciona los métodos
 * necesarios para realizar operaciones relacionadas con la entidad Tramite en
 * la base de datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class TramitesDAO implements ITramitesDAO {

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(TramitesDAO.class.getName());

    /**
     * Constructor de la clase TramitesDAO.
     *
     * Este constructor inicializa un objeto TramitesDAO con la conexión a la
     * base de datos proporcionada.
     *
     * @param conexion Objeto que representa la conexión a la base de datos.
     */
    public TramitesDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    /**
     * Consulta los trámites según los criterios especificados.
     *
     * @return Una lista de trámites que coinciden con los criterios de
     * consulta.
     * @throws PersistenciaException Si ocurre un error durante la consulta en
     * la base de datos.
     */
    @Override
    public List<Tramite> consultarTramites() throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        List<Object[]> resultados = null;
        List<Tramite> historialTramites = new ArrayList<>();

        try {
            Query query = entityManager.createQuery("SELECT t.tipo, t.costo, t.fechaEmision FROM Tramite t");
            resultados = query.getResultList();
            for (Object[] resultado : resultados) {
            String tipo = (String) resultado[0]; // Suponiendo que el tipo es un String
            Float costo = (Float) resultado[1]; // Suponiendo que el costo es un Float
            Calendar fechaEmision = (Calendar) resultado[2]; // Suponiendo que la fecha de emisión es un Calendar
            
            // Crear un nuevo objeto Tramite con los valores obtenidos
            Tramite tramite = new Tramite();
            tramite.setTipo(tipo);
            tramite.setCosto(costo);
            tramite.setFechaEmision(fechaEmision);
            
            historialTramites.add(tramite);
        }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los trámites: " + e.getMessage());
        } finally {
            entityManager.close();
        }

        
        
        return historialTramites;
    }

//     CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Tramite> criteriaQuery = criteriaBuilder.createQuery(Tramite.class);
//        Root<Tramite> root = criteriaQuery.from(Tramite.class);
//        Join<Tramite, Persona> personaJoin = root.join("persona");
//
//        // Construir el predicado para filtrar por tipo de trámite
//        Predicate tipoPlacaPredicate = criteriaBuilder.equal(root.type(), Placa.class);
//        Predicate tipoLicenciaPredicate = criteriaBuilder.equal(root.type(), Licencia.class);
//        Predicate tipoPredicate = criteriaBuilder.or(tipoPlacaPredicate, tipoLicenciaPredicate);
//
//        // Construir el predicado para filtrar por nombre de persona
//        Predicate nombrePredicate = criteriaBuilder.like(personaJoin.get("nombres"), "%" + tramite.getPersona().getNombres() + "%");
//
//        // Construir el predicado para filtrar por fecha de emisión
//        Predicate fechaPredicate = criteriaBuilder.between(root.get("fechaEmision"), tramite.getFechaEmision(), Calendar.getInstance());
//
//        // Combinar los predicados
//        Predicate finalPredicate = criteriaBuilder.and(tipoPredicate, nombrePredicate, fechaPredicate);
//
//        criteriaQuery.select(root)
//                .where(finalPredicate)
//                .orderBy(criteriaBuilder.desc(root.get("fechaEmision")));
//
//        List<Tramite> tramites = entityManager.createQuery(criteriaQuery).getResultList();
//        entityManager.close();
}
