package accenture.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import accenture.model.Lancamento;
import accenture.model.PlanoConta;
import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.repository.LancamentoRepository;


@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repository;
	
	public Lancamento CadastrarLancamento(Lancamento lancamento) {
		return repository.save(lancamento);
	}
}
