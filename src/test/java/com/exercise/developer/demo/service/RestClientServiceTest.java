package com.exercise.developer.demo.service;

import com.exercise.developer.demo.model.LogValues;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RestClientServiceTest {

    LogValues logValues;

    @Autowired
    RestClientService service;

    @Before
    public void setUp() throws Exception {
        logValues=new LogValues();
        logValues.setMensaje("Mensaje de prueba junit");
        logValues.setTipo(1);

    }

    @Test
    public void findAllLogValues() {
        Assert.assertNotEquals(null,service.findAllLogValues());

    }

    @Test
    public void createLogValues() {
        Assert.assertNotEquals(null,service.createLogValues(logValues).getId());
    }

    @Test
    public void grabarArchivoTexto() {
        String mensaje="Mensaje de prueba Junit";
        int tipo=1;
        Assert.assertEquals("0",service.grabarArchivoTexto(mensaje,tipo));
    }

    @Test
    public void consola() {
        String mensaje="Mensaje de prueba Junit";
        int tipo=1;
        Assert.assertEquals("0",service.consola(mensaje,tipo));
    }
}