package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;

import org.primefaces.model.chart.PieChartModel;

import br.com.fiap.bo.UsuarioBO;



@ManagedBean
public class GraficoBean {

	private PieChartModel graficoPizza;
	
	private UsuarioBO bo;

	@PostConstruct
	private void init(){
		bo = new UsuarioBO();
		graficoPizza = new PieChartModel();
		
		graficoPizza.set("Abaixo da m�dia", bo.contarUsuarioPorNivel(1) + bo.contarUsuarioPorNivel(2));
		graficoPizza.set("Normal", bo.contarUsuarioPorNivel(3));
		graficoPizza.set("Acima da m�dia", bo.contarUsuarioPorNivel(5) + bo.contarUsuarioPorNivel(4));
		
		//graficoPizza.set("Abaixo da m�dia", 2);
		//graficoPizza.set("Normal", 1);
		//graficoPizza.set("Acima da m�dia",5);
		
		graficoPizza.setLegendPosition("e");
		graficoPizza.setShowDataLabels(true);
	}
	
	public PieChartModel getGraficoPizza() {
		return graficoPizza;
	}

	public void setGraficoPizza(PieChartModel graficoPizza) {
		this.graficoPizza = graficoPizza;
	}
}
