package br.com.springboot.base.core.error;

import br.com.springboot.base.core.bean.Messages;
import br.com.springboot.base.core.util.Mensagens;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Arrays;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorParamInvalidApiException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;
    private ErrorApiResponse errorApiResponse;
    private HttpStatus httpStatus;

    public ErrorParamInvalidApiException(final String type, final String error){
        super(error);
        httpStatus = HttpStatus.BAD_REQUEST;
        errorApiResponse = new ErrorApiResponse(
                Mensagens.ERROR,
                Arrays.asList(new Messages(
                        type,
                        Mensagens.ERRO_PARAMETROS_INVALIDOS,
                        error
                ))
        );
    }
}
