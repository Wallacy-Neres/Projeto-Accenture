package accenture.model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import accenture.enums.TiposMovimento;

@Entity
@Table(name = "tb_lancamento")
public class Lancamento {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLancamento;
	
	@ManyToOne
	@JoinColumn(name="ID_CONTA")
	private Conta conta;
	
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	
	@Column(name = "DATA", nullable = false)
	private LocalDate data;

	
	@Column(name = "PLANO_CONTA")
	private Long planoConta;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_MOVIMENTO", nullable = false)
	private TiposMovimento tipo;
	
	@Column(name = "VALOR", nullable = false)
	private double valor;

	public int getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(int idLancamento) {
		this.idLancamento = idLancamento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
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

	public TiposMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TiposMovimento tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
