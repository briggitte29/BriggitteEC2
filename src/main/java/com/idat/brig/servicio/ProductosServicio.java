package com.idat.brig.servicio;

import java.util.List;

import com.idat.brig.dto.ProductoDTORequest;
import com.idat.brig.dto.ProductosDTOResponse;


public interface ProductosServicio {
	
	public void guardarProductos(ProductoDTORequest productos);
	public void editarProductos(ProductoDTORequest productos);
	
	public void eliminarProductos(Integer id);
	
	public List<ProductosDTOResponse> listarProducto();
	public ProductosDTOResponse obtenerProductoId(Integer id);

}
