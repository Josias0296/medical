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
@Table(name = "role_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleAccount.findAll", query = "SELECT r FROM RoleAccount r"),
    @NamedQuery(name = "RoleAccount.findByIdRoleaccount", query = "SELECT r FROM RoleAccount r WHERE r.idRoleaccount = :idRoleaccount")})
public class RoleAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRole_account")
    private Integer idRoleaccount;
    @JoinColumn(name = "idRole", referencedColumnName = "idRole")
    @ManyToOne
    private Role idRole;
    @JoinColumn(name = "idAccount", referencedColumnName = "idAccount")
    @ManyToOne
    private Account idAccount;

    public RoleAccount() {
    }

    public RoleAccount(Integer idRoleaccount) {
        this.idRoleaccount = idRoleaccount;
    }

    public Integer getIdRoleaccount() {
        return idRoleaccount;
    }

    public void setIdRoleaccount(Integer idRoleaccount) {
        this.idRoleaccount = idRoleaccount;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    public Account getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Account idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoleaccount != null ? idRoleaccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleAccount)) {
            return false;
        }
        RoleAccount other = (RoleAccount) object;
        if ((this.idRoleaccount == null && other.idRoleaccount != null) || (this.idRoleaccount != null && !this.idRoleaccount.equals(other.idRoleaccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mproject.RoleAccount[ idRoleaccount=" + idRoleaccount + " ]";
    }
    
}
