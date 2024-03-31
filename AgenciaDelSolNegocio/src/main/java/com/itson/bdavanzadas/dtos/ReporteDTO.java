/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdavanzadas.dtos;

import java.util.Date;

/**
 *
 * @author castr
 */
public class ReporteDTO {

    private Date fechaEmision;
    private Float costo;
    private String persona;
    private String tipoTramite;

    public ReporteDTO() {
    }

    public ReporteDTO(Date fechaEmision, Float costo, String persona, String tipoTramite) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
        this.tipoTramite = tipoTramite;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

}
