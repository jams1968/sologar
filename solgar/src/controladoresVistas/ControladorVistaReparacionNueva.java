package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelos.Cliente;
import modelos.DetallesReparacion;
import modelos.Recepcion;
import modelos.Reparacion;
import modelos.Repuesto;
import modelos.RepuestosReparaciones;
import modelos.TipoAparato;
import modelos.Usuario;
import vistas.VistaReparacionNueva;

public class ControladorVistaReparacionNueva implements KeyListener,ActionListener,FocusListener  {
	
	private VistaReparacionNueva vista;
	private Recepcion regRecepcion;
	private Reparacion regReparacion;
	private TipoAparato tipoAparato;
	private Cliente regCliente;
	private Usuario regUsuario;
	private Repuesto regRepuesto;
	private RepuestosReparaciones regRepuestosReparaciones;
	private DetallesReparacion regDetalle;
	private int contar,fila;
	
	public ControladorVistaReparacionNueva(VistaReparacionNueva vista) {
		this.vista=vista;
		regRecepcion=new Recepcion();
		regReparacion=new Reparacion();
		tipoAparato=new TipoAparato();
		regCliente=new Cliente();
		regUsuario=new Usuario();
		regRepuesto=new Repuesto();
		regDetalle= new DetallesReparacion();
		contar=0;
		fila=0;
	}
	
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getComboArtefactosRecibo())&&
				(vista.getComboArtefactosRecibo().getSelectedIndex()>0)){
				regReparacion=(Reparacion) vista.getComboArtefactosRecibo().getSelectedItem();
				llenarArtefactos();
				vista.getTextDetallesRep().setEditable(true);
				vista.getTextDetallesRep().requestFocus();
		}else if(accion.getSource().equals(vista.getBtnCerrar())){
			vista.dispose();
		}else if(accion.getSource().equals(vista.getComboRepuestos())&&
				(vista.getComboRepuestos().getSelectedIndex()>0)){
			regRepuesto=(Repuesto) vista.getComboRepuestos().getSelectedItem();
			vista.getTextCodigo().setText(regRepuesto.getCodigo());
			vista.getTextRepuesto().setText(regRepuesto.getRepuesto());
			vista.getTextCantidadActual().setText(""+regRepuesto.getCantidad());
			vista.getTextPrecio().setText(""+regRepuesto.getPrecio_venta());
			vista.getTextCantidadUsar().setEditable(true);
			vista.getTextCantidadUsar().requestFocus();
			
		}else if(accion.getSource().equals(vista.getBtnAgregarRepuesto())){
			contar++;
			vista.getDatosTabla().insertRow(fila, new String[] {""+contar,vista.getTextCodigo().getText(),
																	vista.getTextRepuesto().getText(),
																	vista.getTextCantidadUsar().getText(),
																	vista.getTextPrecio().getText(),
																	vista.getTextMonto().getText()});
			fila++;
			
			vaciarRepuestos();
			recorrerMontos();
			vista.getBtnGuardar().setEnabled(true);
			//vista.getComboRepuestos().requestFocus();
			
		}else if(accion.getSource().equals(vista.getComboArtefactosRecibo())){
			vista.getTextDetallesRep().setText(null);
			vaciarRepuestos();
			
		}else if(accion.getSource().equals(vista.getBtnGuardar())){
			guardarModeloReparaciones();
			if(regReparacion.update()){
				vista.getLblMensaje().setText("Reparación actualizada exitosamente");
				recorrerTabla();
			}
			else
				vista.getLblMensaje().setText("No se pudo actualizar la reparación");
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextNrecibo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextNrecibo().getText().trim().isEmpty())){
				if(regRecepcion.read(Integer.parseInt(vista.getTextNrecibo().getText()))){
					vista.getTextFechaRecepcion().setText(regRecepcion.getFecha_recepcion());
					vista.getTextFechaEntrega().setText(regRecepcion.getFecha_entrega());
					
					regCliente.buscarID(regRecepcion.getCliente_id());
					vista.getTextCedula().setText(regCliente.getDocumentoIdentidad());
					vista.getTextCliente().setText(regCliente.getCliente());
					vista.getTextTelefono1().setText(regCliente.getTelefono1());
					vista.getTextTelefono2().setText(regCliente.getTelefono2());
					vista.getTextDireccion().setText(regCliente.getDireccion());
					vista.getTextCorrero().setText(regCliente.getCorreo());
					
					regUsuario.buscarID(regRecepcion.getUsuario_id());
					vista.getTextTecnico().setText(regUsuario.getNombre()+" "+regUsuario.getApellido());
					vista.getComboArtefactosRecibo().setEnabled(true);
					vista.getComboArtefactosRecibo().llenar(Integer.parseInt(vista.getTextNrecibo().getText()));
					vista.getComboArtefactosRecibo().requestFocus();
				}else
					vista.getLblMensaje().setText("No se encuentra registrado ese número de recibo");
				
		}if(accion.getSource().equals(vista.getTextCantidadUsar())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCantidadUsar().getText().trim().isEmpty())){
			if(Integer.parseInt(vista.getTextCantidadUsar().getText())<=(Integer.parseInt(vista.getTextCantidadActual().getText()))){
				vista.getTextMonto().setText(""+(regRepuesto.getPrecio_venta()*Integer.parseInt(vista.getTextCantidadUsar().getText())));
				vista.getBtnAgregarRepuesto().setEnabled(true);
				vista.getBtnAgregarRepuesto().requestFocus();
				
			}else 
				vista.getLblMensaje().setText("No existe esa cantidad");
			
		}else if(accion.getSource().equals(vista.getTextDetallesRep())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)){
			vista.getTextManoObra().setEditable(true);
			vista.getTextManoObra().requestFocus();
			
		}else if(accion.getSource().equals(vista.getTextManoObra())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)){
			recorrerMontos();
			vista.getComboRepuestos().setEnabled(true);
			vista.getComboRepuestos().requestFocus();
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

	//---------->llenar campos artefactos<-------------
	public void llenarArtefactos(){
		vista.getTextInformacion().setText(regReparacion.getDiagnostico_cliente());
		vista.getTextDetalles().setText(regReparacion.getDetalles_recepcion());
		vista.getTextDiagnostico().setText(regReparacion.getDiagnostico_tecnico());
		if (regReparacion.getStatus()=='P')
			vista.getComboStatus().setSelectedIndex(0);
		else
			vista.getComboStatus().setSelectedIndex(1);
	}
	public void vaciarRepuestos(){
		vista.getComboRepuestos().setSelectedIndex(0);
		vista.getTextCodigo().setText(null);
		vista.getTextRepuesto().setText(null);
		vista.getTextCantidadActual().setText(null);
		vista.getTextCantidadUsar().setText(null);
		vista.getTextPrecio().setText(null);
		vista.getTextMonto().setText(null);
		vista.getBtnAgregarRepuesto().setEnabled(false);
	}
//---------->guardar<--------------

	@Override
	public void focusGained(FocusEvent accion) {
		if(accion.getSource().equals(vista.getTextNrecibo())){
			vista.getLblMensaje().setText(null);
		}else if(accion.getSource().equals(vista.getTextCantidadUsar())){
			vista.getLblMensaje().setText(null);
		}
		
	}

	@Override
	public void focusLost(FocusEvent accion ) {
		if(accion.getSource().equals(vista.getTextNrecibo())){
			vista.getLblMensaje().setText(null);
		}else if(accion.getSource().equals(vista.getTextCantidadUsar())){
			vista.getLblMensaje().setText(null);
		}
		
	}
	public void guardarModeloReparaciones(){
		
		regReparacion.setRecepcion_id(Integer.parseInt(vista.getTextNrecibo().getText()));
		regReparacion.setMonto_repuestos(Double.parseDouble(vista.getTextMontoGeneral().getText()));
		regReparacion.setMonto_mano_obra(Double.parseDouble(vista.getTextManoObra().getText()));
		regReparacion.setDetalles_reparacion(vista.getTextDetallesRep().getText());
		if(vista.getComboStatus().getSelectedIndex()==0)
			regReparacion.setStatus('P');
		else
			regReparacion.setStatus('R');
		
		
		
	}
	//--------------------->  <...................
	public void  recorrerMontos(){
		int topeFilas=vista.getTablaRepuestoReparacion().getRowCount();
		int topeColumnas=vista.getTablaRepuestoReparacion().getColumnCount();
		double suma=0;
		String valor;
		 
	      for (int i=0; i<topeFilas;i++){
	    	  valor = (String) vista.getTablaRepuestoReparacion().getValueAt(i,5);
	    	  suma+= Double.parseDouble(valor);
	    	 
	        }
	     double sumaMo;
	     if(vista.getTextManoObra().getText().isEmpty())
	    	 sumaMo=0;
	     else
	    	 sumaMo=Double.parseDouble(vista.getTextManoObra().getText());
		
	     vista.getTextMontoGeneral().setText(""+(suma+sumaMo));
	      
	}
	public void recorrerTabla(){

		for(int i=0; i<vista.getTablaRepuestoReparacion().getRowCount();i++){
			regRepuestosReparaciones =new RepuestosReparaciones();
			regRepuestosReparaciones.setReparacion_id(Integer.parseInt(vista.getTextNrecibo().getText()));
							
			regRepuesto = new Repuesto();
			regRepuesto.buscar((String)vista.getTablaRepuestoReparacion().getValueAt(i, 1));
			regRepuestosReparaciones.setRepuestos_id(regRepuesto.getId());
			String valor=(String) vista.getTablaRepuestoReparacion().getValueAt(i, 3);
			regRepuestosReparaciones.setCantidad(Integer.parseInt(valor));
			regRepuestosReparaciones.create();
			regRepuesto.setCantidad(regRepuesto.getCantidad()-Integer.parseInt(valor));
			regRepuesto.update();
		
		}
	}
	

}//fin clases
