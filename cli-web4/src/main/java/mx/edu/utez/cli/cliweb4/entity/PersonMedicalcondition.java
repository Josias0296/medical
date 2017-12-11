/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utez.cli.cliweb4.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "person_medicalcondition")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonMedicalcondition.findAll", query = "SELECT p FROM PersonMedicalcondition p"),
    @NamedQuery(name = "PersonMedicalcondition.findByIdPersonMedicalcondition", query = "SELECT p FROM PersonMedicalcondition p WHERE p.idPersonMedicalcondition = :idPersonMedicalcondition")})
public class PersonMedicalcondition implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerson_Medicalcondition")
    private Integer idPersonMedicalcondition;
    @JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
    @ManyToOne
    private Person idPerson;
    @JoinColumn(name = "idMedicalcondition", referencedColumnName = "idMedicalcondition")
    @ManyToOne
    private Medicalcondition idMedicalcondition;

    public PersonMedicalcondition() {
    }

    public PersonMedicalcondition(Integer idPersonMedicalcondition) {
        this.idPersonMedicalcondition = idPersonMedicalcondition;
    }

    public Integer getIdPersonMedicalcondition() {
        return idPersonMedicalcondition;
    }

    public void setIdPersonMedicalcondition(Integer idPersonMedicalcondition) {
        this.idPersonMedicalcondition = idPersonMedicalcondition;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    public Medicalcondition getIdMedicalcondition() {
        return idMedicalcondition;
    }

    public void setIdMedicalcondition(Medicalcondition idMedicalcondition) {
        this.idMedicalcondition = idMedicalcondition;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonMedicalcondition != null ? idPersonMedicalcondition.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonMedicalcondition)) {
            return false;
        }
        PersonMedicalcondition other = (PersonMedicalcondition) object;
        if ((this.idPersonMedicalcondition == null && other.idPersonMedicalcondition != null) || (this.idPersonMedicalcondition != null && !this.idPersonMedicalcondition.equals(other.idPersonMedicalcondition))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mproject.PersonMedicalcondition[ idPersonMedicalcondition=" + idPersonMedicalcondition + " ]";
    }
    
}
