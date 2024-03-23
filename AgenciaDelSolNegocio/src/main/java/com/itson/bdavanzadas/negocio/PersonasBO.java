package com.itson.bdavanzadas.negocio;

import com.itson.bdavanzadas.avisos.Aviso;
import com.itson.bdavanzadas.dtos.ConsultarPersonaDTO;
import com.itson.bdavanzadas.excepcionesdtos.ValidacionDTOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.encriptar.Encriptacion;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Clase que implementa la lógica de negocio relacionada con las personas.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class PersonasBO implements IPersonasBO {

    private IPersonasDAO personasDAO;
    static final Logger logger = Logger.getLogger(PersonasDAO.class.getName());
    IConexion conexion;
    Persona persona;

    /**
     * Constructor de la clase PersonasBO.
     *
     * Este constructor inicializa la conexión a la base de datos y el objeto de
     * acceso a datos (DAO) correspondiente.
     */
    public PersonasBO() {
        this.conexion = new Conexion();
        this.personasDAO = new PersonasDAO(conexion);
    }

    /**
     * Realiza una inserción masiva de personas en la base de datos.
     *
     * Este método se encarga de realizar una inserción masiva de personas en la
     * base de datos, utilizando el DAO correspondiente. Registra eventos de log
     * utilizando un Logger para llevar un registro de las operaciones
     * realizadas.
     */
    @Override
    public void insersionMasivaPersonas() {
        try {
            personasDAO.insercionMasiva();
            logger.log(Level.INFO, "Se hizo la insercion correctamente");
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        /**
     * Consulta una persona en la base de datos por su RFC.
     *
     * Este método busca una persona en la base de datos utilizando el RFC
     * proporcionado en un objeto ConsultarPersonaDTO. Retorna un objeto
     * ConsultarPersonaDTO con la información de la persona encontrada, o null
     * si no se encuentra o no cumple con los requisitos.
     *
     * @param personaDTO Objeto ConsultarPersonaDTO que contiene el RFC de la
     * persona a buscar.
     * @return ConsultarPersonaDTO con la información de la persona encontrada,
     * o null si no se encuentra o no cumple con los requisitos.
     * @throws ValidacionDTOException arroja la excepción si el rfc no existe en la base de datos.
     */
    @Override
    public ConsultarPersonaDTO consultarPersonaPorRfc(ConsultarPersonaDTO personaDTO) throws ValidacionDTOException{
        try {
            Persona personaBuscar = new Persona();
            personaBuscar.setRfc(personaDTO.getRfc());
            persona = personasDAO.consultarPersonaPorRfc(personaBuscar);
            ConsultarPersonaDTO personaEncontrada = new ConsultarPersonaDTO(
                    persona.getRfc(),
                    persona.getNombres(),
                    persona.getApellidoPaterno(),
                    persona.getApellidoMaterno(),
                    persona.getFechaNacimiento(),
                    Encriptacion.decriptar(persona.getTelefono()),
                    persona.getDiscapacidad()
            );

                return personaEncontrada;
        } catch (PersistenciaException ex) {
            throw new ValidacionDTOException(ex.getMessage());
        }
    }

    /**
     * Verifica si existen registros de personas.
     * 
     * @return true si hay registros de personas, false si la tabla está vacía.
     */
    @Override
    public boolean hayRegistros() {
        return personasDAO.hayRegistros();
    }
}
