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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.backend.victorr.model.Passageiro;
import br.com.backend.victorr.service.PassageiroService;

@Controller
@RequestMapping(value = "/passageiro")
public class PassageiroController {

	@Autowired
	private PassageiroService passageiroService;

	@RequestMapping(value = "/cadastrar")
	public ModelAndView chamaIndex() {
		return new ModelAndView("passageiro");
	}

	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> gravarPass(@Valid Passageiro passageiro) throws ParseException {
		try {
			passageiroService.gravar(passageiro);
			return new ResponseEntity<String>("Cadastro Realizado com sucesso", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listarPasssageiros() {
		Map<String, Object> data = new HashMap<String, Object>();

		try {
			List<Passageiro> listaPassageiros = passageiroService.findall();

			data.put("lista", listaPassageiros);
			
			data.put("mensagem", "Listar Passageiros");
			
			return new ModelAndView("listarPassageiros", data);

		} catch (Exception e) {
			return new ModelAndView("listarPassageiros", data);
		}

	}
}
