package com.tiago.cursomc.dto;

import java.io.Serializable;

import com.tiago.cursomc.domain.Categoria;

/*
 * Classe para listar apenas o id e nome da categoria,
 * sem precisar listar os produtos pertencentes a ela
 */

public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public CategoriaDTO() {

	}

	/*
	 * Esse construtor vai ser responsável por instanciar o DTO
	 * a partir de um objeto Categoria 
	 * */
	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
