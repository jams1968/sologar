/****************************************************************************
 * programa: ControladorVistaUsuario.java
 * objetivo: controlador de la interface VistaUsuario
 ****************************************************************************/
package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controladoresBD.SqlBD;
import modelos.Usuario;
import vistas.VistaUsuario;

public class ControladorVistaUsuario implements ActionListener,KeyListener {
	private Pattern patronLetras,patronNumero,patronTelefono,patronCorreo,patronLogin;
	private Matcher validarNumeros,validarLetras,validarTelefono,validarCorreo,validarLogin;
	private VistaUsuario vista;
	private Usuario nuevoUsuario;
	public ControladorVistaUsuario(VistaUsuario vista){
		this.vista=vista;
		patronLetras = Pattern.compile("[A-Za-z ]");
		patronNumero = Pattern.compile("[0-9]");
		patronTelefono = Pattern.compile("[0-9()-]");
		patronCorreo=Pattern.compile("^[A-Za-z0-9]+@[a-z]+\\.[a-z]+");
		patronLogin=Pattern.compile("[A-Za-z0-9]{5,10}");
		nuevoUsuario=new Usuario(); 
	}
	//-------------->actionlisterner <--------------
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}
	}//fin actionlisterne
	//------------->keyListerner<-----------------------
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCedula().getText().trim().isEmpty())){
			validarNumeros = patronNumero.matcher(vista.getTextCedula().getText().trim());	
			if(validarNumeros.find()){
				
				vista.getTextNombres().setEditable(true);
				vista.getTextNombres().requestFocus();
				
			}else 
				vista.getLblMensaje().setText("Valor invalido");
		}//fin nombres
		else if(accion.getSource().equals(vista.getTextNombres())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextNombres().getText().trim().isEmpty())){
			validarLetras = patronLetras.matcher(vista.getTextNombres().getText().trim());	
			if(validarLetras.find()){
				vista.getTextApellidos().setEditable(true);
				vista.getTextApellidos().requestFocus();
				
			}else vista.getLblMensaje().setText("Valor invalido");
		}//fin apellidos
		else if(accion.getSource().equals(vista.getTextApellidos())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextApellidos().getText().trim().isEmpty())){
			validarLetras = patronLetras.matcher(vista.getTextApellidos().getText().trim());	
			if(validarLetras.find()){
				vista.getTextTelefono1().setEditable(true);
				vista.getTextTelefono1().requestFocus();
				
			}else vista.getLblMensaje().setText("Valor invalido");
		}//fin apellidos
		else if(accion.getSource().equals(vista.getTextTelefono1())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextTelefono1().getText().trim().isEmpty())){
		
			String cadena=vista.getTextTelefono1().getText().trim();
			String valor=cadena.substring(1,4)+cadena.substring(7,9)+cadena.substring(11,12)+cadena.substring(14,15);
			validarTelefono = patronTelefono.matcher(valor);	
		
			if(validarTelefono.find()){
				vista.getTextCorreo().setEditable(true);
				vista.getTextCorreo().requestFocus();
			}else vista.getLblMensaje().setText("Valor invalido");
		}//fin telefono
		else if(accion.getSource().equals(vista.getTextCorreo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCorreo().getText().trim().isEmpty())){
			
			validarCorreo=patronCorreo.matcher(vista.getTextCorreo().getText().trim().toLowerCase());
			if(validarCorreo.find()){
				vista.getTextDireccion().setEditable(true);
				vista.getTextDireccion().requestFocus();
			}else vista.getLblMensaje().setText("Valor invalido");
		}//fin correo
		else if(accion.getSource().equals(vista.getTextDireccion())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextDireccion().getText().trim().isEmpty())){
			vista.getTextLogin().setEditable(true);
			vista.getTextLogin().requestFocus();
		}//fin direccion
		else if(accion.getSource().equals(vista.getTextLogin())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextLogin().getText().trim().isEmpty())){
			vista.getTextClave().setEditable(true);
			vista.getTextClave().requestFocus();
		}//fin login
		else if(accion.getSource().equals(vista.getTextClave())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)){
			if(vista.getTextClave().getPassword().length>0){
				vista.getLblMensaje().setText("Repita la clave para confirmar ");
				vista.getTextClave2().setEditable(true);
				vista.getTextClave2().requestFocus();
			}else vista.getLblMensaje().setText("campo vacio");
		}//fin clave 1
		else if(accion.getSource().equals(vista.getTextClave2())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)){
			String c1=new String(vista.getTextClave().getPassword());
			String c2=new String(vista.getTextClave2().getPassword());
		
			if(c1.compareTo(c2)==0){
				 vista.getLblMensaje().setText("clave confirmada");
				 vista.getBtnRegistrar().setEnabled(true);
				 
			}else vista.getLblMensaje().setText("no coincide la contraseña");
		}
		
	}//fin keypressed
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	//--->funcion vaciar<--------------
	public void vaciarFormulario(){
		vista.getTextCedula().setText(null);
		vista.getTextNombres().setText(null);
		vista.getTextApellidos().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextCorreo().setText(null);
		vista.getTextDireccion().setText(null);
		vista.getTextLogin().setText(null);
		vista.getTextClave().setText(null);
		vista.getTextClave2().setText(null);
	}//vaciar
//------------------->buscar por cedula<---------------
	public Usuario buscarUsuarioCedula(int xCedula){
		Usuario registro=new Usuario();
		
		String sentenciaSql = "SELECT * FROM usuarios where cedula="+xCedula ;
		
		SqlBD codigoSql = new SqlBD();
		
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		try {
			
			while (consulta.next()) {
				registro.setCedula(consulta.getString("cedula"));
				registro.setNombre(consulta.getString("nombre"));
				registro.setApellido(consulta.getString("apellido"));
				registro.setTelefono(consulta.getString("telefono"));
				registro.setEmail(consulta.getString("email"));
				registro.setDireccion(consulta.getString("direccion"));
				registro.setLogin(consulta.getString("login"));
				registro.setClave(consulta.getString("clave"));
				registro.setNivel_usuario(consulta.getInt("nivele_usuario_id"));
			}
		}catch (SQLException e) {

				e.printStackTrace();
		}

	
		
		codigoSql.Desconectar();
		return registro;
		
	}	
//------->buscar por login<-------------------	
	public Usuario buscarUsuario(String xLogin){
		Usuario registro=new Usuario();
		
		String sentenciaSql = "SELECT * FROM usuarios where login='"+xLogin+ "'";
		
		SqlBD codigoSql = new SqlBD();
		
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		try {
			
			while (consulta.next()) {
				registro.setCedula(consulta.getString("cedula"));
				registro.setNombre(consulta.getString("nombre"));
				registro.setApellido(consulta.getString("apellido"));
				registro.setTelefono(consulta.getString("telefono"));
				registro.setEmail(consulta.getString("email"));
				registro.setDireccion(consulta.getString("direccion"));
				registro.setLogin(consulta.getString("login"));
				registro.setClave(consulta.getString("clave"));
				registro.setNivel_usuario(consulta.getInt("nivele_usuario_id"));
			}
		}catch (SQLException e) {

				e.printStackTrace();
		}

		
		
		codigoSql.Desconectar();
		return registro;
		
	}//fin buscar login
	
//--------> guardar en modelo<----------
	public void llenarModelo(){
		nuevoUsuario=new Usuario();
		this.nuevoUsuario.setCedula(vista.getTextCedula().getText());
		this.nuevoUsuario.setNombre(vista.getTextNombres().getText());
		this.nuevoUsuario.setApellido(vista.getTextApellidos().getText());
		this.nuevoUsuario.setTelefono(vista.getTextTelefono1().getText());
		this.nuevoUsuario.setDireccion(vista.getTextDireccion().getText());
		this.nuevoUsuario.setEmail(vista.getTextDireccion().getText());
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//fin de la clase
