package accenture.DTO;

import accenture.enums.TipoMovimento;
import accenture.model.Conta;
import accenture.model.Lancamento;
import accenture.model.PlanoConta;

import javax.persistence.*;
import java.time.LocalDate;

public class LancamentoDTO {

    private Long idLancamento;

    private Long conta;

    private String descricao;

    private LocalDate data;

    private Long planoConta;

    private double valor;

    private Long contaDestino;

    public LancamentoDTO(){}

    public LancamentoDTO(Lancamento lancamento){
        this.idLancamento = lancamento.getIdLancamento();
        this.conta = lancamento.getConta().getId();
        this.data = lancamento.getData();
        this.descricao = lancamento.getDescricao();
        this.planoConta = lancamento.getPlanoConta().getId();
        this.valor = lancamento.getValor();
        if(lancamento.getContaDestino() != null) this.contaDestino = lancamento.getContaDestino().getId();
    }


    public Long getIdLancamento() {
        return idLancamento;
    }

    public void setIdLancamento(Long idLancamento) {
        this.idLancamento = idLancamento;
    }

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getPlanoConta() {
        return planoConta;
    }

    public void setPlanoConta(Long planoConta) {
        this.planoConta = planoConta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


    public Long getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }
}
