/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "medicalcondition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicalcondition.findAll", query = "SELECT m FROM Medicalcondition m"),
    @NamedQuery(name = "Medicalcondition.findByIdMedicalcondition", query = "SELECT m FROM Medicalcondition m WHERE m.idMedicalcondition = :idMedicalcondition")})
public class Medicalcondition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedicalcondition")
    private Integer idMedicalcondition;
    @Lob
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "idMedicalcondition")
    private Collection<PersonMedicalcondition> personMedicalconditionCollection;

    public Medicalcondition() {
    }

    public Medicalcondition(Integer idMedicalcondition) {
        this.idMedicalcondition = idMedicalcondition;
    }

    public Integer getIdMedicalcondition() {
        return idMedicalcondition;
    }

    public void setIdMedicalcondition(Integer idMedicalcondition) {
        this.idMedicalcondition = idMedicalcondition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<PersonMedicalcondition> getPersonMedicalconditionCollection() {
        return personMedicalconditionCollection;
    }

    public void setPersonMedicalconditionCollection(Collection<PersonMedicalcondition> personMedicalconditionCollection) {
        this.personMedicalconditionCollection = personMedicalconditionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicalcondition != null ? idMedicalcondition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalcondition)) {
            return false;
        }
        Medicalcondition other = (Medicalcondition) object;
        if ((this.idMedicalcondition == null && other.idMedicalcondition != null) || (this.idMedicalcondition != null && !this.idMedicalcondition.equals(other.idMedicalcondition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mproject.Medicalcondition[ idMedicalcondition=" + idMedicalcondition + " ]";
    }
    
}
