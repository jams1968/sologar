/****************************************************************************
 * programa: ControladorVistaUsuario.java
 * objetivo: controlador de la interface VistaUsuario
 ****************************************************************************/
package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import vistas.VistaUsuario;

public class ControladorVistaUsuario implements ActionListener {
	private Pattern patronLetras,patronNumero,patronTelefono,patronCorreo,patronLogin;
	private Matcher validarNumeros,validarLetras,validarTelefono,validarCorreo,validarLogin;
	private VistaUsuario vista;
	public ControladorVistaUsuario(VistaUsuario vista){
		this.vista=vista;
	}
	//-------------->actio listerner <--------------
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}
	}//fin actionlisterned
	
	//--->funcion vaciar<--------------
	public void vaciarFormulario(){
		vista.getTextCedula().setText(null);
		vista.getTextNombres().setText(null);
		vista.getTextApellidos().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextTelefono2().setText(null);
		vista.getTextCorreo().setText(null);
		vista.getTextDireccion().setText(null);
		vista.getTextLogin().setText(null);
		vista.getTextClave().setText(null);
		vista.getTextClave2().setText(null);
		
	}

}//fin de la clase
