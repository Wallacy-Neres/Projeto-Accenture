package accenture.model;

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
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import accenture.enums.TiposMovimento; 

@Entity
@Table(name = "TB_PLANO_CONTA")
public class PlanoConta {
	
	@Column(name="ID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "DESCRICAO", nullable = false, length = 100)
	@NotNull
	@Size(min = 5, max = 100)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;
	
	@Column(name = "PADRAO", length = 5)
	private Boolean padrao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_MOVIMENTO", nullable = false)
	private TiposMovimento tiposMovimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario login) {
		this.usuario = login;
	}

	public Boolean getPadrao() {
		return padrao;
	}

	public void setPadrao(Boolean padrao) {
		this.padrao = padrao;
	}

	public TiposMovimento getTiposMovimento() {
		return tiposMovimento;
	}

	public void setTiposMovimento(TiposMovimento tiposMovimento) {
		this.tiposMovimento = tiposMovimento;
	}	
	
	
}
