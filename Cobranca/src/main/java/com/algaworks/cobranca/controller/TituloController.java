package com.algaworks.cobranca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {

	@Autowired
	private Titulos titulos;

	@RequestMapping
	public String pesquisa() {
		return "PesquisaTitulos";
	}
	
	@RequestMapping("novo")
	public String novo() {
		return "CadastroTitulo";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		System.out.println("SALVO: "+titulo.getDescricao());
		
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		titulos.save(titulo);
		
		return mv;
	}
}
