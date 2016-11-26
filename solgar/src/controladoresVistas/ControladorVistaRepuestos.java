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
import modelos.Repuestos;
import modelos.Usuario;

public class ControladorVistaRepuestos implements ActionListener , KeyListener{
	
	private VistaRepuestos vista;
	private int cantidadNueva;
	private Repuestos nuevoRepuestos;
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
	}

	@Override
	public void actionPerformed(ActionEvent accion) {
		
		if (accion.getSource().equals(vista.getBtnRegistrar())) {
			
			if (vista.getComboTipoAparatos().getSelectedIndex()<1) {
				
				vista.getLblMensaje().setText("Seleccione el tipo de aparato");
				
			}else if (vista.getTextCodigo().getText().trim().isEmpty()) {
				
				vista.getTextCodigo().setEnabled(true);
				vista.getTextCodigo().setEditable(true);
				vista.getTextCodigo().requestFocus();
				
				vista.getLblMensaje().setText("El codigo es requerido");
				
			}else if (vista.getTextRepuesto().getText().trim().isEmpty()) {
				
				vista.getTextRepuesto().setEnabled(true);
				vista.getTextRepuesto().setEditable(true);
				vista.getTextRepuesto().requestFocus();
				
				vista.getLblMensaje().setText("El repuesto es requerido");
				
			}else if (vista.getTextMarca().getText().trim().isEmpty()) {
				
				vista.getTextMarca().setEnabled(true);
				vista.getTextMarca().setEditable(true);
				vista.getTextMarca().requestFocus();
				
				vista.getLblMensaje().setText("La marca es requerida");
				
			}else if (vista.getTextCantidad().getText().trim().isEmpty()) {
				
				vista.getTextCantidad().setEnabled(true);
				vista.getTextCantidad().setEditable(true);
				vista.getTextCantidad().requestFocus();
				
				vista.getLblMensaje().setText("La cantidad es requerida");
				
			}else if (vista.getTextPrecioVenta().getText().trim().isEmpty()) {
				
				vista.getTextPrecioVenta().setEnabled(true);
				vista.getTextPrecioVenta().setEditable(true);
				vista.getTextPrecioVenta().requestFocus();
				
				vista.getLblMensaje().setText("El precio de venta es requerido");
				
			}else if (vista.getTextDescripcion().getText().trim().isEmpty()) {
				
				vista.getTextDescripcion().setEnabled(true);
				vista.getTextDescripcion().setEditable(true);
				vista.getTextDescripcion().requestFocus();
				
				vista.getLblMensaje().setText("La descripción es requerida");
				
			}else{
				vista.getLblMensaje().setText(":)");
			}
			
		}else if ( accion.getSource().equals(vista.getBtnAgregarCantidad()) ){
			
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
			
		}else if ( accion.getSource().equals(vista.getBtnVaciar()) ){
			
			vaciarFrm();
			
		}else if (accion.getSource().equals(vista.getBtnEliminar())){
			
			int eliminar = JOptionPane.showConfirmDialog(vista, " Seguro quiere eliminar el  repuesto", null, JOptionPane.YES_NO_OPTION);
			
			if(eliminar == 0){
				JOptionPane.showMessageDialog(vista, "Repuesto eliminado");
				vaciarFrm();
			}
			
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent accion) {
		
		
		
		if(accion.getSource().equals(vista.getTextCodigo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCodigo().getText().trim().isEmpty())){
			
			nuevoRepuestos=buscarCodigo(vista.getTextCodigo().getText());
			if(nuevoRepuestos.getCodigo()==null){
			
				vista.getTextRepuesto().setEditable(true);
				vista.getTextRepuesto().setEnabled(true);
				vista.getTextRepuesto().requestFocus();
				vista.getLblMensaje().setText("");
				
			}
			else{
				vista.getLblMensaje().setText("Codigo se encuentra registrado");
				llenarFormulario(nuevoRepuestos);
				abilitarBoton(vista.getBtnAgregarCantidad());
				abilitarBoton(vista.getBtnModificar());
				abilitarBoton(vista.getBtnEliminar());
				desabilitarBoton(vista.getBtnRegistrar());
			}

				
		}else if(accion.getSource().equals(vista.getTextRepuesto())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextRepuesto().getText().trim().isEmpty())){
			
				vista.getTextMarca().setEditable(true);
				vista.getTextMarca().setEnabled(true);
				vista.getTextMarca().requestFocus();
				
		}else if(accion.getSource().equals(vista.getTextMarca())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextMarca().getText().trim().isEmpty())){
			
				vista.getTextCantidad().setEditable(true);
				vista.getTextCantidad().setEnabled(true);
				vista.getTextCantidad().requestFocus();
				
		}else if(accion.getSource().equals(vista.getTextCantidad())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCantidad().getText().trim().isEmpty())){
			
			validarNumeros = patronNumero.matcher(vista.getTextCantidad().getText().trim());
			
			if(validarNumeros.find()){
				vista.getTextPrecioVenta().setEditable(true);
				vista.getTextPrecioVenta().setEnabled(true);
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
			
			abilitarBoton(vista.getBtnRegistrar());
			
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
	
	
	//------->buscar por codigo repuesto<-------------------	
		public Repuestos buscarCodigo(String xCodigo){
			
			Repuestos registro = new Repuestos();
			
			String sentenciaSql = "SELECT * FROM repuestos where codigo='"+xCodigo+ "'";
			
			SqlBD codigoSql = new SqlBD();
			
			ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
			
			try {
				
				while (consulta.next()) {
					registro.setId(consulta.getInt("id"));
					registro.setCodigo(consulta.getString("id"));
					registro.setRepuesto(consulta.getString("repuesto"));
					registro.setMarca(consulta.getString("marca"));
					registro.setCantidad(consulta.getInt("cantidad"));
					registro.setPrecio_venta(consulta.getDouble("precio_venta"));
					registro.setDescripcion(consulta.getString("descripcion"));
					registro.setTipo_aparato_id(consulta.getInt("tipo_aparato_id"));
				}
			}catch (SQLException e) {

					e.printStackTrace();
			}

			codigoSql.Desconectar();
			
			return registro;
			
		}
		
		//------------>llevar campos formulario<-----------
		public void llenarFormulario(Repuestos registro){
			vista.getTextRepuesto().setText(registro.getRepuesto());
			vista.getTextMarca().setText(registro.getMarca());
			vista.getTextCantidad().setText(""+registro.getCantidad());
			vista.getTextPrecioVenta().setText(""+registro.getPrecio_venta());
			vista.getTextDescripcion().setText(registro.getDescripcion());
		
			vista.getComboTipoAparatos().setSelectedIndex(registro.getTipo_aparato_id());
			
			desabilitarCampos();
			vista.getTextCodigo().setEditable(false);
			vista.getTextCodigo().setEnabled(false);
			
		}
		
		//--------> guardar en modelo<----------
		public void llenarModelo(){
			nuevoRepuestos=new Repuestos();
			this.nuevoRepuestos.setTipo_aparato_id( vista.getComboTipoAparatos().getItemCount());
			this.nuevoRepuestos.setCodigo(vista.getTextCodigo().getText());
			this.nuevoRepuestos.setRepuesto(vista.getTextRepuesto().getText());
			this.nuevoRepuestos.setMarca(vista.getTextMarca().getText());
			this.nuevoRepuestos.setCantidad( Integer.parseInt(vista.getTextCantidad().getText()) );
			this.nuevoRepuestos.setPrecio_venta( Double.parseDouble(vista.getTextPrecioVenta().getText()) );
			this.nuevoRepuestos.setDescripcion( vista.getTextDescripcion().getText() );
		}
		
		public void agregarRepuesto(){
			
		}
		
		public void desabilitarCampos(){
			vista.getTextCodigo().setEditable(true);
			vista.getTextCodigo().setEnabled(true);
			vista.getTextRepuesto().setEditable(true);
			vista.getTextRepuesto().setEnabled(true);
			vista.getTextMarca().setEditable(true);
			vista.getTextMarca().setEnabled(true);
			vista.getTextCantidad().setEditable(true);
			vista.getTextCantidad().setEnabled(true);
			vista.getTextCantidad().setEditable(true);
			vista.getTextCantidad().setEnabled(true);
			vista.getTextPrecioVenta().setEditable(true);
			vista.getTextPrecioVenta().setEnabled(true);
			vista.getTextDescripcion().setEditable(true);
			vista.getTextDescripcion().setEnabled(true);
		}
		
		public void abilitarCampos(){
			vista.getTextCodigo().setEditable(false);
			vista.getTextCodigo().setEnabled(false);
			vista.getTextRepuesto().setEditable(false);
			vista.getTextRepuesto().setEnabled(false);
			vista.getTextMarca().setEditable(false);
			vista.getTextMarca().setEnabled(false);
			vista.getTextCantidad().setEditable(false);
			vista.getTextCantidad().setEnabled(false);
			vista.getTextCantidad().setEditable(false);
			vista.getTextCantidad().setEnabled(false);
			vista.getTextPrecioVenta().setEditable(false);
			vista.getTextPrecioVenta().setEnabled(false);
			vista.getTextDescripcion().setEditable(false);
			vista.getTextDescripcion().setEnabled(false);
		}
		
		private void vaciarFrm() {
			vista.getTextCodigo().setText(""); 
			vista.getTextRepuesto().setText("");
			vista.getTextMarca().setText("");
			vista.getTextCantidad().setText("");
			vista.getTextPrecioVenta().setText("");
			vista.getTextDescripcion().setText("");
			vista.getComboTipoAparatos().setSelectedIndex(0);
			abilitarCampos();
			vista.getTextCodigo().setEditable(true);
			vista.getTextCodigo().setEnabled(true);
			
			desabilitarBoton(vista.getBtnAgregarCantidad());
			desabilitarBoton(vista.getBtnModificar());
			desabilitarBoton(vista.getBtnAgregarCantidad());
			desabilitarBoton(vista.getBtnEliminar());
			
			vista.getLblMensaje().setText("");
			
		}
		
		public void abilitarBoton( JButton btn ){
			btn.setEnabled(true);
		}
		
		public void desabilitarBoton( JButton btn ){
			btn.setEnabled(false);
		}
	

}
