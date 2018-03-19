package br.com.backend.victorr.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.backend.victorr.model.Motorista;
import br.com.backend.victorr.service.MotoristaService;

@Controller
@RequestMapping(value = "/motorista")
public class MotoristaController {

	@Autowired
	private MotoristaService motoristaService;

	@RequestMapping(value = "/cadastrar")
	public ModelAndView chamaIndex() {
		return new ModelAndView("motorista");

	}

	@RequestMapping(value = "/gravar", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> gravarMoto(@Valid Motorista motorista) throws ParseException {

		try {
			motoristaService.gravar(motorista);

			return new ResponseEntity<String>(HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView listarMotorista() {
		Map<String, Object> data = new HashMap<String, Object>();

		try {
			List<Motorista> listaMotorista = motoristaService.findall();

			data.put("lista", listaMotorista);

			data.put("mensagem", "Listar Motoristas");

			return new ModelAndView("listarMotoristas", data);

		} catch (Exception e) {
			return new ModelAndView("listarMotoristas", data);
		}

	}

	@RequestMapping(value = "/mudarStatus/{cpf}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<String> update(@PathParam("cpf") String cpf) {

		try {
			
			motoristaService.changeByCpf(cpf);
			
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}
