/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uff.verde.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Felipe Vila Chã
 */
@Entity
@Table(name = "doacoes")
@NamedQueries({
    @NamedQuery(name = "Doacoes.findAll", query = "SELECT d FROM Doacoes d")
    , @NamedQuery(name = "Doacoes.findByIdDoacao", query = "SELECT d FROM Doacoes d WHERE d.idDoacao = :idDoacao")
    , @NamedQuery(name = "Doacoes.findByValor", query = "SELECT d FROM Doacoes d WHERE d.valor = :valor")
    , @NamedQuery(name = "Doacoes.findByUsuario", query = "SELECT d FROM Doacoes d WHERE d.usuario = :usuario")
    , @NamedQuery(name = "Doacoes.findByDataRealizacao", query = "SELECT d FROM Doacoes d WHERE d.dataRealizacao = :dataRealizacao")})
@XmlRootElement
public class Doacoes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doacao")
    private Integer idDoacao;
    @Column(name = "valor")
    private double valor;
    @ManyToOne
    @JoinColumn(name="usuario", nullable=false)
    private Usuario usuario;
    @Column(name = "data_realizacao")
    @Temporal(TemporalType.DATE)
    private Date dataRealizacao;

    public Doacoes() {
    }

    public Doacoes(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }

    public Doacoes(double valor, Usuario usuario, Date dataRealizacao) {
        this.valor = valor;
        this.usuario = usuario;
        this.dataRealizacao = dataRealizacao;
    }

    public Integer getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(Date dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }
}
