package accenture.DTO;

import accenture.model.UsuarioLogin;

public class UsuarioLoginDTO {

	private String name;
	
	private String login;
	
	private String token;
	
	public static UsuarioLoginDTO responseUserLoginDTO(UsuarioLogin userLogin) {
		UsuarioLoginDTO userLoginDTO = new UsuarioLoginDTO();
		userLoginDTO.setName(userLogin.getNome());
		userLoginDTO.setLogin(userLogin.getLogin());
		userLoginDTO.setToken(userLogin.getToken());
		return userLoginDTO;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
