package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("cliente/CadastroCliente");
		return mv;
	}
}
