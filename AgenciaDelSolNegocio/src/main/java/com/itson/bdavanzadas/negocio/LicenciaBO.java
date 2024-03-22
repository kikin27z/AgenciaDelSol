/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.LicenciasDTO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ILicenciasDAO;
import org.itson.bdavanzadas.daos.LicenciasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.entidades.Discapacidad;
import org.itson.bdavanzadas.entidades.EstadoLicencia;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

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
    IConexion conexion;

    public LicenciaBO() {
        conexion = new Conexion();
    }

    @Override
    public LicenciasDTO realizarTramite(LicenciasDTO licenciaDTO) {
            licenciasDAO = new LicenciasDAO(conexion);
            Licencia licencia = new Licencia(
                    licenciaDTO.getEstado(),
                    licenciaDTO.getFechaVigencia()
            );
            personasDAO = new PersonasDAO(conexion);
            
            Persona persona = new Persona();
            persona.setRfc(licenciaDTO.getPersona().getRfc());
            
        try {
            persona = personasDAO.consultarPersonaPorRfc(persona);
        } catch (PersistenciaException ex) {
            Logger.getLogger(LicenciaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            licencia.setFechaEmision(licenciaDTO.getFechaEmision());
            licencia.setCosto(licenciaDTO.getCosto());
            licencia.setPersona(persona);
            
            licenciasDAO.desactivarLicencias(persona);
            licenciasDAO.tramitarLicencias(licencia);
            
            return licenciaDTO;
    }
    
}
