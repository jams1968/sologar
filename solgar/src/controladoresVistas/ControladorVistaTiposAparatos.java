package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import modelos.Repuesto;
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
			vista.getLblMensaje().setText("");
			vista.getBtnRegistrar().setEnabled(false);
			vista.getBtnModificar().setEnabled(true);
			vista.getBtnEliminar().setEnabled(true);
		}
		else if (accion.getSource().equals(vista.getBtnRegistrar())) {
			registroNuevo.setTipo(vista.getTextTipo().getText());
			if(registroNuevo.buscar()){
				vista.getLblMensaje().setText("El tipo de aparato ya esta registrado en la DB");
				registroNuevo = new TipoAparato();
			}else {
				if(registroNuevo.create()){
					vista.getLblMensaje().setText("Tipo de Aparato registrado exitosamente ");
					vista.getComboTipoAparatos().llenar();
					vista.getBtnRegistrar().setEnabled(false);
				}else{					
					vista.getLblMensaje().setText("No se pudo registrar el Tipo de Aparato "); 
				} 
			}
			
		}else if(accion.getSource().equals(vista.getComboTipoAparatos())
				&&(vista.getComboTipoAparatos().getSelectedIndex()<1)){
				vista.getTextTipo().setText("");
				vista.getBtnModificar().setEnabled(false);
				vista.getBtnEliminar().setEnabled(false); 
		}else if(accion.getSource().equals(vista.getBtnEliminar())){
			int eliminar = JOptionPane.showConfirmDialog(vista, " Desea eliminar el  Tipo Aparato",
					"Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
			
			if(eliminar == 0){
				JOptionPane.showMessageDialog(vista, "Tipo Aparato eliminado");
				registroNuevo=(TipoAparato)vista.getComboTipoAparatos().getSelectedItem();
				registroNuevo.eliminar();
				vista.getComboTipoAparatos().llenar();
				registroNuevo = new TipoAparato();
				vista.getTextTipo().setText("");
				vista.getBtnModificar().setEnabled(false);
				vista.getBtnEliminar().setEnabled(false); 
			}
		}else if(accion.getSource().equals(vista.getBtnModificar())){
			
			registroNuevo=(TipoAparato)vista.getComboTipoAparatos().getSelectedItem();
			registroNuevo.setTipo("");
			
			System.out.println(registroNuevo);
			
		}else if(accion.getSource().equals(vista.getBtnVaciar())){
			vista.getTextTipo().requestFocus();
			vista.getBtnRegistrar().setEnabled(false);
			vista.getTextTipo().setText("");
			vista.getComboTipoAparatos().setSelectedIndex(0);
			
		}	

		
	}//fin actionlisterner

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent accion) {
		if (accion.getSource().equals(vista.getTextTipo()) && (vista.getComboTipoAparatos().getSelectedIndex()<1) ){
			vista.getBtnRegistrar().setEnabled(true);
			vista.getLblMensaje().setText("");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
