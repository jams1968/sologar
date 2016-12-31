package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graficos.VistaGraficoAparatosRecibidos;

public class ControladorVistaGraficoAparatosRecibidos implements ActionListener {
	
	private VistaGraficoAparatosRecibidos vista;
	
	public ControladorVistaGraficoAparatosRecibidos(VistaGraficoAparatosRecibidos vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar())){
			vista.dispose();
		}
		
	}
	
	

}
