package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistas.VistaRecepcion;

public class ControladorVistaRecepcion implements ActionListener {

	VistaRecepcion vista;
	
	public ControladorVistaRecepcion(VistaRecepcion vista) {
		this.vista=vista;
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar()))
			vista.dispose();
		
		
	}

}
