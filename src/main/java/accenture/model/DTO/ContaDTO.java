package accenture.dto;

import java.util.ArrayList;

import accenture.model.Conta;
import accenture.model.Lancamento;

public class ContaDto {
	
	private int id;
	private ArrayList<Lancamento> lancamentos;
	private double saldo;
	
	public ContaDto(Conta conta, ArrayList<Lancamento> lancamentos) {
		this.id = conta.getId();
		this.saldo = conta.getSaldo();
		this.lancamentos = lancamentos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(ArrayList<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}