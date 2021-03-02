package com.operacion.quasar.repositories;

import java.util.ArrayList;
import java.util.List;

import com.operacion.quasar.models.SatelliteDto;
import com.operacion.quasar.models.SatelliteRequestDto;

public class SatellitesRepo {
	public static List<SatelliteDto> _satellitesList = new ArrayList<SatelliteDto>();
	
	public void hydrateSatellitesList(SatelliteRequestDto satellites) {
		_satellitesList.clear();
		for(SatelliteDto satelite : satellites.getSatellites()) {
			_satellitesList.add(satelite);
		}
	}
	
	public void updateSatellitesList(String name, double distance, String [] message) {
		SatelliteDto checkSatelite = new SatelliteDto(name, distance, message);
		for(int i = 0; i < _satellitesList.size(); i++) {
			if(_satellitesList.get(i).getName().equals(name)) {
				_satellitesList.set(i, checkSatelite);
			}
		}
	}
	
	public boolean validateSateliteName(String name) {
		for(SatelliteDto satelite : _satellitesList) {
			if(satelite.getName().equals(name))
				return true;
		}
		
		return false;
	}
	
	public List<SatelliteDto> getSatellites(){
		return _satellitesList;
	}
}
