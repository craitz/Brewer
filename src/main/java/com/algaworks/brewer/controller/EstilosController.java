package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Estilo;

@Controller
@RequestMapping("/estilos")
public class EstilosController {

	@RequestMapping(value = "novo", method = RequestMethod.GET)
	public ModelAndView novo(Estilo estilo) {
		ModelAndView mv = new ModelAndView("estilo/CadastroEstilo");
		return mv;
	}
}
