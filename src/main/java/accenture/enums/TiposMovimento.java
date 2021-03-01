package accenture.enums;

  public enum TiposMovimento {
	  RECEITAS("R"), 
	  DESPESAS ("D"), 
	  TRANSFERENCIAS_CONTAS("TC"), 
	  TRANSFERENCIAS_USUARIOS("TU");
	  
	  private String tipoMovimento;
	  
	  private TiposMovimento(String tipoConta) {
		  this.tipoMovimento = tipoMovimento;
	  }
	  
	  public String getTipoMovimento() {
		  return tipoMovimento;
	  }
  };
