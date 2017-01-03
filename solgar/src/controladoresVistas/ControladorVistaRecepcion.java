package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Calendar;

import librerias.Funciones;
import modelos.Cliente;
import modelos.Recepcion;
import modelos.Reparacion;
import modelos.TipoAparato;
import modelos.Usuario;
import pdf.reciboPDF;
import vistas.VistaCliente;
import vistas.VistaRecepcion;

public class ControladorVistaRecepcion implements ActionListener,KeyListener {

	private VistaRecepcion vista;
	private Cliente registroCliente;
	private TipoAparato tipoAparato;
	private Funciones funcion;
	private int contar;
	private Recepcion regRecepcion;
	private Reparacion regReparacion;
	
	
	public ControladorVistaRecepcion(VistaRecepcion vista) {
		regRecepcion=new Recepcion();
		regReparacion=new Reparacion();
		tipoAparato=new TipoAparato();
		contar=0;
		this.vista=vista;
		this.registroCliente=new Cliente();
		funcion=new Funciones();
		iniciar();
		vista.getTextCedula().requestFocus();
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar()))
			vista.dispose();
		else if(accion.getSource().equals(vista.getBtnVaciar()))
			vaciarFormulario();
		else if(accion.getSource().equals(vista.getBtnRegistrar())){
			if(vista.getFechaEntrega().getDate()!=null){
				llenarModelos();
				if(regRecepcion.create()){
					recorrerTabla();
					vista.getLblMensaje().setText("Recibo almacenado Exitosamente");
					this.vista.setAlwaysOnTop(false);
					new reciboPDF(regRecepcion.getId());
					vaciarFormulario();
				}else
					vista.getLblMensaje().setText("No se pudo almacenar el recibo");
			}else
				vista.getLblMensaje().setText("indique fecha de entrega");
	   	}//fin registrar
		
		else if(accion.getSource().equals(vista.getBtnAgregarArtefacto())){
		
			if((vista.getComboTipoAparatos().getSelectedIndex()>0)&&
					(!vista.getTextInformacion().getText().trim().isEmpty())&&
					(!vista.getTextDetalles().getText().trim().isEmpty())&&
					(!vista.getTextDiagnostico().getText().trim().isEmpty())){
			
				contar++;
				tipoAparato=(TipoAparato) vista.getComboTipoAparatos().getSelectedItem();
				vista.getDatosArtefactos().addRow(new String[]{""+contar,tipoAparato.getTipo(),
						vista.getTextInformacion().getText(),vista.getTextDetalles().getText(),
						vista.getTextDiagnostico().getText()});
				
						vaciarArtefactos();	
						vista.getBtnRegistrar().setEnabled(true);
			}
		}// fin agregarArtefacto
		else if(vista.getComboTipoAparatos().getSelectedIndex()>0){
			vista.getTextInformacion().requestFocus();
		}
		
	}// fin action
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextCedula())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextCedula().getText().trim().isEmpty())){
			if(registroCliente.buscar(vista.getTextCedula().getText().trim())){
				llenarFormularioCliente();
				vista.getBtnAgregarArtefacto().setEnabled(true);
				vista.getComboTipoAparatos().setEnabled(true);
				vista.getComboTipoAparatos().requestFocus();
				
				
			}else{
				vista.getLblMensaje().setText("Cliente no se encuentra registrado");
				new VistaCliente(vista.getRegistroUsuario());
				if(registroCliente.buscar(vista.getTextCedula().getText().trim())){
					llenarFormularioCliente();
					vista.getBtnAgregarArtefacto().setEnabled(true);
					vista.getLblMensaje().setText(null);
				
				}
			}
		
		}//cedula
		else if(accion.getSource().equals(vista.getTextInformacion())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextInformacion().getText().trim().isEmpty())){
				vista.getTextDetalles().requestFocus();
			
		}else if(accion.getSource().equals(vista.getTextDetalles())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextDetalles().getText().trim().isEmpty())){
				vista.getTextDiagnostico().requestFocus();
			
		}else if(accion.getSource().equals(vista.getTextDiagnostico())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextDiagnostico().getText().trim().isEmpty())){
				vista.getBtnAgregarArtefacto().requestFocus();
			
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
	//------------>llenar campos formulario<-----------
	public void llenarFormularioCliente(){
		vista.getTextCliente().setText(registroCliente.getCliente());
		vista.getTextTelefono1().setText(registroCliente.getTelefono1());
		vista.getTextTelefono2().setText(registroCliente.getTelefono2());
		vista.getTextDireccion().setText(registroCliente.getDireccion());
		vista.getTextCorreo().setText(registroCliente.getCorreo());
		//vista.getFechaEntrega().setDate(null);
		vista.getBtnAgregarArtefacto().setEnabled(false);
		vista.getBtnRegistrar().setEnabled(false);
		vista.getBtnModificar().setEnabled(false);
		vista.getBtnEliminar().setEnabled(false);
	}
	//-------------->llenar modelos<---------------
	public void llenarModelos(){
		regRecepcion.setId(Integer.parseInt(vista.getTextNrecibo().getText()));
		regRecepcion.setCliente_id(this.registroCliente.getId());
		regRecepcion.setUsuario_id(vista.getRegistroUsuario().getId());
		regRecepcion.setFecha_recepcion(vista.getTextFechaRecibo().getText());
		
		String dia=Integer.toString(vista.getFechaEntrega().getCalendar().get(Calendar.DAY_OF_MONTH));
		String mes=Integer.toString(vista.getFechaEntrega().getCalendar().get(Calendar.MONTH)+1);
		String anno=Integer.toString(vista.getFechaEntrega().getCalendar().get(Calendar.YEAR));
		String fecha=""+anno+"/"+mes+"/"+dia;
		regRecepcion.setFecha_entrega(fecha);
		
		
	}
	//-------------------->vaciar campos<----------------------
	public void vaciarFormulario(){
		iniciar();
		vista.getTextCedula().setText(null);
		vista.getTextCliente().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextTelefono2().setText(null);
		vista.getTextDireccion().setText(null);
		vista.getTextCorreo().setText(null);
		vista.getFechaEntrega().setDate(null);
		vista.getBtnAgregarArtefacto().setEnabled(false);
		
		vista.getFechaEntrega();
		
		vista.borrarTabla(vista.getTablaArtefactos());
		vaciarArtefactos();
			
		registroCliente=new Cliente();
		vista.getTextCedula().requestFocus();
	}
	public void vaciarArtefactos(){
		vista.getComboTipoAparatos().setSelectedIndex(0);
		vista.getTextInformacion().setText(null);
		vista.getTextDetalles().setText(null);
		vista.getTextDiagnostico().setText(null);
		
		
	}
	public void recorrerTabla(){
		for(int i=0; i<vista.getTablaArtefactos().getRowCount();i++){
			
			regReparacion=new Reparacion();
			regReparacion.setRecepcion_id(Integer.parseInt(vista.getTextNrecibo().getText()));
			tipoAparato.setTipo((String)vista.getTablaArtefactos().getValueAt(i, 1));
			tipoAparato.buscar();
			regReparacion.setTipo_Aparato_id(tipoAparato.getId());
			regReparacion.setDiagnostico_cliente((String)vista.getTablaArtefactos().getValueAt(i, 2));
			regReparacion.setDetalles_recepcion((String)vista.getTablaArtefactos().getValueAt(i, 3));
			regReparacion.setDiagnostico_tecnico((String)vista.getTablaArtefactos().getValueAt(i, 4));
			regReparacion.setDetalles_reparacion(null);
			regReparacion.setStatus('P');
			regReparacion.create();
		}
	}
public void iniciar(){
	vista.getTextNrecibo().setText(""+funcion.proximoID("SELECT AUTO_INCREMENT FROM information_schema.TABLES "
			+ "WHERE TABLE_SCHEMA='bd_sologar' AND TABLE_NAME= 'recepciones' "));
}
	
}//fi de la clase
