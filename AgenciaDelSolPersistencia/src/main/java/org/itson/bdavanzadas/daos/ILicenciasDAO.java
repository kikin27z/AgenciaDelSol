package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.entidades.Licencia;
import org.itson.bdavanzadas.entidades.Persona;

/**
 * Esta interfaz define métodos para acceder y manipular datos relacionados con
 * personas en la base de datos. Las clases que implementen esta interfaz deben
 * proporcionar implementaciones de estos métodos para interactuar con la base
 * de datos y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en
 * la tabla de licencias.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface ILicenciasDAO {

    /**
     * Tramita una licencia en el sistema.
     *
     * @param licencia La licencia que se va a tramitar.
     * @return La licencia tramitada.
     */
    public Licencia tramitarLicencias(Licencia licencia);

    /**
     * Desactiva todas las licencias asociadas a una persona.
     *
     * @param persona La persona para la cual se desactivarán las licencias.
     */
    public void desactivarLicencias(Persona persona);
}
