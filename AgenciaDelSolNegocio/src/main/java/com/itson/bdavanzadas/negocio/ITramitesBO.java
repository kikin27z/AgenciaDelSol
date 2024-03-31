package com.itson.bdavanzadas.negocio;

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

    public void generarReporte(List<ReporteDTO> listaTramites);

}
