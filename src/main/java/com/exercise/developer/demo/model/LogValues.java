package com.exercise.developer.demo.model;

public class LogValues {

	private long id;
	private String mensaje;
	private int tipo;
	
	public LogValues(long id, String mensaje, int tipo) {
		this.id = id;
		this.mensaje = mensaje;
		this.tipo = tipo;
	}
	
	public LogValues() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
}
