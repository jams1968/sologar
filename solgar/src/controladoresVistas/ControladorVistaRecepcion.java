package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelos.Cliente;
import modelos.Usuario;
import vistas.VistaCliente;
import vistas.VistaRecepcion;

public class ControladorVistaRecepcion implements ActionListener,KeyListener {

	private VistaRecepcion vista;
	private Cliente registroCliente;
	
	
	public ControladorVistaRecepcion(VistaRecepcion vista) {
		this.vista=vista;
		this.registroCliente=new Cliente();
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar()))
			vista.dispose();
		
		
	}
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCedula().getText().trim().isEmpty())){
			if(registroCliente.buscar(vista.getTextCedula().getText().trim())){
				llenarFormularioCliente();
				
				
				
			}else{
				vista.getLblMensaje().setText("Cliente no se encuentra registrado");
				new VistaCliente(vista.getRegistroUsuario());
				
				
			}
		
		}//cedula
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//------------>llenar campos formulario<-----------
	public void llenarFormularioCliente(){
		vista.getTextCliente().setText(registroCliente.getCliente());
		vista.getTextTelefono1().setText(registroCliente.getTelefono1());
		vista.getTextTelefono2().setText(registroCliente.getTelefono2());
		vista.getTextDireccion().setText(registroCliente.getDireccion());
		vista.getTextCorreo().setText(registroCliente.getCorreo());
			
	}

}
