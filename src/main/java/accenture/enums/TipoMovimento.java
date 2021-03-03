package accenture.enums;

  public enum TipoMovimento {
	  RECEITAS("R"), 
	  DESPESAS ("D"), 
	  TRANSFERENCIAS_CONTAS("TC"), 
	  TRANSFERENCIAS_USUARIOS("TU");
	  
	  private String tipoMovimento;
	  
	  private TipoMovimento(String tipoMovimento) {
		  this.tipoMovimento = tipoMovimento;
	  }
	  
	  public String getTipoMovimento() {
		  return tipoMovimento;
	  }
  };
