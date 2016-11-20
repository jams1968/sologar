package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import vistas.VistaRepuestos;

public class ControladorVistaRepuestos implements ActionListener , KeyListener{
	
	private VistaRepuestos vista;

	public ControladorVistaRepuestos(VistaRepuestos vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		
		if (accion.getSource().equals(vista.getBtnRegistrar())) {
			
			if (vista.getComboTipoAparatos().getSelectedIndex()<1) {
				
				vista.getLblMensaje().setText("Seleccione el tipo de aparato");
				
			}else if (vista.getTextCodigo().getText().trim().isEmpty()) {
				
				vista.getTextCodigo().requestFocus();
				
				vista.getLblMensaje().setText("El codigo es requerido");
				
			}else if (vista.getTextRepuesto().getText().trim().isEmpty()) {
				
				vista.getTextRepuesto().requestFocus();
				
				vista.getLblMensaje().setText("El repuesto es requerido");
				
			}else if (vista.getTextCantidad().getText().trim().isEmpty()) {
				
				vista.getTextCantidad().requestFocus();
				
				vista.getLblMensaje().setText("La cantidad es requerida");
				
			}else if (vista.getTextPrecioVenta().getText().trim().isEmpty()) {
				
				vista.getTextPrecioVenta().requestFocus();
				
				vista.getLblMensaje().setText("El precio de venta es requerido");
				
			}else if (vista.getTextDescripcion().getText().trim().isEmpty()) {
				
				vista.getTextDescripcion().requestFocus();
				
				vista.getLblMensaje().setText("La descripción es requerida");
				
			}else{
				vista.getLblMensaje().setText(":)");
			}
			
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent accion) {
		
		if (accion.getSource().equals(vista.getTextCodigo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCodigo().getText().trim().isEmpty())) {
			
			JOptionPane.showMessageDialog(null, "lihaua n");
			
		}
			
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
