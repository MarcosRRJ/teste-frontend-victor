package br.com.backend.victorr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.backend.victorr.dao.MotoristaDao;
import br.com.backend.victorr.model.Motorista;

@Service("motoristaService")
@Transactional
public class MotoristaServiceImpl implements MotoristaService {

	@Autowired
	private MotoristaDao motoristadao;

	public void gravar(Motorista motorista) {

		Motorista motoristaAux = findByCpf(motorista.getCpf());

		if (motoristaAux != null) {
			System.out.println("Motorista ja cadastrado");
		} else {
			motoristadao.save(motorista);
		}
	}

	public List<Motorista> findall() {

		return motoristadao.findAll();
	}

	public Motorista findById(int i) {

		return motoristadao.findOne(i);
	}

	public Motorista findByCpf(String cpf) {

		return motoristadao.getMotoristaByCpf(cpf);
	}

	public void changeByCpf(String cpf) {
		try {
			Motorista motorista = findByCpf(cpf);
			if (motorista != null && motorista.getStatus().equals("Inativo")) {
				motorista.setStatus("Ativo");
				motoristadao.save(motorista);
			} else if (motorista != null && motorista.getStatus().equals("Ativo")) {
				motorista.setStatus("Inativo");
				motoristadao.save(motorista);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
