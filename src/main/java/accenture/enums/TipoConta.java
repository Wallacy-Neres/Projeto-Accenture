package accenture.enums;

  public enum TipoConta {
	  CONTA_BANCARIA("BC"), 
	  CONTA_CORRENTE ("CC");
	  
	  private String tipoConta;
	  
	  private TipoConta(String tipoConta) {
		  this.tipoConta = tipoConta;
	  }
	  
	  public String getTipoConta() {
		  return tipoConta;
	  }
  };
