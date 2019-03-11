package br.com.springboot.base.core.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsExecucao {

    private static final Logger log = LogManager.getLogger(LogsExecucao.class);

    /**
     * método genérico para criação de logs
     * @author nick.borges
     * @param nomeMetodo
     * @param codigoErro
     * @param motivoErro
     * @param descricaoErro
     * @param parametro
     * @return
     * @throws Exception
     */
    public static String geraLogErro(final String nomeMetodo,
                                     final String codigoErro,
                                     final String motivoErro,
                                     final String descricaoErro,
                                     final Object... parametro) throws Exception{
        try{
            String param = "";
            if(parametro != null)
                for(Object par: parametro){
                    if(par != null)
                        param += param.concat(par.toString()).concat("; ");
                }

            return "\n\n" +
                    "===== INICIO DO ERRO ===== " +
                    "\n\t\t Erro no método: [ " + nomeMetodo + " ]" +
                    "\n\t\t Menssagem: [ " + codigoErro + " - " + motivoErro + " - " + descricaoErro + " ] "+
                    "\n\t\t Parâmetros de entrada:  " + param + "  " +
                    "\n" +
                    "===== FIM DO ERRO ===== " +
                    "\n\n";
        } catch(final Exception exception){
            log.error(exception);
            throw new Exception(exception);
        }
    }

    public static void executaInicio(final String nomeMetodo, final Object... array) throws Exception{
        try {
            String msg = "";
            if (log != null) {
                msg = msg.concat("Vai executar o metodo = " + nomeMetodo);
                if (array != null && array.length > 0) {
                    msg = msg.concat(" --> Parametros de entrada = " + array.toString());
                }
                log.debug(msg);
            }
        } catch(final Exception exception){
            log.error(Constantes.STR_METODO_EXECUTA_INICO + Constantes.STR_SINAL_IGUAL + exception);
            throw new Exception(exception);
        }
    }

    public static void executaRetorno(final String nomeMetodo, final Object obj) throws Exception{
        String msg = "";
        try{
            if(log != null){
                msg = msg.concat("A execucao do metodo = " + nomeMetodo );
                if(obj != null){
                    msg = msg.concat(" --> Retornou o resultado = " + obj.toString());
                } else {
                    msg = msg.concat(" --> Nao retornou nenhum resultado = " + obj);
                }
            }

            log.debug(msg);

        } catch(final Exception exception){
            log.error(Constantes.STR_METODO_EXECUTA_RETORNO + Constantes.STR_SINAL_IGUAL + exception);
            throw new Exception(exception);
        }
    }

}
