package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.LicenciasDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.ILicenciasDAO;
import org.itson.bdavanzadas.daos.LicenciasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Clase que implementa la lógica de negocio relacionada con las licencias.
 * Se encarga de tramitar las licencias, desactivar licencias previas y gestionar
 * la conexión con la capa de persistencia.
 * 
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

    /**
     * Constructor de la clase LicenciaBO.
     * Inicializa la conexión con la base de datos.
     */
    public LicenciaBO() {
        conexion = new Conexion();
        licenciasDAO = new LicenciasDAO(conexion);
    }

    /**
     * Realiza el trámite de una licencia.
     * Este método tramita una nueva licencia para una persona dada, desactivando
     * cualquier licencia previa que pueda tener.
     * 
     * @param licenciaDTO El DTO que contiene los datos de la licencia a tramitar.
     * @return El DTO de la licencia tramitada.
     */
    @Override
    public LicenciasDTO realizarTramite(LicenciasDTO licenciaDTO) {
            
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

    /**
     * Verifica si una persona tiene una licencia vigente.
     * 
     * @param personaDTO El DTO que contiene la información de la persona cuya licencia se verificará.
     * @throws ValidacionDTOException Si la persona no tiene una licencia vigente.
     */
    @Override
    public void licenciaVigente(ConsultarPersonaDTO personaDTO) throws ValidacionDTOException{
        Persona persona = new Persona();
        persona.setRfc(personaDTO.getRfc());
        
        try {
            licenciasDAO.tieneLicenciaVigente(persona);
        } catch (PersistenciaException pe) {
            
            Logger.getLogger(LicenciaBO.class.getName()).log(Level.SEVERE, "Persona sin licencia vigente para tramitar placas");
            throw new ValidacionDTOException("Esta persona no tiene licencia vigente para tramitar una placa");
        }
    }
}
