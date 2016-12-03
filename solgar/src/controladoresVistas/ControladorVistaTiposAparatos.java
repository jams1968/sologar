package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelos.TipoAparato;
import vistas.VistaTipoAparato;

public class ControladorVistaTiposAparatos implements ActionListener {
	
	private VistaTipoAparato vista;
	private TipoAparato registroNuevo;
	
	public ControladorVistaTiposAparatos( VistaTipoAparato vista) {
		this.vista=vista;
		registroNuevo=new TipoAparato();
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getComboTipoAparatos())
				&&(vista.getComboTipoAparatos().getSelectedIndex()>0)){
			registroNuevo=(TipoAparato)vista.getComboTipoAparatos().getSelectedItem();
			vista.getTextTipo().setText(registroNuevo.getTipo());
		}
		
	}

}
