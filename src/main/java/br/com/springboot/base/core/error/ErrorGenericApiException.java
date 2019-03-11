package br.com.springboot.base.core.error;

import br.com.springboot.base.core.bean.Messages;
import br.com.springboot.base.core.util.Mensagens;
import lombok.*;
import org.springframework.http.HttpStatus;
import java.io.Serializable;
import java.util.Arrays;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ErrorGenericApiException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1905122041950251207L;
    private ErrorApiResponse errorApiResponse;
    private HttpStatus httpStatus;

    public ErrorGenericApiException(final Exception error){
        final long start = System.currentTimeMillis();
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        errorApiResponse = new ErrorApiResponse(
                Mensagens.ERROR,
                Arrays.asList(new Messages(
                        Mensagens.ERROR,
                        Mensagens.ERRO_INTERNO_SERVIDOR,
                        error.getMessage()
                ))
        );
    }
}
