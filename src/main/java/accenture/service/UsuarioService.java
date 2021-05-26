package accenture.service;

//import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

//import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import accenture.enums.TipoConta;
import accenture.enums.TipoMovimento;
import accenture.model.Conta;
import accenture.model.PlanoConta;
import accenture.model.Usuario;
import accenture.model.UsuarioLogin;
import accenture.repository.ContaRepository;
import accenture.repository.PlanoContaRepository;
import accenture.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private PlanoContaRepository planoContaRepository;
	
	@Autowired
	private TokenService tokenService;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		usuarioRepository.save(usuario);
		cadastrarConta(usuario);
		cadastrarPlanoContasPadrao(usuario);
		return usuario;
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepository.findByLogin(user.get().getLogin());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
		    user.get().setToken(TokenService.JWT_PREFIX + tokenService.geraToken(usuario.get()));
				user.get().setNome(usuario.get().getNome());
				user.get().setCodigo(usuario.get().getCodigo());

				return user;
			}
		}
		return null;
	}

	public Usuario buscaPorCpf(String cpf) {
		return usuarioRepository.findByCpf(cpf);
	}

	public List<Usuario> buscarTodos() {
		return usuarioRepository.findAll();
	}
	
	private void cadastrarConta(Usuario usuario) {
		Conta contaDebito = new Conta(usuario.getLogin());
		contaDebito.setUsuario(usuario);
		contaDebito.setTipoConta(TipoConta.CONTA_DEBITO);
		
		Conta contaCredito = new Conta(usuario.getLogin());
		contaCredito.setUsuario(usuario);
		contaCredito.setTipoConta(TipoConta.CONTA_CREDITO);
		
		contaRepository.save(contaDebito);
		contaRepository.save(contaCredito);
	}
	
//  Gerar Todos os Planos de Contas Padrão
	public void cadastrarPlanoContasPadrao(Usuario usuario){
		//Plano de Conta Padrao Receitas
		PlanoConta planoContaReceitas = new PlanoConta(usuario, "Receitas", true, TipoMovimento.RECEITAS);
		//Plano de Conta Padrao Despesas
		PlanoConta planoContaDespesas = new PlanoConta(usuario, "Despesas", true, TipoMovimento.DESPESAS);
		//Plano de Conta Padrao Transferência Contas
		PlanoConta planoContaTransferenciaContas = new PlanoConta(usuario, "Transferência entre Contas", true, TipoMovimento.TRANSFERENCIAS_CONTAS);
		//Plano de Conta Padrao Transferência Usuários
		PlanoConta planoContaTransferenciaUsuarios= new PlanoConta(usuario, "Transferência entre Usuarios", true, TipoMovimento.TRANSFERENCIAS_USUARIOS);

		// Persistindo os planos no banco de dados
		planoContaRepository.save(planoContaReceitas); // Planos Receita
		planoContaRepository.save(planoContaDespesas); // Planos Depesas
		planoContaRepository.save(planoContaTransferenciaContas); // Planos Transferencia Contas
		planoContaRepository.save(planoContaTransferenciaUsuarios); // Planos Transferencias usuarios
	}
}
