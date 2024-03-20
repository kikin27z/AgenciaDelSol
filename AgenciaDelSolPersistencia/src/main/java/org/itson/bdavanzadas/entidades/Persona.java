package org.itson.bdavanzadas.entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa a una persona en el sistema.
 * Esta clase se mapea a una tabla en la base de datos utilizando JPA.
 * 
 * @author José Karim Franco Valencia - 245138
 * @author Jesus Rene Gonzalez Castro - 247336
 * @author Gael Rafael Castro Molina - 247887
 */
@Entity
@Table (name="personas")
@NamedStoredProcedureQueries({
  @NamedStoredProcedureQuery(
    name = "insercionMasiva", 
    procedureName = "insercion_masiva", 
    resultClasses = { Persona.class }) 
})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_persona")
    private Long id;

    @Column (name = "nombres", nullable = false, length = 50)
    private String nombres;
    
    @Column (name = "apellido_paterno", nullable = false, length = 30)
    private String apellidoPaterno;
    
    @Column (name = "apellido_materno", nullable = false, length = 30)
    private String apellidoMaterno;
    
    @Column (name = "telefono", nullable = false, length = 15)
    private String telefono;
    
    @Column (name = "rfc", nullable = false, length = 13, unique = true)
    private String rfc;
    
    @Column (name = "curp", nullable = false, length = 18, unique = true)
    private String curp;
    
    @Column (name = "fecha_nacimiento", nullable =  false)
    @Temporal (TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @Column (name = "discapacitado", nullable =  false)
    @Enumerated (EnumType.STRING)
    private Discapacidad discapacidad;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "persona")
    private List<Tramite> tramites;
    
    @OneToMany(mappedBy = "persona")
    private List<Vehiculo> vehiculos;
    
    /**
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona.
     * 
     * @param nombres           Los nombres de la persona.
     * @param apellidoPaterno   El apellido paterno de la persona.
     * @param apellidoMaterno   El apellido materno de la persona.
     * @param telefono          El teléfono de la persona.
     * @param rfc               El RFC de la persona.
     * @param curp              El CURP de la persona.
     * @param fechaNacimiento   La fecha de nacimiento de la persona.
     * @param discapacidad      El tipo de discapacidad de la persona.
     */
    public Persona(String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String rfc, String curp, Calendar fechaNacimiento, Discapacidad discapacidad) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.rfc = rfc;
        this.curp = curp;
        this.fechaNacimiento = fechaNacimiento;
        this.discapacidad = discapacidad;
    }
    
    /**
     * Obtiene el ID de la persona.
     * 
     * @return El ID de la persona.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la persona.
     * 
     * @param id El ID de la persona.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene los nombres de la persona.
     * 
     * @return Los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres de la persona.
     * 
     * @param nombres Los nombres de la persona.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     * 
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     * 
     * @param apellidoPaterno El apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     * 
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno de la persona.
     * 
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene el teléfono de la persona.
     * 
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     * 
     * @param telefono El teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el RFC de la persona.
     * 
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     * 
     * @param rfc El RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene el CURP de la persona.
     * 
     * @return El CURP de la persona.
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Establece el CURP de la persona.
     * 
     * @param curp El CURP de la persona.
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     * 
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * 
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el tipo de discapacidad de la persona.
     * 
     * @return El tipo de discapacidad de la persona.
     */
    public Discapacidad getDiscapacidad() {
        return discapacidad;
    }

    /**
     * Establece el tipo de discapacidad de la persona.
     * 
     * @param discapacidad El tipo de discapacidad de la persona.
     */
    public void setDiscapacidad(Discapacidad discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Obtiene la lista de trámites asociados a esta persona.
     * 
     * @return La lista de trámites asociados a esta persona.
     */
    public List<Tramite> getTramites() {
        return tramites;
    }

     /**
     * Establece la lista de trámites asociados a esta persona.
     * 
     * @param tramites La lista de trámites asociados a esta persona.
     */
    public void setTramites(List<Tramite> tramites) {
        this.tramites = tramites;
    }

    
    /**
     * Calcula y devuelve un valor hash basado en el ID de la persona.
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
     * Compara esta instancia de Persona con otro objeto para determinar igualdad.
     * Dos instancias de Persona son iguales si tienen el mismo ID, o si el otro objeto
     * es también una instancia de Persona y tiene el mismo ID.
     * 
     * @param object El objeto con el que se comparará esta instancia.
     * @return true si los objetos son iguales, false de lo contrario.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en cadena de esta instancia de Persona.
     * 
     * @return Una cadena que representa esta instancia de Persona.
     */
    @Override
    public String toString() {
        return "org.itson.bdavanzadas.entidades.Persona[ id=" + id + " ]";
    }
}
