package com.example.Reto.models;

import org.springframework.data.annotation.Id;

public class RutasData {
	@Id
	private String _id;
	private float lat;
	private float lng;

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
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



}
