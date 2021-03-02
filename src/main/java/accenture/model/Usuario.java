package accenture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {
	
	@Column(name="ID_USUARIO")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
		
	@Column(name = "SENHA", nullable = false, length = 100)
	@NotNull
	@Size(min = 5, max = 100)
	private String senha;
	
	@Column(name = "NOME", nullable = false, length = 50)
	@NotNull
	@Size(min = 2, max = 50)
	private String nome;
	
	@Column(name = "LOGIN", nullable = false, length = 50, unique = true)
	@NotNull
	@Size(min = 2, max = 50)
	private String login;
	
	@Column(name = "CPF", nullable = false, length = 30, unique = true)
	@NotNull
	private String cpf;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
