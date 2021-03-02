package com.operacion.quasar.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.operacion.quasar.models.SatelliteDto;
import com.operacion.quasar.models.SatelliteRequestDto;
import com.operacion.quasar.models.TopSecretResponse;
import com.operacion.quasar.utils.ErrorHandler;

class TopSecretServiceTest {
	
	@Test
	public void getTopSecretMessage_with_complete_message_and_location_returns_message() {
		String expectedMessage = "un mensaje secreto";	
		double expectedX = -157.950157623709;
		double expectedY = -106.02502322945861;
		List<SatelliteDto> satellitesList = new ArrayList<SatelliteDto>();
		satellitesList.add(new SatelliteDto("Test1", 8.06, new String[] {"","mensaje",""}));
		satellitesList.add(new SatelliteDto("Test2", 13.97, new String[] {"","","secreto"}));
		satellitesList.add(new SatelliteDto("Test3", 23.32, new String[] {"un","",""}));
		
		TopSecretService topSecretServiceTest = new TopSecretService(new MessageService(), new LocationService());
	
		TopSecretResponse result = topSecretServiceTest.getTopSecretMessage(new SatelliteRequestDto(satellitesList));

		assertNotNull(result);
		assertEquals(expectedMessage, result.getMessage());
		assertEquals(expectedX, result.getPosition().getX());
		assertEquals(expectedY, result.getPosition().getY());
	}
	
	@Test
	public void getTopSecretMessage_with_invalid_input_throw_exception() {
		String expectedMessage = "Posición/Mensaje desconocidos";
		List<SatelliteDto> satellitesList = new ArrayList<SatelliteDto>();
		satellitesList.add(new SatelliteDto("Test1", 8.06, new String[] {"","mensaje",""}));
		
		TopSecretService topSecretServiceTest = new TopSecretService(new MessageService(), new LocationService());
	
		Exception exception = assertThrows(ErrorHandler.class, () -> {
			topSecretServiceTest.getTopSecretMessage(new SatelliteRequestDto(satellitesList));
		});
		
		assertEquals(expectedMessage, exception.getMessage());
	}
	
	@Test
	public void getSplitTopSecretMessage_with_complete_message_and_location_returns_message() {

		String expectedMessage = "un mensaje secreto";	
		double expectedX = -157.950157623709;
		double expectedY = -106.02502322945861;
		List<SatelliteDto> satellitesList = new ArrayList<SatelliteDto>();
		satellitesList.add(new SatelliteDto("Test1", 8.06, new String[] {"","mensaje",""}));
		satellitesList.add(new SatelliteDto("Test2", 13.97, new String[] {"","","secreto"}));
		satellitesList.add(new SatelliteDto("Test3", 23.32, new String[] {"un","",""}));
		
		TopSecretService topSecretServiceTest = new TopSecretService(new MessageService(), new LocationService());

		TopSecretResponse result = topSecretServiceTest.getSplitTopSecretMessage(satellitesList);

		assertNotNull(result);
		assertEquals(expectedMessage, result.getMessage());
		assertEquals(expectedX, result.getPosition().getX());
		assertEquals(expectedY, result.getPosition().getY());
	}
	
	@Test
	public void getSplitTopSecretMessage_with_incomplete_message_and_location_throw_exception() {

		String expectedMessage = "No hay suficiente informacion";
		List<SatelliteDto> satellitesList = new ArrayList<SatelliteDto>();
		satellitesList.add(new SatelliteDto("Test1", 8.06, new String[] {"","mensaje",""}));
		satellitesList.add(new SatelliteDto("Test2", 13.97, new String[] {"","","secreto"}));
		satellitesList.add(new SatelliteDto("Test3", 23.32, new String[] {""}));
		
		TopSecretService topSecretServiceTest = new TopSecretService(new MessageService(), new LocationService());
			
		Exception exception = assertThrows(ErrorHandler.class, () -> {
			topSecretServiceTest.getSplitTopSecretMessage(satellitesList);
		});
		
		assertEquals(expectedMessage, exception.getMessage());
	}

}