package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pdf.reciboPDF;
import vistas.VistaPorNroRecibo;

public class ControladorVistaPorNroRecibo implements ActionListener {
	
	private VistaPorNroRecibo vista;
	
	public ControladorVistaPorNroRecibo(VistaPorNroRecibo vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if (accion.getSource().equals(vista.getCancelButton()))
			vista.dispose();
		else if(accion.getSource().equals(vista.getOkButton())&&
				(!vista.getTextNRecibo().getText().isEmpty())){
			new reciboPDF(Integer.parseInt(vista.getTextNRecibo().getText()));
			
		}
		
	}

}//fin clase
