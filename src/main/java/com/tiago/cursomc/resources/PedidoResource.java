package com.tiago.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.cursomc.domain.Pedido;
import com.tiago.cursomc.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	/*
	 * Para que o Spring saiba que o id da URL->value="/(id)" tem que ir 
	 * pro id da variável ->  Integer id tem que incluir a anotação @PathVariable 
	 * 
	 * ResponseEntity é um tipo especial do Spring que já encapsula/armazena várias informações
	 * de uma resposta http para o serviço REST,coloca uma interrogação no tipo para dizer que 
	 * pode ser qualquer tipo
	 */
	public ResponseEntity<Pedido> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
