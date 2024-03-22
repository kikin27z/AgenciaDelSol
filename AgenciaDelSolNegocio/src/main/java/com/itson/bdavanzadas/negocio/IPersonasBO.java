/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import java.util.Calendar;
import java.util.List;
import org.itson.bdavanzadas.entidades.Persona;

/**
 * Interfaz que define las operaciones de lógica de negocio relacionadas con las
 * personas.
 *
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IPersonasBO {

    /**
     * Realiza una inserción masiva de personas en la base de datos.
     *
     * Este método se encarga de realizar una inserción masiva de personas en la
     * base de datos, utilizando el DAO correspondiente. Registra eventos de log
     * utilizando un Logger para llevar un registro de las operaciones
     * realizadas.
     *
     * @throws PersistenciaException Si ocurre un error durante la inserción
     * masiva de personas.
     */
    public void incersionMasivaPersonas();

    /**
     * Verifica si una persona es mayor de edad.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @return true si la persona es mayor de edad, false si es menor de edad.
     */
    public boolean esMayor(Calendar fechaNacimiento);

    /**
     * Verifica si una persona tiene una discapacidad.
     *
     * @return true si la persona tiene una discapacidad, false si no la tiene.
     */
    public boolean esDiscapacitado();

    /**
     * Consulta una persona en la base de datos por su RFC.
     *
     * Este método busca una persona en la base de datos utilizando el RFC
     * proporcionado en un objeto ConsultarPersonaDTO. Retorna un objeto
     * ConsultarPersonaDTO con la información de la persona encontrada, o null
     * si no se encuentra o no cumple con los requisitos.
     *
     * @param personaDTO Objeto ConsultarPersonaDTO que contiene el RFC de la
     * persona a buscar.
     * @return ConsultarPersonaDTO con la información de la persona encontrada,
     * o null si no se encuentra o no cumple con los requisitos.
     */
    public ConsultarPersonaDTO consultarPersonaPorRfc(ConsultarPersonaDTO personaDTO);

}
