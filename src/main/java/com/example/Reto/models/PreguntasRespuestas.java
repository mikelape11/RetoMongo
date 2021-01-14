package com.example.Reto.models;

import org.springframework.data.annotation.Id;

public class PreguntasRespuestas {
	@Id
	private String id;
	private int numRespuesta;
	private String respuesta;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumRespuesta() {
		return numRespuesta;
	}
	public void setNumRespuesta(int numRespuesta) {
		this.numRespuesta = numRespuesta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}



}
