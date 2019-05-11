package com.tiago.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.cursomc.domain.Cliente;
import com.tiago.cursomc.repositories.ClienteRepository;
import com.tiago.cursomc.services.execeptions.ObjectNotFoundException;

@Service
public class ClienteService {

	/*
	 * Declarar uma dependencia de um objeto do tipo ClienteRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private ClienteRepository repo;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
