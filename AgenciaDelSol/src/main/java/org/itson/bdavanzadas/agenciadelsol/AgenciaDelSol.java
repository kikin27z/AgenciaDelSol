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
    
    
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        
        ventana.cambiarVistaInicio();
        ventana.setVisible(true);
    }
}
