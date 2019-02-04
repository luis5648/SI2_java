package main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYSeries;

public class Histograma {
	XYSeries puntos = new XYSeries("Histograma");
	
	
	public void puntos(double color,double cantidad) {
		puntos.add(color,cantidad);
		
	}
	
	public JFreeChart createBarChart(CategoryDataset datos) {
		
		JFreeChart graficaBarras = ChartFactory.createBarChart("Escalas de gris", 
				"colores", 
				"colores", 
				datos);
		
		return graficaBarras;
	}
	
	
}
