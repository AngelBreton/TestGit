package com.pruebaSabado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaSabado.model.Contactos;
import com.pruebaSabado.service.IContactoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/contactos")
@RequiredArgsConstructor

public class ControllerContactos {
	
	//hola
	//hola2

	private final IContactoService service;
	
	@PostMapping
	public ResponseEntity<Contactos> create (@RequestBody Contactos contactos) throws Exception{
		Contactos obj = service.save(contactos);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Contactos>> readAll() throws Exception {
		
		List<Contactos> list = service.readAll();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Contactos> readById(@PathVariable Integer id) throws Exception {
		
		Contactos obj = service.readById(id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Contactos> update(@RequestBody Contactos contactos, @PathVariable("id") Integer id) throws Exception {
		
		Contactos obj = service.update(contactos,id);
		return new ResponseEntity<>(obj,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
		
		service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
	
	
	
