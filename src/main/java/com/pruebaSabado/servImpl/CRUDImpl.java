package com.pruebaSabado.servImpl;

import java.util.List;

import com.pruebaSabado.exceptions.ModelNotFoundException;
import com.pruebaSabado.repo.IGenericRepo;
import com.pruebaSabado.service.ICRUD;

public abstract class CRUDImpl<T,ID> implements ICRUD<T, ID>{

	protected abstract  IGenericRepo<T, ID> getRepo();
	
	@Override
	public T save(T t) throws Exception {
		// TODO Auto-generated method stub
		return getRepo().save(t);
	}

	@Override
	public T update(T t, ID id) throws Exception {
		
		getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND :" + id));
		return getRepo().save(t);
	}

	@Override
	public List<T> readAll() throws Exception {
		return getRepo().findAll();
	}

	@Override
	public T readById(ID id) throws Exception {
		return getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND :" + id));
	}

	@Override
	public void delete(ID id) throws Exception {
		getRepo().findById(id).orElseThrow(()-> new ModelNotFoundException("ID NOT FOUND :" + id));
		getRepo().deleteById(id);
		
	}

}
