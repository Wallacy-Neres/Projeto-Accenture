package accenture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import accenture.enums.TipoConta;

@Entity
@Table(name = "tb_conta")
public class Conta {

	@Id
	@Column(name = "id_conta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "id_usuario", nullable = false)
	private int idUsuario;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "numero", nullable = false)
	private String numero;

	@Column(name = "tipo_conta", nullable = false)
	private TipoConta tipoConta;

	@Column(name = "saldo", nullable = false)
	private float saldo;
	
	public Conta() {}
	
	public Conta(String numero) {
		this.numero = numero;
		this.saldo = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
}