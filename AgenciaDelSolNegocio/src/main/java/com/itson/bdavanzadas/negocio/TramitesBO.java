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
    IConexion conexion;

    /**
     * Constructor de la clase TramitesBO. inicializa la conexión a la base de
     * datos y el objeto de acceso a datos (DAO) correspondiente.
     */
    public TramitesBO() {
        this.tramitesDAO = new TramitesDAO(conexion);
        this.conexion = new Conexion();
    }

    /**
     * Consulta los trámites que coinciden con los criterios especificados en el
     * objeto TramiteDTO.
     *
     * @param tramiteDTO El objeto TramiteDTO que contiene los criterios de
     * consulta, incluyendo la fecha de emisión, la persona asociada al trámite,
     * etc.
     * @return Una lista de objetos TramiteDTO que representan los trámites
     * encontrados.
     * @throws ValidacionDTOException Si ocurre un error durante la consulta en
     * la base de datos.
     */
    @Override
    public List<TramiteDTO> consultarTramites(TramiteDTO tramiteDTO) throws ValidacionDTOException {
        try {
            Tramite tramiteBuscar = new Tramite();
            tramiteBuscar.setFechaEmision(tramiteDTO.getFechaEmision());

            List<Tramite> tramitesEncontrados = tramitesDAO.consultarTramites(tramiteBuscar);
            List<TramiteDTO> tramitesDTOEncontrados = new LinkedList<>();

            if (!tramitesEncontrados.isEmpty()) {
                tramitesEncontrados.forEach(tramite -> {
                    ConsultarPersonaDTO consultarPersona = new ConsultarPersonaDTO(
                            tramite.getPersona().getNombres(),
                            tramite.getPersona().getApellidoPaterno(),
                            tramite.getPersona().getApellidoMaterno()
                    );
                    tramitesDTOEncontrados.add(new TramiteDTO(tramite.getFechaEmision(), consultarPersona));
                });
            }
            return tramitesDTOEncontrados;
        } catch (PersistenciaException ex) {
            throw new ValidacionDTOException(ex.getMessage());
        }
    }

//            if (!tramitesEncontrados.isEmpty()) {
//                List<ConsultarPersonaDTO> personasEncontradas = new ArrayList<>();
//
//                for (Tramite tramite : tramitesEncontrados) {
//
//                    ConsultarPersonaDTO personaDTO = new ConsultarPersonaDTO(
//                            tramite.getPersona().getNombres(),
//                            tramite.getPersona().getApellidoPaterno(),
//                            tramite.getPersona().getApellidoMaterno()
//                    );
//                    personasEncontradas.add(personaDTO);
//
//                    TramiteDTO tramiteDTOEncontrado = new TramiteDTO();
//                    tramiteDTOEncontrado.setFechaEmision(tramite.getFechaEmision());
//                    tramiteDTOEncontrado.setPersona(personaDTO);
//
//                    tramitesEncontrados.add(tramiteDTOEncontrado);
//                }
    /**
     * Consulta los trámites que coinciden con los criterios especificados en el
     * objeto TramiteDTO.
     *
     * @param tramite
     * @param tramiteDTO El objeto TramiteDTO que contiene los criterios de
     * consulta, incluyendo la fecha de emisión, la persona asociada al trámite,
     * etc.
     * @return Una lista de objetos TramiteDTO que representan los trámites
     * encontrados.
     * @throws ValidacionDTOException Si ocurre un error durante la consulta en
     * la base de datos.
     */
    //    public List<TramiteDTO> consultarTramites(TramiteDTO tramiteDTO) throws ValidacionDTOException {
    //        try {
    //            Tramite tramiteBuscar = new Tramite();
    //            tramiteBuscar.setFechaEmision(tramiteDTO.getFechaEmision());
    //            tramiteBuscar.setPersona(tramiteDTO.getPersona());
    //            List<Tramite> tramitesEncontrados = tramitesDAO.consultarTramites(tramiteBuscar);
    //
    //            // Lista para almacenar los resultados encontrados
    //            List<TramiteDTO> tramitesDTO = new ArrayList<>();
    //
    //            for (Tramite tramite : tramitesEncontrados) {
    //                String tipo = null;
    //                if (tramite instanceof Placa) {
    //                    tipo = "Placa";
    //                } else if (tramite instanceof Licencia) {
    //                    tipo = "Licencia";
    //                }
    //                TramiteDTO tramiteDTOResultado = new TramiteDTO(
    //                        tramite.getFechaEmision(),
    //                        tramite.getCosto(),
    //                        tramite.getPersona(),
    //                        tipo
    //                );
    //                tramitesDTO.add(tramiteDTOResultado);
    //            }
    //
    //            return tramitesDTO;
    //        } catch (PersistenciaException ex) {
    //            throw new ValidacionDTOException(ex.getMessage());
    //        }
    //    }
//    public TramiteDTO convertirTramiteATramiteDTO(Tramite tramite) {
//        ConsultarPersonaDTO personaDTO = new ConsultarPersonaDTO(
//                tramite.getPersona().getNombres(),
//                tramite.getPersona().getApellidoPaterno(),
//                tramite.getPersona().getApellidoMaterno()
//        );
//
//        return new TramiteDTO(
//                tramite.getFechaEmision(),
//                tramite.getCosto(),
//                personaDTO,
//                ""
//        );
//    }
}
