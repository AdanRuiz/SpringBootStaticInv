// InvernaderoService.java
package com.tlg.inv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tlg.inv.model.Invernadero;
import com.tlg.inv.model.ActuadorRiegoFactory;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvernaderoService {

    private List<Invernadero> invernaderos = new ArrayList<>();

    @Autowired
    private ActuadorRiegoFactory actuadorRiegoFactory;

    InvernaderoService(){
        // Obtener una nueva instancia de Invernadero cada vez
        Invernadero invernadero1 = new Invernadero();
        invernadero1.setInvernaderoId("Inv1");
        invernadero1.regar();

        Invernadero invernadero2 = new Invernadero();
        invernadero2.setInvernaderoId("Inv2");
        invernadero2.setActuadorRiego("lluvia");
        invernadero2.regar();

        invernaderos.add(invernadero1);
        invernaderos.add(invernadero2);
    }



    public List<Invernadero> obtenerTodosLosInvernaderos() {
        return invernaderos;
    }

    public void agregarInvernadero(Invernadero invernadero) {
        invernaderos.add(invernadero);
    }
}
