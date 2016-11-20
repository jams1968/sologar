/****************************************************************************
 * programa: ControladorVistaInicial.java
 * objetivo: Controlador del a Pantalloa inicial
 ****************************************************************************/
package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vistas.VentanaInicial;

public class ControladorVistaInicial implements ActionListener{
	private VentanaInicial vista;
	
	public ControladorVistaInicial(VentanaInicial vista) {
		this.vista=vista;
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if (accion.getSource().equals(vista.getBtnSalir())||accion.getSource().equals(vista.getMntmSalirDelSistema())){
			 int dialogButton = JOptionPane.showConfirmDialog
					 (vista, "Desea Salir del Sistema ","Mensaje del Sistema",JOptionPane.YES_NO_OPTION);

             if(dialogButton == JOptionPane.YES_OPTION){
            	 System.exit(0);
            	 
             }
		}
		
	}

}
