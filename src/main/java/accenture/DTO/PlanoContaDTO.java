package accenture.DTO;

import accenture.enums.TipoMovimento;
import accenture.model.PlanoConta;


public class PlanoContaDTO {
	
	private Long id;
	private String descricao;
	private String login;
	private TipoMovimento tipoMovimento;
	
	public static PlanoContaDTO responsePlanoContaDTO(PlanoConta plano) {
		PlanoContaDTO planoContaDTO = new PlanoContaDTO();
		planoContaDTO.setId(plano.getId());
		planoContaDTO.setLogin(plano.getUsuario().getLogin());
		planoContaDTO.setDescricao(plano.getDescricao());
		planoContaDTO.setTipoMovimento(plano.getTipoMovimento());
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
