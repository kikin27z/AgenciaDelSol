package com.itson.bdavanzadas.dtos;

import java.util.Calendar;
import org.itson.bdavanzadas.entidades.EstadoPlaca;

/**
 * DTO (Data Transfer Object) que representa la información necesaria para registrar una nueva placa.
 * Contiene los campos necesarios para describir una placa, incluyendo el vehículo asociado, la fecha de recepción, 
 * fecha de emisión, número de placa, estado, costo, persona asociada y tipo de vehículo.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class PlacaNuevaDTO {
    private VehiculoNuevoDTO vehiculo;
    private Calendar fechaRecepcion;
    private Calendar fechaEmision;
    private String numero;
    private EstadoPlaca estado;
    private Float costo;
    private ConsultarPersonaDTO persona;
    private String tipoVehiculo; 

    /**
     * Constructor por defecto de la clase PlacaNuevaDTO.
     */
    public PlacaNuevaDTO() {
    }

    
    /**
     * Obtiene el vehículo asociado a la placa.
     * 
     * @return El vehículo asociado a la placa.
     */
    public VehiculoNuevoDTO getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehículo asociado a la placa.
     * 
     * @param vehiculo El vehículo asociado a la placa a establecer.
     */
    public void setVehiculo(VehiculoNuevoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene la fecha de recepción de la placa.
     * 
     * @return La fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     * 
     * @param fechaRecepcion La fecha de recepción de la placa a establecer.
     */
    public void setFechaRecepcion(Calendar fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
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
     * @param numero El número de la placa a establecer.
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @param estado El estado de la placa a establecer.
     */
    public void setEstado(EstadoPlaca estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el costo de la placa.
     * 
     * @return El costo de la placa.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo de la placa.
     * 
     * @param costo El costo de la placa a establecer.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la fecha de emisión de la placa.
     * 
     * @return La fecha de emisión de la placa.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión de la placa.
     * 
     * @param fechaEmision La fecha de emisión de la placa a establecer.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene la persona asociada a la placa.
     * 
     * @return La persona asociada a la placa.
     */
    public ConsultarPersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada a la placa.
     * 
     * @param persona La persona asociada a la placa a establecer.
     */
    public void setPersona(ConsultarPersonaDTO persona) {
        this.persona = persona;
    }

    /**
     * Obtiene el tipo de vehículo asociado a la placa.
     * 
     * @return El tipo de vehículo asociado a la placa.
     */
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    /**
     * Establece el tipo de vehículo asociado a la placa.
     * 
     * @param tipoVehiculo El tipo de vehículo asociado a la placa.
     */
    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}
