package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelos.Cliente;
import modelos.DetallesReparacion;
import modelos.Recepcion;
import modelos.Reparacion;
import modelos.Repuesto;
import modelos.TipoAparato;
import modelos.Usuario;
import vistas.VistaReparacion;

public class ControladorVistaReparacion implements KeyListener,ActionListener  {
	
	private VistaReparacion vista;
	private Recepcion regRecepcion;
	private Reparacion regReparacion;
	private TipoAparato tipoAparato;
	private Cliente regCliente;
	private Usuario regUsuario;
	private Repuesto regRepuesto;
	private DetallesReparacion regDetalle;
	private int contar,fila;
	
	public ControladorVistaReparacion(VistaReparacion vista) {
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
				vista.getComboRepuestos().setEnabled(true);
				vista.getComboRepuestos().requestFocus();
				
		}else if(accion.getSource().equals(vista.getComboRepuestos())&&(vista.getComboRepuestos().getSelectedIndex()>0)){
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
			vista.getComboRepuestos().requestFocus();
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
				}
				
		}if(accion.getSource().equals(vista.getTextCantidadUsar())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCantidadUsar().getText().trim().isEmpty())){
			vista.getTextMonto().setText(""+(regRepuesto.getPrecio_venta()*Integer.parseInt(vista.getTextCantidadUsar().getText())));
			vista.getTextDetallesRep().setEditable(true);
			vista.getTextDetallesRep().requestFocus();
			
		}else if(accion.getSource().equals(vista.getTextDetallesRep())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)){
			vista.getBtnAgregarRepuesto().requestFocus();
			vista.getBtnAgregarRepuesto().setEnabled(true);
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

	public void llenarCamposRecepcion(){
		
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
	}
//---------->guardar<--------------
	

}//fin clases
