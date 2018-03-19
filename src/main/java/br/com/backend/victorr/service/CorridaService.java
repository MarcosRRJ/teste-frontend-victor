package br.com.backend.victorr.service;

import java.util.List;

import br.com.backend.victorr.model.Corrida;

public interface CorridaService {

	
	public void gravar(Corrida corrida);

	public List<Corrida> findall();

}
