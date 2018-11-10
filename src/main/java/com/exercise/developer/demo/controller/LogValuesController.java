package com.exercise.developer.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.exercise.developer.demo.model.LogValues;
import com.exercise.developer.demo.service.RestClientService;

@Controller
public class LogValuesController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final RestClientService service;
	
	@Autowired
    public LogValuesController(RestClientService service){
       this.service = service;
    }
	
	
	public List<LogValues> getAllLogValues() {
		logger.info("> getAllLogValues restclientservice");
		List<LogValues> listLogValues = null;

		try {
			listLogValues = service.findAllLogValues();
			if (listLogValues == null) {
				listLogValues = new ArrayList<LogValues>();
			}

		} catch (Exception e) {
			logger.error("Ocurrio una exception.", e);
		}

		logger.info("< getAllLogValues restclientservice");
		return listLogValues;
	}
	
	public LogValues createLogValues(LogValues logValues) {
		logger.info("> createLogValues restclientservice");
		LogValues logval=new LogValues();

		try {
			logval = service.createLogValues(logValues);
			

		} catch (Exception e) {
			logger.error("Ocurrio una exception.", e);
		}

		logger.info("< createLogValues restclientservice");
		return logval;
	}
	
	public String grabarArchivoTexto(String mensaje, int tipo) {
		
		return service.grabarArchivoTexto(mensaje, tipo);
	}
	
	public String consola(String mensaje, int tipo) {
		
		return service.consola(mensaje, tipo);
	}

}
