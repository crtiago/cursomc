package com.tiago.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.cursomc.domain.Pedido;
import com.tiago.cursomc.repositories.PedidoRepository;
import com.tiago.cursomc.services.execeptions.ObjectNotFoundException;

@Service
public class PedidoService {

	/*
	 * Declarar uma dependencia de um objeto do tipo PedidoRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private PedidoRepository repo;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
