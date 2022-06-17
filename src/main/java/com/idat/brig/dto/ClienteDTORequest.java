package com.idat.brig.dto;

public class ClienteDTORequest {

	private Integer idClienteDTO;
	private String nameDTO;
	private String direccionDTO;
	private Integer dniDTO;
	
	
	public Integer getIdClienteDTO() {
		return idClienteDTO;
	}
	public void setIdClienteDTO(Integer idClienteDTO) {
		this.idClienteDTO = idClienteDTO;
	}
	public String getNameDTO() {
		return nameDTO;
	}
	public void setNameDTO(String nameDTO) {
		this.nameDTO = nameDTO;
	}
	public String getDireccionDTO() {
		return direccionDTO;
	}
	public void setDireccionDTO(String direccionDTO) {
		this.direccionDTO = direccionDTO;
	}
	public Integer getDniDTO() {
		return dniDTO;
	}
	public void setDniDTO(Integer dniDTO) {
		this.dniDTO = dniDTO;
	}
}
