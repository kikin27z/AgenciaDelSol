/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.Automovil;
import org.itson.bdavanzadas.entidades.EstadoPlaca;
import org.itson.bdavanzadas.entidades.Persona;
import org.itson.bdavanzadas.entidades.Placa;
import org.itson.bdavanzadas.entidades.TVehiculo;
import org.itson.bdavanzadas.entidades.Vehiculo;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author karim
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws PersistenciaException {
            IConexion conexion = new Conexion();
            IPlacasDAO placasDao = new PlacasDAO(conexion);
            IPersonasDAO personaDao = new PersonasDAO(conexion);
            IVehiculosDAO vehiculoDAO = new VehiculosDAO(conexion);
            
            Vehiculo vehiculo1 = new Vehiculo("ASDFF12334");
            Vehiculo vehiculo2 = new Automovil("23");
            
            Placa placa1 = new Placa();
            
            ITramitesDAO tramitesDAO = new TramitesDAO(conexion);
            
            
            
//            placasDao.buscarVehiculo(placa1);
        
    }
    
}
