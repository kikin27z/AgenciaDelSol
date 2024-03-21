package org.itson.bdavanzadas.daos;

import javax.persistence.PersistenceException;
import org.itson.bdavanzadas.entidades.Automovil;
import org.itson.bdavanzadas.entidades.Vehiculo;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IVehiculosDAO {
    public Automovil agregarAutomovil(Automovil automovil) throws PersistenceException;
    
    public Vehiculo buscarVehiculo(Vehiculo vehiculo) throws PersistenceException;
}
