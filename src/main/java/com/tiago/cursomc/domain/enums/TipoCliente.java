package com.tiago.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private int cod;
	private String descricao;

	/*
	 * Construtor do tipo enumerado é private
	 */
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	/*
	 * Static porque essa operação vai te que ser possivel de ser executada
	 * mesmo sem estanciar objetos
	 */
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
		
	}
}
