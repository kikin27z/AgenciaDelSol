package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.ConsultaPlacaDTO;
import com.itson.bdavanzadas.dtos.PlacaNuevaDTO;
import com.itson.bdavanzadas.dtos.VehiculoNuevoDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.List;

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
    * Realiza el trámite para renovar la placa de un vehículo.
    * 
    * @param placaConsultadaDTO Objeto de tipo ConsultaPlacaDTO que contiene la información necesaria para el trámite.
    * @return Objeto de tipo ConsultaPlacaDTO que contiene la información de la nueva placa generada.
    */
    public ConsultaPlacaDTO realizarTramitePlaca(ConsultaPlacaDTO placaConsultadaDTO);
    
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
    
    /**
    * Verifica si ya existe un vehículo con el mismo número de serie en la base de datos.
    * 
    * @param vehiculoNuevoDTO Objeto de tipo VehiculoNuevoDTO que contiene la información del vehículo.
    * @throws ValidacionDTOException Si ya existe un vehículo con el mismo número de serie.
    */
    public void existeVehiculo(VehiculoNuevoDTO vehiculoNuevoDTO) throws ValidacionDTOException;
    
    /**
    * Consulta la información de una placa por su número.
    * 
    * @param consultaPlacaDTO Objeto de tipo ConsultaPlacaDTO que contiene el número de placa a consultar.
    * @return Objeto de tipo ConsultaPlacaDTO que contiene la información de la placa consultada.
    * @throws ValidacionDTOException Si no existe la placa buscada o si la placa pertenece a otra persona.
    */
    public ConsultaPlacaDTO consultarPlacaPorNumero(ConsultaPlacaDTO consultaPlacaDTO) throws ValidacionDTOException;
    
    /**
    * Consulta la información de una placa por su número.
    * No valida rfc`s.
    * 
    * @param consultaPlacaDTO Objeto de tipo ConsultaPlacaDTO que contiene el número de placa a consultar.
    * @return Objeto de tipo ConsultaPlacaDTO que contiene la información de la placa consultada.
    * @throws ValidacionDTOException Si no existe la placa buscada o si la placa pertenece a otra persona.
    */
    public ConsultaPlacaDTO consultarPlacaPorNumeroSinValidacion(ConsultaPlacaDTO consultaPlacaDTO) throws ValidacionDTOException;
    
    /**
     * Consulta las placas sin fecha de emisión.
     * @return lista de placas nuevas sin fecha de emisión.
     */
    public List<PlacaNuevaDTO> consultarPlacasSiEmision();
    
    /**
     * Modifica la fecha de recepcion de una placa ya previamente seleccionada,
     * por lo cual solo envia su numero de placa para encontrarla.
     *
     * @param numeroPlaca numero de placa a solicitar.
     */
    public void establecerFechaRecepcion(String numeroPlaca);
}
