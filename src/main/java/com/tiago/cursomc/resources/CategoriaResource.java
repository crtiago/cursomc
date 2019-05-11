package com.tiago.cursomc.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tiago.cursomc.domain.Categoria;
import com.tiago.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	/*
	 * Para que o Spring saiba que o id da URL->value="/(id)" tem que ir pro id da
	 * variável -> Integer id tem que incluir a anotação @PathVariable
	 * 
	 * ResponseEntity é um tipo especial do Spring que já encapsula/armazena várias
	 * informações de uma resposta http para o serviço REST,coloca uma interrogação
	 * no tipo para dizer que pode ser qualquer tipo
	 */
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * Método pra receber uma categoria no formato de Jsom e inserir essa categoria
	 * no banco de dados
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
