/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.LicenciasDTO;
import java.util.logging.Logger;
import org.itson.bdavanzadas.daos.ILicenciasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.entidades.Discapacidad;
import org.itson.bdavanzadas.entidades.EstadoLicencia;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;

/**
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class LicenciaBO implements ILicenciaBO{

    private ILicenciasDAO licenciasDAO;
    private PersonasBO personasBO;
    private PersonasDAO personasDAO;
    static final Logger logger = Logger.getLogger(PersonasDAO.class.getName());

    public LicenciaBO(ILicenciasDAO licenciasDAO, PersonasBO personasBO) {
        this.licenciasDAO = licenciasDAO;
        this.personasBO = personasBO;
    }

    @Override
    public LicenciasDTO realizarTramite(LicenciasDTO licenciaDTO) {
        Licencia licencia = new Licencia(
                licenciaDTO.getEstado(), 
                licenciaDTO.getFechaVigencia()
        );
        
        licencia.setFechaEmision(licenciaDTO.getFechaEmision());
        licencia.setCosto(licenciaDTO.getCosto());
        licencia.setPersona(licenciaDTO.getPersona());
        
        licenciasDAO.tramitarLicencias(licencia);
        
        return licenciaDTO;
    }
    
}
