package org.itson.bdavanzadas.complementos;

import java.util.Date;

/**
 * Clase que representa los filtros utilizados para generar un reporte.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class FiltrosReporte {

    private String persona;
    private String tipoTramite;
    private Date fechaInicio;
    private Date fechaFin;

    /**
     * Obtiene el nombre de la persona asociada a los trámites.
     *
     * @return El nombre de la persona asociada a los trámites.
     */
    public String getPersona() {
        return persona;
    }

    /**
     * Establece el nombre de la persona asociada a los trámites.
     *
     * @param persona El nombre de la persona asociada a los trámites.
     */
    public void setPersona(String persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el tipo de trámite utilizado como filtro.
     *
     * @return El tipo de trámite utilizado como filtro.
     */
    public String getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Establece el tipo de trámite utilizado como filtro.
     *
     * @param tipoTramite El tipo de trámite utilizado como filtro.
     */
    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Obtiene la fecha de inicio utilizada como filtro.
     *
     * @return La fecha de inicio utilizada como filtro.
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * Establece la fecha de inicio utilizada como filtro.
     *
     * @param fechaInicio La fecha de inicio utilizada como filtro.
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * Obtiene la fecha de fin utilizada como filtro.
     *
     * @return La fecha de fin utilizada como filtro.
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * Establece la fecha de fin utilizada como filtro.
     *
     * @param fechaFin La fecha de fin utilizada como filtro.
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
