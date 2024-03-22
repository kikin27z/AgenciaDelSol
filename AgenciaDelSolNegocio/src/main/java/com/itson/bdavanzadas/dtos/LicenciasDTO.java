package com.itson.bdavanzadas.dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.entidades.EstadoLicencia;
import org.itson.bdavanzadas.entidades.Persona;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class LicenciasDTO {
    private EstadoLicencia estado;
    private Calendar fechaVigencia;
    private Calendar fechaEmision;
    private Float costo;
    private ConsultarPersonaDTO persona;

    public LicenciasDTO(EstadoLicencia estado, Calendar fechaVigencia, Calendar fechaEmision, Float costo, ConsultarPersonaDTO persona) {
        this.estado = estado;
        this.fechaVigencia = fechaVigencia;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
    }

    public EstadoLicencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoLicencia estado) {
        this.estado = estado;
    }

    public Calendar getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(Calendar fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public ConsultarPersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(ConsultarPersonaDTO persona) {
        this.persona = persona;
    }

    
    
    
}
