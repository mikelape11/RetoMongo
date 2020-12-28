package com.example.Reto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {
	@Id
	private String id;
	private String usuario;
	private String password;
	private int rol;

	public Usuario(){

	}

	public Usuario(String id, String usuario, String password, int rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
	}

	public String get_id() {
		return id;
	}

	public void set_id(String id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}





}
