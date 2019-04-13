package com.tiago.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.cursomc.domain.Categoria;
import com.tiago.cursomc.repositories.CategoriaRepository;

import java.util.Optional;

@Service
public class CategoriaService {

	/*
	 * Declarar uma dependencia de um objeto do tipo CategoriaRepository
	 * Para instanciar esse repositorio usa @Autowired,com isso essa dependencia 
	 * vai ser automaticamente instanciada pelo Spring 
	 */
	
	@Autowired
	private CategoriaRepository repo;
	
	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
