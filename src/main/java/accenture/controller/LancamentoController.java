package accenture.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.model.Lancamento;
import accenture.model.PlanoConta;
import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.model.DTO.UsuarioLoginDTO;
import accenture.service.*;


@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Lancamento> PostCadastrar(@RequestBody Lancamento lancamento){	
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoService.CadastrarLancamento(lancamento));
	}
	
}
