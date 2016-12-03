package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistasReportes.VistaReporteRepuestosPP;

public class ControladorVistaReporteRepuestosPP implements ActionListener {
	
	private VistaReporteRepuestosPP vista;
	
	public ControladorVistaReporteRepuestosPP( VistaReporteRepuestosPP vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnRetornar())){
			vista.dispose();
		}// fin cerrar
		
	}

}