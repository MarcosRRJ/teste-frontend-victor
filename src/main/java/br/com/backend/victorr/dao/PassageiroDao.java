package br.com.backend.victorr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.backend.victorr.model.Passageiro;

@Repository
public interface PassageiroDao extends JpaRepository<Passageiro, Integer> {

	String Q_GET_PASSAGEIRO_CPF = "from Passageiro p where p.cpf = ?1";

	@Query(Q_GET_PASSAGEIRO_CPF)
	Passageiro getPassageiroByCpf(String cpf);

}
