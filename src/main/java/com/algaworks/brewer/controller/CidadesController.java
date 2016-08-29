package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Cidade;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

	@RequestMapping(value = "novo", method = RequestMethod.GET)
	public ModelAndView novo(Cidade cidade) {
		ModelAndView mv = new ModelAndView("cidade/CadastroCidade");
		return mv;
	}
}
