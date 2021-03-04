package accenture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import accenture.enums.TipoConta;

@Entity
@Table(name = "TB_CONTA")
public class Conta {

	@Id
	@Column(name = "ID_CONTA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	@Column(name = "NUMERO", nullable = false)
	private String numero;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_CONTA", nullable = false)
	private TipoConta tipoConta;

	@Column(name = "SALDO", nullable = false)
	private float saldo;
	
	public Conta(String numero) {
		this.numero = numero;
		this.saldo = 0;
	}
	
	public Conta() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Conta{" +
				"id=" + id +
				", usuario=" + usuario +
				", numero='" + numero + '\'' +
				", tipoConta=" + tipoConta +
				", saldo=" + saldo +
				'}';
	}
}