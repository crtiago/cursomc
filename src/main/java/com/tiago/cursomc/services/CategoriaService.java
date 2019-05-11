package com.tiago.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tiago.cursomc.domain.Categoria;
import com.tiago.cursomc.repositories.CategoriaRepository;
import com.tiago.cursomc.services.execeptions.DataIntegrityException;
import com.tiago.cursomc.services.execeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	/*
	 * Declarar uma dependencia de um objeto do tipo CategoriaRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private CategoriaRepository repo;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	/*
	 * Método para inserir uma categoria utilizando o repositório
	 */

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	/*
	 * Método para atualizar uma categoria
	 */

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	/*
	 * Método para deletar uma categoria
	 */

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	/*
	 * Método para buscar a lista de categorias
	 */

	public List<Categoria> findAll() {
		return repo.findAll();
	}

}
