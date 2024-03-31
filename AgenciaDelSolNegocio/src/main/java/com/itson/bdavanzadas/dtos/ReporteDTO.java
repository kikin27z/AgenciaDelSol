/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdavanzadas.dtos;

import java.util.Date;

/**
 * La clase ReporteDTO representa un reporte generado en la aplicación.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class ReporteDTO {

    private Date fechaEmision;
    private String costo;
    private String persona;
    private String tipoTramite;

    /**
     * Constructor por defecto de la clase ReporteDTO.
     */
    public ReporteDTO() {
    }

    /**
     * Constructor de la clase ReporteDTO que inicializa todos los atributos.
     *
     * @param fechaEmision La fecha de emisión del reporte.
     * @param costo El costo del trámite asociado al reporte.
     * @param persona La persona asociada al reporte.
     * @param tipoTramite El tipo de trámite asociado al reporte.
     */
    public ReporteDTO(Date fechaEmision, String costo, String persona, String tipoTramite) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
        this.tipoTramite = tipoTramite;
    }

    /**
     * Devuelve la persona asociada al reporte.
     *
     * @return La persona asociada al reporte.
     */
    public String getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al reporte.
     *
     * @param persona La persona asociada al reporte.
     */
    public void setPersona(String persona) {
        this.persona = persona;
    }

    /**
     * Devuelve el tipo de trámite asociado al reporte.
     *
     * @return El tipo de trámite asociado al reporte.
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de trámite asociado al reporte.
     *
     * @param tipoTramite El tipo de trámite asociado al reporte.
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Devuelve la fecha de emisión del reporte.
     *
     * @return La fecha de emisión del reporte.
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión del reporte.
     *
     * @param fechaEmision La fecha de emisión del reporte.
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Devuelve el costo del trámite asociado al reporte.
     *
     * @return El costo del trámite asociado al reporte.
     */
    public String getCosto() {
        return costo;
    }

    /**
     * Establece el costo del trámite asociado al reporte.
     *
     * @param costo El costo del trámite asociado al reporte.
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }
}
