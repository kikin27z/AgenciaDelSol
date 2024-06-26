package com.itson.bdavanzadas.dtos;

import java.util.Calendar;
import java.util.Date;

/**
 * En esta clase encapsulamos un objeto tramite con los datos necesarios para
 * realizar consultas.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class TramiteDTO {

    private Date fechaEmision;
    private Float costo;
    private ConsultarPersonaDTO persona;
    private String tipoTramite;

    /**
     * Constructor vacío de la clase TramiteDTO.
     *
     * Crea un nuevo objeto TramiteDTO con todos sus atributos inicializados a
     * sus valores predeterminados.
     */
    public TramiteDTO() {
    }

    /**
     * Constructor de la clase TramiteDTO.
     *
     * Crea un nuevo objeto TramiteDTO con la fecha de emisión, la persona y el
     * tipo especificados.
     *
     * @param fechaEmision La fecha de emisión del trámite.
     * @param costo El costro del tramite realizado.
     * @param tipoTramite el tipo de tramite realizado.
     * @param persona
     */
    public TramiteDTO(Date fechaEmision, Float costo, String tipoTramite, ConsultarPersonaDTO persona) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.tipoTramite = tipoTramite;
        this.persona = persona;
    }

    /**
     * Constructor de la clase TramiteDTO.
     *
     * Crea un nuevo objeto TramiteDTO con la fecha de emisión, el costo y el
     * tipo especificados.
     * 
     * @param fechaEmision
     * @param costo
     * @param tipoTramite
     */
    public TramiteDTO(Date fechaEmision, Float costo, String tipoTramite) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.tipoTramite = tipoTramite;
    }
    
    /**
     * Obtiene la fecha de emisión del trámite.
     *
     * @return La fecha de emisión del trámite.
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión del trámite.
     *
     * @param fechaEmision La fecha de emisión del trámite.
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene el costo del trámite.
     *
     * @return El costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo del trámite.
     *
     * @param costo El costo del trámite.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la persona asociada al trámite.
     *
     * @return La persona asociada al trámite.
     */
    public ConsultarPersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     *
     * @param persona La persona asociada al trámite.
     */
    public void setPersona(ConsultarPersonaDTO persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el tipo de tramite.
     * @return
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de tramite.
     * @param tipoTramite
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

}
