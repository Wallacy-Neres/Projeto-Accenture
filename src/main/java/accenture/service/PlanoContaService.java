package accenture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accenture.model.PlanoConta;
import accenture.repository.PlanoContaRepository;

@Service
public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository repository;
	
	public PlanoConta CadastrarPlanoConta(PlanoConta planoConta) {
		return repository.save(planoConta);
	}
}
