package org.itson.bdavanzadas.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.IVehiculosDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.daos.VehiculosDAO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author karim
 */
public class AgenciaDelSolPersistencia {

    public static void main(String[] args) {
            IConexion conexion = new Conexion();
            IPersonasDAO personasDAO = new PersonasDAO(conexion);
            IVehiculosDAO vehiculoDAO = new VehiculosDAO(conexion);
            
            EntityManager entity = conexion.crearConexion();
            
            Persona gael = entity.find(Persona.class, 6L);
            Persona karim = entity.find(Persona.class, 1L);
            Persona madero = entity.find(Persona.class, 12L);
            
            Automovil vehiculo = new Automovil("Honda", "Civic", "Lima", "NL53WSJ2CDJ7TG04", "2016", karim);
            Automovil vehiculo2 = new Automovil("Suzuki", "Vitara", "Rojo", "MWNJFN8E2T7HSRFR", "2001", gael);
            Automovil vehiculo3 = new Automovil("Nissan", "Sentra", "Negro", "ZR9TVHKB6VM19YEJ", "2020", madero);
            Automovil vehiculo4 = new Automovil("Jeep", "Patriot", "Gris", "J2K9NBKPPDNANMPS", "2022", gael);
            
       Automovil auxAuto = new Automovil();
       auxAuto.setNumeroSerie("5QCYUWV3XNPX9NLY");
            
//       Vehiculo autoBuscar = vehiculoDAO.buscarAutomovil(auxAuto);

       
//            
//            EntityManager entityManager = conexion.crearConexion();
//            try {
////            personasDAO.agregarPersona(persona);
//            personasDAO.insercionMasiva();
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(AgenciaDelSolPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            
//            Vehiculo auto = new Automovil();
//            auto.setColor("Rojo pasion");
//            auto.setLinea("Civic");
//            auto.setModelo("2016");
//            auto.setMarca("Honda");
//
//
//            
//            Licencia licencia = new Licencia();
//            licencia.setEstado(EstadoLicencia.ACTIVA);
//            licencia.setVigenciaAnios(3);
//            licencia.setFechaEmision(Calendar.getInstance());
//            licencia.setNombre("Karim Franco");
//            
//            Placa placa = new Placa();
//            
//            placa.setFechaEmision(Calendar.getInstance());
//            placa.setNumero("ABC-123");
//            auto.setNumero_serie(placa.getNumero());
//           placa.setNombre("Luis Miguel");
//
//
//           
//           List<Tramite> tramites = new ArrayList<>();
//
//
//
//
//           
//            // Iniciamos una transaccion nueva
//            entityManager.getTransaction().begin();
//            Persona persona = entityManager.find(Persona.class, 1L);
//            // Marca el jugador nuevo para guardarlo
//            licencia.setPersona(persona);
//            placa.setPersona(persona);
//            auto.setPersona(persona);
//            licencia.calcularCosto();
//            placa.setCosto(400F);
//            placa.setVehiculo(auto);
//            tramites.add(placa);
//           tramites.add(licencia);
//            persona.setTramites(tramites);
//            // Manda los cambios de la transacción
//            entityManager.getTransaction().commit();
//
//            entityManager.close();
//            
//        System.out.println(persona.getDiscapacidad());
//
//        
    }
}
