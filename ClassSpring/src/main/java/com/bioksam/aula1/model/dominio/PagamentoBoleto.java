package com.bioksam.aula1.model.dominio;

import java.util.Date;

import javax.persistence.Entity;

import com.bioksam.aula1.model.dominio.enums.EstadoPagamento;

@Entity
public class PagamentoBoleto extends Pagamento {
    
    private static final long serialVersionUID = 1L;
    private Date dataPagamento;
    private Date dataVencimento;

   
    public PagamentoBoleto() {
        
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public Date getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    
    public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date dataVencimento) {
        super(id, estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    
}
