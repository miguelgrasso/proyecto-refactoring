package com.exercise.developer.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.exercise.developer.demo.model.LogValues;

@Service
public class RestClientService {

 
    private final RestTemplate restTemplate;

    private final String GET_ALL_URL = "http://localhost:8085/api/logValues";
    private final String POST_CREAR_URL = "http://localhost:8085/api/crearLogValues";
    private final String GET_ARCHIVO_TEXTO = "http://localhost:8085/api/grabarArchivoTexto/";
    private final String GET_CONSOLA = "http://localhost:8085/api/consola/";
    

 
    @Autowired
    public RestClientService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<LogValues> findAllLogValues(){
        return Arrays.stream(restTemplate.getForObject(GET_ALL_URL,LogValues[].class)).collect(Collectors.toList());
    }


    public LogValues createLogValues(LogValues logValues){
    	System.out.println("mensaje desde el cliente: "+logValues.getMensaje());
        return restTemplate.postForObject(POST_CREAR_URL, logValues, LogValues.class);
    }
    
    public String grabarArchivoTexto(String mensaje, int tipo) {
    	
    	String urlfinal=GET_ARCHIVO_TEXTO+mensaje+"/"+tipo;
    	return restTemplate.getForObject(urlfinal, String.class);
    }
    
    public String consola(String mensaje, int tipo) {
    	
    	String urlfinal=GET_CONSOLA+mensaje+"/"+tipo;
    	return restTemplate.getForObject(urlfinal, String.class);
    }
}