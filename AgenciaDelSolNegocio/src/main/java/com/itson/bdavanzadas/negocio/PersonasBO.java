/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.itson.bdavanzadas.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.itson.bdavanzadas.daos.IPersonasDAO;
import org.itson.bdavanzadas.daos.PersonasDAO;
import org.itson.bdavanzadas.excepciones.PersistenciaException;

/**
 *
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
public class PersonasBO implements IPersonasBO{

    private IPersonasDAO personasDAO;
    static final Logger logger = Logger.getLogger(PersonasDAO.class.getName());

    public PersonasBO(IPersonasDAO personasDAO) {
        this.personasDAO = personasDAO;
    }
    
    @Override
    public void incersionMasivaPersonas() {
        try {
            personasDAO.insercionMasiva();
            logger.log(Level.INFO, "Se hizo la insercion correctamente");
        } catch (PersistenciaException ex) {
            Logger.getLogger(PersonasBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IPersonasDAO getPersonasDAO() {
        return personasDAO;
    }

    public void setPersonasDAO(IPersonasDAO personasDAO) {
        this.personasDAO = personasDAO;
    }
    
    
    
}
