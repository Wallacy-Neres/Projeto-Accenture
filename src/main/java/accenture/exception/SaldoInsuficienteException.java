package accenture.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ACCEPTED)
public class SaldoInsuficienteException extends RuntimeException{

    public SaldoInsuficienteException(){
        super();
    }

    public SaldoInsuficienteException(String mensagem){
        super(mensagem);
    }
}
