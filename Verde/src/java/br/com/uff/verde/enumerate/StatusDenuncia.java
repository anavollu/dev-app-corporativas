package br.com.uff.verde.enumerate;

/**
 *
 * @author Felipe Vila Chã
 */
public enum StatusDenuncia {

    CRIADO(0),
    EM_ANALISE(1),
    ENCAMINHADO(2),
    REJEITADO(3);

    private Integer codigo;

    StatusDenuncia(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }
}
