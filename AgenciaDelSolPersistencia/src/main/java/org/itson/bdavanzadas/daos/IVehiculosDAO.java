package org.itson.bdavanzadas.daos;

import javax.persistence.PersistenceException;
import org.itson.bdavanzadas.entidades.Automovil;
import org.itson.bdavanzadas.entidades.Vehiculo;

/**
 * Esta interfaz define métodos para acceder y manipular datos relacionados con
 * vehículos en la base de datos.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IVehiculosDAO {
    /**
     * Agrega un vehiculo a la base de datos.
     * 
     * @param vehiculo El vehiculo que se va a agregar.
     * @return El automóvil agregado.
     * @throws PersistenceException Si ocurre un error durante la persistencia.
     */
    public Vehiculo agregarAutomovil(Vehiculo vehiculo) throws PersistenceException;
    
     /**
     * Busca un automóvil en la base de datos.
     * 
     * @param automovil El automóvil que se va a buscar.
     * @return El automóvil encontrado.
     * @throws PersistenceException Si ocurre un error durante la búsqueda.
     */
    public Automovil buscarAutomovil(Automovil automovil) throws PersistenceException;
    
}
