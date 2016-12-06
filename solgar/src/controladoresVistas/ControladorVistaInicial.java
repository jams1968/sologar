/****************************************************************************
 * programa: ControladorVistaInicial.java
 * objetivo: Controlador del a Pantalloa inicial
 ****************************************************************************/
package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vistas.VentanaInicial;
import vistas.VistaCambioClave;
import vistas.VistaCliente;
import vistas.VistaRecepcion;
import vistas.VistaRepuestos;
import vistas.VistaTipoAparato;
import vistas.VistaUsuario;
import vistasReportes.VistaReporteRepuestosPP;

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
		}//fin salir
		else if (accion.getSource().equals(vista.getBtnClientes())||accion.getSource().equals(vista.getMntmClientes())){
			new VistaCliente(vista.getRegistroUsuario());
			
		}
		else if (accion.getSource().equals(vista.getMntmUsuarios())){
			new VistaUsuario(vista.getRegistroUsuario());
		}
		else if (accion.getSource().equals(vista.getMntmCambioDeClave())){
			new VistaCambioClave(vista.getRegistroUsuario());
		}
		else if (accion.getSource().equals(vista.getMntmRepuestos())){
			new VistaRepuestos();
			
		}
		else if (accion.getSource().equals(vista.getMntmTiposAparatos())){
			new VistaTipoAparato();
			
		}
		else if (accion.getSource().equals(vista.getMntmRecepcion())||
				(accion.getSource().equals(vista.getBtnRecepcion()))){
			new VistaRecepcion(vista.getRegistroUsuario());
			
		}
		else if (accion.getSource().equals(vista.getMntmInventario_1())){
			new VistaReporteRepuestosPP();
			
		}
	}//fin action

}//fin clase
