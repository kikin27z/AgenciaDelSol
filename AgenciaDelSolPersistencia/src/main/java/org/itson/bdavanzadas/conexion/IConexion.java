package org.itson.bdavanzadas.conexion;

import javax.persistence.EntityManager;

/**
 * Esta interfaz define un método para crear una conexión con el gestor de persistencia.
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface IConexion {
    /**
     * Crea una conexión con el gestor de persistencia.
     * @return Un objeto EntityManager para interactuar con la base de datos.
     */
    public EntityManager crearConexion();
}
