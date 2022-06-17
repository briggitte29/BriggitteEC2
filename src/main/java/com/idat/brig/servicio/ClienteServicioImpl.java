package com.idat.brig.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.brig.dto.ClienteDTORequest;
import com.idat.brig.dto.ClienteDTOResponse;
import com.idat.brig.modelo.Cliente;
import com.idat.brig.repository.ClienteRepositoy;

@Service
public class ClienteServicioImpl implements ClienteServicio {
	
	@Autowired
	public ClienteRepositoy repositorio;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente c= new Cliente();
		c.setName(cliente.getNameDTO());
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		
		repositorio.save(c);
	}

	@Override
	public void editarCliente(ClienteDTORequest cliente) {
		Cliente c= new Cliente();
		c.setName(cliente.getNameDTO());
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setDireccion(cliente.getDireccionDTO());
		c.setDni(cliente.getDniDTO());
		
		repositorio.saveAndFlush(c);
		
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repositorio.deleteById(id);
		
	}

	@Override
	public List<ClienteDTOResponse> listarCliente() {
		List<ClienteDTOResponse>lista= new ArrayList<ClienteDTOResponse>();
		ClienteDTOResponse c= null;
		
		for(Cliente cliente: repositorio.findAll()) {
			c= new ClienteDTOResponse();
			
			c.setNameDTO(cliente.getName());
			c.setIdClienteDTO(cliente.getIdCliente());
			c.setDireccionDTO(cliente.getDireccion());
			c.setDniDTO(cliente.getDni());
			
			lista.add(c);
		}
		return lista;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		Cliente cliente= repositorio.findById(id).orElse(null);
		ClienteDTOResponse c= new ClienteDTOResponse();
		c.setNameDTO(cliente.getName());
		c.setIdClienteDTO(cliente.getIdCliente());
		c.setDireccionDTO(cliente.getDireccion());
		c.setDniDTO(cliente.getDni());
		
		return c;
	}

}
