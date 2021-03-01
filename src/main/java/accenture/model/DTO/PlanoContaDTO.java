package accenture.model.DTO;

import accenture.enums.TiposMovimento;
import accenture.model.PlanoConta;
import accenture.model.Usuario;


public class PlanoContaDTO {
	
	private Long id;
	private String descricao;
	private String login;
	private TiposMovimento tiposMovimento;
	
	public static PlanoContaDTO responsePlanoContaDTO(PlanoConta plano) {
		PlanoContaDTO planoContaDTO = new PlanoContaDTO();
		planoContaDTO.setId(plano.getId());
		planoContaDTO.setDescricao(plano.getDescricao());
		planoContaDTO.setTiposMovimento(plano.getTiposMovimento());
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
	public TiposMovimento getTiposMovimento() {
		return tiposMovimento;
	}
	public void setTiposMovimento(TiposMovimento tiposMovimento) {
		this.tiposMovimento = tiposMovimento;
	}
	
}
