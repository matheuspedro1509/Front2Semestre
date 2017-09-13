package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dao.AcessorioDAO;



@Controller
@RequestMapping("/acessorio")
public class AcessorioController {
	
	@Autowired //Servidor vai injetar um objeto aqui
	private AcessorioDAO dao;

	@GetMapping("cadastrar")
	public ModelAndView abrirFormulario(){
		return new ModelAndView("acessorio/cadastro");
		//return new ModelAndView("veiculo/cadastro")
		//.addObject("veiculo", new Veiculo());
	}
	
	@GetMapping("listar")
	public ModelAndView listarAcessorios(){
		ModelAndView retorno = new ModelAndView("acessorio/lista");
		//retorno.addObject("acessorios", dao.listar());
		return retorno;
		
	}
}
