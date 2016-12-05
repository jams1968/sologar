package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelos.Cliente;
import modelos.Usuario;
import vistas.VistaCliente;

public class ControladorVistaCliente implements ActionListener,KeyListener {

	VistaCliente vista;
	private Cliente nuevoRegistro;
	
	public ControladorVistaCliente(VistaCliente vista) {
		this.vista=vista;
		nuevoRegistro=new Cliente();
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}// fin cerrar
		else if (accion.getSource().equals(vista.getBtnRegistrar())) {
			llenarModelo();
			  
			if(!nuevoRegistro.buscar(vista.getTextCedula().getText())&&(nuevoRegistro.create()))
					vista.getLblMensaje().setText("Cliente registrado exitosamente ");
				else
					vista.getLblMensaje().setText("No se pudo registrar el cliente ");
			
			}
		
	}//fin action
	
	//-------->keylisterner<-----------------
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCedula().getText().trim().isEmpty())){
			if(!nuevoRegistro.buscar(vista.getTextCedula().getText().trim())){
				vista.getTextCliente().setEditable(true);
				vista.getTextCliente().requestFocus();
				
				
			}else{
				vista.getLblMensaje().setText("Cedula o rif se encuentra registrado");
				llenarFormulario(nuevoRegistro);
				desbloquear();
				vista.getBtnModificar().setEnabled(true);
				vista.getBtnEliminar().setEnabled(true);
			}
		
		}//cedula
		else if(accion.getSource().equals(vista.getTextCliente())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCliente().getText().trim().isEmpty())){
				vista.getTextTelefono1().setEditable(true);
				vista.getTextTelefono1().requestFocus();
		}
		else if(accion.getSource().equals(vista.getTextTelefono1())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextTelefono1().getText().trim().isEmpty())){
				vista.getTextTelefono2().setEditable(true);
				vista.getTextTelefono2().requestFocus();
		}
		else if(accion.getSource().equals(vista.getTextTelefono2())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextTelefono2().getText().trim().isEmpty())){
				vista.getTextCorreo().setEditable(true);
				vista.getTextCorreo().requestFocus();
		}
		else if(accion.getSource().equals(vista.getTextCorreo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCorreo().getText().trim().isEmpty())){
				vista.getTextDireccion().setEditable(true);
				vista.getTextDireccion().requestFocus();
		}
		else if(accion.getSource().equals(vista.getTextDireccion())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)){
				vista.getBtnRegistrar().setEnabled(true);
				
		}
		
		
	}//fin keypressed
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//------------>llevar campos formulario<-----------
	public void llenarFormulario(Cliente registro){
		vista.getTextCliente().setText(registro.getCliente());
		vista.getTextTelefono1().setText(registro.getTelefono1());
		vista.getTextTelefono2().setText(registro.getTelefono2());
		vista.getTextDireccion().setText(registro.getDireccion());
		vista.getTextCorreo().setText(registro.getCorreo());
		
			
	}
	//--------> guardar en modelo<----------
	public void llenarModelo(){
		nuevoRegistro=new Cliente();
		this.nuevoRegistro.setDocumentoIdentidad(vista.getTextCedula().getText());
		this.nuevoRegistro.setCliente(vista.getTextCliente().getText().toUpperCase());
		this.nuevoRegistro.setTelefono1(vista.getTextTelefono1().getText());
		
		if(vista.getTextTelefono2().getText().charAt(1)=='_')
			this.nuevoRegistro.setTelefono2("");
		else
			this.nuevoRegistro.setTelefono2(vista.getTextTelefono2().getText());
		this.nuevoRegistro.setDireccion(vista.getTextDireccion().getText().toUpperCase());
		this.nuevoRegistro.setCorreo(vista.getTextCorreo().getText().toLowerCase());
	}
	
	public void desbloquear(){
		vista.getTextCliente().setEditable(true);
		vista.getTextTelefono1().setEditable(true);
		vista.getTextTelefono2().setEditable(true);
		vista.getTextDireccion().setEditable(true);
		vista.getTextCorreo().setEditable(true);
		
	}
	public void bloquear(){
		vista.getTextCliente().setEditable(false);
		vista.getTextTelefono1().setEditable(false);
		vista.getTextTelefono2().setEditable(false);
		vista.getTextDireccion().setEditable(false);
		vista.getTextCorreo().setEditable(false);
		
	}
}//fin clase
