package com.itson.bdavanzadas.dtos;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.itson.bdavanzadas.entidades.EstadoPlaca;

/**
 * DTO (Data Transfer Object) que representa la información necesaria para consultar una placa.
 * Contiene información sobre el vehículo, la fecha de recepción y emisión de la placa, el número de placa,
 * el estado de la placa, el costo, la información de la persona asociada y el tipo de vehículo.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class ConsultaPlacaDTO {

    private VehiculoNuevoDTO vehiculo;
    private Calendar fechaRecepcion;
    private Calendar fechaEmision;
    private String numero;
    private EstadoPlaca estado;
    private Float costo;
    private ConsultarPersonaDTO persona;
    private String tipoVehiculo;

    /**
     * Constructor vacío.
     */
    public ConsultaPlacaDTO() {
    }

    /**
     * Constructor que incializa el número de la placa.
     * @param numero El número de la placa.
     */
    public ConsultaPlacaDTO(String numero) {
        this.numero = numero;
    }

    
    
   /**
     * Obtiene la información del vehículo asociado a la placa.
     * 
     * @return El objeto VehiculoNuevoDTO que representa la información del vehículo asociado a la placa.
     */
    public VehiculoNuevoDTO getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece la información del vehículo asociado a la placa.
     * 
     * @param vehiculo El objeto VehiculoNuevoDTO que contiene la información del vehículo asociado a la placa.
     */
    public void setVehiculo(VehiculoNuevoDTO vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene la fecha de recepción de la placa.
     * 
     * @return El objeto Calendar que representa la fecha de recepción de la placa.
     */
    public Calendar getFechaRecepcion() {
        return fechaRecepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     * 
     * @param fechaRecepcion El objeto Calendar que contiene la fecha de recepción de la placa.
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
     * @param numero El número de la placa.
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
     * @param estado El estado de la placa.
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
     * @param costo El costo de la placa.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la fecha de emisión de la placa.
     * 
     * @return El objeto Calendar que representa la fecha de emisión de la placa.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión de la placa.
     * 
     * @param fechaEmision El objeto Calendar que contiene la fecha de emisión de la placa.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene la información de la persona asociada a la placa.
     * 
     * @return El objeto ConsultarPersonaDTO que representa la información de la persona asociada a la placa.
     */
    public ConsultarPersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la información de la persona asociada a la placa.
     * 
     * @param persona El objeto ConsultarPersonaDTO que contiene la información de la persona asociada a la placa.
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
    
    /**
     * Método para validar si existen campos vacíos en el DTO.
     * 
     * @throws ValidacionDTOException Si hay campos vacíos en el DTO.
     */
    public void validarNumeroPlaca() throws ValidacionDTOException{
        if (this.numero == null || this.numero.isBlank()) {
            throw new ValidacionDTOException("Llene el campo de número de placa.");
        }
        
        String cadenaNumeroPlaca= "^[A-Z]{3}-[0-9]{3}$";

        Pattern patronNumero = Pattern.compile(cadenaNumeroPlaca);

        // Verifica el campo del automovil
        Matcher matcherNumero = patronNumero.matcher(this.numero);
        if (!matcherNumero.matches()) {
            throw new ValidacionDTOException("El número de placa es inválido debe tener el siguiente formato AAA-000, 3 letras mayúsculas, un guión y 3 números.");
        }
    }
}