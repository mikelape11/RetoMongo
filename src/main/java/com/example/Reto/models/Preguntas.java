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
	private List<PreguntasRespuestas> respuestas;
	private String rutasId;
	private int opcion;

	public Preguntas(String _id, int numPregunta, String pregunta, List<PreguntasRespuestas> respuestas, String rutasId,
			int opcion) {
		super();
		this._id = _id;
		this.numPregunta = numPregunta;
		this.pregunta = pregunta;
		this.respuestas = respuestas;
		this.rutasId = rutasId;
		this.opcion = opcion;
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

	public List<PreguntasRespuestas> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<PreguntasRespuestas> respuestas) {
		this.respuestas = respuestas;
	}

	public String getRutasId() {
		return rutasId;
	}

	public void setRutasId(String rutasId) {
		this.rutasId = rutasId;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public Preguntas(){

	}





}
