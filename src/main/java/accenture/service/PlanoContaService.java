package accenture.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accenture.model.PlanoConta;
import accenture.model.DTO.PlanoContaDTO;
import accenture.repository.PlanoContaDTORepository;
import accenture.repository.PlanoContaRepository;

@Service
public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository repository;
		
	public PlanoConta CadastrarPlanoConta(PlanoConta planoConta) {
		return repository.save(planoConta);
	}
	
	public List<PlanoContaDTO> listarTodos() {
		List<PlanoConta> lista = repository.findAll();
		List<PlanoContaDTO> listaDto = new ArrayList<>();
		for (PlanoConta plano : lista) {
			PlanoContaDTO dto = new PlanoContaDTO();
			dto.setId(plano.getId());
			dto.setDescricao(plano.getDescricao());
			dto.setLogin(plano.getUsuario().getLogin());
			dto.setTiposMovimento(plano.getTiposMovimento());
			
			listaDto.add(dto);
		}
		return listaDto;
	}
	
}
