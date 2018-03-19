package br.com.backend.victorr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.backend.victorr.dao.CorridaDao;
import br.com.backend.victorr.model.Corrida;

@Service("corridaService")
@Transactional
public class CorridaServiceImpl implements CorridaService {

	@Autowired
	private CorridaDao corridaDao;

	
	public void gravar(Corrida corrida) {

		corridaDao.save(corrida);

	}

	public List<Corrida> findall() {

		return corridaDao.findAll();
	}

}
