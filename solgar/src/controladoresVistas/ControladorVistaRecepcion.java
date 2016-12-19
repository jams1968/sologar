package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import librerias.Funciones;
import modelos.Cliente;
import modelos.Usuario;
import vistas.VistaAgregarArtefacto;
import vistas.VistaCliente;
import vistas.VistaRecepcion;

public class ControladorVistaRecepcion implements ActionListener,KeyListener {

	private VistaRecepcion vista;
	private Cliente registroCliente;
	private Funciones funcion;
	
	
	public ControladorVistaRecepcion(VistaRecepcion vista) {
		this.vista=vista;
		this.registroCliente=new Cliente();
		funcion=new Funciones();
		vista.getTextNrecibo().setText(""+funcion.proximoID("SELECT AUTO_INCREMENT FROM information_schema.TABLES "
			+ "WHERE TABLE_SCHEMA='solgar' AND TABLE_NAME= 'recepciones' "));
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar()))
			vista.dispose();
		else if(accion.getSource().equals(vista.getBtnVaciar()))
			vaciarFormulario();
		else if(accion.getSource().equals(vista.getBtnAgregarArtefacto()))
			new VistaAgregarArtefacto();
		
		
	}
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCedula().getText().trim().isEmpty())){
			if(registroCliente.buscar(vista.getTextCedula().getText().trim())){
				llenarFormularioCliente();
				vista.getBtnAgregarArtefacto().setEnabled(true);
				
				
			}else{
				vista.getLblMensaje().setText("Cliente no se encuentra registrado");
				new VistaCliente(vista.getRegistroUsuario());
				if(registroCliente.buscar(vista.getTextCedula().getText().trim())){
					llenarFormularioCliente();
					vista.getBtnAgregarArtefacto().setEnabled(true);
					vista.getLblMensaje().setText(null);
				
				}
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

		vista.getBtnAgregarArtefacto().setEnabled(false);
		vista.getBtnRegistrar().setEnabled(false);
		vista.getBtnModificar().setEnabled(false);
		vista.getBtnEliminar().setEnabled(false);
		
			
	}
	//-------------------->vaciar campos<----------------------
	public void vaciarFormulario(){
		vista.getTextCedula().setText(null);
		vista.getTextCliente().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextTelefono2().setText(null);
		vista.getTextDireccion().setText(null);
		vista.getTextCorreo().setText(null);
		
		registroCliente=new Cliente();
		vista.getTextCedula().requestFocus();
	}

}
