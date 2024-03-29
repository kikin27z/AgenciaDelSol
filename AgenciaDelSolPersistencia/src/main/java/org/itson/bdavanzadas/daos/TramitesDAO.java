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
            Query query = entityManager.createQuery("SELECT t.tipo, t.costo, t.fechaEmision, t.persona FROM Tramite t");
            resultados = query.getResultList();
            for (Object[] resultado : resultados) {
                String tipo = (String) resultado[0]; // Suponiendo que el tipo es un String
                Float costo = (Float) resultado[1]; // Suponiendo que el costo es un Float
                Calendar fechaEmision = (Calendar) resultado[2]; // Suponiendo que la fecha de emisión es un Calendar
                Persona persona = (Persona) resultado[3];

                // Crear un nuevo objeto Tramite con los valores obtenidos
                Tramite tramite = new Tramite();
                tramite.setTipo(tipo);
                tramite.setCosto(costo);
                tramite.setFechaEmision(fechaEmision);
                tramite.setPersona(persona);

                historialTramites.add(tramite);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los trámites: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return historialTramites;
    }

    @Override
    public List<Tramite> consultarTramitesPorTipo(String tipo) throws PersistenciaException {
        EntityManager entityManager = conexion.crearConexion();
        List<Object[]> resultados = null;
        List<Tramite> tramitesPorTipo = new ArrayList<>();

        try {
            Query query = entityManager.createQuery("SELECT t.tipo, t.costo, t.fechaEmision, t.persona FROM Tramite t WHERE t.tipo = :tipo");
            query.setParameter("tipo", tipo);
            resultados = query.getResultList();
            for (Object[] resultado : resultados) {
                String tipoResultado = (String) resultado[0]; // Suponiendo que el tipo es un String
                Float costo = (Float) resultado[1]; // Suponiendo que el costo es un Float
                Calendar fechaEmision = (Calendar) resultado[2]; // Suponiendo que la fecha de emisión es un Calendar
                Persona persona = (Persona) resultado[3];

                // Crear un nuevo objeto Tramite con los valores obtenidos
                Tramite tramite = new Tramite();
                tramite.setTipo(tipoResultado);
                tramite.setCosto(costo);
                tramite.setFechaEmision(fechaEmision);
                tramite.setPersona(persona);

                tramitesPorTipo.add(tramite);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los trámites por tipo: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return tramitesPorTipo;
    }

}
