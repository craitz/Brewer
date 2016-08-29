package com.algaworks.brewer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.brewer.model.Cerveja;
import com.algaworks.brewer.repository.Cervejas;

@Controller
@RequestMapping("/cervejas")
public class CervejasController {

	@Autowired
	private Cervejas cervejas;
	
	@RequestMapping(value = "novo", method = RequestMethod.GET)
	public ModelAndView novo(Cerveja cerveja) {
		List<Cerveja> lc = cervejas.findAll();
		System.out.println(">>>>>>> " + lc.size());
		
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		return mv;
	}

	@RequestMapping(value = "novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, RedirectAttributes attr) {

		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			return novo(cerveja);
		} else {
			attr.addFlashAttribute("mensagem", "Deu tudo certo!!");
			mv.setViewName("redirect:/cervejas/novo");
		}

		return mv;
	}
}
