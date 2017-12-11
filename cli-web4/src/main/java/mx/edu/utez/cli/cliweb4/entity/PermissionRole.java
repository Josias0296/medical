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
@Table(name = "permission_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermissionRole.findAll", query = "SELECT p FROM PermissionRole p"),
    @NamedQuery(name = "PermissionRole.findByIdPermissionrole", query = "SELECT p FROM PermissionRole p WHERE p.idPermissionrole = :idPermissionrole")})
public class PermissionRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermission_role")
    private Integer idPermissionrole;
    @JoinColumn(name = "idPermission", referencedColumnName = "idPermission")
    @ManyToOne
    private Permission idPermission;
    @JoinColumn(name = "idRole", referencedColumnName = "idRole")
    @ManyToOne
    private Role idRole;

    public PermissionRole() {
    }

    public PermissionRole(Integer idPermissionrole) {
        this.idPermissionrole = idPermissionrole;
    }

    public Integer getIdPermissionrole() {
        return idPermissionrole;
    }

    public void setIdPermissionrole(Integer idPermissionrole) {
        this.idPermissionrole = idPermissionrole;
    }

    public Permission getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Permission idPermission) {
        this.idPermission = idPermission;
    }

    public Role getIdRole() {
        return idRole;
    }

    public void setIdRole(Role idRole) {
        this.idRole = idRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermissionrole != null ? idPermissionrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermissionRole)) {
            return false;
        }
        PermissionRole other = (PermissionRole) object;
        if ((this.idPermissionrole == null && other.idPermissionrole != null) || (this.idPermissionrole != null && !this.idPermissionrole.equals(other.idPermissionrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mproject.PermissionRole[ idPermissionrole=" + idPermissionrole + " ]";
    }
    
}
