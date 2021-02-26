package accenture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import accenture.model.Usuario;
import accenture.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		//usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return repository.save(usuario);
	}
	
	public String checaDuplicidade(Usuario user) {
		if(buscaPorEmail(user.getEmail()) != null)
			return "Email já existente.";
		else if(buscaPorCpf(user.getCpf()) != null)
			return "Cpf já existente.";
		
		return null;
	}
	
	public Usuario buscaPorEmail(String email) {
		return repository.findByEmail(email);
	}
	
	public Usuario buscaPorCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
	
	public List<Usuario> buscarTodos(){
		return repository.findAll();
	}
}
