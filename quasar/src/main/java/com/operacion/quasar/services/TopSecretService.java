package com.operacion.quasar.services;

import java.util.ArrayList;
import java.util.List;

import com.operacion.quasar.interfaces.ILocationService;
import com.operacion.quasar.interfaces.IMessageService;
import com.operacion.quasar.interfaces.ITopSecretService;
import com.operacion.quasar.models.Position;
import com.operacion.quasar.models.SatelliteDto;
import com.operacion.quasar.models.SatelliteRequestDto;
import com.operacion.quasar.models.TopSecretResponse;
import com.operacion.quasar.utils.Constants;
import com.operacion.quasar.utils.ErrorHandler;

public class TopSecretService implements ITopSecretService{

	private final IMessageService _messageService;
	private final ILocationService _locationService;
	
	public TopSecretService(final IMessageService messageService, final ILocationService locationService) {
		this._messageService = messageService;
		this._locationService = locationService;
	}
	
	@Override
	public TopSecretResponse getTopSecretMessage(SatelliteRequestDto satellites) throws ErrorHandler {
		List<SatelliteDto> satellitesList = satellites.getSatellites();
		if(validateRequestFormat(satellitesList)) {
			String message = getMessage(satellitesList);
			Position position = getPosition(satellitesList);
	    	TopSecretResponse response = new TopSecretResponse(position, message);
	    	return response;
		}else {
			throw new ErrorHandler("Información incompleta");
		}
		
	}
	
	@Override
	public TopSecretResponse getSplitTopSecretMessage(List<SatelliteDto> satellites) {
		
		if(validateRequestFormat(satellites)) {
			try {

				String message = getMessage(satellites);
				Position position = getPosition(satellites);
		    	TopSecretResponse response = new TopSecretResponse(position, message);
		    	return response;
			}catch(ErrorHandler e) {
				throw new ErrorHandler("Información incompleta");
			}
		}else {
			throw new ErrorHandler("Posición/Mensaje desconocida");
		}
	}
	
	@Override
	public String getMessage(List<SatelliteDto> satellites) throws ErrorHandler {
		List<String[]> messagesList = new ArrayList<String[]>();
		
		for(SatelliteDto satelite : satellites) {
			messagesList.add(satelite.getMessage());
		}
		
		String message = _messageService.getMessage(messagesList);
		return message;
	}

	@Override
	public Position getPosition(List<SatelliteDto> satellites) {
		double [][] satellitesPosition = new double[][]
		{
			{Constants.kenobi_x, Constants.kenobi_y},
			{Constants.skywalker_x, Constants.skywalker_y},
			{Constants.sato_x, Constants.sato_y}
		};
		
		double [] satellitesDistance = new double[satellites.size()];
		
		for(int i = 0; i < satellites.size(); i++) {
			satellitesDistance[i] = satellites.get(i).getDistance();
		}
		
		double[] point = _locationService.getLocation(satellitesPosition, satellitesDistance);
		
		return convertPoint(point);
	}
	
	private Position convertPoint(double[] point) {
		if(point.length == 2) {
			return new Position(point[0], point[1]);
		}
		throw new ErrorHandler("Posición desconocida");
	}
	
	private boolean validateRequestFormat(List<SatelliteDto> satellitesList) {
		return satellitesList.size() == 3 ? true : false;
	}

}