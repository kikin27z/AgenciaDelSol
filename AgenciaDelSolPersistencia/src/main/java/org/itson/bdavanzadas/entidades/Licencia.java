package org.itson.bdavanzadas.entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column (name = "vigencia_anios", nullable = false)
    private Integer vigenciaAnios;
    
    @Column (name = "fecha_vigencia", nullable = true)
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar fechaVigencia;

    /**
     * Constructor vacío de la clase Licencia.
     */
    public Licencia() {
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
     * Obtiene la vigencia en años de la licencia.
     * 
     * @return La vigencia en años de la licencia.
     */
    public Integer getVigenciaAnios() {
        return vigenciaAnios;
    }

    /**
     * Establece la vigencia en años de la licencia.
     * 
     * @param vigenciaAnios La vigencia en años de la licencia.
     */
    public void setVigenciaAnios(Integer vigenciaAnios) {
        this.vigenciaAnios = vigenciaAnios;
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
     * Método para calcular el costo de la licencia basado en la vigencia y el estado de discapacidad.
     */
    public void calcularCosto(){
        if(this.getPersona().getDiscapacidad() == Discapacidad.NORMAL){
            switch (vigenciaAnios) {
                case 1:
                    this.setCosto(600F);
                    break;
                case 2:
                    this.setCosto(900F);
                default:
                    this.setCosto(1100F);
            }
        }else{
            switch (vigenciaAnios) {
                case 1:
                    this.setCosto(200F);
                    break;
                case 2:
                    this.setCosto(500F);
                default:
                    this.setCosto(700F);
            }
        }
    }
    
    
}
