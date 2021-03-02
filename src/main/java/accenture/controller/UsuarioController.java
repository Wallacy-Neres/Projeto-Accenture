package accenture.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.model.DTO.UsuarioLoginDTO;
import accenture.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> PostCadastrar(@RequestBody Usuario user){
		//if(usuarioService.checaDuplicidade(user) != null)
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(user));
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLoginDTO> Autentication(@RequestBody Optional<UsuarioLogin> user){
		usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
		UsuarioLoginDTO userLoginDTO = new UsuarioLoginDTO();
		userLoginDTO.setName(user.get().getNome());
		userLoginDTO.setLogin(user.get().getLogin());
		userLoginDTO.setToken(user.get().getToken());
		return ResponseEntity.ok(userLoginDTO);
	}
	
}
