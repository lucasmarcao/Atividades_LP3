/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "planetas")
@NamedQueries({
    @NamedQuery(name = "Planetas.findAll", query = "SELECT p FROM Planetas p")})
public class Planetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sigla_planeta")
    private String siglaPlaneta;
    @Basic(optional = false)
    @Column(name = "nome_planeta")
    private String nomePlaneta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planetassiglaplaneta")
    private List<Aliens> aliensList;

    public Planetas() {
    }

    public Planetas(String siglaPlaneta) {
        this.siglaPlaneta = siglaPlaneta;
    }

    public Planetas(String siglaPlaneta, String nomePlaneta) {
        this.siglaPlaneta = siglaPlaneta;
        this.nomePlaneta = nomePlaneta;
    }

    public String getSiglaPlaneta() {
        return siglaPlaneta;
    }

    public void setSiglaPlaneta(String siglaPlaneta) {
        this.siglaPlaneta = siglaPlaneta;
    }

    public String getNomePlaneta() {
        return nomePlaneta;
    }

    public void setNomePlaneta(String nomePlaneta) {
        this.nomePlaneta = nomePlaneta;
    }

    public List<Aliens> getAliensList() {
        return aliensList;
    }

    public void setAliensList(List<Aliens> aliensList) {
        this.aliensList = aliensList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siglaPlaneta != null ? siglaPlaneta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planetas)) {
            return false;
        }
        Planetas other = (Planetas) object;
        if ((this.siglaPlaneta == null && other.siglaPlaneta != null) || (this.siglaPlaneta != null && !this.siglaPlaneta.equals(other.siglaPlaneta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return siglaPlaneta + ";"+ nomePlaneta;
    }
    
}
