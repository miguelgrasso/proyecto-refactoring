package com.exercise.developer.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.exercise.developer.demo.controller.LogValuesController;
import com.exercise.developer.demo.model.LogValues;
import com.exercise.developer.demo.service.RestClientService;


@SpringBootApplication
public class DemoApplication {
	
	@Autowired
	private static RestClientService service = new RestClientService(new RestTemplate());
	
	public static void main(String[] args) throws Exception {
			
		SpringApplication.run(DemoApplication.class, args);
		registroLogValue();
	}
	

	public static void registroLogValue() {
		
		String mensaje = "" ;
		int tipo=0;
		String resultado="";
		String interaccion="";
		LogValuesController logValuesController=new LogValuesController(service);		
		System.out.println("cantidad de registros: "+logValuesController.getAllLogValues().size());

        try {
             System.out.println("Ingresar 1(bd), 2(archivo de texto), 3(consola):");
             InputStreamReader flujo= new InputStreamReader  (System.in  );     
             BufferedReader teclado = new BufferedReader ( flujo ); 
             interaccion=teclado.readLine();
             System.out.println("Ingresar tipo de mensaje: 1(INFO),2(WARNING),3(ERROR)");
        	 tipo=Integer.parseInt(teclado.readLine());
        	 System.out.println("Ingresar mensaje:");
        	 mensaje = teclado.readLine();
             if(interaccion.equalsIgnoreCase("1")) {
            	 LogValues logValues=new LogValues();
                 LogValues logval=new LogValues();
                 logValues.setMensaje(mensaje);
                 logValues.setTipo(tipo);
                 logval=logValuesController.createLogValues(logValues);
                 System.out.println("se creo el objeto con id: "+logval.getId());
             }else if(interaccion.equalsIgnoreCase("2")) {
            	 resultado=logValuesController.grabarArchivoTexto(mensaje, tipo);
            	 System.out.println("el resultado es: "+resultado);
             }else{
            	 resultado=logValuesController.consola(mensaje, tipo);
            	 System.out.println("el resultado es: "+resultado);
             }

        }catch(IOException e){
             System.err .print ( "Error: " + e.getMessage ( ) );
        }
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
	      return new RestTemplate();
	   }
	
}
