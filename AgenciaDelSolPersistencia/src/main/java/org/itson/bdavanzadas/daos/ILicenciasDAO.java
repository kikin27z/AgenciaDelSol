/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import org.itson.bdavanzadas.entidades.Licencia;

/**
 * Esta interfaz define métodos para acceder y manipular datos relacionados con personas en la base de datos.
 * Las clases que implementen esta interfaz deben proporcionar implementaciones de estos métodos para interactuar
 * con la base de datos y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en la tabla de licencias.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public interface ILicenciasDAO {
    public Licencia tramitarLicencias(Licencia licencia);
}
