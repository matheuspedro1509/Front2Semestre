package br.com.fiap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PratoController {

	@RequestMapping("/prato/cadastro")
	public String abreForm(){
		return "prato/cadastro";
	}
	
	@RequestMapping(value="prato/cadastrar", method=RequestMethod.POST)
	public String processForm(String nome, double preco, float peso){
		System.out.println(nome + " " + preco + ""  + peso);
		return "prato/cadastro";
	}
}
