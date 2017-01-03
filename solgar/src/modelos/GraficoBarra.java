package modelos;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import java.awt.Cursor;

public class GraficoBarra extends JPanel {
	private JFreeChart graficoBarra;
	
	public GraficoBarra(Grafico grafico) {

		if(grafico.getOrientacion()==0)
		graficoBarra = ChartFactory.createBarChart(grafico.getTitulo(),grafico.getAbcisa(),grafico.getOrdenada(),
				grafico.getData(),PlotOrientation.HORIZONTAL,grafico.isLeyenda(),grafico.isEtiqueta(),false);
		
		else 
			graficoBarra = ChartFactory.createBarChart(grafico.getTitulo(),grafico.getAbcisa(),grafico.getOrdenada(),
					grafico.getData(),PlotOrientation.VERTICAL,grafico.isLeyenda(),grafico.isEtiqueta(),false);
		
		
		ChartPanel panelGrafico = new ChartPanel(graficoBarra);
		panelGrafico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		this.add(panelGrafico);
	}	
	
				
		
	
}
