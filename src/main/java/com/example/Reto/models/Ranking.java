package com.example.Reto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Ranking")
public class Ranking {
	@Id
	private String _id;
	private int puntos;
	private String usuario_id;
	private String nombre;
	private int aciertos;
	private int fallos;
	private int tiempo;
	private String rutas_id;

	public Ranking(String _id, int puntos, String usuario_id, String nombre,int aciertos, int fallos, int tiempo, String rutas_id) {
		super();
		this._id = _id;
		this.puntos = puntos;
		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.aciertos = aciertos;
		this.fallos = fallos;
		this.tiempo = tiempo;
		this.rutas_id = rutas_id;
	}

	public Ranking(){

	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(String usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
	}

	public int getFallos() {
		return fallos;
	}

	public void setFallos(int fallos) {
		this.fallos = fallos;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	public String getRutas_id() {
		return rutas_id;
	}

	public void setRutas_id(String rutas_id) {
		this.rutas_id = rutas_id;
	}



}
