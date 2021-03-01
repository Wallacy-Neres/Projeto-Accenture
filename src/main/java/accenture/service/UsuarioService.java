package accenture.service;

<<<<<<< Updated upstream
=======
import java.nio.charset.Charset;
import java.util.ArrayList;
>>>>>>> Stashed changes
import java.util.List;

<<<<<<< Updated upstream
=======
import accenture.model.PlanoConta;
import org.apache.commons.codec.binary.Base64;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

<<<<<<< Updated upstream
=======
import accenture.enums.TipoConta;
import accenture.enums.TiposMovimento;
import accenture.model.Conta;
>>>>>>> Stashed changes
import accenture.model.Usuario;
import accenture.repository.UsuarioRepository;
import accenture.repository.PlanoContaRepository;

@Service
public class UsuarioService {
	
	@Autowired
<<<<<<< Updated upstream
	private UsuarioRepository repository;
	
	public Usuario CadastrarUsuario(Usuario usuario) {
		//usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		return repository.save(usuario);
=======
	private ContaRepository contaRepository;

	@Autowired
	private PlanoContaRepository planoContaRepository;


	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		usuarioRepository.save(usuario);
		Conta conta = new Conta(usuario.getLogin());
		conta.setUsuario(usuario);
		cadastrarConta(conta);
		
		// Cadastra o Plano de Contas Padrão (Receitas, Despesas, Transferencia_Usuarios, Transferencia_Contas)
		cadastrarPlanoContasPadrao(usuario.getLogin());
		return usuario;
>>>>>>> Stashed changes
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
	
	//  Gerar Todos os Planos de Contas Padrão
	public void cadastrarPlanoContasPadrao(String loginUsuario){

		//Plano de Conta Padrao Receitas
		PlanoConta planoContaReceitas = new PlanoConta(loginUsuario, "Receitas", true, TiposMovimento.RECEITAS);


		//Plano de Conta Padrao Despesas
		PlanoConta planoContaDespesas = new PlanoConta(loginUsuario, "Despesas", true, TiposMovimento.DESPESAS);


		//Plano de Conta Padrao Despesas
		PlanoConta planoContaTransferenciaContas = new PlanoConta(loginUsuario, "Transferência entre Contas", true, TiposMovimento.TRANSFERENCIAS_CONTAS);

		//Plano de Conta Padrao Despesas
		PlanoConta planoContaTransferenciaUsuarios= new PlanoConta(loginUsuario, "Transferência entre Usuarios", true, TiposMovimento.TRANSFERENCIAS_USUARIOS);

		// Persistindo os planos no banco de dados
		planoContaRepository.save(planoContaReceitas); // Planos Receita
		planoContaRepository.save(planoContaDespesas); // Planos Depesas
		planoContaRepository.save(planoContaTransferenciaContas); // Planos Transferencia Contas
		planoContaRepository.save(planoContaTransferenciaUsuarios); // Planos Transferencias usuarios
		
	}

}
