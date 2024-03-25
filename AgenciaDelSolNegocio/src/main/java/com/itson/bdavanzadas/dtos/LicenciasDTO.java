package com.itson.bdavanzadas.dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.entidades.EstadoLicencia;

/**
 * DTO que encapsula los datos necesarios para representar una licencia.
 * Contiene información como el estado de la licencia, la fecha de vigencia, la fecha de emisión,
 * el costo y los detalles de la persona asociada a la licencia.
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

    /**
     * Constructor que inicializa los atributos del DTO con los valores especificados en el constructor.
     * 
     * @param estado El estado de la licencia.
     * @param fechaVigencia La fecha de vigencia de la licencia.
     * @param fechaEmision La fecha de emisión de la licencia.
     * @param costo El costo de la licencia.
     * @param persona Los detalles de la persona asociada a la licencia.
     */
    public LicenciasDTO(EstadoLicencia estado, Calendar fechaVigencia, Calendar fechaEmision, Float costo, ConsultarPersonaDTO persona) {
        this.estado = estado;
        this.fechaVigencia = fechaVigencia;
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
    }

    /**
     * Obtiene el estado de la licencia.
     * 
     * @return El estado de la licencia.
     */
    public EstadoLicencia getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la licencia.
     * 
     * @param estado El estado de la licencia.
     */
    public void setEstado(EstadoLicencia estado) {
        this.estado = estado;
    }

    /**
     * Obtiene la fecha de vigencia de la licencia.
     * 
     * @return La fecha de vigencia de la licencia.
     */
    public Calendar getFechaVigencia() {
        return fechaVigencia;
    }

    /**
     * Establece la fecha de vigencia de la licencia.
     * 
     * @param fechaVigencia La fecha de vigencia de la licencia.
     */
    public void setFechaVigencia(Calendar fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    /**
     * Obtiene la fecha de emisión de la licencia.
     * 
     * @return La fecha de emisión de la licencia.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión del licencia.
     * 
     * @param fechaEmision La fecha de emisión de la licencia.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene el costo del licencia.
     * 
     * @return El costo de la licencia.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo del tramite/licencia.
     * 
     * @param costo El costo de la licencia.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene los detalles de la persona asociada al tramite/licencia.
     * 
     * @return Los detalles de la persona asociada a la licencia.
     */
    public ConsultarPersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece los detalles de la persona asociada al tramite/licencia.
     * 
     * @param persona Los detalles de la persona asociada a la licencia.
     */
    public void setPersona(ConsultarPersonaDTO persona) {
        this.persona = persona;
    }
}
