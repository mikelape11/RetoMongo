package com.example.Reto.models;

import org.springframework.data.annotation.Id;

public class PreguntasRespuestas {
	@Id
	private String _id;
	private int numRespuesta;
	private String respuesta;

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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
