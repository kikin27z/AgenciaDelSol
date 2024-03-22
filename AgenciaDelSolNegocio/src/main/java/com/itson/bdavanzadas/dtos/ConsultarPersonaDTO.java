package com.itson.bdavanzadas.dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.entidades.Discapacidad;

/**
 * En este DTO encapsulamos los datos necesarios para poder realizar una
 * consulta de persona.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class ConsultarPersonaDTO {

    private String rfc;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Calendar fechaNacimiento;
    private String telefono;
    private Discapacidad discapacidad;

    /**
     * Constructor vacío de la clase ConsultarPersonaDTO.
     */
    public ConsultarPersonaDTO() {
    }

    /**
     * Constructor que inicializa el DTO con el RFC especificado.
     * 
     * @param rfc El RFC de la persona.
     */
    public ConsultarPersonaDTO(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Constructor que inicializa todos los atributos del DTO.
     * 
     * @param rfc El RFC de la persona.
     * @param nombres Los nombres de la persona.
     * @param apellidoPaterno El apellido paterno de la persona.
     * @param apellidoMaterno El apellido materno de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     * @param telefono El número de teléfono de la persona.
     * @param discapacidad El estado de discapacidad de la persona.
     */
    public ConsultarPersonaDTO(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, Discapacidad discapacidad) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.discapacidad = discapacidad;
    }

    /**
     * Obtiene el RFC de la persona.
     * 
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     * 
     * @param rfc El RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene los nombres de la persona.
     * 
     * @return Los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres de la persona.
     * 
     * @param nombres Los nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * 
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * 
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el número de teléfono de la persona.
     * 
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     * 
     * @param telefono El número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     * 
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     * 
     * @param apellidoPaterno El apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     * 
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona.
     * 
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el estado de discapacidad de la persona.
     * 
     * @return El estado de discapacidad de la persona.
     */
    public Discapacidad getDiscapacidad() {
        return discapacidad;
    }

    /**
     * Establece el estado de discapacidad de la persona.
     * 
     * @param discapacidad El estado de discapacidad de la persona.
     */
    public void setDiscapacidad(Discapacidad discapacidad) {
        this.discapacidad = discapacidad;
    }

    
}
