package org.itson.bdavanzadas.entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la expedición de una licencia en el sistema.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA.
 * Utiliza la estrategia de herencia JOINED y tiene un valor discriminador específico.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
@Entity
@Table (name = "licencias")
@DiscriminatorValue ("Expedición de Licencia")
public class Licencia extends Tramite implements Serializable {
    
    @Column (name = "estado",nullable = false)
    @Enumerated (EnumType.STRING)
    private EstadoLicencia estado;
    
    @Column (name = "fecha_vigencia", nullable = true)
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar fechaVigencia;

    /**
     * Constructor vacío de la clase Licencia.
     */
    public Licencia() {
    }

    /**
     * Consturctor que iniciliza solo el estado y la fecha de vigencia de la licencia.
     * @param estado estado de la licencia.
     * @param fechaVigencia fecha de vigencia de la licencia.
     */
    public Licencia(EstadoLicencia estado, Calendar fechaVigencia) {
        this.estado = estado;
        this.fechaVigencia = fechaVigencia;
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
}
