package accenture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.model.Lancamento;
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
