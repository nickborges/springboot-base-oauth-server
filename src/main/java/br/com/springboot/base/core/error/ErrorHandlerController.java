package br.com.springboot.base.core.error;

import br.com.springboot.base.core.bean.Messages;
import br.com.springboot.base.core.util.Mensagens;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.Arrays;

/**
 * GET: não deve atualizar nada. Deve ser independete. Possíveis Códigos de Retorno 200 (OK), 404 (NÃO ENCONTRADOS), 400 (BAD REQUEST)
 * POST: deve criar um novo recurso. O ideal é retornar JSON com link para o recurso recém-criado. Os mesmos códigos de retorno que forem possíveis. Além disso - o código de retorno 201 (CREATED) pode ser usado.
 * PUT: atualiza um recurso conhecido. ex: atualiza detalhes do cliente. Códigos de retorno possíveis: 200 (OK) + 404 (NÃO ENCONTRADO) +400 (PEDIDO PROBLEMA)
 * DELETE: Usado para excluir um recurso. Códigos de retorno possíveis: 200 (OK).
 */
@Slf4j
@RestControllerAdvice
public class ErrorHandlerController {

    final long start = System.currentTimeMillis();

    @ExceptionHandler(ErrorApiException.class)
    public final ResponseEntity<ErrorApiResponse> handleBadRequestException(final ErrorApiException errorApiException){
        log.error(Mensagens.ERROR, errorApiException);
        ErrorApiResponse errorApiResponse = errorApiException.getErrorApiResponse();
        return new ResponseEntity<>(errorApiResponse, errorApiException.getHttpStatus() != null ? errorApiException.getHttpStatus() : HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorGenericApiException.class)
    public final ResponseEntity<ErrorApiResponse> handleBadRequestException(final ErrorGenericApiException errorGenericApiException){
        log.error(Mensagens.ERROR, errorGenericApiException);
        ErrorApiResponse errorApiResponse = errorGenericApiException.getErrorApiResponse();
        return new ResponseEntity<>(errorApiResponse, errorGenericApiException.getHttpStatus() != null ? errorGenericApiException.getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorParamInvalidApiException.class)
    public final ResponseEntity<ErrorApiResponse> handleBadRequestException(final ErrorParamInvalidApiException errorParamInvalidApiException){
        log.error(Mensagens.ERROR, errorParamInvalidApiException);
        ErrorApiResponse errorApiResponse = errorParamInvalidApiException.getErrorApiResponse();
        return new ResponseEntity<>(errorApiResponse, errorParamInvalidApiException.getHttpStatus() != null ? errorParamInvalidApiException.getHttpStatus() : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<ErrorApiResponse> handleInternalErrorException(final RuntimeException runtimeException){
        log.error(Mensagens.ERROR, runtimeException);
        ErrorApiResponse errorApiResponse = new ErrorApiResponse(
                Mensagens.ERROR,
                Arrays.asList(new Messages(Mensagens.ERROR, Mensagens.ERRO_INTERNO_SERVIDOR, runtimeException.getMessage()))
        );
        return new ResponseEntity<>(errorApiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
