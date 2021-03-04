package accenture.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import accenture.DTO.ExtratoDTO;
import accenture.model.Conta;
import accenture.repository.ContaRepository;
import accenture.repository.LancamentoRepository;

@Service
public class DashboardService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ContaRepository contaRepository;
	
	public ExtratoDTO getExtrato(String login, String dataini, String dataFinal) throws ParseException {
		ExtratoDTO extratoDTO = new ExtratoDTO();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dataInicio = formato.parse(dataini);
		Date dataFim = formato.parse(dataFinal);
		
		extratoDTO.setDataInicio(dataInicio);
		extratoDTO.setDataFim(dataFim);
		
		Conta contaDebito = contaRepository.findContaDebitoByLogin(login);
		Conta contaCredito = contaRepository.findContaCreditoByLogin(login);
		
		
		extratoDTO.setContaDebitoId(contaDebito.getId());
		extratoDTO.setContaDebitoSaldo(contaDebito.getSaldo());
		extratoDTO.setContaDebitoLancamentos(lancamentoRepository.findByLoginAndDataInicioAndDataFimAndTipo(login, dataInicio, dataFim, contaDebito.getTipoConta()));
		
		
		extratoDTO.setContaCreditoId(contaCredito.getId());
		extratoDTO.setContaCreditoSaldo(contaCredito.getSaldo());
		extratoDTO.setContaCreditoLancamentos(lancamentoRepository.findByLoginAndDataInicioAndDataFimAndTipo(login, dataInicio, dataFim, contaCredito.getTipoConta()));
		
		return extratoDTO;
	}

}
