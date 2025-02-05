package br.com.ifpe.oxefood.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ClienteException extends RuntimeException{
    
    public static final String MSG_NOME_DUPLICADO = "JÁ EXISTE UM CLIENTE COM ESTE NOME.";

    public ClienteException(String msg) {

	super(String.format(msg));
    }
}
