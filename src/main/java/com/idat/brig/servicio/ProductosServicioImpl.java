package com.idat.brig.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.brig.dto.ProductoDTORequest;
import com.idat.brig.dto.ProductosDTOResponse;
import com.idat.brig.modelo.Productos;
import com.idat.brig.repository.ProductosRepository;

@Service
public class ProductosServicioImpl implements ProductosServicio {

	@Autowired
	public ProductosRepository repositorio;
	
	@Override
	public void guardarProductos(ProductoDTORequest productos) {
		Productos p= new Productos();
		p.setProducto(productos.getProductoDTO());
		p.setIdProducto(productos.getIdProductoDTO());
		p.setDescripcion(productos.getDescripcionDTO());
		p.setPrecio(productos.getPrecioDTO());
		p.setStock(productos.getStockDTO());
		
		repositorio.save(p);
	}

	@Override
	public void editarProductos(ProductoDTORequest productos) {
		Productos p= new Productos();
		p.setProducto(productos.getProductoDTO());
		p.setIdProducto(productos.getIdProductoDTO());
		p.setDescripcion(productos.getDescripcionDTO());
		p.setPrecio(productos.getPrecioDTO());
		p.setStock(productos.getStockDTO());
		repositorio.saveAndFlush(p);
		
	}

	@Override
	public void eliminarProductos(Integer id) {
		repositorio.deleteById(id);
		
	}

	@Override
	public List<ProductosDTOResponse> listarProducto() {
		List<ProductosDTOResponse> lista= new ArrayList<ProductosDTOResponse>();
		ProductosDTOResponse p= null;
		
		for(Productos productos: repositorio.findAll()) {
			p= new ProductosDTOResponse();
			
			p.setDescripcionDTO(productos.getDescripcion());
			p.setIdProductoDTO(productos.getIdProducto());
			p.setProductoDTO(productos.getProducto());
			p.setPrecioDTO(productos.getPrecio());
			p.setStockDTO(productos.getStock());
			
			lista.add(p);
		}
		return lista;
	}

	@Override
	public ProductosDTOResponse obtenerProductoId(Integer id) {
		Productos producto= repositorio.findById(id).orElse(null);
		ProductosDTOResponse p= new ProductosDTOResponse();
		p.setDescripcionDTO(producto.getDescripcion());
		p.setIdProductoDTO(producto.getIdProducto());
		p.setProductoDTO(producto.getProducto());
		p.setPrecioDTO(producto.getPrecio());
		p.setStockDTO(producto.getStock());
		
		return p;
	}

}
