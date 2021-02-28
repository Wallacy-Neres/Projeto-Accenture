package accenture.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import accenture.model.PlanoConta;
import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.repository.PlanoContaRepository;
import accenture.repository.UsuarioRepository;

@Service
public class PlanoContaService {
	
	@Autowired
	private PlanoContaRepository repository;
	
	public PlanoConta CadastrarPlanoConta(PlanoConta planoConta) {
		return repository.save(planoConta);
	}
}
