package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.Vehiculo;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Esta interfaz define los métodos que deben ser implementados por cualquier clase que proporcione acceso a datos relacionados
 * con las placas y los vehículos en el sistema.
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
    
    /**
     * Verifica si un número de placa ya existe en el sistema.
     *
     * @param placa La placa para la cual se verificará la existencia del número.
     * @return true si el número de placa ya existe, false de lo contrario.
     */
    public boolean existeNumero(Placa placa);
    
    /**
     * Busca una placa en la base de datos utilizando su número.
     *
     * @param placa La placa con el número a buscar.
     * @return La placa encontrada.
     * @throws PersistenciaException Si no se encuentra la placa con el número especificado.
     */
    public Placa buscarPlaca(Placa placa) throws PersistenciaException;
}
