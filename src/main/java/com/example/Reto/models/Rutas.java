package com.example.Reto.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Rutas")
public class Rutas {
	@Id
	private String _id;
	private String nombre;
	private String ciudad;
	private String imagen;
	private float distancia;
	private int tiempo;
	private List<RutasData> rutas_data;
	private List<RutasLocalizacion> rutas_loc;
	public Rutas(){}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
	public List<RutasData> getRutas_data() {
		return rutas_data;
	}
	public void setRutas_data(List<RutasData> rutas_data) {
		this.rutas_data = rutas_data;
	}
	public List<RutasLocalizacion> getRutas_loc() {
		return rutas_loc;
	}
	public void setRutas_loc(List<RutasLocalizacion> rutas_loc) {
		this.rutas_loc = rutas_loc;
	}


}