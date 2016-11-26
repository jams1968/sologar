package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controladoresBD.SqlBD;
import librerias.Funciones;
import modelos.Usuario;
import vistas.VistaCambioClave;

public class ControladorVistaCambioClave implements ActionListener,KeyListener {

	 private VistaCambioClave vista;
	 private Funciones funcion;
	
	public ControladorVistaCambioClave(VistaCambioClave vista) {
		this.vista=vista;
		funcion=new Funciones();
		
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}// fin cerrar
		
	}//fin action
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextClaveActual())
				&&(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextClaveActual().getPassword().toString().trim().isEmpty())){
			
			if(vista.getTextClaveActual().getText().compareTo(vista.getRegistroUsuario().getClave())==0){
				vista.getTxtNuevaClave().setEditable(true);
				vista.getTxtNuevaClave().requestFocus();
			}else
				vista.getLblMensaje().setText("Clave Incorrecta");
						
		}
		else if(accion.getSource().equals(vista.getTxtNuevaClave())
				&&(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTxtNuevaClave().getPassword().toString().trim().isEmpty())){
			
				vista.getTxtConfirmar().setEditable(true);
				vista.getTxtConfirmar().requestFocus();
			}
		else if(accion.getSource().equals(vista.getTxtConfirmar())
				&&(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTxtConfirmar().getPassword().toString().trim().isEmpty())){
			if(vista.getTxtNuevaClave().getText().compareTo(vista.getTxtConfirmar().getText())==0){
				cambiarClave();
				
			
			}else
				vista.getLblMensaje().setText("no son iguales");
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
//-------------->registrarUsuario<------------------
	public void cambiarClave(){
			
		Usuario nuevoUsuario=vista.getRegistroUsuario();
		
		nuevoUsuario.setClave(funcion.Encriptar(vista.getTxtNuevaClave().getText()));
		
		String sentenciaSql="UPDATE usuarios SET clave='"+ nuevoUsuario.getClave()+"' where cedula='"+nuevoUsuario.getCedula()+"'";
						
	 		
				SqlBD codigoSql = new SqlBD();
				if(codigoSql.agregarRegistro(sentenciaSql)){
					vista.getLblMensaje().setText("la clave ha sido cambiada Exitosamente");
					vista.getTextClaveActual().setText(null);
					vista.getTxtNuevaClave().setText(null);
					vista.getTxtConfirmar().setText(null);
				}
				else
					vista.getLblMensaje().setText("No se pudo cambiar la clave");
		}
		

}//fin de la clase
