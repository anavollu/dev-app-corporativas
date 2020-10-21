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
    , @NamedQuery(name = "Denuncia.findByLocalidade", query = "SELECT d FROM Denuncia d WHERE d.localidade = :localidade")
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
    @Column(name = "localidade")
    private String localidade;
    @Column(name = "cd_status")
    private Integer status;
    @ManyToOne
    @JoinColumn(name="usuario")
    private Usuario usuario;

    public Denuncia() {
    }

    public Denuncia(Integer idDenuncia) {
        this.id = idDenuncia;
    }

    public Denuncia(String descricao, String localidade, Usuario usuario) {
        this.descricao = descricao;
        this.localidade = localidade;
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

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
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
}