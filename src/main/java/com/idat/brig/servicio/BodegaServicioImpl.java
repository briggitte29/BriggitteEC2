package com.idat.brig.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.brig.dto.BodegaDTORequest;
import com.idat.brig.dto.BodegaDTOResponse;
import com.idat.brig.modelo.Bodega;
import com.idat.brig.repository.BodegaRepository;

@Service
public class BodegaServicioImpl implements BodegaServicio {
	
	@Autowired
	public BodegaRepository repositorio;

	@Override
	public void guardarBodega(BodegaDTORequest bodega) {
	
		Bodega b= new Bodega();
		b.setNombre(bodega.getNombreDTO());
		b.setIdBodega(bodega.getIdBodegaDTO());
		b.setDireccion(bodega.getDireccionDTO());
		b.setIdProducto(bodega.getIdProductoDTO());
		
		repositorio.save(b);
		
	}

	@Override
	public void editarBodega(BodegaDTORequest bodega) {
		Bodega b= new Bodega();
		b.setNombre(bodega.getNombreDTO());
		b.setIdBodega(bodega.getIdBodegaDTO());
		b.setDireccion(bodega.getDireccionDTO());
		b.setIdProducto(bodega.getIdProductoDTO());
		repositorio.saveAndFlush(b);
		
		
	}

	@Override
	public void eliminarBodega(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<BodegaDTOResponse> listarBodega() {
		List<BodegaDTOResponse> lista= new ArrayList<BodegaDTOResponse>();
		BodegaDTOResponse b= null;
		
		for(Bodega bodega: repositorio.findAll()) {
			b= new BodegaDTOResponse();
			
			b.setNombreDTO(bodega.getNombre());
			b.setIdBodegaDTO(bodega.getIdBodega());
			b.setDireccionDTO(bodega.getDireccion());
			b.setIdProductoDTO(bodega.getIdProducto());
			
			lista.add(b);
		}
		return lista;
	}

	@Override
	public BodegaDTOResponse obtenerBodegaId(Integer id) {
		
		Bodega bodega= repositorio.findById(id).orElse(null);
		BodegaDTOResponse b= new BodegaDTOResponse();
		b.setNombreDTO(bodega.getNombre());
		b.setIdBodegaDTO(bodega.getIdBodega());
		b.setDireccionDTO(bodega.getDireccion());
		b.setIdProductoDTO(bodega.getIdProducto());
		
		return b;
	}
	
	
	

}
