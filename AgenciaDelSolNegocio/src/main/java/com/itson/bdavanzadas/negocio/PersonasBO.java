/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class PersonasBO implements IPersonasBO {

    private IPersonasDAO personasDAO;
    static final Logger logger = Logger.getLogger(PersonasDAO.class.getName());

    public PersonasBO(IPersonasDAO personasDAO) {
        this.personasDAO = personasDAO;
    }

    @Override
    public void incersionMasivaPersonas() {
        try {
            personasDAO.insercionMasiva();
            logger.log(Level.INFO, "Se hizo la insercion correctamente");
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @Override
//    public List<ConsultarPersonaDTO> consultarPersonasRegistradas(ConsultarPersonaDTO consulta) {
//        List<ConsultarPersonaDTO> resultados = new ArrayList<>();
//
//        try {
//            // Consultar personas por CURP utilizando el método del DAO
//            Persona persona = personasDAO.consultarPersonaPorCurp(consulta.getCurp());
//
//            // Si la persona no es nula, convertir la entidad a DTO y agregarla a la lista de resultados
//            if (persona != null) {
//                ConsultarPersonaDTO dto = convertirPersonaADTO(persona);
//                resultados.add(dto);
//            }
//
//            logger.log(Level.INFO, "Se consulto correctamente la lista");
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return resultados;
//    }

    /**
     * Este método sirve para convertir una entidad Persona a DTO
     * ConsultarPersonaDTO
     *
     * @param persona
     * @return dto
     */
    private ConsultarPersonaDTO convertirPersonaADTO(Persona persona) {
        ConsultarPersonaDTO dto = new ConsultarPersonaDTO();
        dto.setRfc(persona.getRfc());
        dto.setNombres(persona.getNombres());
        dto.setFechaNacimiento(persona.getFechaNacimiento());
        dto.setTelefono(Integer.parseInt(persona.getTelefono()));
        return dto;
    }

    @Override
    public Persona consultarPersonaPorCurp(ConsultarPersonaDTO personaDTO) {       
        try {
            Persona persona = new Persona();
            persona.setRfc(personaDTO.getRfc());
            return personasDAO.consultarPersonaPorRfc(persona);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
