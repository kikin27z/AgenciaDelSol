package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.ReporteDTO;
import com.itson.bdavanzadas.dtos.TramiteDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con trámites en el sistema.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface ITramitesBO {

    /**
     * Consulta los trámites según los criterios especificados en el objeto
     * TramiteDTO.
     *
     * @return Una lista de TramiteDTO que representan los trámites encontrados.
     * @throws ValidacionDTOException Si ocurre un error durante la consulta.
     */
    public List<TramiteDTO> consultarTramites() throws ValidacionDTOException;
    
    /**
     * Consulta los tramites de una persona en especifico.
     * @param personaDTO persona a la cual consultaremos
     * @return lista de tramites de la persona.
     */
    public List<TramiteDTO> consultarTramitesPersona(ConsultarPersonaDTO personaDTO);

    /**
     * Genera un reporte a partir de una lista de ReporteDTO. Permite al usuario
     * seleccionar la ubicación y el nombre del archivo PDF donde se guardará el
     * reporte.
     *
     * @param listaTramites La lista de ReporteDTO que se utilizará para generar
     * el reporte.
     */
    public void generarReporte(List<ReporteDTO> listaTramites);

    /**
     * Convierte una lista de trámites representados como objetos TramiteDTO en
     * una lista de reportes representados como objetos ReporteDTO. Cada objeto
     * TramiteDTO se transforma en un objeto ReporteDTO con los mismos datos.
     *
     * @param listaTramites La lista de TramiteDTO que se va a convertir en
     * reportes.
     * @return Una lista de ReporteDTO que representa los reportes generados a
     * partir de los trámites.
     */
    public List<ReporteDTO> convertirTramitesAReportes(List<TramiteDTO> listaTramites);

}
