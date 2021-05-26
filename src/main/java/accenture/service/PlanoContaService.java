package accenture.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accenture.DTO.PlanoContaDTO;
import accenture.exception.UsuarioNaoEncontradoException;
import accenture.model.PlanoConta;
import accenture.model.Usuario;
import accenture.repository.PlanoContaRepository;
import accenture.repository.UsuarioRepository;

@Service
public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public PlanoContaDTO CadastrarPlanoConta(PlanoContaDTO planoContaDTO) throws UsuarioNaoEncontradoException{
		PlanoConta planoConta = new PlanoConta();
		
		try {
			Usuario usuario = usuarioRepository.findByLogin(planoContaDTO.getLogin()).orElseThrow(() ->  new UsuarioNaoEncontradoException());
			planoConta.setUsuario(usuario);
			planoConta.setDescricao(planoContaDTO.getDescricao());
			planoConta.setPadrao(false);
			planoConta.setTipoMovimento(planoContaDTO.getTipoMovimento());
			return PlanoContaDTO.responsePlanoContaDTO(repository.save(planoConta));
		} catch(Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
			return null;
		}
		
	}
	
	public List<PlanoContaDTO> listarTodos() {
		List<PlanoConta> lista = repository.findAll();
		List<PlanoContaDTO> listaDto = new ArrayList<>();
		for (PlanoConta plano : lista) {
			PlanoContaDTO dto = new PlanoContaDTO(plano);
			listaDto.add(dto);
		}
		return listaDto;
	}

    public List<PlanoContaDTO> listarPlanosContasUsuario(String login) {
		List<PlanoConta> lista = repository.findAllByLogin(login);
		List<PlanoContaDTO> listaDto = new ArrayList<>();
		for (PlanoConta plano : lista) {
			PlanoContaDTO dto = new PlanoContaDTO(plano);
			listaDto.add(dto);
		}
		return listaDto;
    }
}
