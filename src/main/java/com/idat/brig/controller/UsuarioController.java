package com.idat.brig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.brig.dto.UsuarioDTORequest;
import com.idat.brig.dto.UsuarioDTOResponse;
import com.idat.brig.segurity.JwtUtil;

@RestController
public class UsuarioController {

	@Autowired JwtUtil util;
	
	@Autowired
	private UserDetailsService service;
	
	@RequestMapping(path ="/crearToken", method= RequestMethod.POST)
	
	public ResponseEntity<?> crearToken(@RequestBody UsuarioDTORequest dto){
		
		UserDetails detail= service.loadUserByUsername(dto.getUsuario());
		return ResponseEntity.ok(new UsuarioDTOResponse(util.generateToken(detail.getUsername())));
	}
}

