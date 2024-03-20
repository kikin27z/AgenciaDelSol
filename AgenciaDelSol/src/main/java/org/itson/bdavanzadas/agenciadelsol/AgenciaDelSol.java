package org.itson.bdavanzadas.agenciadelsol;

import com.itson.bdavanzadas.negocio.IPersonasBO;
import com.itson.bdavanzadas.negocio.PersonasBO;
import javax.persistence.EntityManager;
import org.itson.bdavanzadas.conexion.Conexion;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class AgenciaDelSol {

    private static IPersonasBO personasBO;
    
    
    
    public static void main(String[] args) {
        IPersonasDAO personasDAO;
        IConexion conexion = new Conexion();
        personasBO = new PersonasBO(new PersonasDAO(conexion));
        
        
        
        
        Ventana ventana = new Ventana(personasBO);
        
        ventana.cambiarVistaInicio();
        ventana.setVisible(true);
    }
}
