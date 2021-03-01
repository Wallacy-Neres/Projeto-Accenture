package accenture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import accenture.model.PlanoConta;
import accenture.model.DTO.PlanoContaDTO;
import accenture.repository.PlanoContaDTORepository;
import accenture.repository.PlanoContaRepository;
import accenture.service.PlanoContaService;

@RestController
@RequestMapping("/planoconta")
public class PlanoContaController {

	@Autowired
	private PlanoContaService planoContaService;
	
	
	@PostMapping("/cadastrar")
	public ResponseEntity<PlanoConta> PostCadastrar(@RequestBody PlanoConta planoConta){	
		return ResponseEntity.status(HttpStatus.CREATED).body(planoContaService.CadastrarPlanoConta(planoConta));
	}
	
	@GetMapping
	public ResponseEntity<List<PlanoContaDTO>> GetPlanoConta(){
		return ResponseEntity.ok(planoContaService.listarTodos());
	}
	
}
