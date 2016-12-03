package vistas;
  


import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import modelos.Usuario;



public class Principal {

	public static void main(String[] args) {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		Usuario registroUsuario=new Usuario();
		registroUsuario.setNombre("Admin");
		registroUsuario.setApellido("Admin");
		registroUsuario.setNivel_usuario(1);
		
		new VentanaInicial(registroUsuario);
	}

}
