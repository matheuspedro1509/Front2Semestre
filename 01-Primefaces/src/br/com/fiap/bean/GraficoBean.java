package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.fiap.bo.UsuarioBO;

@ManagedBean
public class GraficoBean {

	private PieChartModel graficoPizza;
	private LineChartModel graficoLinha;
	
	private UsuarioBO bo;

	@PostConstruct
	private void init(){
		bo = new UsuarioBO();
		graficoPizza = new PieChartModel();
		
		graficoPizza.set("Abaixo da média", bo.contarUsuarioPorNivel(1) + bo.contarUsuarioPorNivel(2));
		graficoPizza.set("Normal", bo.contarUsuarioPorNivel(3));
		graficoPizza.set("Acima da média", bo.contarUsuarioPorNivel(5) + bo.contarUsuarioPorNivel(4));
		
		//graficoPizza.set("Abaixo da média", 2);
		//graficoPizza.set("Normal", 1);
		//graficoPizza.set("Acima da média",5);
		
		graficoPizza.setLegendPosition("e");
		graficoPizza.setShowDataLabels(true);
		
		///// Grafico de linha
		graficoLinha = new LineChartModel();
		graficoLinha.setLegendPosition("e");
		graficoLinha.getAxes().put(AxisType.X, new CategoryAxis("Mês"));
		
		LineChartSeries series = new LineChartSeries();
		series.setLabel("Alunos");
		
		String[] meses = {"Jan","Fev","Março","Abril","Maio", "Junho", "Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
		
		for(int i=1 ; i<=12; i++){
			series.set(meses[i-1], bo.contarPorMes(i));
			}
		getGraficoLinha().addSeries(series);
	}
	
	public PieChartModel getGraficoPizza() {
		return graficoPizza;
	}

	public void setGraficoPizza(PieChartModel graficoPizza) {
		this.graficoPizza = graficoPizza;
	}

	public LineChartModel getGraficoLinha() {
		return graficoLinha;
	}

	public void setGraficoLinha(LineChartModel graficoLinha) {
		this.graficoLinha = graficoLinha;
	}
}
