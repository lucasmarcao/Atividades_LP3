/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@Entity
@Table(name = "aliens")
@NamedQueries({
    @NamedQuery(name = "Aliens.findAll", query = "SELECT a FROM Aliens a")})

public class Aliens implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nome_alien")
    private String nomeAlien;
    @Basic(optional = false)
    @Column(name = "tipo_alien")
    private String tipoAlien;
    @Basic(optional = false)
    @Column(name = "altura")
    private double altura;
    @Basic(optional = false)
    @Column(name = "peso")
    private double peso;
    @Basic(optional = false)
    @Column(name = "primeira_aparicao")
    @Temporal(TemporalType.DATE)
    private Date primeiraAparicao;
    @Basic(optional = false)
    @Column(name = "foto")
    private String foto;
    @JoinColumn(name = "Planetas_sigla_planeta", referencedColumnName = "sigla_planeta")
    @ManyToOne(optional = false)
    private Planetas planetassiglaplaneta;

    public Aliens() {
        
    }
    
    public Aliens(String nomeAlien) {
        this.nomeAlien = nomeAlien;
    }

    public Aliens(String nomeAlien, String tipoAlien, double altura, double peso, Date primeiraAparicao, String foto) {
        this.nomeAlien = nomeAlien;
        this.tipoAlien = tipoAlien;
        this.altura = altura;
        this.peso = peso;
        this.primeiraAparicao = primeiraAparicao;
        this.foto = foto;
    }

    public String getNomeAlien() {
        return nomeAlien;
    }

    public void setNomeAlien(String nomeAlien) {
        this.nomeAlien = nomeAlien;
    }

    public String getTipoAlien() {
        return tipoAlien;
    }

    public void setTipoAlien(String tipoAlien) {
        this.tipoAlien = tipoAlien;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Date getPrimeiraAparicao() {
        return primeiraAparicao;
    }

    public void setPrimeiraAparicao(Date primeiraAparicao) {
        this.primeiraAparicao = primeiraAparicao;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Planetas getPlanetassiglaplaneta() {
        return planetassiglaplaneta;
    }

    public void setPlanetassiglaplaneta(Planetas planetassiglaplaneta) {
        this.planetassiglaplaneta = planetassiglaplaneta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomeAlien != null ? nomeAlien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aliens)) {
            return false;
        }
        Aliens other = (Aliens) object;
        if ((this.nomeAlien == null && other.nomeAlien != null) || (this.nomeAlien != null && !this.nomeAlien.equals(other.nomeAlien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return nomeAlien+ ";"
        + tipoAlien+ ";"+ 
        altura+ ";" +
        peso+ ";" + 
        (planetassiglaplaneta.getSiglaPlaneta()+" -> "+planetassiglaplaneta.getNomePlaneta())+ ";"+ 
        foto + ";"+
        simpleDateFormat.format(primeiraAparicao);
    }
    
}
