package accenture.service;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return repository.save(usuario);
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByLogin(user.get().getLogin());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				String auth = user.get().getLogin() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setCodigo(usuario.get().getCodigo());

				return user;
			}
		}
		return null;
	}

	//public String checaDuplicidade(Usuario user) {
		//if (repository.findByEmail(user.getEmail()) != null)
			//return "Email já existente.";
		//else if (buscaPorCpf(user.getCpf()) != null)
			//return "Cpf já existente.";

		//return null;
	//}

	// public Usuario buscaPorEmail(String email) {
	// return repository.findByEmail(email);
	// }

	public Usuario buscaPorCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public List<Usuario> buscarTodos() {
		return repository.findAll();
	}
}
