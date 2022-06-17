package com.idat.brig.servicio;

import java.util.List;

import com.idat.brig.dto.BodegaDTORequest;
import com.idat.brig.dto.BodegaDTOResponse;



public interface BodegaServicio {

	public void guardarBodega(BodegaDTORequest bodega);
	public void editarBodega(BodegaDTORequest bodega);
	
	public void eliminarBodega(Integer id);
	
	public List<BodegaDTOResponse> listarBodega();
	public BodegaDTOResponse obtenerBodegaId(Integer id);
}
