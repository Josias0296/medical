/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.medicalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eduardo
 */
@Entity
@Table(name = "tipopersonal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopersonal.findAll", query = "SELECT t FROM Tipopersonal t"),
    @NamedQuery(name = "Tipopersonal.findByIdTipoPersonal", query = "SELECT t FROM Tipopersonal t WHERE t.idTipoPersonal = :idTipoPersonal"),
    @NamedQuery(name = "Tipopersonal.findByTipoPersonal", query = "SELECT t FROM Tipopersonal t WHERE t.tipoPersonal = :tipoPersonal")})
public class Tipopersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_personal")
    private Integer idTipoPersonal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_personal")
    private String tipoPersonal;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "tipoPersonalId", fetch = FetchType.EAGER)
    private List<Empleado> empleadoList;

    public Tipopersonal() {
    }

    public Tipopersonal(Integer idTipoPersonal) {
        this.idTipoPersonal = idTipoPersonal;
    }

    public Tipopersonal(Integer idTipoPersonal, String tipoPersonal) {
        this.idTipoPersonal = idTipoPersonal;
        this.tipoPersonal = tipoPersonal;
    }

    public Integer getIdTipoPersonal() {
        return idTipoPersonal;
    }

    public void setIdTipoPersonal(Integer idTipoPersonal) {
        this.idTipoPersonal = idTipoPersonal;
    }

    public String getTipoPersonal() {
        return tipoPersonal;
    }

    public void setTipoPersonal(String tipoPersonal) {
        this.tipoPersonal = tipoPersonal;
    }

    @XmlTransient
    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPersonal != null ? idTipoPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopersonal)) {
            return false;
        }
        Tipopersonal other = (Tipopersonal) object;
        if ((this.idTipoPersonal == null && other.idTipoPersonal != null) || (this.idTipoPersonal != null && !this.idTipoPersonal.equals(other.idTipoPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.medicalproject.entity.Tipopersonal[ idTipoPersonal=" + idTipoPersonal + " ]";
    }
    
}
