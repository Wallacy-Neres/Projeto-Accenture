package accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import accenture.DTO.PlanoContaDTO;
import accenture.exception.UsuarioNaoEncontradoException;
import accenture.service.PlanoContaService;

@RestController
@RequestMapping("/planoconta")
public class PlanoContaController {

	@Autowired
	private PlanoContaService planoContaService;
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<PlanoContaDTO> PostCadastrar(@RequestBody PlanoContaDTO planoContaDTO) throws UsuarioNaoEncontradoException{	
		PlanoContaDTO usuario = planoContaService.CadastrarPlanoConta(planoContaDTO);
		if(usuario != null) 
			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping
	public ResponseEntity<List<PlanoContaDTO>> GetPlanoConta(){
		return ResponseEntity.ok(planoContaService.listarTodos());
	}

	@GetMapping("/{login}")
	public ResponseEntity<List<PlanoContaDTO>> GetPlanoContaUsuario(@PathVariable String login){
		return ResponseEntity.ok(planoContaService.listarPlanosContasUsuario(login));
	}
	
}
