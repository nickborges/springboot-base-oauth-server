package br.com.springboot.base.controller;

import br.com.springboot.base.core.util.Constantes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nick Kras Borges
 */
@RestController
@RequestMapping(Constantes.API)
public class SpringbootBaseOAuthController implements SpringbootBaseOAuthControllerApi {

    private final Logger log = LogManager.getLogger(this.getClass());

}
