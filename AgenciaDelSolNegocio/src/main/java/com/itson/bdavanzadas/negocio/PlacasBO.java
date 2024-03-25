package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.VehiculoNuevoDTO;
import com.itson.bdavanzadas.dtos.ConsultaPlacaDTO;
import com.itson.bdavanzadas.dtos.PlacaNuevaDTO;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.daos.PlacasDAO;
import org.itson.bdavanzadas.daos.VehiculosDAO;
import org.itson.bdavanzadas.entidades.Automovil;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.TVehiculo;
import org.itson.bdavanzadas.entidades.Vehiculo;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Clase que implementa la lógica de negocio para los trámites relacionados con las placas de vehículos.
 * 
 * Esta clase proporciona métodos para realizar trámites de placas nuevas, calcular el costo de placas para
 * vehículos nuevos y usados, y generar números de placas aleatorios.
 * Utiliza objetos DAO para acceder a la capa de persistencia y un objeto de conexión para establecer
 * la conexión necesaria con la base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class PlacasBO implements  IPlacasBO{

    static final Logger logger = Logger.getLogger(PlacasBO.class.getName());
    private PlacasDAO placasDAO;
    private VehiculosDAO vehiculoDAO;
    private PersonasDAO personaDAO;
    private IConexion conexion;

    /**
     * Constructor de la clase PlacasBO.
     * 
     * Este constructor inicializa la conexión a la base de datos y los objetos DAO necesarios para acceder a la capa de persistencia.
     */
    public PlacasBO() {
        this.conexion = new Conexion();
        placasDAO = new PlacasDAO(conexion);
        vehiculoDAO = new VehiculosDAO(conexion);
        personaDAO = new PersonasDAO(conexion); 
    }

    /**
    * Realiza el trámite para obtener una nueva placa para un vehículo.
    * 
    * @param placaNuevaDTO Objeto de tipo PlacaNuevaDTO que contiene la información necesaria para el trámite.
    * @return Objeto de tipo PlacaNuevaDTO que contiene la información de la nueva placa generada.
    */
    @Override
    public PlacaNuevaDTO realizarTramitePlaca(PlacaNuevaDTO placaNuevaDTO) {
        Vehiculo vehiculo = null;
        Placa placa = new Placa();
        
        Persona persona = new Persona();
        persona.setRfc(placaNuevaDTO.getPersona().getRfc());
        try {
            persona = personaDAO.consultarPersonaPorRfc(persona);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacasBO.class.getName()).log(Level.SEVERE, "No se pudo encontrar a la persona intente de nuevo");
            return null;
        }
        
        
        switch (placaNuevaDTO.getTipoVehiculo()) {
            case "Automovil":
                vehiculo = new Automovil();
                placa.setTipoVehiculo(TVehiculo.AUTOMOVIL);
                break;
        }
        
        vehiculo.setColor(placaNuevaDTO.getVehiculo().getColor());
        vehiculo.setMarca(placaNuevaDTO.getVehiculo().getMarca());
        vehiculo.setModelo(placaNuevaDTO.getVehiculo().getModelo());
        vehiculo.setNumeroSerie(placaNuevaDTO.getVehiculo().getNumeroSerie());
        vehiculo.setLinea(placaNuevaDTO.getVehiculo().getLinea());
        vehiculo.setPersona(persona);
        
        vehiculo = vehiculoDAO.agregarAutomovil(vehiculo);
        
        placa.setPersona(persona);
        placa.setFechaEmision(Calendar.getInstance());
        placa.setCosto(placaNuevaDTO.getCosto());
        placa.setVehiculo(vehiculo);
        placa.setNumero(placaNuevaDTO.getNumero());
        placa = placasDAO.agregarPlaca(placa);
        placaNuevaDTO.setFechaEmision(placa.getFechaEmision());
        
        return placaNuevaDTO;
    }
    
    /**
    * Calcula el costo de obtener una nueva placa para un vehículo nuevo, basado en el tipo de vehículo.
    * 
    * @param placaNuevaDTO Objeto de tipo PlacaNuevaDTO que contiene la información del vehículo.
    */
    @Override
    public void calcularCostoVehiculoNuevo(PlacaNuevaDTO placaNuevaDTO) {
        switch (placaNuevaDTO.getTipoVehiculo()) {
            case "Automovil":
                placaNuevaDTO.setCosto(1500F);
                break;
        }
        
    }
    /**
    * Calcula el costo de obtener una nueva placa para un vehículo usado, basado en el tipo de vehículo.
    * 
    * @param placaDTO Objeto de tipo ConsultaPlacaDTO que contiene la información del vehículo usado.
    */
    @Override
    public void calcularCostoVehiculoUsado(ConsultaPlacaDTO placaDTO) {
        switch (placaDTO.getTipoVehiculo()) {
            case "AUTOMOVIL":
                placaDTO.setCosto(1000F);
                break;
        }  
    }

    /**
    * Genera un nuevo número de placa de manera aleatoria.
    * 
    * @return Un nuevo número de placa generado.
    */
    @Override
    public String generaPlacaNueva() {
        String numero = generarNumeroPlaca();
        Placa placa = new Placa();
        placa.setNumero("ABC-987");
        while(placasDAO.existeNumero(placa)){
            numero = generarNumeroPlaca();
        }
        
        logger.log(Level.INFO, "Se genero un nuevo numero de placa");
        return numero;
    }
    
    /**
    * Genera un nuevo número de placa de manera aleatoria.
    * 
    * @return Un nuevo número de placa generado.
    */
    private String generarNumeroPlaca(){
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // Números del 0 al 9
        String numeros = "0123456789";

        // Creamos un objeto Random para generar valores aleatorios
        Random random = new Random();

        // Generamos las tres letras aleatorias
        StringBuilder sbLetras = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(letras.length());
            sbLetras.append(letras.charAt(index));
        }

        // Generamos los tres números aleatorios
        StringBuilder sbNumeros = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(numeros.length());
            sbNumeros.append(numeros.charAt(index));
        }

        // Concatenamos las letras, el guion y los números para formar la secuencia
        return sbLetras.toString() + "-" + sbNumeros.toString();
    } 

    
}
