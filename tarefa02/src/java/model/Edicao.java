package model;

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

/**
 *
 * @author Felipe Vila Chã
 */
@Entity
@Table(name = "edicao")
@NamedQueries({
    @NamedQuery(name = "Edicao.findAll", query = "SELECT e FROM Edicao e")
    , @NamedQuery(name = "Edicao.findById", query = "SELECT e FROM Edicao e WHERE e.id = :id")
    , @NamedQuery(name = "Edicao.findByNumero", query = "SELECT e FROM Edicao e WHERE e.numero = :numero")
    , @NamedQuery(name = "Edicao.findByAno", query = "SELECT e FROM Edicao e WHERE e.ano = :ano")
    , @NamedQuery(name = "Edicao.findByDataInicio", query = "SELECT e FROM Edicao e WHERE e.data_inicio = :data_inicio")
    , @NamedQuery(name = "Edicao.findByDataFim", query = "SELECT e FROM Edicao e WHERE e.data_fim = :data_fim")
    , @NamedQuery(name = "Edicao.findByCidade", query = "SELECT e FROM Edicao e WHERE e.cidade = :cidade")
    , @NamedQuery(name = "Edicao.findByPais", query = "SELECT e FROM Edicao e WHERE e.pais = :pais")
    , @NamedQuery(name = "Edicao.findByEvento", query = "SELECT e FROM Edicao e WHERE e.evento = :evento")})
public class Edicao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_edicao")
    private Integer id_edicao;
    @Column(name = "numero")
    private int numero;
    @Column(name = "ano")
    private Integer ano;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio")
    private Date data_inicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fim")
    private Date data_fim;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "pais")
    private String pais;
    @ManyToOne
    @JoinColumn(name="evento", nullable=false)
    private Evento evento;
    
    
    public Integer getId() {
        return id_edicao;
    }

    public void setId(Integer id) {
        this.id_edicao = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}
