package com.example.Reto.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuario")
public class Usuario {
	@Id
	private String _id;
	private String usuario;
	private String password;
	private int rol;
	private String avatar;

	public Usuario(){
	}

	public Usuario(String _id, String usuario, String password, int rol, String avatar) {
		super();
		this._id = _id;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.avatar = avatar;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
