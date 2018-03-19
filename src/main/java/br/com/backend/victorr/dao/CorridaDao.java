package br.com.backend.victorr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.backend.victorr.model.Corrida;

@Repository
public interface CorridaDao extends JpaRepository<Corrida, Integer> {
	

}
