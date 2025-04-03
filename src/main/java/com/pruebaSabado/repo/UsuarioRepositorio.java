package com.pruebaSabado.repo;

import com.pruebaSabado.model.Usuario;

public interface UsuarioRepositorio {
	Usuario buscarPorId(Long id);
	
	Usuario crearUsuario(String nombre);
	
	Usuario obtenerUsuario(long id);
}
