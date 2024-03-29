package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.dtos.VehiculoNuevoDTO;
import com.itson.bdavanzadas.dtos.ConsultaPlacaDTO;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.dtos.PlacaNuevaDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.daos.PlacasDAO;
import org.itson.bdavanzadas.daos.VehiculosDAO;
import org.itson.bdavanzadas.entidades.Automovil;
import org.itson.bdavanzadas.entidades.Discapacidad;
import org.itson.bdavanzadas.entidades.EstadoPlaca;
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
        
        VehiculoNuevoDTO vehiculoDTO = placaNuevaDTO.getVehiculo();
        
        switch (placaNuevaDTO.getTipoVehiculo()) {
            case "Automovil":
                vehiculo = new Automovil();
                placa.setTipoVehiculo(TVehiculo.Automovil);
                break;
        }
        
        vehiculo.setPersona(persona);
        iniciarVehiculo(vehiculo, vehiculoDTO);
        
        vehiculo = vehiculoDAO.agregarAutomovil(vehiculo);
        
        //Se asignan valores necesarios a la placa
        placa.setPersona(persona);
        placa.setVehiculo(vehiculo);
        placa.setCosto(placaNuevaDTO.getCosto());
        placa.setFechaEmision(Calendar.getInstance());
        placa.setEstado(EstadoPlaca.HABILITADA);
        placa.setNumero(placaNuevaDTO.getNumero());
        
        //Se agrega a la base de datos
        placa = placasDAO.agregarPlaca(placa);
        placaNuevaDTO.setFechaEmision(placa.getFechaEmision());
        return placaNuevaDTO;
    }
    
    /**
    * Inicializa un objeto Vehiculo con los datos proporcionados en un objeto VehiculoNuevoDTO.
    * 
    * @param vehiculo Objeto de tipo Vehiculo a inicializar.
    * @param vehiculoDTO Objeto de tipo VehiculoNuevoDTO que contiene la información del vehículo.
    */
    private void iniciarVehiculo(Vehiculo vehiculo, VehiculoNuevoDTO vehiculoDTO){
        vehiculo.setColor(vehiculoDTO.getColor());
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setNumeroSerie(vehiculoDTO.getNumeroSerie());
        vehiculo.setLinea(vehiculoDTO.getLinea());
        
    }
    
    /**
    * Realiza el trámite para renovar la placa de un vehículo.
    * 
    * @param placaConsultadaDTO Objeto de tipo ConsultaPlacaDTO que contiene la información necesaria para el trámite.
    * @return Objeto de tipo ConsultaPlacaDTO que contiene la información de la nueva placa generada.
    */
    @Override
    public ConsultaPlacaDTO realizarTramitePlaca(ConsultaPlacaDTO placaConsultadaDTO) {
        //Se busca el auto con el número de serie para renovar la placa
        Vehiculo vehiculo = new Vehiculo(placaConsultadaDTO.getVehiculo().getNumeroSerie());
        vehiculo = vehiculoDAO.buscarVehiculo(vehiculo);
        
        
        Placa placa = new Placa();
        //Se localiza a la persona para vincular los id a la placa
        Persona persona = new Persona();
        persona.setRfc(placaConsultadaDTO.getPersona().getRfc());
        try {
            persona = personaDAO.consultarPersonaPorRfc(persona);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacasBO.class.getName()).log(Level.SEVERE, "No se pudo encontrar a la persona intente de nuevo");
            return null;
        }
        
        //Se asignan valores necesarios a la placa
        placa.setCosto(placaConsultadaDTO.getCosto());
        placa.setEstado(EstadoPlaca.HABILITADA);
        placa.setFechaEmision(Calendar.getInstance());
        placa.setPersona(persona);
        placa.setVehiculo(vehiculo);
        placa.setNumero(placaConsultadaDTO.getNumero());
        
        switch (placaConsultadaDTO.getTipoVehiculo()) {
            case "Automovil":
                placa.setTipoVehiculo(TVehiculo.Automovil);
                break;
        }
        
        //Se desactivan las placas del vehiculo en cuestion
        placasDAO.desactivarPlacas(vehiculo);
        
        //Se agrega a la base de datos
        placa = placasDAO.agregarPlaca(placa);
        
        
        
        placaConsultadaDTO.setFechaEmision(placa.getFechaEmision());
        return placaConsultadaDTO;
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
            case "Automovil":
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
        placa.setNumero(numero);
        while(placasDAO.existeNumero(placa)){
            numero = generarNumeroPlaca();
            placa.setNumero(numero);
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

    /**
    * Verifica si ya existe un vehículo con el mismo número de serie en la base de datos.
    * 
    * @param vehiculoNuevoDTO Objeto de tipo VehiculoNuevoDTO que contiene la información del vehículo.
    * @throws ValidacionDTOException Si ya existe un vehículo con el mismo número de serie.
    */
    @Override
    public void existeVehiculo(VehiculoNuevoDTO vehiculoNuevoDTO) throws ValidacionDTOException{
        Vehiculo vehiculo = new Vehiculo(vehiculoNuevoDTO.getNumeroSerie());
        if(vehiculoDAO.existeNumeroSerie(vehiculo)){
            logger.log(Level.INFO, "Ya existe el número de serie del vehículo");
            throw new ValidacionDTOException("El número de serie ya existe en los registro, regrese y busque la placa");
        }
    }

    /**
    * Consulta la información de una placa por su número.
    * 
    * @param consultaPlacaDTO Objeto de tipo ConsultaPlacaDTO que contiene el número de placa a consultar.
    * @return Objeto de tipo ConsultaPlacaDTO que contiene la información de la placa consultada.
    * @throws ValidacionDTOException Si no existe la placa buscada o si la placa pertenece a otra persona.
    */
    @Override
    public ConsultaPlacaDTO consultarPlacaPorNumero(ConsultaPlacaDTO consultaPlacaDTO) throws ValidacionDTOException {
        Placa placa = new Placa();
        placa.setNumero(consultaPlacaDTO.getNumero());
        try {
            placa = placasDAO.buscarPlaca(placa);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacasBO.class.getName()).log(Level.SEVERE, "No existe el número de placa buscado");
            throw new ValidacionDTOException("Número de placa inesxistente");
        }
        
        if(!placa.getPersona().getRfc().equals(consultaPlacaDTO.getPersona().getRfc())){
            throw new ValidacionDTOException("Número de placa de otra persona");
        }
        
        Vehiculo vehiculo = placa.getVehiculo();
        
        consultaPlacaDTO.setVehiculo(new VehiculoNuevoDTO());
        consultaPlacaDTO.getVehiculo().setColor(vehiculo.getColor());
        consultaPlacaDTO.getVehiculo().setMarca(vehiculo.getMarca());
        consultaPlacaDTO.getVehiculo().setLinea(vehiculo.getLinea());
        consultaPlacaDTO.getVehiculo().setModelo(vehiculo.getModelo());
        consultaPlacaDTO.getVehiculo().setNumeroSerie(vehiculo.getNumeroSerie());
        consultaPlacaDTO.setTipoVehiculo(placa.getTipoVehiculo().toString());
        
        return consultaPlacaDTO;
    }

    /**
    * Consulta la información de una placa por su número.
    * Sin validar rfc`s.
    * 
    * @param consultaPlacaDTO Objeto de tipo ConsultaPlacaDTO que contiene el número de placa a consultar.
    * @return Objeto de tipo ConsultaPlacaDTO que contiene la información de la placa consultada.
    * @throws ValidacionDTOException Si no existe la placa buscada o si la placa pertenece a otra persona.
    */
    @Override
    public ConsultaPlacaDTO consultarPlacaPorNumeroSinValidacion(ConsultaPlacaDTO consultaPlacaDTO) throws ValidacionDTOException {
        Placa placa = new Placa();
        placa.setNumero(consultaPlacaDTO.getNumero());
        try {
            placa = placasDAO.buscarPlaca(placa);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacasBO.class.getName()).log(Level.SEVERE, "No existe el número de placa buscado");
            throw new ValidacionDTOException("Número de placa inesxistente");
        }
        
        Vehiculo vehiculo = placa.getVehiculo();
        
        consultaPlacaDTO.setVehiculo(new VehiculoNuevoDTO());
        consultaPlacaDTO.getVehiculo().setColor(vehiculo.getColor());
        consultaPlacaDTO.getVehiculo().setMarca(vehiculo.getMarca());
        consultaPlacaDTO.getVehiculo().setLinea(vehiculo.getLinea());
        consultaPlacaDTO.getVehiculo().setModelo(vehiculo.getModelo());
        consultaPlacaDTO.getVehiculo().setNumeroSerie(vehiculo.getNumeroSerie());
        consultaPlacaDTO.setTipoVehiculo(placa.getTipoVehiculo().toString());
        consultaPlacaDTO.setFechaEmision(placa.getFechaEmision());
        consultaPlacaDTO.setFechaRecepcion(placa.getFechaRecepcion());
        consultaPlacaDTO.setCosto(placa.getCosto());
        ConsultarPersonaDTO persona = new ConsultarPersonaDTO(
                placa.getPersona().getNombres(), 
                placa.getPersona().getApellidoPaterno(), 
                placa.getPersona().getApellidoMaterno()
        );
        consultaPlacaDTO.setPersona(persona);
        
        
        return consultaPlacaDTO;
    }
    
    @Override
    public List<PlacaNuevaDTO> consultarPlacasSiEmision() {
        List<Placa> placasEncontradas;
        try {
            placasEncontradas = placasDAO.consultarPlacasSiEmision();
            List<PlacaNuevaDTO> placas = new LinkedList<>();
            for (Placa placasEncontrada : placasEncontradas) {
                ConsultarPersonaDTO persona = new ConsultarPersonaDTO(
                        placasEncontrada.getPersona().getRfc(),
                        placasEncontrada.getPersona().getNombres(),
                        placasEncontrada.getPersona().getApellidoPaterno(),
                        placasEncontrada.getPersona().getApellidoMaterno(),
                        placasEncontrada.getPersona().getFechaNacimiento(),
                        placasEncontrada.getPersona().getTelefono(),
                        placasEncontrada.getPersona().getDiscapacidad()
                );

                VehiculoNuevoDTO vehhiculo = new VehiculoNuevoDTO(
                        placasEncontrada.getVehiculo().getNumeroSerie(),
                        placasEncontrada.getVehiculo().getColor(),
                        placasEncontrada.getVehiculo().getMarca(),
                        placasEncontrada.getVehiculo().getModelo(),
                        placasEncontrada.getVehiculo().getLinea(),
                        persona
                );

                PlacaNuevaDTO placa = new PlacaNuevaDTO(
                        vehhiculo,
                        placasEncontrada.getFechaRecepcion(),
                        placasEncontrada.getFechaEmision(),
                        placasEncontrada.getNumero(),
                        placasEncontrada.getEstado(),
                        placasEncontrada.getCosto(),
                        persona,
                        placasEncontrada.getTipoVehiculo().toString()
                );
                
                placas.add(placa);
            }
            return placas;
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacasBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void establecerFechaRecepcion(String numeroPlaca) {
        try {
            placasDAO.establecerFechaRecepcion(numeroPlaca);
        } catch (PersistenciaException ex) {
            Logger.getLogger(PlacasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
