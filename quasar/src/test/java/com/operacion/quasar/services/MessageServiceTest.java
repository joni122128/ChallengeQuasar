package com.operacion.quasar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.operacion.quasar.utils.ErrorHandler;

class MessageServiceTest {

	@Test
	public void getMessage_with_complete_message_returns_TopSecretResponse() {		

		String expectedMessage = "este es un mensaje secreto";
		List<String[]> messagesList = new ArrayList<String[]>();
		String [] message1 = {"", "es", "", "mensaje", "secreto"};
		String [] message2 = {"este", "es", "", "", "secreto"};
		String [] message3 = {"este", "", "un", "mensaje", ""};
		messagesList.add(message1);
		messagesList.add(message2);
		messagesList.add(message3);
		
		MessageService messageServiceTest = new MessageService();
		

		String result = messageServiceTest.getMessage(messagesList);
		

		assertNotNull(result);
		assertEquals(expectedMessage, result);
	}
	
	@Test
	public void getMessage_with_incomplete_message_throw_exception() {
		//Arrange
		String expectedMessage = "No se pudo obtener el mensaje";
		List<String[]> messagesList = new ArrayList<String[]>();
		String [] message1 = {"", "es", "", "mensaje", "secreto"};
		String [] message2 = {"este", "es", "", "", "secreto"};
		String [] message3 = {"este", "", "un"};
		messagesList.add(message1);
		messagesList.add(message2);
		messagesList.add(message3);
		
		MessageService messageServiceTest = new MessageService();
		

		Exception exception = assertThrows(ErrorHandler.class, () -> {
			messageServiceTest.getMessage(messagesList);
		});
		
		assertEquals(expectedMessage, exception.getMessage());
	}

}
