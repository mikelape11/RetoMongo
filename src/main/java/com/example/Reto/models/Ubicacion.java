package com.example.Reto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ubicacion")
public class Ubicacion {
	@Id
	private String _id;
	private String nombreUsuario;
	private float lat;
	private float lng;
	private String rutaId;

	public Ubicacion(String _id, String nombreUsuario, float lat, float lng, String rutaId) {
		super();
		this._id = _id;
		this.nombreUsuario = nombreUsuario;
		this.lat = lat;
		this.lng = lng;
		this.rutaId = rutaId;
	}

	public Ubicacion(){

	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public float getLat() {
		return lat;
	}


	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public String getRutaId() {
		return rutaId;
	}

	public void setRutaId(String rutaId) {
		this.rutaId = rutaId;
	}



}