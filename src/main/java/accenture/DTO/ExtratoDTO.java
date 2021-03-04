package accenture.DTO;

import java.util.Date;
import java.util.List;

public class ExtratoDTO {

	private Long ContaDebitoId;
	private float ContaDebitoSaldo;
	private List<LancamentoDTO> ContaDebitoLancamentos;
	private Date dataInicio;
	private Date dataFim;
	private Long ContaCreditoId;
	private float ContaCreditoSaldo;
	private List<LancamentoDTO> ContaCreditoLancamentos;
	
	
	public Long getContaDebitoId() {
		return ContaDebitoId;
	}
	public void setContaDebitoId(Long contaDebitoId) {
		ContaDebitoId = contaDebitoId;
	}
	public float getContaDebitoSaldo() {
		return ContaDebitoSaldo;
	}
	public void setContaDebitoSaldo(float contaDebitoSaldo) {
		ContaDebitoSaldo = contaDebitoSaldo;
	}
	public List<LancamentoDTO> getContaDebitoLancamentos() {
		return ContaDebitoLancamentos;
	}
	public void setContaDebitoLancamentos(List<LancamentoDTO> contaDebitoLancamentos) {
		ContaDebitoLancamentos = contaDebitoLancamentos;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public Long getContaCreditoId() {
		return ContaCreditoId;
	}
	public void setContaCreditoId(Long contaCreditoId) {
		ContaCreditoId = contaCreditoId;
	}
	public float getContaCreditoSaldo() {
		return ContaCreditoSaldo;
	}
	public void setContaCreditoSaldo(float contaCreditoSaldo) {
		ContaCreditoSaldo = contaCreditoSaldo;
	}
	public List<LancamentoDTO> getContaCreditoLancamentos() {
		return ContaCreditoLancamentos;
	}
	public void setContaCreditoLancamentos(List<LancamentoDTO> contaCreditoLancamentos) {
		ContaCreditoLancamentos = contaCreditoLancamentos;
	}
	
	
}
