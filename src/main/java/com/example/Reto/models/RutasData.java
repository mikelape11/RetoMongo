package com.example.Reto.models;

import org.springframework.data.annotation.Id;

public class RutasData {
	@Id
	private String id;
	private float lat;
	private float lng;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
