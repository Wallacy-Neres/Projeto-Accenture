package accenture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accenture.model.Lancamento;
import accenture.repository.LancamentoRepository;


@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public Lancamento CadastrarLancamento(Lancamento lancamento) {
		return repository.save(lancamento);
	}
}
