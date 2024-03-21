package org.itson.bdavanzadas.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Clase que representa un automóvil en el sistema.
 * Esta clase extiende la clase Vehiculo y se mapea a una tabla en la base de datos utilizando JPA.
 * 
 * Un automóvil es un tipo específico de vehículo con características adicionales.
 * Esta clase no agrega nuevos atributos ni métodos, simplemente hereda los de la clase Vehiculo.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
@Entity
@DiscriminatorValue ("Automovil")
public class Automovil extends Vehiculo implements Serializable {

    public Automovil() {
    }

    
    
    public Automovil(String marca, String linea, String color, String numero_serie, String modelo, Persona persona) {
        super(marca, linea, color, numero_serie, modelo, persona);
    }

    
}
