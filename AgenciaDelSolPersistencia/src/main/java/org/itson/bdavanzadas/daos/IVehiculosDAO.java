package org.itson.bdavanzadas.daos;

import javax.persistence.PersistenceException;
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
     * Busca un vehículo en la base de datos utilizando el número de serie.
     * 
     * @param vehiculo El vehículo con el número de serie a buscar.
     * @return El vehículo encontrado.
     * @throws PersistenceException Si ocurre un error durante la búsqueda.
     */
    public Vehiculo buscarVehiculo(Vehiculo vehiculo) throws PersistenceException;
    
     /**
     * Verifica si ya existe un vehículo con el mismo número de serie en la base de datos.
     * 
     * @param vehiculo El vehículo con el número de serie a verificar.
     * @return true si ya existe un vehículo con el mismo número de serie, false de lo contrario.
     */
    public boolean existeNumeroSerie(Vehiculo vehiculo);
    
}
