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
    private String nombre;
    private String tipoTramite;

    public ReporteDTO(Date fechaEmision, Float costo, String nombre, String tipoTramite) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.nombre = nombre;
        this.tipoTramite = tipoTramite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
