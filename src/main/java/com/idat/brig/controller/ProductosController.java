package com.idat.brig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.idat.brig.dto.ProductoDTORequest;
import com.idat.brig.dto.ProductosDTOResponse;
import com.idat.brig.servicio.ProductosServicio;



public class ProductosController {

	@Autowired
	private ProductosServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ProductosDTOResponse>> listarProductos(){
		
		return new ResponseEntity<List<ProductosDTOResponse>>(servicio.listarProducto(), HttpStatus.CREATED);  
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody ProductoDTORequest producto){
		
		
		
		servicio.guardarProductos(producto);
		return  new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path = "/listar/{id}" , method = RequestMethod.GET)
	public ResponseEntity<ProductosDTOResponse> listarPorId(@PathVariable Integer id) {
		
		ProductosDTOResponse p = servicio.obtenerProductoId(id);
		if(p != null)
			return new ResponseEntity<ProductosDTOResponse>(p, HttpStatus.OK);
		
		return new ResponseEntity<ProductosDTOResponse>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ProductoDTORequest producto){
		
		ProductosDTOResponse p = servicio.obtenerProductoId(producto.getIdProductoDTO());

		if(p != null) {
			servicio.editarProductos(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProductosDTOResponse p = servicio.obtenerProductoId(id);
		if(p != null) {
			servicio.eliminarProductos(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

		
	}
	
}
