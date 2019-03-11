package br.com.springboot.base.core.error;

import br.com.springboot.base.core.bean.Messages;
import br.com.springboot.base.core.util.Mensagens;
import lombok.*;
import org.springframework.http.HttpStatus;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class ErrorApiException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;
    final long start = System.currentTimeMillis();
    private ErrorApiResponse errorApiResponse;
    private HttpStatus httpStatus;

    public ErrorApiException(final ErrorApiResponse errorApiResponse, final HttpStatus httpStatus){
        this.errorApiResponse = verificaStatus(errorApiResponse, httpStatus);
        this.httpStatus = httpStatus;
    }
    public ErrorApiException(final List<Messages> message, final String time){
        this.errorApiResponse = new ErrorApiResponse(
                Mensagens.ERROR,
                message
        );
    }

    public ErrorApiException(final List<Messages> message, final String time, final HttpStatus httpStatus){
        this.errorApiResponse = new ErrorApiResponse(
                Mensagens.ERROR,
                message
        );
        this.httpStatus = httpStatus;
    }


    private ErrorApiResponse verificaStatus(final ErrorApiResponse errorApiResponse, final HttpStatus httpStatus){
        if(httpStatus.value() == 401){
            return new ErrorApiResponse(
                    Mensagens.WARNING,
                    Arrays.asList(new Messages(Mensagens.WARNING, Mensagens.ERRO_AUTENTICACAO_HTTP, Mensagens.ERRO_401))
            );
        } else{
            return errorApiResponse;
        }
    }

}
