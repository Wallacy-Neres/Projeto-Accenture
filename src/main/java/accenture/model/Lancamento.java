package accenture.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import accenture.enums.TipoMovimento;

@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLancamento;
	
	@Column(name = "id_conta", nullable = false)
	private int conta;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "data", nullable = false)
	private LocalDate data;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plano_conta", referencedColumnName = "id", nullable = false)
	private PlanoConta planoConta;
	
	@Column(name = "tipo_movimento", nullable = false)
	private TipoMovimento tipo;
	
	@Column(name = "valor", nullable = false)
	private double valor;
	
	public Lancamento() {}

	public int getIdLancamento() {
		return idLancamento;
	}
	public void setIdLancamento(int idLancamento) {
		this.idLancamento = idLancamento;
	}

	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
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

	public PlanoConta getPlanoConta() {
		return planoConta;
	}
	public void setPlanoConta(PlanoConta planoConta) {
		this.planoConta = planoConta;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}
