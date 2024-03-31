package com.itson.bdavanzadas.dtos;

import java.util.Date;

/**
 * Clase para almacenar los filtros utilizados en la generación de reportes.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class FiltrosReporteGeneradoDTO {

    private String persona;
    private String tipoTramite;
    private Date fechaInicio;
    private Date fechaFin;
    
    /**
     * Devuelve el nombre de la persona asociada al filtro.
     *
     * @return El nombre de la persona.
     */
    public String getPersona() {
        return persona;
    }

    /**
     * Establece el nombre de la persona asociada al filtro.
     *
     * @param persona El nombre de la persona.
     */
    public void setPersona(String persona) {
        this.persona = persona;
    }

    /**
     * Devuelve el tipo de trámite asociado al filtro.
     *
     * @return El tipo de trámite.
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de trámite asociado al filtro.
     *
     * @param tipoTramite El tipo de trámite.
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Devuelve la fecha de inicio asociada al filtro.
     *
     * @return La fecha de inicio.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio asociada al filtro.
     *
     * @param fechaInicio La fecha de inicio.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Devuelve la fecha de fin asociada al filtro.
     *
     * @return La fecha de fin.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin asociada al filtro.
     *
     * @param fechaFin La fecha de fin.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
