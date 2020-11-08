package br.com.uff.verde.model;

import java.io.Serializable;
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
 * @author Felipe Vila Chã
 */
@Entity
@Table(name = "denuncia")
@NamedQueries({
    @NamedQuery(name = "Denuncia.findAll", query = "SELECT d FROM Denuncia d")
    , @NamedQuery(name = "Denuncia.findByIdDenuncia", query = "SELECT d FROM Denuncia d WHERE d.id = :id")
    , @NamedQuery(name = "Denuncia.findByDescricao", query = "SELECT d FROM Denuncia d WHERE d.descricao = :descricao")
    , @NamedQuery(name = "Denuncia.findByCdStatus", query = "SELECT d FROM Denuncia d WHERE d.status = :status")
    , @NamedQuery(name = "Denuncia.findByUsuario", query = "SELECT d FROM Denuncia d WHERE d.usuario = :usuario")})
@XmlRootElement
public class Denuncia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_denuncia")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "cd_status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="local")
    private Local local;

    public Denuncia() {
    }

    public Denuncia(Integer idDenuncia) {
        this.id = idDenuncia;
    }

    public Denuncia(String descricao, Usuario usuario) {
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}