package com.pruebaSabado.servImpl;

import org.springframework.stereotype.Service;

import com.pruebaSabado.model.Contactos;
import com.pruebaSabado.repo.IContactoRepo;
import com.pruebaSabado.repo.IGenericRepo;
import com.pruebaSabado.service.IContactoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactoServiceImpl extends CRUDImpl<Contactos, Integer> implements IContactoService {

	private final IContactoRepo repo;

	@Override
	protected IGenericRepo<Contactos, Integer> getRepo() {
		
		return repo;
	}
	
	

}
