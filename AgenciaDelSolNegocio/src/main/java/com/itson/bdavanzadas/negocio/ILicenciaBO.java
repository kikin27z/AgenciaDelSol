package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.LicenciasDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;

/**
 * Interfaz que define el contrato para la lógica de negocio relacionada con las licencias.
 * Define un método para realizar el trámite de una licencia.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface ILicenciaBO {

    /**
     * Realiza el trámite de una licencia según la información proporcionada en el DTO.
     * 
     * @param licenciaDTO El DTO que contiene la información necesaria para el trámite de la licencia.
     * @return El DTO que representa la licencia tramitada.
     */
    public LicenciasDTO realizarTramite(LicenciasDTO licenciaDTO);
    
    /**
     * Verifica si una persona tiene una licencia vigente.
     * 
     * @param personaDTO El DTO que contiene la información de la persona cuya licencia se verificará.
     * @throws ValidacionDTOException Si la persona no tiene una licencia vigente.
     */
    public void licenciaVigente(ConsultarPersonaDTO personaDTO) throws ValidacionDTOException;
}
