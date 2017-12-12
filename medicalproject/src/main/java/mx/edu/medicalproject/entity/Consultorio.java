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
@Table(name = "consultorio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultorio.findAll", query = "SELECT c FROM Consultorio c"),
    @NamedQuery(name = "Consultorio.findByIdConsultorio", query = "SELECT c FROM Consultorio c WHERE c.idConsultorio = :idConsultorio"),
    @NamedQuery(name = "Consultorio.findByNombreConsultorio", query = "SELECT c FROM Consultorio c WHERE c.nombreConsultorio = :nombreConsultorio"),
    @NamedQuery(name = "Consultorio.findByEstado", query = "SELECT c FROM Consultorio c WHERE c.estado = :estado")})
public class Consultorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_consultorio")
    private Integer idConsultorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_consultorio")
    private String nombreConsultorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "consultorioId", fetch = FetchType.EAGER)
    private List<Cita> citaList;

    public Consultorio() {
    }

    public Consultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Consultorio(Integer idConsultorio, String nombreConsultorio, int estado) {
        this.idConsultorio = idConsultorio;
        this.nombreConsultorio = nombreConsultorio;
        this.estado = estado;
    }

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getNombreConsultorio() {
        return nombreConsultorio;
    }

    public void setNombreConsultorio(String nombreConsultorio) {
        this.nombreConsultorio = nombreConsultorio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsultorio != null ? idConsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultorio)) {
            return false;
        }
        Consultorio other = (Consultorio) object;
        if ((this.idConsultorio == null && other.idConsultorio != null) || (this.idConsultorio != null && !this.idConsultorio.equals(other.idConsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.edu.medicalproject.entity.Consultorio[ idConsultorio=" + idConsultorio + " ]";
    }
    
}
