package accenture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class SaldoInsuficienteException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(){
        super();
    }

    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
}
