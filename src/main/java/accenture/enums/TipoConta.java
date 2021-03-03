package accenture.enums;

  public enum TipoConta {
	  CONTA_DEBITO("Conta Débito"),
	  CONTA_CREDITO ("C Crédito");
	  
	  private String tipoConta;
	  
	  private TipoConta(String tipoConta) {
		  this.tipoConta = tipoConta;
	  }
	  
	  public String getTipoConta() {
		  return tipoConta;
	  }
  };
