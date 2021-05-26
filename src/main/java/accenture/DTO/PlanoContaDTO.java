package accenture.DTO;

import accenture.enums.TipoMovimento;
import accenture.model.PlanoConta;


public class PlanoContaDTO {
	
	private Long id;
	private String descricao;
	private String login;
	private TipoMovimento tipoMovimento;
	
	public PlanoContaDTO(PlanoConta plano) {
		this.id = plano.getId();
		this.login = plano.getUsuario().getLogin();
		this.descricao = plano.getDescricao();
		this.tipoMovimento = plano.getTipoMovimento();
	}
	
	public static PlanoContaDTO responsePlanoContaDTO(PlanoConta plano) {
		PlanoContaDTO planoContaDTO = new PlanoContaDTO(plano);
		return planoContaDTO;
	}
	
	
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(TipoMovimento tiposMovimento) {
		this.tipoMovimento = tiposMovimento;
	}
}
