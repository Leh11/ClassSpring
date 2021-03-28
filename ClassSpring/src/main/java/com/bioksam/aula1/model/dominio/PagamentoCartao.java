package com.bioksam.aula1.model.dominio;

import javax.persistence.Entity;

import com.bioksam.aula1.model.dominio.enums.EstadoPagamento;

@Entity
public class PagamentoCartao extends Pagamento{
  
    private static final long serialVersionUID = 1L;

    private Integer numeroParcela;

    public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer i) {
        super(id, estado, pedido);
        this.numeroParcela = i;
    }

    public PagamentoCartao() {
        
    }

    public Integer getNumeroParcela() {
        return numeroParcela;
    }

    public void setNumeroParcela(Integer numeroParcela) {
        this.numeroParcela = numeroParcela;
    }


    
}
