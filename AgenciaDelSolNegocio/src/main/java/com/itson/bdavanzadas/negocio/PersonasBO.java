/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.avisos.Aviso;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.entidades.Discapacidad;
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
    IConexion conexion;
    Persona persona;
    Aviso aviso;

    public PersonasBO() {
        this.conexion = new Conexion();
        this.personasDAO = new PersonasDAO(conexion);
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

    @Override
    public ConsultarPersonaDTO consultarPersonaPorRfc(ConsultarPersonaDTO personaDTO) {
        try {
            Persona personaBuscar = new Persona();
            personaBuscar.setRfc(personaDTO.getRfc());
            persona = personasDAO.consultarPersonaPorRfc(personaBuscar);
            ConsultarPersonaDTO personaEncontrada = new ConsultarPersonaDTO(
                    persona.getRfc(),
                    persona.getNombres(),
                    persona.getApellidoPaterno(),
                    persona.getApellidoMaterno(),
                    persona.getFechaNacimiento(),
                    persona.getTelefono(),
                    persona.getDiscapacidad()
            );
//            if (esMayor()) {
                return personaEncontrada;
//            } else {
//                Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, "La persona debe de ser mayor");
//                return null;
//            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean esMayor(){
        Calendar fechaNacimiento = persona.getFechaNacimiento();
        Calendar fechaActual = Calendar.getInstance();
        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        if (edad >=18) {
            return true;
        } else {
            System.out.println("Es menor");
            return false;
        }
    }

    @Override
    public boolean esDiscapacitado() {
        return persona.getDiscapacidad() == Discapacidad.DISCAPACITADO;
    }

}
