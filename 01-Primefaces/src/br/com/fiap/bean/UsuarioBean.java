package br.com.fiap.bean;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;
	
	private UsuarioBO bo;
	
	//Metodo que realiza o upload de arquivo
	public void subirFoto(FileUploadEvent event) throws IOException{
		try {
			//Cria um arquivo  com o nome do upload
			File file = new File("C:\\arquivo",event.getFile().getFileName());
			//Gravar a informacao no arquivo
			FileOutputStream output = new FileOutputStream(file);
			output.write(event.getFile().getContents());
			output.close();
			//Grava o nome d arquivo no banco
			usuario.setFoto(event.getFile().getFileName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

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
