package com.operacion.quasar.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.operacion.quasar.interfaces.IMessageService;
import com.operacion.quasar.utils.ErrorHandler;

public class MessageService implements IMessageService {

	@Override
	public String getMessage(List<String[]> messagesList) throws ErrorHandler {
		Map<Integer, String> parsedMessage = parseMessage(messagesList);
	    if(!validateMessageFormat(messagesList, parsedMessage.size()))
	        throw new ErrorHandler("Mensaje perdido");
	    
	    String finalMessage = getFinalMessage(parsedMessage);
	    
	    return finalMessage;
	}  
	
	private Map<Integer, String> parseMessage(List<String[]> messagesList){
	    Map<Integer, String> parsedMessage = new HashMap<>();
		for(String[] message : messagesList) {
			parsedMessage.putAll(IntStream.range(0, message.length).boxed().filter(i -> !message[i].isEmpty()).
			collect(Collectors.toMap(i -> i, i -> message[i])));
		}
		
		return parsedMessage;
	}
	
	private boolean validateMessageFormat(List<String[]> messagesList, int messageSize) {
		for(String[] message : messagesList){
	        if(message.length != messageSize){
	            return false;
	        }
	    }
		
	    return true;
	}

	private String getFinalMessage(Map<Integer, String> parsedMessage) {
		String finalMessage = "";
		
		for (String message : parsedMessage.values()) {
			finalMessage += message + " ";
		}
		
		return finalMessage.substring(0, finalMessage.length() - 1);
	}

}
