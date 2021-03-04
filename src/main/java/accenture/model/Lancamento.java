package accenture.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import accenture.enums.TipoMovimento;

@Entity
@Table(name = "TB_LANCAMENTO")
public class Lancamento {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLancamento;
	
	@ManyToOne
	@JoinColumn(name="ID_CONTA")
	private Conta conta;
	
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	
	@Column(name = "DATA", nullable = false)
	private Date data;

	@OneToOne
	@JoinColumn(name = "ID_PLANO_CONTA", nullable = false)
	private PlanoConta planoConta;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_MOVIMENTO", nullable = false)
	private TipoMovimento tipo;
	
	@Min(value = 1, message = "Valor não pode ser menor que 1")
	@Column(name = "VALOR", nullable = false)
	private double valor;

	@ManyToOne
	@JoinColumn(name="ID_CONTA_DESTINO")
	private Conta contaDestino;

	public Long getIdLancamento() {
		return idLancamento;
	}

	public void setIdLancamento(Long idLancamento) {
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
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

	public Conta getContaDestino() {
		return contaDestino;
	}
	
	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	@Override
	public String toString() {
		return "Lancamento{" +
				"idLancamento=" + idLancamento +
				", conta=" + conta +
				", descricao='" + descricao + '\'' +
				", data=" + data +
				", planoConta=" + planoConta +
				", tipo=" + tipo +
				", valor=" + valor +
				'}';
	}

	
}
