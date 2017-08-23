package br.com.fiap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.model.Veiculo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	//Simulando o banco
	List<Veiculo> banco = new ArrayList<Veiculo>();
	
	@GetMapping("cadastrar") //Abre a tela
	public String abreForm(){
		return "veiculo/cadastro";
	}
	
	@PostMapping("cadastrar") //Processa as informacoes
	public ModelAndView processaForm(Veiculo veiculo){
		banco.add(veiculo);
		
		ModelAndView retorno = new ModelAndView("veiculo/cadastroSucesso");
		retorno.addObject("v",veiculo);
		return retorno;
	}
	
	@GetMapping("listar")
	public ModelAndView listarVeiculos(){
		ModelAndView retorno = new ModelAndView();
		retorno.addObject("veiculos",banco);
		return retorno;
	}
	
}
