package com.itson.bdavanzadas.dtos;

import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DTO (Data Transfer Object) que representa la información necesaria para registrar un vehículo nuevo.
 * Contiene los campos necesarios para describir un vehículo, incluyendo el número de serie, color, marca, modelo y línea.
 * También contiene información sobre la persona asociada al vehículo.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class VehiculoNuevoDTO {
    private String numeroSerie;
    private String color;
    private String marca;
    private String modelo;
    private String linea;
    private ConsultarPersonaDTO persona; 

    /**
     * Constructor vacío.
     */
    public VehiculoNuevoDTO() {
    }

    public VehiculoNuevoDTO(String numeroSerie, String color, String marca, String modelo, String linea, ConsultarPersonaDTO persona) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.linea = linea;
        this.persona = persona;
    }

    /**
     * Obtiene el número de serie del vehículo.
     * 
     * @return El número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     * 
     * @param numeroSerie El número de serie del vehículo a establecer.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Obtiene el color del vehículo.
     * 
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     * 
     * @param color El color del vehículo a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene la marca del vehículo.
     * 
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     * 
     * @param marca La marca del vehículo a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo El modelo del vehículo a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la línea del vehículo.
     * 
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     * 
     * @param linea La línea del vehículo a establecer.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene la información de la persona asociada al vehículo.
     * 
     * @return La información de la persona asociada al vehículo.
     */
    public ConsultarPersonaDTO getPersona() {
        return persona;
    }

    /**
     * Establece la información de la persona asociada al vehículo.
     * 
     * @param persona La información de la persona asociada al vehículo a establecer.
     */
    public void setPersona(ConsultarPersonaDTO persona) {
        this.persona = persona;
    }
    
    /**
     * Método para validar si existen campos vacíos en el DTO.
     * 
     * @throws ValidacionDTOException Si hay campos vacíos en el DTO.
     */
    public void validarCamposVacios() throws ValidacionDTOException{
        if (this.marca == null || this.marca.isBlank()
                || this.numeroSerie == null || this.numeroSerie.isBlank()
                || this.modelo == null || this.modelo.isBlank()
                || this.color == null || this.color.isBlank()
                || this.linea == null || this.linea.isBlank()) {
            throw new ValidacionDTOException("Llene todos los campos");
        }
    }
    
    /**
     * Método para validar los campos del DTO según ciertas reglas.
     * 
     * @throws ValidacionDTOException Si algún campo no cumple con las reglas de validación.
     */
    public void validaCampos() throws ValidacionDTOException{
        String cadenaModelo = "^[0-9]{4}$";
        String cadenaNumeroSerie = "^[A-Z0-9]{10}$";
        String cadenaColor = "^[a-zA-Z\\s]{1,20}$";
        String cadenaMarca = "^[a-zA-Z\\s0-9&]{1,30}$";

        Pattern patronNumeroSerie = Pattern.compile(cadenaNumeroSerie);
        Pattern patronModelo = Pattern.compile(cadenaModelo);
        Pattern patronMarca = Pattern.compile(cadenaMarca);
        Pattern patronColor = Pattern.compile(cadenaColor);

        // Verifica el campo del automovil
        Matcher matcherNumeroSerie = patronNumeroSerie.matcher(this.numeroSerie);
        if (!matcherNumeroSerie.matches()) {
            throw new ValidacionDTOException("El número de serie del automóvil deben ser 10 caracteres con mayúsculas y números.");
        }
        Matcher matcherMarca = patronMarca.matcher(this.marca);
        if (!matcherMarca.matches()) {
            throw new ValidacionDTOException("La marca del automóvil no debe superar los 30 caracteres, solo números, letras y el & son válidos.");
        }
        matcherMarca = patronMarca.matcher(this.linea);
        if (!matcherMarca.matches()) {
            throw new ValidacionDTOException("La linea del automóvil no debe superar los 30 caracteres, solo números, letras y el & son válidos.");
        }
        Matcher matcherModelo = patronModelo.matcher(this.modelo);
        if (!matcherModelo.matches()) {
            throw new ValidacionDTOException("El modelo del automóvil no debe superar los 4 caracteres, solo números son válidos.");
        }
        Matcher matcherColor = patronColor.matcher(this.color);
        if (!matcherColor.matches()) {
            throw new ValidacionDTOException("El color del automóvil no debe superar los 10 caracteres, solo letra son válidos.");
        }
    }
    
}
