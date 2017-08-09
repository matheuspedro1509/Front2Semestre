package br.com.fiap.bean;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario;
	
	private UsuarioBO bo;

	@PostConstruct
	private void init(){
		//inicializacao dos objetos
		usuario = new Usuario();
		usuario.setDataNascimento(Calendar.getInstance());
		bo= new UsuarioBO();
	}
	
	public String cadastrar(){
		FacesMessage msg;
		try {
			if (usuario.getCodigo() == 0){
				bo.cadastrar(usuario);
				msg = new FacesMessage("Cadastrado");
			}else{
				bo.atualizar(usuario);
				msg = new FacesMessage("Atualizado!");
			}
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ...");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		FacesContext.getCurrentInstance().getExternalContext()
				.getFlash().setKeepMessages(true);
		return "usuario?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
