/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.List;
import org.itson.bdavanzadas.encriptar.FiltrosReporte;
import org.itson.bdavanzadas.entidades.Tramite;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 * Interfaz que define los métodos para el acceso a datos relacionados con los
 * trámites.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface ITramitesDAO {

    /**
     * Realiza una consulta de los tramites según el criterio especificado.
     *
     * @return Una lista de objetos Tramite que cumplen con los criterios de
     * búsqueda especificados.
     * @throws PersistenciaException Si ocurre algún error durante la consulta
     * en la persistencia de datos.
     */
    public List<Tramite> consultarTramites() throws PersistenciaException;


    public List<Tramite> obtenerTramitesPorFiltros(FiltrosReporte filtro);
    
}