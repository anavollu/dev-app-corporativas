/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uff.verde.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Felipe Vila Chã
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUser", query = "SELECT u FROM Usuario u WHERE u.id = :id")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")
    , @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
    , @NamedQuery(name = "Usuario.findByDataNasc", query = "SELECT u FROM Usuario u WHERE u.data_nascimento = :data_nascimento")
    , @NamedQuery(name = "Usuario.findByRg", query = "SELECT u FROM Usuario u WHERE u.rg = :rg")
    , @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "senha")
    private String senha;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date data_nascimento;
    @Column(name = "rg")
    private String rg;
    @Column(name = "email")
    private String email;
    @OneToMany(mappedBy="usuario")
    private List<Denuncia> denuncias;
    @OneToMany(mappedBy="usuario")
    private List<Doacoes> doacoes;

    public Usuario() {
    }

    public Usuario(Integer id) {
        this.id = id;
    }

    public Usuario(Integer idUser, String username, String senha, String nome, Date data_nascimento, String rg, String email) {
        this.id = idUser;
        this.username = username;
        this.senha = senha;
        this.nome = nome;
        this.data_nascimento = data_nascimento;
        this.rg = rg;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNasc() {
        return data_nascimento;
    }

    public void setDataNasc(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    public List<Doacoes> getDoacoes() {
        return doacoes;
    }

    public void setDoacoes(List<Doacoes> doacoes) {
        this.doacoes = doacoes;
    }
}
