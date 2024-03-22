/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.bdavanzadas.daos;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.itson.bdavanzadas.conexion.IConexion;
import org.itson.bdavanzadas.entidades.Licencia;

/**
 * Esta clase implementa la interfaz ILicenciasDAO y proporciona métodos para
 * realizar operaciones relacionadas con la entidad Licencia en la base de datos.
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class LicenciasDAO implements ILicenciasDAO{

    final IConexion conexion;
    static final Logger logger = Logger.getLogger(PersonasDAO.class.getName());

    public LicenciasDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Licencia tramitarLicencias(Licencia licencia) {
        EntityManager em = conexion.crearConexion();
        
        em.getTransaction().begin();
        
        em.persist(licencia);
        
        em.getTransaction().commit();
        
        em.close();
        
        return licencia;
    }
    
}
