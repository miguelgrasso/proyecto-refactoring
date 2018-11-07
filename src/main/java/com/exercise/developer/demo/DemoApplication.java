package com.exercise.developer.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) throws Exception {
		String datointroducido = "" ;
		
		SpringApplication.run(DemoApplication.class, args);


        try {
             System.out.println("Entrar primer dato");
             InputStreamReader flujo= new InputStreamReader  (System.in  );   // Definimos un flujo de caracteres de entrada.  
             BufferedReader teclado = new BufferedReader ( flujo ); // Creamos un objeto de esta clase que almacenará
             datointroducido = teclado .readLine();    
             // Introducimos la entrada y la asignamos a una variable.
        }catch(IOException e){
             System.err .print ( "Error: " + e.getMessage ( ) );
        }
		JobLogger jobLogger = new JobLogger(false,false,true,true,false,false);
		System.out.println("prueba datos entrada de consola: "+datointroducido);
		jobLogger.LogMessage("mensaje de prueba", true, false, false);

	}
	
	
}
