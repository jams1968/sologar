package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import controladoresBD.SqlBD;
import modelos.Usuario;
import vistas.VentanaInicial;
import vistas.VistaLogin;

public class ControladorVistaLogin implements ActionListener,FocusListener,KeyListener {

	VistaLogin vista;
	Usuario registroUsuario;
	public ControladorVistaLogin(VistaLogin vista) {

		this.vista=vista;
		registroUsuario=new Usuario();
	}
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnOk())){
			new VentanaInicial(registroUsuario);
			vista.dispose();
		}//fin boton ok
		else if(accion.getSource().equals(vista.getBtnCancel())){
			System.exit(0);
		}
	}//------------------------------>fin action
	@Override
	public void focusGained(FocusEvent accion) {
		 if(accion.getSource().equals(vista.getTextUsuario())){
			 vista.getLblMensaje().setText("Ingrese usuario, presione enter");
			 vista.getTextClave().setEditable(false);
			 vista.getTextClave().setText(null);
			 vista.getBtnOk().setEnabled(false);
		 }
		 else  if(accion.getSource().equals(vista.getTextClave())&&(!vista.getTextUsuario().getText().trim().isEmpty())
				 &&(vista.getTextClave().isEditable())){
			 vista.getLblMensaje().setText("Ingrese clave, presione enter");
			// vista.getBtnOk().setEnabled(true);
		 }

	}
	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}
	//-------------------->fin focuslisterner
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextUsuario())
				&&(accion.getKeyCode()== KeyEvent.VK_ENTER)&&(!vista.getTextUsuario().getText().isEmpty())){
			vista.getTextClave().setEditable(true);
			vista.getTextClave().requestFocus();
		}
		else if(accion.getSource().equals(vista.getTextClave())
				&&(accion.getKeyCode()== KeyEvent.VK_ENTER)){
			registroUsuario=buscarUsuario(vista.getTextUsuario().getText(),vista.getTextClave().getPassword());
			if(registroUsuario.getCedula()==null){
				vista.getLblMensaje().setText("Usuario o Clave incorrecta");
			}else{
				vista.getLblSamasforoR().setIcon(new ImageIcon(VistaLogin.class.getResource("/imagenes/iconos/empty.png")));
			
				vista.getLblMensaje().setText("Bienvenido(a) "+
						registroUsuario.getNombre()+" "+registroUsuario.getApellido());
					vista.getBtnOk().setEnabled(true);	
					
			}
			 
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		

public Usuario buscarUsuario(String xLogin,char[] xClave){
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
			registro.setClave(consulta.getString("clave").toCharArray());
			registro.setNivel_usuario(consulta.getInt("nivele_usuario_id"));
		}
	}catch (SQLException e) {

			e.printStackTrace();
	}

	if(registro.getClave()==xClave)
		registro=new Usuario();
	
	codigoSql.Desconectar();
	return registro;
	
}

}//fin clase
