package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultaPlacaDTO;
import com.itson.bdavanzadas.dtos.PlacaNuevaDTO;

/**
 * Esta interfaz define los métodos que deben ser implementados por las clases que manejan las placas de vehículos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IPlacasBO {
    /**
    * Realiza el trámite para obtener una nueva placa para un vehículo.
    * 
    * @param placaNuevaDTO Objeto de tipo PlacaNuevaDTO que contiene la información necesaria para el trámite.
    * @return Objeto de tipo PlacaNuevaDTO que contiene la información de la nueva placa generada.
    */
    public PlacaNuevaDTO realizarTramitePlaca(PlacaNuevaDTO placaNuevaDTO);
    
    /**
    * Calcula el costo de obtener una nueva placa para un vehículo nuevo, basado en el tipo de vehículo.
    * 
    * @param placaNuevaDTO Objeto de tipo PlacaNuevaDTO que contiene la información del vehículo.
    */
    public void calcularCostoVehiculoNuevo(PlacaNuevaDTO placaNuevaDTO);
    
    /**
    * Calcula el costo de obtener una nueva placa para un vehículo usado, basado en el tipo de vehículo.
    * 
    * @param placaConsultadaDTO Objeto de tipo ConsultaPlacaDTO que contiene la información del vehículo usado.
    */
    public void calcularCostoVehiculoUsado(ConsultaPlacaDTO placaConsultadaDTO);
    
    /**
    * Genera un nuevo número de placa de manera aleatoria.
    * 
    * @return Un nuevo número de placa generado.
    */
    public String generaPlacaNueva();
}
