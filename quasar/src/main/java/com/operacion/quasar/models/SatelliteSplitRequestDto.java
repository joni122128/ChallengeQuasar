package com.operacion.quasar.models;

public class SatelliteSplitRequestDto {

	private double distance;

	private String[] message;
	
	public SatelliteSplitRequestDto(double distance, String[] message) {
		this.distance = distance;
		this.message = message;
	}

	public double getDistance() {
		return distance;
	}

	public String[] getMessage() {
		return message;
	}
}
