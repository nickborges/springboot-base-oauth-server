package br.com.springboot.base.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Bad Request: Parâmetro informado é inválido."),
        @ApiResponse(code = 401, message = "Usuário não autenticado."),
        @ApiResponse(code = 403, message = "Usuário sem permissão."),
        @ApiResponse(code = 404, message = "Recurso não encontrado."),
        @ApiResponse(code = 500, message = "Erro interno do servidor."),
        @ApiResponse(code = 503, message = "Erro comunicação gatway."),
        @ApiResponse(code = 504, message = "Serviço inexistente.")
})
interface SpringbootBaseOAuthControllerApi {

    /*@ApiOperation(value = "Retrieve a list of ConsultaVeiculosResponse.")
    @ApiResponses({
            @ApiResponse(code = 200,
                         message = "Operação realizada com sucesso.",
                         response = ConsultaVeiculosResponse.class)
    })*/
}
