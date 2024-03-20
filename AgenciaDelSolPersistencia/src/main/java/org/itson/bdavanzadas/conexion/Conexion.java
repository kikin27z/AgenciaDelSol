package org.itson.bdavanzadas.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Esta clase proporciona una implementación de la interfaz IConexion para crear una conexión
 * con el gestor de persistencia utilizando Java Persistence API (JPA).
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class Conexion implements IConexion{

    /**
     * Crea una conexión con el gestor de persistencia.
     * @return Un objeto EntityManager para interactuar con la base de datos.
     */
    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("AgenciaDelSolPU");
        // Solivitamos una entity manager (acceso a la BD)
        EntityManager entityManager = emFactory.createEntityManager();
        
        return entityManager;
    }
}
