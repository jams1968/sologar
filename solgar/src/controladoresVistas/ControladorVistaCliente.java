package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import librerias.Funciones;
import modelos.Cliente;
import modelos.Repuesto;
import modelos.Usuario;
import vistas.VistaCliente;

public class ControladorVistaCliente implements ActionListener,KeyListener {

	VistaCliente vista;
	private Cliente nuevoRegistro;
	private Pattern patronLetras,patronNumero,patronTelefono,patronCorreo;
	private Matcher validarNumeros,validarLetras,validarTelefono,validarCorreo;
	private Funciones funcion;
	
	public ControladorVistaCliente(VistaCliente vista) {
		this.vista=vista;
		patronLetras = Pattern.compile("[A-Za-z ]");
		patronNumero = Pattern.compile("[0-9]");
		patronTelefono = Pattern.compile("[0-9()-]");
		patronCorreo=Pattern.compile("^[A-Za-z0-9]+@[a-z]+\\.[a-z]+");
		funcion=new Funciones();
		nuevoRegistro=new Cliente();
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}// fin cerrar
		else if (accion.getSource().equals(vista.getBtnRegistrar())) {
			llenarModelo();
			  
			if(!nuevoRegistro.buscar(vista.getTextCedula().getText())&&(nuevoRegistro.create())){
					vista.getLblMensaje().setText("Cliente registrado exitosamente ");
					vaciarFormulario();
					
			}
				else
					vista.getLblMensaje().setText("No se pudo registrar el cliente ");
			
		}//fin registrar
		else if (accion.getSource().equals(vista.getBtnModificar())) {
			
			  
			if(nuevoRegistro.buscar(vista.getTextCedula().getText())){
				llenarModelo();
				if(nuevoRegistro.update())
						vista.getLblMensaje().setText("Datos del Cliente  Modificado exitosamente ");
					else
						vista.getLblMensaje().setText("No se pudo modificar los datos del cliente ");
				}
			}//fin modificar
		else if (accion.getSource().equals(vista.getBtnEliminar())){
			
			int eliminar = JOptionPane.showConfirmDialog(vista, " Desea eliminar el  Cliente",
					"Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
			
			if(eliminar == 0){
				JOptionPane.showMessageDialog(vista, "Repuesto eliminado");
				nuevoRegistro.setDocumentoIdentidad(vista.getTextCedula().getText());
				nuevoRegistro.delete();
				nuevoRegistro=new Cliente();
				vaciarFormulario();
			}
			
		}//fin eliminar
		else if ( accion.getSource().equals(vista.getBtnVaciar()) )
			
			vaciarFormulario();
		
		else if(accion.getSource().equals(vista.getRdbtnSi())|| accion.getSource().equals(vista.getRdbtnNo())){
			if(vista.getRdbtnSi().isSelected()){
				vista.getTextCorreo().setEditable(true);
				vista.getTextCorreo().requestFocus();
			}else if(vista.getRdbtnNo().isSelected()){
				vista.getTextDireccion().setEditable(true);
				vista.getTextDireccion().requestFocus();
			}
			
		}
		else if(accion.getSource().equals(vista.getRdbtnTeleSi())|| accion.getSource().equals(vista.getRdbtnTeleNo())){
			if(vista.getRdbtnTeleSi().isSelected()){
				vista.getTextTelefono2().setEditable(true);
				vista.getTextTelefono2().requestFocus();
			}else if(vista.getRdbtnTeleNo().isSelected()){
				vista.getRdbtnSi().setEnabled(true);
				vista.getRdbtnNo().setEnabled(true);
				vista.getRdbtnSi().requestFocus();
			}
			
		}
		
		
		
	}//fin action
	
	//-------->keylisterner<-----------------
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCedula().getText().trim().isEmpty())){
			validarNumeros = patronNumero.matcher(vista.getTextCedula().getText().trim());	
			if(validarNumeros.find()){
				if(!nuevoRegistro.buscar(vista.getTextCedula().getText().trim())){
					vista.getTextCliente().setEditable(true);
					vista.getTextCliente().requestFocus();
				}else{
					vista.getLblMensaje().setText("Cédula o Rif se encuentra registrado");
					llenarFormulario(nuevoRegistro);
					desbloquear();
					vista.getBtnModificar().setEnabled(true);
					vista.getBtnEliminar().setEnabled(true);
				}
			}else {
				vista.getLblMensaje().setText("Valor invalido");
	
			}
		}//cedula
		else if(accion.getSource().equals(vista.getTextCliente())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCliente().getText().trim().isEmpty())){
			
			validarLetras = patronLetras.matcher(vista.getTextCliente().getText().trim());	
			if(validarLetras.find()){
				vista.getTextTelefono1().setEditable(true);
				vista.getTextTelefono1().requestFocus();
			}else vista.getLblMensaje().setText("Valor invalido");
		}
				
		else if(accion.getSource().equals(vista.getTextTelefono1())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextTelefono1().getText().trim().isEmpty())){
				
			
			String cadena=vista.getTextTelefono1().getText().trim();
			String valor=cadena.substring(1,4)+cadena.substring(7,9)+cadena.substring(11,12)+cadena.substring(14,15);
			validarTelefono = patronTelefono.matcher(valor);	
		
			if(validarTelefono.find()){
				vista.getRdbtnTeleNo().setEnabled(true);
				vista.getRdbtnTeleSi().setEnabled(true);
				vista.getRdbtnTeleSi().requestFocus();
			}else vista.getLblMensaje().setText("Valor invalido");
			
			
			
		}
		else if(accion.getSource().equals(vista.getTextTelefono2())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextTelefono2().getText().trim().isEmpty())){
			
			String cadena=vista.getTextTelefono2().getText().trim();
			String valor=cadena.substring(1,4)+cadena.substring(7,9)+cadena.substring(11,12)+cadena.substring(14,15);
			validarTelefono = patronTelefono.matcher(valor);	
		
			if(validarTelefono.find()){
				vista.getRdbtnTeleNo().setEnabled(true);
				vista.getRdbtnTeleSi().setEnabled(true);
				vista.getRdbtnTeleSi().requestFocus();
				
			}else vista.getLblMensaje().setText("Valor invalido");
			
				
			/*
				vista.getRdbtnSi().setEnabled(true);
				vista.getRdbtnNo().setEnabled(true);
				vista.getRdbtnSi().requestFocus();*/
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

	//------------>llenar campos formulario<-----------
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
	public void vaciarFormulario(){
		vista.getTextCedula().setText(null);
		vista.getTextCliente().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextTelefono2().setText(null);
		
		vista.getTextDireccion().setText(null);
		vista.getTextCorreo().setText(null);
		bloquear();
		vista.getBtnRegistrar().setEnabled(false);
		vista.getBtnModificar().setEnabled(false);
		vista.getBtnEliminar().setEnabled(false);
		vista.getRdbtnNo().setEnabled(false);
		vista.getRdbtnSi().setEnabled(false);
		vista.getRdbtnNo().setSelected(false);
		vista.getRdbtnSi().setSelected(false);

		vista.getRdbtnTeleNo().setEnabled(false);
		vista.getRdbtnTeleSi().setEnabled(false);
		vista.getRdbtnTeleNo().setSelected(false);
		vista.getRdbtnTeleSi().setSelected(false);
		
		
	}
}//fin clase
