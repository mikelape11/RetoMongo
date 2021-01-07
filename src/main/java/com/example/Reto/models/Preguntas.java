package com.example.Reto.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Preguntas")
public class Preguntas {
	@Id
	private String _id;
	private int numPregunta;
	private String pregunta;
	private List<String> respuestas;
	private String rutasId;

	public Preguntas(String _id, int numPregunta, String pregunta, List<String> respuestas, String rutasId) {
		super();
		this._id = _id;
		this.numPregunta = numPregunta;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.rutasId = rutasId;
	}

	public Preguntas(){

	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getNumPregunta() {
		return numPregunta;
	}

	public void setNumPregunta(int numPregunta) {
		this.numPregunta = numPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public List<String> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<String> respuestas) {
		this.respuestas = respuestas;
	}

	public String getRutasId() {
		return rutasId;
	}

	public void setRutasId(String rutasId) {
		this.rutasId = rutasId;
	}



}
