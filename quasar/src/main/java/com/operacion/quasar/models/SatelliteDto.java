package com.operacion.quasar.models;

public class SatelliteDto {
	
	private String name;
	private double distance;
	private String[] message;
	
	public SatelliteDto() {}

	public SatelliteDto(String name, double distance, String[] message) {
		super();
		this.name = name;
		this.distance = distance;
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public double getDistance() {
		return distance;
	}

	public String[] getMessage() {
		return message;
	}	
}
