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
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author karim
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            IConexion conexion = new Conexion();
            IPlacasDAO placasDao = new PlacasDAO(conexion);
            IPersonasDAO personaDao = new PersonasDAO(conexion);
            IVehiculosDAO vehiculoDAO = new VehiculosDAO(conexion);
            
            Persona persona = new Persona();
            persona.setRfc("KUBV931119SF4");
        try {
            persona = personaDao.consultarPersonaPorRfc(persona);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            Automovil auto = new Automovil("Nissan", "Sentra", "Negro", "7777", "2017", persona);
            auto = vehiculoDAO.agregarAutomovil(auto);
//            Automovil auto = new Automovil();
//            auto.setNumeroSerie("2222");
//            auto = vehiculoDAO.buscarAutomovil(auto);
            
            
            
            placasDao.desactivarPlacas(auto);
            Placa placa = new Placa();
            placa.setEstado(EstadoPlaca.HABILITADA);
            placa.setVehiculo(auto);
            placa.setCosto(200F);
            placa.setFechaEmision(Calendar.getInstance());
            placa.setNumero("ZRY-987");
            placa.setPersona(persona);
            placa.setVehiculo(auto);
            
            placasDao.agregarPlaca(placa);
            
//        try {
//            // TODO code application logic here
//            ILicenciasDAO licendiasDao = new LicenciasDAO(conexion);
//            
//            Persona persona = new Persona();
//            persona.setRfc("IUVO0407069Z3");
//            
//            licendiasDao.tieneLicenciaVigente(persona);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
    }
    
}
