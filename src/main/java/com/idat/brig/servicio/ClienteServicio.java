package com.idat.brig.servicio;

import java.util.List;

import com.idat.brig.dto.ClienteDTORequest;
import com.idat.brig.dto.ClienteDTOResponse;



public interface ClienteServicio {
	
	public void guardarCliente(ClienteDTORequest cliente);
	public void editarCliente(ClienteDTORequest cliente);
	
	public void eliminarCliente(Integer id);
	
	public List<ClienteDTOResponse> listarCliente();
	public ClienteDTOResponse obtenerClienteId(Integer id);

}
