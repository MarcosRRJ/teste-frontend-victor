package br.com.backend.victorr.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.backend.victorr.model.Corrida;
import br.com.backend.victorr.model.Motorista;
import br.com.backend.victorr.model.Passageiro;
import br.com.backend.victorr.service.CorridaService;
import br.com.backend.victorr.service.MotoristaService;
import br.com.backend.victorr.service.PassageiroService;

@Controller
@RequestMapping(value = "/corrida")
public class CorridaController {

	@Autowired
	private CorridaService corridaService;

	@Autowired
	private PassageiroService passageiroService;
	
	@Autowired
	private MotoristaService motoristaService;
	
	
	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> gravarPass(@RequestParam String cpfMotorista, @RequestParam String cpfPassageiro, @RequestParam Double valorCorrida) throws ParseException {
		try {
			
			Passageiro passageiro = passageiroService.findByCpf(cpfPassageiro);
			
			Motorista motorista = motoristaService.findByCpf(cpfMotorista);
			
			Corrida corrida = new Corrida();
			corrida.setMotorista(motorista);
			corrida.setPassageiro(passageiro);
			corrida.setValorCorrida(valorCorrida);
			
			corridaService.gravar(corrida);
			
			return new ResponseEntity<String>("Cadastro Realizado com sucesso", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}
	
	
	@RequestMapping(value = "/registrar", method = RequestMethod.GET)
	public ModelAndView registrarPassageiros() {
		Map<String, Object> data = new HashMap<String, Object>();

		try {
			
			List<Passageiro> listaPassageiros = passageiroService.findall();
			
			List<Motorista> listaMotorista = motoristaService.findall();
			
			
			data.put("listaPassageiro",listaPassageiros);
			
			data.put("listaMotorista",listaMotorista);
			

			return new ModelAndView("registrarCorridas", data);

		} catch (Exception e) {
			return new ModelAndView("registrarCorridas", data);
		}

	}


	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listarPasssageiros() {
		Map<String, Object> data = new HashMap<String, Object>();

		try {
			List<Corrida> listaCorridas = corridaService.findall();

			data.put("lista", listaCorridas);

			data.put("mensagem", "ListadeCorridas");

			return new ModelAndView("listaDeCorridas", data);

		} catch (Exception e) {
			return new ModelAndView("listaDeCorridas", data);
		}

	}
}
