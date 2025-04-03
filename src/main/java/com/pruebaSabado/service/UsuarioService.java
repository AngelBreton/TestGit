package com.pruebaSabado.service;

import com.pruebaSabado.model.Usuario;
import com.pruebaSabado.repo.UsuarioRepositorio;

public class UsuarioService {
	 private final UsuarioRepositorio repositorio;
	 
	 
	 public UsuarioService(UsuarioRepositorio repo) { 
		 this.repositorio = repo; 
	 }
	 
	 public Usuario obtenerUsuario(Long id) { 
		 return repositorio.buscarPorId(id); 
	}

}
