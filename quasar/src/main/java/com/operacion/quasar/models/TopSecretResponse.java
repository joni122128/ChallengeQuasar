package com.operacion.quasar.models;

public class TopSecretResponse {

	private Position position;

	private String message;
	
	public TopSecretResponse() {}
	
	public TopSecretResponse(Position position, String message) {
		super();
		this.position = position;
		this.message = message;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
