package com.operacion.quasar.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.operacion.quasar.models.SatelliteRequestDto;
import com.operacion.quasar.models.SatelliteSplitRequestDto;
import com.operacion.quasar.models.TopSecretResponse;
import com.operacion.quasar.repositories.SatellitesRepo;
import com.operacion.quasar.services.LocationService;
import com.operacion.quasar.services.MessageService;
import com.operacion.quasar.services.TopSecretService;
import com.operacion.quasar.utils.ErrorHandler;


@RestController
@RequestMapping("/")
public class TopSecretController {
	
	SatellitesRepo satellitesRepo = new SatellitesRepo();

	@RequestMapping(value="topsecret", method=RequestMethod.POST)
	public ResponseEntity<TopSecretResponse> getTopSecret( @RequestBody SatelliteRequestDto request) {
		TopSecretService _topSecretService = new TopSecretService(new MessageService(), new LocationService());
    	satellitesRepo.hydrateSatellitesList(request);
		
		try {
			TopSecretResponse response = _topSecretService.getTopSecretMessage(request);
			return ResponseEntity.ok(response);
		} catch (ErrorHandler e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
    	
	}
	

	@RequestMapping(value="topsecret_split/{satellite_name}", method=RequestMethod.POST)
	public ResponseEntity<TopSecretResponse> getTopSecretBySatelite( @RequestBody SatelliteSplitRequestDto request, @PathVariable("satellite_name") String satelliteName) {	
		TopSecretService _topSecretService = new TopSecretService(new MessageService(), new LocationService());
    	satellitesRepo.updateSatellitesList(satelliteName, request.getDistance(), request.getMessage());
    	
    	if(satellitesRepo.validateSateliteName(satelliteName)) {
    		try {
    			TopSecretResponse response = _topSecretService.getSplitTopSecretMessage(satellitesRepo.getSatellites());
    			return ResponseEntity.ok(response);
    		} catch (ErrorHandler e) {
    			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
    		}
    	}else {
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Satelite incorrecto");
    	}
    	
	}
	
	@RequestMapping(value="topsecret_split", method=RequestMethod.GET)
	public ResponseEntity<TopSecretResponse> getTopSecretBySatelite() {	
		TopSecretService _topSecretService = new TopSecretService(new MessageService(), new LocationService());
	
    	try {
			TopSecretResponse response = _topSecretService.getSplitTopSecretMessage(satellitesRepo.getSatellites());
			return ResponseEntity.ok(response);
		} catch (ErrorHandler e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
}
