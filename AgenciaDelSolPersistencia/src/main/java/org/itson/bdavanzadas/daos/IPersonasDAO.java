package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta interfaz define métodos para acceder y manipular datos relacionados con personas en la base de datos.
 * Las clases que implementen esta interfaz deben proporcionar implementaciones de estos métodos para interactuar
 * con la base de datos y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla de personas.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IPersonasDAO {
    /**
     * Agrega una nueva persona a la base de datos.
     *
     * @param persona Persona nueva a agregar.
     * @return La persona recién agregada.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la base de datos.
     */
    public Persona agregarPersona(Persona persona) throws PersistenciaException;
    
    /**
     * Realiza una inserción masiva de 20 registros de personas, cuando el usuario
     * lo solicita.
     * @throws PersistenciaException Si ocurre un error durante la inserción a la base de datos.
     */
    public void insercionMasiva() throws PersistenciaException;
    
    
    /**
     * Realiza una consulta de personas en base a la rfc.
     * @param persona Persona a consultar.
     * @return La persona coincidente.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public Persona consultarPersonaPorRfc(Persona persona) throws PersistenciaException;
  
}
