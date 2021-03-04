package accenture.service;

import accenture.DTO.LancamentoDTO;
import accenture.enums.TipoMovimento;
import accenture.exception.ContaNaoEncontradaException;
import accenture.exception.RecursoNaoEncontrado;
import accenture.exception.SaldoInsuficienteException;
import accenture.model.Conta;
import accenture.model.PlanoConta;
import accenture.repository.PlanoContaRepository;
import accenture.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accenture.model.Lancamento;
import accenture.repository.LancamentoRepository;

import java.util.Optional;


@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private PlanoContaRepository planoContaRepository;

	@Autowired
	private ContaRepository contaRepository;

	public LancamentoDTO CadastrarLancamento(LancamentoDTO lancamentoDTO) {

		// instancia da classe Lancamento a ser manuseada
		Lancamento lancamento = new Lancamento();

		// Setando alguns dados obtidos na requisão no LancamentoDTO
		lancamento.setDescricao(lancamentoDTO.getDescricao());
		lancamento.setData(lancamentoDTO.getData());
		lancamento.setValor(lancamentoDTO.getValor());

		// Buscando
		Optional<PlanoConta> planoContaBuscado = planoContaRepository.findById(lancamentoDTO.getPlanoConta());
		Optional<Conta> contaBuscada = contaRepository.findById(lancamentoDTO.getConta());

		// Verificando se a conta e o plano foram encontrados
		if(contaBuscada.isPresent() == false) throw new ContaNaoEncontradaException("Conta não encontrada");
		if(planoContaBuscado.isPresent() == false) throw new RecursoNaoEncontrado("Plano de conta não enontrado");

		// Verifica se a conta e o plano de conta informados foram achados
		if(contaBuscada.isPresent() && planoContaBuscado.isPresent()) {

			// Adiciona a conta buscada ao lancamento
			lancamento.setConta(contaBuscada.get());
			lancamento.setPlanoConta(planoContaBuscado.get());

			// Set o tipo de movimento o mesmo tipo de movimento do plano de contas
			lancamento.setTipo(lancamento.getPlanoConta().getTipoMovimento());
			
			// Verifica qual o tipo de movimento
			if(lancamento.getTipo() == TipoMovimento.DESPESAS) {
				realizarLancamentoDespesa(lancamento);

			}else if(lancamento.getTipo() == TipoMovimento.RECEITAS){
				realizarLancamentoReceita(lancamento);

			}else if(lancamento.getTipo() == TipoMovimento.TRANSFERENCIAS_CONTAS || lancamento.getTipo() == TipoMovimento.TRANSFERENCIAS_USUARIOS){
				// Verificando se há conta de destino
					Optional<Conta> contaDestinoBuscada = contaRepository.findById(lancamentoDTO.getContaDestino());
					if (contaDestinoBuscada.isPresent()) {
						lancamento.setContaDestino(contaDestinoBuscada.get());
					}else{
						throw new ContaNaoEncontradaException("Conta de Destino não encontrada");
					}
				realizarLancamentoTransferenciaConta(lancamento);
			}

		}else {
			throw new ContaNaoEncontradaException("Conta não encontrada");
		}

		// Persistindo Lancamento no banco de dados
		System.out.println(" ------------------------ CONTA DESTINO : " + lancamento.getContaDestino());
		lancamento = lancamentoRepository.save(lancamento);

		return new LancamentoDTO(lancamento); // Retorna DTO
	}


	// Executa a operação de um lancamento de despesa
	private void realizarLancamentoDespesa(Lancamento lancamento){
		Conta conta = lancamento.getConta();
		if(conta.getSaldo() < lancamento.getValor()){
			throw new SaldoInsuficienteException("Conta não possui saldo suficiente para efetuar lancamento"); // Saldo insuficiente lancando excecao
		}else{
			conta.setSaldo((float) (conta.getSaldo() - lancamento.getValor())); // Executando a operacao
			contaRepository.save(conta); // Salvando os novos valores na banco de dados
		}
	}


	// Executa a operação de um lancamento de receita
	private void realizarLancamentoReceita(Lancamento lancamento){
		Conta conta = lancamento.getConta();
		conta.setSaldo((float) (conta.getSaldo() + lancamento.getValor()));
		contaRepository.save(conta);
	}


	// Executa a operação de um lancamento de transferência
	private void realizarLancamentoTransferenciaConta(Lancamento lancamento){
		Conta contaOrigem = lancamento.getConta();
		Conta contaDestino = lancamento.getContaDestino();
		
		System.out.println(contaDestino);
		
		// Verificando existe conta destino
		if(contaDestino == null) throw new ContaNaoEncontradaException("Conta de destino não encontrada");

		// Verificanndo se a saldo suficiente para a transferência
		if (contaOrigem.getSaldo() < lancamento.getValor()){
			throw new SaldoInsuficienteException("Conta não possui saldo suficiente para efetuar lancamento");
		}else{
			// Realizando operação de retirar de uma conta e adicionando em outra
			contaOrigem.setSaldo((float) (contaOrigem.getSaldo() - lancamento.getValor()));
			contaDestino.setSaldo((float) (contaDestino.getSaldo() + lancamento.getValor()));

			// Persistindo novos valores
			contaRepository.save(contaOrigem);
			contaRepository.save(contaDestino);
			
		}
	}
}
