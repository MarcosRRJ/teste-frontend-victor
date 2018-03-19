package br.com.backend.victorr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.backend.victorr.dao.PassageiroDao;
import br.com.backend.victorr.model.Motorista;
import br.com.backend.victorr.model.Passageiro;

@Service("passageiroService")
@Transactional
public class PassageiroServiceImpl implements PassageiroService {

	@Autowired
	private PassageiroDao passageiroDao;

	
	public void gravar(Passageiro passageiro) {

		Passageiro passageiroAux = findByCpf(passageiro.getCpf());

		if (passageiroAux != null) {
			System.out.println("Passageiro ja cadastrado");
		} else {
			passageiroDao.save(passageiro);
		}
	}
	public List<Passageiro> findall() {

		return passageiroDao.findAll();
	}

	public Passageiro findById(int i) {
		
		return passageiroDao.findOne(1);
		
	}

	@Override
	public Passageiro findByCpf(String cpf) {
		
		return passageiroDao.getPassageiroByCpf(cpf);
		
		
	}
	
	
	

}
