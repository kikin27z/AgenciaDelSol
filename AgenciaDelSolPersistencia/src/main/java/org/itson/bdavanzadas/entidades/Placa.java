package org.itson.bdavanzadas.entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa la expedición de placas en el sistema.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA.
 * Utiliza la estrategia de herencia de una tabla por clase con un valor discriminador específico.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
@Entity
@Table (name = "placas")
@DiscriminatorValue ("Expedición de placas")
public class Placa extends Tramite implements Serializable {

    @Column (name = "numero",nullable = false, length = 7, unique = true)
    private String numero;

    @Column (name = "fecha_recepcion", nullable = true)
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar fechaRecepcion;
    
    @Column (name = "estado", nullable = false)
    @Enumerated (EnumType.STRING)
    private EstadoPlaca estado;
    
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;
    
    /**
     * Constructor vacío de la clase Placa.
     */
    public Placa() {
    }

    /**
     * Obtiene el número de la placa.
     * 
     * @return El número de la placa.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Establece el número de la placa.
     * 
     * @param numero El número de la placa.
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el vehículo asociado a la placa.
     * 
     * @return El vehículo asociado a la placa.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado a la placa.
     * 
     * @param vehiculo El vehículo asociado a la placa.
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene la fecha en la que se recibio la placa.
     * @return La fecha en la que recibio la placa
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha en la que se recibio la placa.
     * @param fechaRecepcion La fecha en la que se recibio la placa.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    /**
     * Obtiene el estado de la placa.
     * 
     * @return El estado de la placa.
     */
    public EstadoPlaca getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa.
     * 
     * @param estado El estado de la placa.
     */
    public void setEstado(EstadoPlaca estado) {
        this.estado = estado;
    }
    
    
}
