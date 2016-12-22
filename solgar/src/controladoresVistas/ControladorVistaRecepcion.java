package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import librerias.Funciones;
import modelos.Cliente;
import modelos.TipoAparato;
import modelos.Usuario;
import vistas.VistaCliente;
import vistas.VistaRecepcion;

public class ControladorVistaRecepcion implements ActionListener,KeyListener {

	private VistaRecepcion vista;
	private Cliente registroCliente;
	private TipoAparato tipoAparato;
	private Funciones funcion;
	private int contar;
	private double montoR,montoMo;
	
	public ControladorVistaRecepcion(VistaRecepcion vista) {
		tipoAparato=new TipoAparato();
		contar=0;
		montoR=0;
		montoMo=0;
		this.vista=vista;
		this.registroCliente=new Cliente();
		funcion=new Funciones();
		vista.getTextNrecibo().setText(""+funcion.proximoID("SELECT AUTO_INCREMENT FROM information_schema.TABLES "
			+ "WHERE TABLE_SCHEMA='solgar' AND TABLE_NAME= 'recepciones' "));
	}
	@Override
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar()))
			vista.dispose();
		else if(accion.getSource().equals(vista.getBtnVaciar()))
			vaciarFormulario();
		else if(accion.getSource().equals(vista.getBtnAgregarArtefacto())){
			if((vista.getComboTipoAparatos().getSelectedIndex()>0)&&
					(!vista.getTextInformacion().getText().trim().isEmpty())&&
					(!vista.getTextDetalles().getText().trim().isEmpty())&&
					(!vista.getTextDiagnostico().getText().trim().isEmpty())&&
					(!vista.getTextManoObra().getText().trim().isEmpty())){
			
				contar++;
				montoMo+=Double.parseDouble(vista.getTextManoObra().getText());
				montoR+=Double.parseDouble(vista.getTextMontoRepuesto().getText());
				tipoAparato=(TipoAparato) vista.getComboTipoAparatos().getSelectedItem();
				vista.getTextTotalManoObra().setText(""+montoMo);
				vista.getTextTotalMontoRep().setText(""+montoR);
				vista.getTextMontoTotal().setText("Bs."+(montoMo+montoR));
				vista.getDatosArtefactos().addRow(new String[]{""+contar,tipoAparato.getTipo(),
						vista.getTextInformacion().getText(),vista.getTextDetalles().getText(),
						vista.getTextDiagnostico().getText(),""+vista.getTextMontoRepuesto().getText(),""+vista.getTextManoObra().getText()});
				
						vaciarArtefactos();	
			}
		}
		
	}
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
		vista.getFechaEntrega().setDate(null);
		vista.getBtnAgregarArtefacto().setEnabled(false);
		vista.getBtnRegistrar().setEnabled(false);
		vista.getBtnModificar().setEnabled(false);
		vista.getBtnEliminar().setEnabled(false);
		
		
		
			
	}
	//-------------------->vaciar campos<----------------------
	public void vaciarFormulario(){
		vista.getTextCedula().setText(null);
		vista.getTextCliente().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextTelefono2().setText(null);
		vista.getTextDireccion().setText(null);
		vista.getTextCorreo().setText(null);
		
		vista.getFechaEntrega();
		
		vista.borrarTabla(vista.getTablaArtefactos());
		vaciarArtefactos();
		vista.getTextTotalManoObra().setText(null);
		vista.getTextTotalMontoRep().setText(null);
		vista.getTextMontoTotal().setText(null);
		
		registroCliente=new Cliente();
		vista.getTextCedula().requestFocus();
	}
	public void vaciarArtefactos(){
		vista.getComboTipoAparatos().setSelectedIndex(0);
		vista.getTextInformacion().setText(null);
		vista.getTextDetalles().setText(null);
		vista.getTextDiagnostico().setText(null);
		vista.getTextMontoRepuesto().setText(null);
		vista.getTextManoObra().setText(null);
		
	}

}
