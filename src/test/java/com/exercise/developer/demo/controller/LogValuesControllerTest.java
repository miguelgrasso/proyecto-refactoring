package com.exercise.developer.demo.controller;

import com.exercise.developer.demo.model.LogValues;
import com.exercise.developer.demo.service.RestClientService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LogValuesControllerTest {


    RestClientService service;
    LogValues logValues;

    @Autowired
    LogValuesController controller=new LogValuesController(service);

    @Before
    public void setUp() throws Exception {
        logValues=new LogValues();
        logValues.setMensaje("Mensaje de prueba junit");
        logValues.setTipo(1);

    }

    @Test
    public void getAllLogValues() {

        Assert.assertNotEquals(null,controller.getAllLogValues());
    }

    @Test
    public void createLogValues() {
        Assert.assertNotEquals(null,controller.createLogValues(logValues).getId());
    }

    @Test
    public void grabarArchivoTexto() {
        String mensaje="Mensaje de prueba Junit";
        int tipo=1;
        Assert.assertEquals("0",controller.grabarArchivoTexto(mensaje,tipo));
    }

    @Test
    public void consola() {
        String mensaje="Mensaje de prueba Junit";
        int tipo=1;
        Assert.assertEquals("0",controller.consola(mensaje,tipo));
    }
}