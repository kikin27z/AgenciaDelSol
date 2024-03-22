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

    public ConsultarPersonaDTO() {
    }

    public ConsultarPersonaDTO(String rfc) {
        this.rfc = rfc;
    }

    public ConsultarPersonaDTO(String rfc, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, Discapacidad discapacidad) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.discapacidad = discapacidad;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Discapacidad getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(Discapacidad discapacidad) {
        this.discapacidad = discapacidad;
    }

    
}
