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
@Table(name = "tiposangre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposangre.findAll", query = "SELECT t FROM Tiposangre t"),
    @NamedQuery(name = "Tiposangre.findByIdTipoSangre", query = "SELECT t FROM Tiposangre t WHERE t.idTipoSangre = :idTipoSangre"),
    @NamedQuery(name = "Tiposangre.findByTipoSangre", query = "SELECT t FROM Tiposangre t WHERE t.tipoSangre = :tipoSangre")})
public class Tiposangre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_sangre")
    private Integer idTipoSangre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_sangre")
    private String tipoSangre;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "sangreTipo", fetch = FetchType.EAGER)
    private List<Paciente> pacienteList;

    public Tiposangre() {
    }

    public Tiposangre(Integer idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public Tiposangre(Integer idTipoSangre, String tipoSangre) {
        this.idTipoSangre = idTipoSangre;
        this.tipoSangre = tipoSangre;
    }

    public Integer getIdTipoSangre() {
        return idTipoSangre;
    }

    public void setIdTipoSangre(Integer idTipoSangre) {
        this.idTipoSangre = idTipoSangre;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    @XmlTransient
    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSangre != null ? idTipoSangre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposangre)) {
            return false;
        }
        Tiposangre other = (Tiposangre) object;
        if ((this.idTipoSangre == null && other.idTipoSangre != null) || (this.idTipoSangre != null && !this.idTipoSangre.equals(other.idTipoSangre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.medicalproject.entity.Tiposangre[ idTipoSangre=" + idTipoSangre + " ]";
    }
    
}
