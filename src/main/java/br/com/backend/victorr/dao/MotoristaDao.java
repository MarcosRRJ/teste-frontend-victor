package br.com.backend.victorr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.backend.victorr.model.Motorista;

@Repository
public interface MotoristaDao extends JpaRepository<Motorista, Integer>  {
	
	String Q_GET_MOTORISTA_CPF = "from Motorista m where m.cpf = ?1";

	@Query(Q_GET_MOTORISTA_CPF)
	Motorista getMotoristaByCpf(String cpf);

}
