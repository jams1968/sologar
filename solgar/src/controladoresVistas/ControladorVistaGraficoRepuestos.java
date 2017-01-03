package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graficos.VistaGraficoRepuestos;

public class ControladorVistaGraficoRepuestos implements ActionListener{
	
	private VistaGraficoRepuestos vista;
	
	public ControladorVistaGraficoRepuestos(VistaGraficoRepuestos vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar())){
			vista.dispose();
		}
		
	}//fin action

}//fin de la clase
