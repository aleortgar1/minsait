package com.prueba.minsait.repository;

import org.springframework.stereotype.Repository;

import com.prueba.minsait.exception.RepositoryException;
import com.prueba.minsait.model.entity.Minsait;

@Repository
public interface IMinsaitRepository {

	Minsait findById(String idCadena, String idProduct, String fechaApp) throws RepositoryException;
	
}
