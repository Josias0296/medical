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
import javax.persistence.Lob;
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
@Table(name = "personalnfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personalnfo.findAll", query = "SELECT p FROM Personalnfo p"),
    @NamedQuery(name = "Personalnfo.findByIdPersonalInfo", query = "SELECT p FROM Personalnfo p WHERE p.idPersonalInfo = :idPersonalInfo")})
public class Personalnfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPersonalInfo")
    private Integer idPersonalInfo;
    @Lob
    @Column(name = "phone")
    private String phone;
    @Lob
    @Column(name = "cellphone")
    private String cellphone;
    @JoinColumn(name = "idPerson", referencedColumnName = "idPerson")
    @ManyToOne
    private Person idPerson;

    public Personalnfo() {
    }

    public Personalnfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public Integer getIdPersonalInfo() {
        return idPersonalInfo;
    }

    public void setIdPersonalInfo(Integer idPersonalInfo) {
        this.idPersonalInfo = idPersonalInfo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public Person getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Person idPerson) {
        this.idPerson = idPerson;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonalInfo != null ? idPersonalInfo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personalnfo)) {
            return false;
        }
        Personalnfo other = (Personalnfo) object;
        if ((this.idPersonalInfo == null && other.idPersonalInfo != null) || (this.idPersonalInfo != null && !this.idPersonalInfo.equals(other.idPersonalInfo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mproject.Personalnfo[ idPersonalInfo=" + idPersonalInfo + " ]";
    }
    
}
