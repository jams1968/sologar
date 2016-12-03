package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelos.TipoAparato;
import vistas.VistaTipoAparato;

public class ControladorVistaTiposAparatos implements ActionListener,KeyListener {
	
	private VistaTipoAparato vista;
	private TipoAparato registroNuevo;
	
	public ControladorVistaTiposAparatos( VistaTipoAparato vista) {
		this.vista=vista;
		registroNuevo=new TipoAparato();
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}// fin cerrar
		else if(accion.getSource().equals(vista.getComboTipoAparatos())
				&&(vista.getComboTipoAparatos().getSelectedIndex()>0)){
			registroNuevo=(TipoAparato)vista.getComboTipoAparatos().getSelectedItem();
			vista.getTextTipo().setText(registroNuevo.getTipo());
		}
		else if (accion.getSource().equals(vista.getBtnRegistrar())) {
			registroNuevo.setTipo(vista.getTextTipo().getText());
			
		
			  
			if(registroNuevo.create()){
					vista.getLblMensaje().setText("Tipo de Aparato registrado exitosamente ");
					vista.getComboTipoAparatos().llenar();
			}
				else
					vista.getLblMensaje().setText("No se pudo registrar el Tipo de Aparato ");
			
			}
		
	}//fin actionlisterner

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent accion) {
		if (accion.getSource().equals(vista.getTextTipo())){
			vista.getBtnRegistrar().setEnabled(true);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
