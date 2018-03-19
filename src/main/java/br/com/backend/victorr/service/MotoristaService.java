package br.com.backend.victorr.service;

import java.util.List;

import br.com.backend.victorr.model.Motorista;

public interface MotoristaService {

	public void gravar(Motorista motorista);

	public List<Motorista> findall();

	public Motorista findById(int i);
	
	public Motorista findByCpf(String cpf);
	
	public void changeByCpf(String cpf);

}
