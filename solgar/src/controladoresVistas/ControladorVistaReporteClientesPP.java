package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistasReportes.VistaReporteClientesPP;

public class ControladorVistaReporteClientesPP implements ActionListener {
	private VistaReporteClientesPP vista;
	
	public ControladorVistaReporteClientesPP(VistaReporteClientesPP vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnRetornar()))
			vista.dispose();
		
	}//fin action
	
	

}//finclase
