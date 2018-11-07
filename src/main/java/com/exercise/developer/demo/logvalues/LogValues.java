package com.exercise.developer.demo.logvalues;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LogValues {
	
	@Id
    @GeneratedValue
    private int id;
	private String message;
	private int type;
	
	public LogValues(String message, int type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public LogValues(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LogValues [message=" + message + ", type=" + type + "]";
	}
	
	

}
