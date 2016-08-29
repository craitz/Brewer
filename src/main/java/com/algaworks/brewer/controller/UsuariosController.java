package com.algaworks.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.brewer.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@RequestMapping(value = "novo", method = RequestMethod.GET)
	public ModelAndView novo(Usuario usuario) {
		ModelAndView mv = new ModelAndView("usuario/CadastroUsuario");
		return mv;
	}
}
