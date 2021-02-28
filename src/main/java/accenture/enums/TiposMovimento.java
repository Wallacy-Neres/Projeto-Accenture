package accenture.enums;

  public enum TiposMovimento {
	  RECEITAS("R"), 
	  DESPESAS ("D"), 
	  TRANSFERENCIAS_CONTAS("TC"), 
	  TRANSFERENCIAS_USUARIOS("TU");
	  
	  private String tipoConta;
	  
	  private TiposMovimento(String tipoConta) {
		  this.tipoConta = tipoConta;
	  }
	  
	  public String getTipoConta() {
		  return tipoConta;
	  }
  };
