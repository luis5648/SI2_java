package main;



import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;

public class Histograma {
	
	
	DefaultCategoryDataset datos = new DefaultCategoryDataset();
	
	
	public void puntos(int x,String fila,String columna) {
		datos.addValue(x, fila, columna);
		
	}
	
	public JFreeChart createBarChart(CategoryDataset datos) {
		
		JFreeChart graficaBarras = ChartFactory.createBarChart("Escalas de gris", 
				"colores", 
				"intensidad", 
				datos,
				PlotOrientation.HORIZONTAL,
				true,
				true,
				false);
		
		return graficaBarras;
	}
	
	
}
