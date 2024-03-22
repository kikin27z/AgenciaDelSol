package org.itson.bdavanzadas.entidades;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase base que representa un trámite en el sistema.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA.
 * Utiliza la estrategia de herencia JOINED para la herencia de subclases.
 * Se utiliza un discriminador para distinguir entre las subclases.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
@Entity
@Table (name = "tramites")
@Inheritance (strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_tramite")
    private Long id;

    @Column (name = "fecha_emision", nullable = false)
    @Temporal (TemporalType.TIMESTAMP)
    private Calendar fechaEmision;
    
    @Column (name = "costo", nullable = false)
    private Float costo;
    
    @ManyToOne ()
    @JoinColumn (name = "id_persona", nullable = false)
    private Persona persona;
    
    /**
     * Constructor vacío de la clase Tramite.
     */
    public Tramite() {
    }

    /**
     * Constructor de la clase Tramite.
     *
     * Este constructor inicializa un objeto Tramite con la fecha de emisión, el
     * costo y la persona asociada proporcionados.
     *
     * @param fechaEmision La fecha en que se emite el trámite.
     * @param costo El costo asociado al trámite.
     * @param persona La persona asociada al trámite.
     */
    public Tramite(Calendar fechaEmision, Float costo, Persona persona) {
        this.fechaEmision = fechaEmision;
        this.costo = costo;
        this.persona = persona;
    }
    
    /**
     * Obtiene el ID del trámite.
     * 
     * @return El ID del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del trámite.
     * 
     * @param id El ID del trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de emisión del trámite.
     * 
     * @return La fecha de emisión del trámite.
     */
    public Calendar getFechaEmision() {
        return fechaEmision;
    }

    /**
     * Establece la fecha de emisión del trámite.
     * 
     * @param fechaEmision La fecha de emisión del trámite.
     */
    public void setFechaEmision(Calendar fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * Obtiene el costo del trámite.
     * 
     * @return El costo del trámite.
     */
    public Float getCosto() {
        return costo;
    }

    /**
     * Establece el costo del trámite.
     * 
     * @param costo El costo del trámite.
     */
    public void setCosto(Float costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la persona asociada al trámite.
     * 
     * @return La persona asociada al trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona asociada al trámite.
     * 
     * @param persona La persona asociada al trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Calcula y devuelve un valor hash basado en el ID del trámite.
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
     * Compara esta instancia de Tramite con otro objeto para determinar igualdad.
     * Dos instancias de Tramite son iguales si tienen el mismo ID, o si el otro objeto
     * es también una instancia de Tramite y tiene el mismo ID.
     * 
     * @param object El objeto con el que se comparará esta instancia.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena de esta instancia de Tramite.
     * 
     * @return Una cadena que representa esta instancia de Tramite.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.entidades.Tramite[ id=" + id + " ]";
    }

}
