package com.idat.brig.dto;

public class UsuarioDTORequest {
	
	private String usuario;
	private String password;
	
	public UsuarioDTORequest() {
		// TODO Auto-generated constructor stub
	}
	
	
	public UsuarioDTORequest(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
