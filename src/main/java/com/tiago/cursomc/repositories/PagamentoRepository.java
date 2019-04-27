package com.tiago.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiago.cursomc.domain.Pagamento;

/*
 * Classe capaz de acessar o BD,fazer as consultas para acessar os dados da tabela Pagamento
 * JpaRepository tipo especial do Spring capaz de acessar os dados com base em um tipo que você 
 * passar que no caso é Pagamento,e também deve colocar qual o tipo do atributo identificador desse obejto
 * que no caso é Integer
 */
@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
