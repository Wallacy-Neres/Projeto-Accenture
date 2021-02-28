package accenture.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.model.PlanoConta;
import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.model.DTO.UsuarioLoginDTO;
import accenture.service.PlanoContaService;
import accenture.service.UsuarioService;

@RestController
@RequestMapping("/planoconta")
public class PlanoContaController {

	@Autowired
	private PlanoContaService planoContaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<PlanoConta> PostCadastrar(@RequestBody PlanoConta planoConta){	
		return ResponseEntity.status(HttpStatus.CREATED).body(planoContaService.CadastrarPlanoConta(planoConta));
	}
	
}
