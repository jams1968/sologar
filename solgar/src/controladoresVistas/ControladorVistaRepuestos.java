package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import controladoresBD.SqlBD;
import vistas.VistaRepuestos;
import vistasReportes.VistaReporteRepuestosPP;
import modelos.Repuesto;
import modelos.TipoAparato;
import modelos.Usuario;

public class ControladorVistaRepuestos implements ActionListener , KeyListener{
	
	private VistaRepuestos vista;
	private int cantidadNueva;
	private Repuesto nuevoRepuestos;
	private Pattern patronLetras,patronNumero,patronTelefono,patronCorreo,patronLogin,patronLetraNumeros;
	private Matcher validarNumeros,validarLetras,validarTelefono,validarCorreo,validarLogin,validarLetrasNumeros;
	
	public ControladorVistaRepuestos(VistaRepuestos vista) {
		this.vista = vista;
		patronLetras = Pattern.compile("[A-Za-z ]");
		patronLetraNumeros = Pattern.compile("[A-Za-z0-9 ]");
		patronNumero = Pattern.compile("[0-9]");
		patronTelefono = Pattern.compile("[0-9()-]");
		patronCorreo=Pattern.compile("^[A-Za-z0-9]+@[a-z]+\\.[a-z]+");
		patronLogin=Pattern.compile("[A-Za-z0-9]{5,10}");
		nuevoRepuestos=new Repuesto();
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getCancelButton())){
			vista.dispose();
		}// fin cerrar
		if(accion.getSource().equals(vista.getBtnReportePantalla())){
			new VistaReporteRepuestosPP();
		}// fin cerrar
		else if (accion.getSource().equals(vista.getBtnRegistrar())) {
			llenarModelo();
			  
			if(!nuevoRepuestos.buscar(vista.getTextCodigo().getText())&&(nuevoRepuestos.create()))
					vista.getLblMensaje().setText("Repuesto registrado exitosamente ");
				else
					vista.getLblMensaje().setText("No se pudo registrar el repuesto ");
			
			}
		else if (accion.getSource().equals(vista.getBtnModificar())) {
			
			  
			if(nuevoRepuestos.buscar(vista.getTextCodigo().getText())){
				llenarModelo();
				if(nuevoRepuestos.update())
						vista.getLblMensaje().setText("Repuesto modificado exitosamente ");
					else
						vista.getLblMensaje().setText("No se pudo modificar el repuesto ");
				}
			}//fin modificar
		
		else if(accion.getSource().equals(vista.getComboTipoAparatos())&&(vista.getComboTipoAparatos().getSelectedIndex()>0)){
			vista.getTextRepuesto().setEditable(true);
			vista.getTextRepuesto().requestFocus();
		}//fin combo
			
		else if ( accion.getSource().equals(vista.getBtnAgregarCantidad()) ){
			
			String valor; 
			
			int cantidacActual = Integer.parseInt(vista.getTextCantidad().getText());
			
			do {
				valor = JOptionPane.showInputDialog(vista, "Ingrese la cantidad para agregarla");
				
				if( null == valor ){
					break;
				}
				try {
					
					cantidadNueva = Integer.parseInt(valor);
					
					if(cantidadNueva<1){
						continue;
					}else{						
						break;
					}
					
				} catch (NumberFormatException e) {
					
				}
			} while (true);
			
			int cantidad = cantidacActual + cantidadNueva;
			
			vista.getTextCantidad().setText( ""+cantidad );
			
		}//fin agregar cantidad
		else if ( accion.getSource().equals(vista.getBtnVaciar()) ){
			
			vaciarFrm();
			
		}else if (accion.getSource().equals(vista.getBtnEliminar())){
			
			int eliminar = JOptionPane.showConfirmDialog(vista, " Desea eliminar el  repuesto",
					"Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
			
			if(eliminar == 0){
				JOptionPane.showMessageDialog(vista, "Repuesto eliminado");
				vaciarFrm();
			}
			
		}//fin eliminar
		
		
	}

	@Override
	public void keyPressed(KeyEvent accion) {
		
		
		
		if(accion.getSource().equals(vista.getTextCodigo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCodigo().getText().trim().isEmpty())){
			
			
			if(!nuevoRepuestos.buscar(vista.getTextCodigo().getText())){
				vista.getComboTipoAparatos().setEnabled(true);
				vista.getComboTipoAparatos().llenar();
				
				vista.getLblMensaje().setText("");
				
			}
			else{
				vista.getLblMensaje().setText("Codigo se encuentra registrado");
				
				llenarFormulario(nuevoRepuestos);
				vista.getTextCantidad().setEditable(false);
				habilitarBoton(vista.getBtnAgregarCantidad());
				habilitarBoton(vista.getBtnModificar());
				habilitarBoton(vista.getBtnEliminar());
				deshabilitarBoton(vista.getBtnRegistrar());
			}

				
		}else if(accion.getSource().equals(vista.getTextRepuesto())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextRepuesto().getText().trim().isEmpty())){
			
				vista.getTextMarca().setEditable(true);
				vista.getTextMarca().requestFocus();
				
		}else if(accion.getSource().equals(vista.getTextMarca())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextMarca().getText().trim().isEmpty())){
			
				vista.getTextCantidad().setEditable(true);
				vista.getTextCantidad().requestFocus();
				
		}else if(accion.getSource().equals(vista.getTextCantidad())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCantidad().getText().trim().isEmpty())){
			
			validarNumeros = patronNumero.matcher(vista.getTextCantidad().getText().trim());
			
			if(validarNumeros.find()){
				vista.getTextPrecioVenta().setEditable(true);
				vista.getTextPrecioVenta().requestFocus();
				vista.getLblMensaje().setText("");
			}else 
				vista.getLblMensaje().setText("Valor invalido");
				
		}else if(accion.getSource().equals(vista.getTextPrecioVenta())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextPrecioVenta().getText().trim().isEmpty())){
			
			validarNumeros = patronNumero.matcher(vista.getTextPrecioVenta().getText().trim());
			
			if(validarNumeros.find()){
				vista.getTextDescripcion().setEditable(true);
				vista.getTextDescripcion().setEnabled(true);
				vista.getTextDescripcion().requestFocus();	
				vista.getLblMensaje().setText("");
			}else 
				vista.getLblMensaje().setText("Valor invalido");
				
		}else if(accion.getSource().equals(vista.getTextDescripcion())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				(vista.getTextDescripcion().getText().trim().isEmpty())){
			
				vista.getLblMensaje().setText("La descripción es requerida");
		}else if ( accion.getSource().equals(vista.getTextDescripcion())
				
				&& !(vista.getTextCodigo().getText().trim().isEmpty())
				&& !(vista.getTextCodigo().getText().trim().isEmpty())
				&& !(vista.getTextRepuesto().getText().trim().isEmpty())
				&& !(vista.getTextMarca().getText().trim().isEmpty())
				&& !(vista.getTextCantidad().getText().trim().isEmpty())
				&& !(vista.getTextPrecioVenta().getText().trim().isEmpty())
				&& !(vista.getTextDescripcion().getText().trim().isEmpty())
				
				&& vista.getComboTipoAparatos().getSelectedIndex() != 0
				){
			
			habilitarBoton(vista.getBtnRegistrar());
			
			vista.getLblMensaje().setText("");
			
		}else {
			vista.getLblMensaje().setText("Campo requerido");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
		//------------>llevar campos formulario<-----------
		public void llenarFormulario(Repuesto registro){
		
			vista.getTextRepuesto().setText(registro.getRepuesto());
			vista.getTextMarca().setText(registro.getMarca());
			vista.getTextCantidad().setText(""+registro.getCantidad());
			vista.getTextPrecioVenta().setText(""+registro.getPrecio_venta());
			vista.getTextDescripcion().setText(registro.getDescripcion());
			vista.getComboTipoAparatos().setEnabled(true);
			vista.getComboTipoAparatos().llenar();
			vista.getComboTipoAparatos().setSelectedIndex(registro.getTipo_aparato_id());
			
			
			deshabilitarCampos();
			vista.getTextCodigo().setEditable(false);
			
			
		}
		
		//--------> guardar en modelo<----------
		public void llenarModelo(){
			nuevoRepuestos=new Repuesto();
			this.nuevoRepuestos.setTipo_aparato_id(vista.getComboTipoAparatos().getSelectedIndex());
			
			this.nuevoRepuestos.setCodigo(vista.getTextCodigo().getText());
			this.nuevoRepuestos.setRepuesto(vista.getTextRepuesto().getText());
			this.nuevoRepuestos.setMarca(vista.getTextMarca().getText());
			this.nuevoRepuestos.setCantidad( Integer.parseInt(vista.getTextCantidad().getText()) );
			this.nuevoRepuestos.setPrecio_venta( Double.parseDouble(vista.getTextPrecioVenta().getText()) );
			this.nuevoRepuestos.setDescripcion( vista.getTextDescripcion().getText() );
		}
		
	
	//------>deshabilitar campos<--------------	
		public void deshabilitarCampos(){
			vista.getTextCodigo().setEditable(true);
			vista.getTextRepuesto().setEditable(true);
			vista.getTextMarca().setEditable(true);
			vista.getTextCantidad().setEditable(true);
			vista.getTextCantidad().setEditable(true);
			vista.getTextPrecioVenta().setEditable(true);
			vista.getTextDescripcion().setEditable(true);
			vista.getComboTipoAparatos().setEnabled(true);
		}
	//-->habilitar campos<----------	
		public void habilitarCampos(){
			vista.getTextCodigo().setEditable(false);
			vista.getTextRepuesto().setEditable(false);
			vista.getTextMarca().setEditable(false);
			vista.getTextCantidad().setEditable(false);
			vista.getTextCantidad().setEditable(false);
			vista.getTextPrecioVenta().setEditable(false);
			vista.getTextDescripcion().setEditable(false);
			vista.getComboTipoAparatos().setEnabled(false);
		}
		
		private void vaciarFrm() {
			vista.getTextCodigo().setText(""); 
			vista.getTextRepuesto().setText("");
			vista.getTextMarca().setText("");
			vista.getTextCantidad().setText("");
			vista.getTextPrecioVenta().setText("");
			vista.getTextDescripcion().setText("");
			TipoAparato regi=new TipoAparato();
			vista.getComboTipoAparatos().setSelectedItem(regi);
			habilitarCampos();
			vista.getTextCodigo().setEditable(true);
			vista.getTextCodigo().setEnabled(true);
			
			deshabilitarBoton(vista.getBtnAgregarCantidad());
			deshabilitarBoton(vista.getBtnModificar());
			deshabilitarBoton(vista.getBtnAgregarCantidad());
			deshabilitarBoton(vista.getBtnEliminar());
			
			vista.getLblMensaje().setText("");
			
		}
		
		public void habilitarBoton( JButton btn ){
			btn.setEnabled(true);
		}
		
		public void deshabilitarBoton( JButton btn ){
			btn.setEnabled(false);
		}
	

}
