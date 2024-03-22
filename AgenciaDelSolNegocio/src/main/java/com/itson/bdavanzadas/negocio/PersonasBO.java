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
 * Clase que implementa la lógica de negocio relacionada con las personas.
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

    /**
     * Constructor de la clase PersonasBO.
     *
     * Este constructor inicializa la conexión a la base de datos y el objeto de
     * acceso a datos (DAO) correspondiente.
     */
    public PersonasBO() {
        this.conexion = new Conexion();
        this.personasDAO = new PersonasDAO(conexion);
    }

    /**
     * Realiza una inserción masiva de personas en la base de datos. Llama al
     * método de inserción masiva en el DAO correspondiente y registra un
     * mensaje de registro de información si la inserción es exitosa.
     *
     * @throws PersistenciaException Si ocurre un error durante la inserción
     * masiva de personas.
     */
    @Override
    public void incersionMasivaPersonas() {
        try {
            personasDAO.insercionMasiva();
            logger.log(Level.INFO, "Se hizo la insercion correctamente");
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Consulta una persona en la base de datos por su RFC.
     *
     * @param personaDTO Objeto ConsultarPersonaDTO que contiene el RFC de la
     * persona a buscar.
     * @return ConsultarPersonaDTO con la información de la persona encontrada,
     * o null si no se encuentra o no cumple con los requisitos.
     */
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

                return personaEncontrada;
        } catch (PersistenciaException ex) {
            
        return null;
        }
    }

    /**
     * Verifica si una persona es mayor de edad comparando su fecha de
     * nacimiento con la fecha actual.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @return true si la persona es mayor de edad, false si es menor de edad.
     */
    @Override
    public boolean esMayor(Calendar fechaNacimiento) {
        Calendar fechaActual = Calendar.getInstance();
        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        if (edad >= 18) {
            return true;
        } else {
            System.out.println("Es menor");
            return false;
        }
    }

    /**
     * Verifica si una persona tiene una discapacidad.
     *
     * @return true si la persona tiene una discapacidad, false si no la tiene.
     */
    @Override
    public boolean esDiscapacitado() {
        return persona.getDiscapacidad() == Discapacidad.DISCAPACITADO;
    }

}
