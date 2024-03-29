package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.avisos.Aviso;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.TramiteDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ITramitesDAO;
import org.itson.bdavanzadas.daos.TramitesDAO;
import org.itson.bdavanzadas.entidades.Discapacidad;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.TipoTramite;
import org.itson.bdavanzadas.entidades.Tramite;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Clase que implementa la interfaz ITramitesBO y proporciona los métodos para
 * realizar operaciones relacionadas con los trámites.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class TramitesBO implements ITramitesBO {

    private ITramitesDAO tramitesDAO;
    static final Logger logger = Logger.getLogger(TramitesDAO.class.getName());
    private IConexion conexion;

    /**
     * Constructor de la clase TramitesBO. inicializa la conexión a la base de
     * datos y el objeto de acceso a datos (DAO) correspondiente.
     */
    public TramitesBO() {
        this.conexion = new Conexion();
        this.tramitesDAO = new TramitesDAO(conexion);
    }

    /**
     * Consulta los trámites que coinciden con los criterios especificados en el
     * objeto TramiteDTO.
     *
     * @return Una lista de objetos TramiteDTO que representan los trámites
     * encontrados.
     */
    @Override
    public List<TramiteDTO> consultarTramites() {
        try {
            List<Tramite> tramitesEncontrados = tramitesDAO.consultarTramites();
            List<TramiteDTO> tramitesDTOEncontrados = new LinkedList<>();

            for (Tramite tramitesEncontrado : tramitesEncontrados) {
                TramiteDTO tramite = new TramiteDTO(
                        tramitesEncontrado.getFechaEmision(),
                        tramitesEncontrado.getCosto(),
                        tramitesEncontrado.getTipo(),
                        fromPersona(tramitesEncontrado.getPersona()));

                tramitesDTOEncontrados.add(tramite);
            }
            return tramitesDTOEncontrados;
        } catch (PersistenciaException ex) {
            Logger.getLogger(TramitesBO.class.getName()).log(Level.SEVERE, "No fue posible consultar la lista de tramites");
            return null;
        }
    }

    @Override
    public List<TramiteDTO> consultarTramitesPorTipo(String tipo) {
        try {
            List<Tramite> tramitesEncontrados = tramitesDAO.consultarTramitesPorTipo(tipo);
            List<TramiteDTO> tramitesDTOEncontrados = new LinkedList<>();

            for (Tramite tramitesEncontrado : tramitesEncontrados) {
                TramiteDTO tramite = new TramiteDTO(
                        tramitesEncontrado.getFechaEmision(),
                        tramitesEncontrado.getCosto(),
                        tramitesEncontrado.getTipo(),
                        fromPersona(tramitesEncontrado.getPersona()));

                tramitesDTOEncontrados.add(tramite);
            }
            return tramitesDTOEncontrados;
        } catch (PersistenciaException ex) {
            Logger.getLogger(TramitesBO.class.getName()).log(Level.SEVERE, "No fue posible consultar la lista de tramites por tipo");
            return null;
        }
    }

    // Método para convertir Persona a ConsultarPersonaDTO
    private static ConsultarPersonaDTO fromPersona(Persona persona) {
        return new ConsultarPersonaDTO(
                persona.getNombres(),
                persona.getApellidoPaterno(),
                persona.getApellidoMaterno()
        );
    }

}
