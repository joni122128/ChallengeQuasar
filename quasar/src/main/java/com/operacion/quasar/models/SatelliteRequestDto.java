package com.operacion.quasar.models;

import java.util.List;

public class SatelliteRequestDto {
	
	private List<SatelliteDto> satellites;

	public SatelliteRequestDto() {}
	
	public SatelliteRequestDto(List<SatelliteDto> satellites) {
		super();
		this.satellites = satellites;
	}

	public List<SatelliteDto> getSatellites() {
		return satellites;
	}
}
