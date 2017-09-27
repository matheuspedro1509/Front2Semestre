package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.model.Veiculo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired //Servidor vai injetar um objeto aqui
	private VeiculoDAO dao;
	
	@Transactional
	@PostMapping("excluir")
	public ModelAndView excluirForm(int codigo, RedirectAttributes redirect){
		try {
			dao.remover(codigo);
			redirect.addFlashAttribute("msg", "Excluido!");
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/veiculo/listar");
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(@Valid Veiculo veiculo,
				BindingResult result, RedirectAttributes redirect){
		ModelAndView retorno;
		if (result.hasErrors()){
			retorno = new ModelAndView("veiculo/edicao");
		}else{
			dao.alterar(veiculo);
			redirect.addFlashAttribute("msg", "Atualizado!");
			retorno = new ModelAndView("redirect:/veiculo/listar");
		}
		return retorno;
	}

	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo){
		Veiculo veiculo = dao.pesquisar(codigo);
		return new ModelAndView("veiculo/edicao")
							.addObject("veiculo",veiculo);
	}
	
	@GetMapping("cadastrar") //Abre a tela de formulário
	public ModelAndView abrirForm(){
		return new ModelAndView("veiculo/cadastro")
							.addObject("veiculo", new Veiculo());
	}
	
	@Transactional
	@PostMapping("cadastrar") //Processa as informações do formulário
	public ModelAndView processaForm(@Valid Veiculo veiculo, BindingResult result,  RedirectAttributes redirect){
		//Verifica se existe erro de validação
		ModelAndView retorno;
		if (result.hasErrors()){
			retorno = new ModelAndView("veiculo/cadastro");
		}else{		
			//Cadastrar no banco
			dao.cadastrar(veiculo);
			//Retorno.. redirecionar para o método listar
			retorno = new ModelAndView("redirect:/veiculo/listar");
			redirect.addFlashAttribute("msg", "Cadastrado com sucesso!");
		}
		return retorno;
	}
	
	@GetMapping("listar")
	public ModelAndView listarVeiculos(){
		ModelAndView retorno = new ModelAndView("veiculo/lista");
		retorno.addObject("veiculos",dao.listar());
		return retorno;
	}
	
}




