package com.idat.brig.dto;

public class UsuarioDTOResponse {
	
	private String token;

	public UsuarioDTOResponse() {
		// TODO Auto-generated constructor stub
		super();
	}

	public UsuarioDTOResponse(String token) {
		super();
		this.token = token;
	}



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
