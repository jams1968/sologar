/****************************************************************************
 * programa: ControladorVistaPersona.java
 * objetivo: controlador de la interface vistapersona
 ****************************************************************************/
package controladoresVistas;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import controladoresBD.SqlBD;
import librerias.Funciones;
import modelos.Persona;

import vistas.VistaPersona;

public class ControladorVistaPersona 
				implements KeyListener,FocusListener,ActionListener,MouseListener{
	private VistaPersona vista;
	private Pattern patronLetras,patronNumero,patronTelefono,patronCorreo,patronLogin;
	private Matcher validarNumeros,validarLetras,validarTelefono,validarCorreo,validarLogin;
	private Persona registroCliente;
	private SqlBD codigoSql;
	public ControladorVistaPersona(VistaPersona vista) {
		this.vista=vista;
		patronLetras = Pattern.compile("[^A-Za-z ]");
		patronNumero = Pattern.compile("[^0-9]");
		patronTelefono = Pattern.compile("[^0-9()-]");
		patronCorreo=Pattern.compile("[A-Za-z0-9]+@[a-z]+\\.[a-z]+");
		patronLogin=Pattern.compile("^[a-z]");
	}
	//-------->keyListerner<------------
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}else if(accion.getSource().equals(vista.getBtnRegistrar())){
			if((vista.getTextCedula().getText().trim().length()>0)&&
				(vista.getTextNombres().getText().trim().length()>0)&&
				(vista.getTextApellidos().getText().trim().length()>0)&&
				(vista.getTextTelefono1().getText().trim().length()>0)&&
				(vista.getTextDireccion().getText().trim().length()>0)){
					registrarCliente();
			}
			else
				vista.getLblMensaje().setText("Debe llenar todos los campos requeridos");
		}
		
		
	}//fin action
	

	//------------->keyListerner<-------------------
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCedula().getText().trim().isEmpty())){
			validarNumeros = patronNumero.matcher(vista.getTextCedula().getText().trim());	
			if(!validarNumeros.find()){//busca si no hay error
				Persona registro=new Persona();
				registro=buscarCliente(Integer.parseInt
						(vista.getTextCedula().getText()));
				if(registro.getCedula()==0){
					vista.getTextNombres().setEditable(true);
					vista.getTextNombres().requestFocus();
				}else{
					llenarFormulario(registro);
					vista.getLblMensaje().setText("Cedula ya esta Registrada");
				}
			}
			else{
				vista.getLblMensaje().setText("¡Valor invalido!");
				Toolkit.getDefaultToolkit().beep();
			}
		}//fin cedula
		else if(accion.getSource().equals(vista.getTextNombres())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextNombres().getText().trim().isEmpty())){
			validarLetras = patronLetras.matcher(vista.getTextNombres().getText().trim());	
			if(!validarLetras.find()){
				vista.getTextApellidos().setEditable(true);
				vista.getTextApellidos().requestFocus();
				
			}else{
				vista.getLblMensaje().setText("¡Valor invalido!");
				Toolkit.getDefaultToolkit().beep();
			}
		}//fin apellidos
		else if(accion.getSource().equals(vista.getTextApellidos())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextApellidos().getText().trim().isEmpty())){
			validarLetras = patronLetras.matcher(vista.getTextApellidos().getText().trim());	
			if(!validarLetras.find()){
				vista.getTextTelefono1().setEditable(true);
				vista.getTextTelefono1().requestFocus();
				
			}else{
				vista.getLblMensaje().setText("¡Valor invalido!");
				Toolkit.getDefaultToolkit().beep();
			}
		}//fin apellidos
		else if(accion.getSource().equals(vista.getTextTelefono1())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextTelefono1().getText().trim().isEmpty())){
		
			String cadena=vista.getTextTelefono1().getText().trim();
			String valor=cadena.substring(1,4)+cadena.substring(7,9)+cadena.substring(11,12)+cadena.substring(14,15);
			validarTelefono = patronTelefono.matcher(valor);	
		
			if(!validarTelefono.find()){
				vista.getTextTelefono2().setEditable(true);
				vista.getTextTelefono2().requestFocus();
			}else vista.getLblMensaje().setText("¡Valor invalido!");
		}//fin de telefono1
		else if(accion.getSource().equals(vista.getTextTelefono2())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)){
		
			String cadena=vista.getTextTelefono2().getText().trim();
			String valor=cadena.substring(1,4)+cadena.substring(7,9)+cadena.substring(11,12)+cadena.substring(14,15);
			
			validarTelefono = patronTelefono.matcher(valor);	
			String v[]=valor.split("_");
			String s=null;
			for(int i=0;i<v.length;i++)
				s+=v[i];
			
			if(s==null){
				
				vista.getRdbtnSi().setEnabled(true);
				vista.getRdbtnNo().setEnabled(true);
				vista.getRdbtnSi().requestFocus();
				
			}else{
			
				if(!validarTelefono.find()){
					vista.getRdbtnSi().setEnabled(true);
					vista.getRdbtnNo().setEnabled(true);
					vista.getRdbtnSi().requestFocus();
				}else vista.getLblMensaje().setText("¡Valor invalido!");
			}
		}//fin de telefono2
		else if(accion.getSource().equals(vista.getTextCorreo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCorreo().getText().trim().isEmpty())){
			
			validarCorreo=patronCorreo.matcher(vista.getTextCorreo().getText().trim().toLowerCase());
			if(validarCorreo.find()){
				vista.getTextDireccion().setEditable(true);
				vista.getTextDireccion().requestFocus();
			}else vista.getLblMensaje().setText("¡Valor invalido!");
		}//fin correo
		
		
	}//fin key

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent accion) {
		
		if(accion.getSource().equals(vista.getTextCedula())){
			
			if(!vista.getTextCedula().getText().isEmpty()){
				int d = vista.getTextCedula().getText().length();
				vista.getLblContarCedula().setVisible(true);
				vista.getLblContarCedula().setText(""+d);
				if(d>7){
					accion.consume();
					Toolkit.getDefaultToolkit().beep();
					vista.getLblMensaje().setText("máximo 8 dígitos");
				}
			}
		
		}//fin cedula
		else if(accion.getSource().equals(vista.getTextNombres())){
			int d;
			if(vista.getTextNombres().getText().isEmpty()){
				vista.getLblContarNombres().setVisible(false);
				d=0;
			}
			else{
				d=vista.getTextNombres().getText().length()+1;
				vista.getLblContarNombres().setVisible(true);
			}
				
			vista.getLblContarNombres().setText(""+d);
			if(d>20){
				accion.consume();
				Toolkit.getDefaultToolkit().beep();
				vista.getLblMensaje().setText("máximo 20 caracteres");
			}
		
		}//fin nombres
		else if(accion.getSource().equals(vista.getTextApellidos())){
			int d;
			
			if(vista.getTextApellidos().getText().isEmpty()){
				vista.getLblContrarApellidos().setVisible(false);
				d=0;
			}
			else{
				d=vista.getTextApellidos().getText().length()+1;
				vista.getLblContrarApellidos().setVisible(true);
			}
				
			vista.getLblContrarApellidos().setText(""+d);
			if(d>20){
				accion.consume();
				Toolkit.getDefaultToolkit().beep();
				vista.getLblMensaje().setText("máximo 20 caracteres");
			}
		
		}//fin apellidos
		
		

		
	}//fin typed
	//-------------------------->focusListerner<----------------
	@Override
	public void focusGained(FocusEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula()))
			 vista.getLblMensaje().setText
			 ("luego de ingresar Cédula, presione enter para activar el campo Nombres");
		 else if(accion.getSource().equals(vista.getTextNombres()))
			 vista.getLblMensaje().setText
			 ("luego de ingresar nombre, presione enter para activar el campo Apellidos");
		 else if(accion.getSource().equals(vista.getTextApellidos()))
			 vista.getLblMensaje().setText("luego de ingresar apellido, presione enter para activar el campo Teléfono Celular");
		 else if(accion.getSource().equals(vista.getTextTelefono1()))
			 vista.getLblMensaje().setText("luego de ingresar el teléfono, presione enter para activar el campo Otro Telefono");
		 else if(accion.getSource().equals(vista.getTextTelefono2()))
			 vista.getLblMensaje().setText("luego de ingresar el Otro teléfono, presione enter para activar el campo Correo");
		 else if(accion.getSource().equals(vista.getTextCorreo()))
			 vista.getLblMensaje().setText("luego de ingresar el correo, presione enter para activar el campo Dirección");
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//----------->mouselisterner<--------
	@Override
	public void mouseClicked(MouseEvent accion) {
		if(accion.getSource().equals(vista.getRdbtnSi())){
			
			vista.getTextCorreo().setEditable(true);
			vista.getTextCorreo().requestFocus();
		}
		else if(accion.getSource().equals(vista.getRdbtnNo())){
			vista.getTextCorreo().setEditable(false);
			vista.getTextDireccion().setEditable(true);
			vista.getTextDireccion().requestFocus();
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
//-------------->buscar cliente<------------
public Persona buscarCliente(int xCedula){
				
	String sentenciaSql = "SELECT * FROM personas a "
				+ "where (a.status='A' and a.cedula="+xCedula+")";
	Persona registroCliente=new Persona();
	codigoSql = new SqlBD();

	ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
			
	try {
		while (consulta.next()) {
			registroCliente.setId(consulta.getInt("id"));
			registroCliente.setCedula(consulta.getInt("cedula"));
			registroCliente.setNombres(consulta.getString("nombres"));
			registroCliente.setApellidos(consulta.getString("apellidos"));
			registroCliente.setTelefono1(consulta.getString("telefono1"));
			registroCliente.setTelefono2(consulta.getString("telefono2"));
			registroCliente.setDireccion(consulta.getString("direccion"));
			registroCliente.setCorreo(consulta.getString("correo"));
			registroCliente.setStatus(consulta.getString("status").charAt(0));
		}
	}catch (SQLException e) {

		e.printStackTrace();
	}
	return registroCliente;
			
}//fin buscar cliente
	//---------->registrar cliente<----------------
	public void registrarCliente(){
		registroCliente=new Persona();
		registroCliente=buscarCliente(Integer.parseInt
				(vista.getTextCedula().getText()));
		if(registroCliente.getCedula()!=0)
			vista.getLblMensaje().setText("Cedula ya esta Registrada");
		else{
			registroCliente=llenarRegistros();
			String sentenciaSql="INSERT INTO personas (cedula,apellidos,nombres,telefono1,telefono2,"
					+ "direccion,correo,status) "
					+ "VALUES ("+registroCliente.getCedula()+",'"+registroCliente.getApellidos()+"','"
							+ registroCliente.getNombres()+"','"+registroCliente.getTelefono1()+"','"
							+registroCliente.getTelefono2()+"','"+registroCliente.getDireccion()+"','"
							+registroCliente.getCorreo()+"','"+registroCliente.getStatus()+"')";
			
			SqlBD codigoSql = new SqlBD();
			
			if (codigoSql.agregarRegistro(sentenciaSql)){
				vista.getLblMensaje().setText("Cliente registrado satisfactoriamente");
				vaciarFormulario();
			}
			else
				vista.getLblMensaje().setText("No se pudo registrar el cliente");
			
				
			
			
		}
			
		
	}
	//-------------->modificar cliente<------------
	public void modificarCliente(){
		
	}
	
	
	//----------->llenar campos<------------
	public void llenarFormulario(Persona registro){
		vista.getTextApellidos().setText(registro.getApellidos());
		vista.getTextNombres().setText(registro.getNombres());
		vista.getTextTelefono1().setText(registro.getTelefono1());
		vista.getTextTelefono2().setText(registro.getTelefono2());
		vista.getTextCorreo().setText(registro.getCorreo());
		vista.getTextDireccion().setText(registro.getDireccion());
	}
	//------->llenar registro<----------
	public Persona llenarRegistros(){
		Persona registroCliente=new Persona();
		registroCliente.setCedula(Integer.parseInt
				(vista.getTextCedula().getText()));
			registroCliente.setApellidos(vista.getTextApellidos().getText());
			registroCliente.setNombres(vista.getTextNombres().getText());
			registroCliente.setTelefono1(vista.getTextTelefono1().getText());
			registroCliente.setTelefono2(vista.getTextTelefono2().getText());
			registroCliente.setCorreo(vista.getTextCorreo().getText());
			registroCliente.setDireccion(vista.getTextDireccion().getText());
			registroCliente.setStatus('A');
		return registroCliente;
	}
	//-------->vaciar formulario<---------
	public void vaciarFormulario(){
		vista.getTextCedula().setText(null);
		vista.getTextApellidos().setText(null);
		vista.getTextNombres().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextTelefono2().setText(null);
		vista.getTextCorreo().setText(null);
		vista.getTextDireccion().setText(null);
		
		vista.getLblContarCedula().setText(null);
		vista.getLblContarNombres().setText(null);
		vista.getLblContrarApellidos().setText(null);
		vista.getLblContarTelefono1().setText(null);
		
		
		vista.getTextApellidos().setEditable(false);
		vista.getTextNombres().setEditable(false);
		vista.getTextTelefono1().setEditable(false);
		vista.getTextTelefono2().setEditable(false);
		vista.getTextCorreo().setEditable(false);
		vista.getTextDireccion().setEditable(false);
		
		vista.getTextCedula().requestFocus();
	}




}//fin de la clase
