// InvernaderoController.java
package com.tlg.inv.controller;

import com.tlg.inv.service.InvernaderoService;
import com.tlg.inv.model.Invernadero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.Model;
import java.util.List;


@RestController
@RequestMapping("/api")
public class InvernaderoRESTController {
    private static final Logger logger = LoggerFactory.getLogger(InvernaderoController.class);

    @Autowired
    private InvernaderoService invernaderoService;

    @GetMapping("/invernaderos")
    public String listarInvernaderos() {
        String out = "[";
        List<Invernadero> invernaderos = invernaderoService.obtenerTodosLosInvernaderos();
        for (Invernadero invernadero : invernaderos) { 
            logger.info(invernadero.toString()); 
            out +=invernadero.toString()+",";
        }
        out=out.substring(0, out.length()-1);
        out+="]";
        return out;
    }

    @PostMapping("/invernadero/add")
    public Invernadero agregarInvernadero(@RequestBody Invernadero invernadero) {
        invernaderoService.agregarInvernadero(invernadero);
        return invernadero;
    }
}
