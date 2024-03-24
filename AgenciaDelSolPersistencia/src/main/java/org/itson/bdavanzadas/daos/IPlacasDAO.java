package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.Vehiculo;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IPlacasDAO {

    /**
     * Agrega una nueva placa al sistema.
     *
     * @param placa La placa que se va a agregar.
     * @return La placa agregada.
     */
    public Placa agregarPlaca(Placa placa);
    
     /**
     * Desactiva todas las placas asociadas a un vehículo.
     *
     * @param vehiculo El vehículo para la cual se desactivarán las placas.
     */
    public void desactivarPlacas(Vehiculo vehiculo);
}
