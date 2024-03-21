package org.itson.bdavanzadas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa un vehículo en el sistema.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA.
 * 
 * Esta clase representa la información asociada a un vehículo, incluyendo su marca, línea, color,
 * número de serie, modelo y su relación con las placas asociadas y la persona propietaria.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
@Entity
@Table (name = "vehiculos")
@Inheritance (strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_vehiculo")
    private Long id;

    @Column (name = "marca", nullable = false, length = 50)
    private String marca;
    
    @Column (name = "linea", nullable = false, length = 50)
    private String linea;
    
    @Column (name = "color", nullable = false, length = 20)
    private String color;
    
    @Column (name = "numero_serie", nullable = false, length = 50, unique = true)
    private String numeroSerie;
    
    @Column (name = "modelo", nullable = false, length = 5)
    private String modelo;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "vehiculo")
    private List<Placa> placas;
    
    @ManyToOne
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona persona;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String linea, String color, String numeroSerie, String modelo, Persona persona) {
        this.marca = marca;
        this.linea = linea;
        this.color = color;
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.persona = persona;
    }
    
    
    
    
    /**
     * Obtiene el ID del vehículo.
     * 
     * @return El ID del vehículo.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del vehículo.
     * 
     * @param id El ID del vehículo.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la marca del vehículo.
     * 
     * @return La marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     * 
     * @param marca La marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene la línea del vehículo.
     * 
     * @return La línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     * 
     * @param linea La línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene el color del vehículo.
     * 
     * @return El color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     * 
     * @param color El color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el número de serie del vehículo.
     * 
     * @return El número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     * 
     * @param numeroSerie El número de serie del vehículo.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Obtiene el modelo del vehículo.
     * 
     * @return El modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     * 
     * @param modelo El modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la lista de placas asociadas al vehículo.
     * 
     * @return La lista de placas asociadas al vehículo.
     */
    public List<Placa> getPlacas() {
        return placas;
    }

    /**
     * Establece la lista de placas asociadas al vehículo.
     * 
     * @param placas La lista de placas asociadas al vehículo.
     */
    public void setPlacas(List<Placa> placas) {
        this.placas = placas;
    }

    /**
     * Obtiene la persona dueña del vehículo.
     * 
     * @return La persona dueña del vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona dueña del vehículo.
     * 
     * @param persona La persona dueña del vehículo.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

    /**
     * Calcula y devuelve un valor hash basado en el ID del vehículo.
     * 
     * @return El valor hash calculado.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara esta instancia de Vehiculo con otro objeto para determinar igualdad.
     * Dos instancias de Vehiculo son iguales si tienen el mismo ID, o si el otro objeto
     * es también una instancia de Vehiculo y tiene el mismo ID.
     * 
     * @param object El objeto con el que se comparará esta instancia.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena de esta instancia de Vehiculo.
     * 
     * @return Una cadena que representa esta instancia de Vehiculo.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.entidades.Vehiculo[ id=" + id + " ]";
    }

}
