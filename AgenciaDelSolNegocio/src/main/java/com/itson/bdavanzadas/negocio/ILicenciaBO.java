/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.LicenciasDTO;

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
}
