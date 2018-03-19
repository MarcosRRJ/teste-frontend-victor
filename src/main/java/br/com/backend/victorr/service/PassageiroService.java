package br.com.backend.victorr.service;

import java.util.List;

import br.com.backend.victorr.model.Passageiro;

public interface PassageiroService {

	public void gravar(Passageiro passageiro);

	public List<Passageiro> findall();

	public Passageiro findById(int i);

	public Passageiro findByCpf(String cpf);

}
