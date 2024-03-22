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
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author karim
 */
public class AgenciaDelSolPersistencia {

    public static void main(String[] args) {
            IConexion conexion = new Conexion();
            IPersonasDAO personasDAO = new PersonasDAO(conexion);
            
            
//       
//            try{
//                Persona persona = personasDAO.consultarPersonaPorCurp("CAMG040802HSRSLLA5");
//                System.out.println(persona);
//            }catch(PersistenciaException ex) {
//            Logger.getLogger(AgenciaDelSolPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
            
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
