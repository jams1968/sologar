package controladoresVistas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Generated;

import modelos.Cliente;
import modelos.Entrega;
import modelos.Recepcion;
import modelos.Reparacion;
import modelos.TipoAparato;
import modelos.Usuario;
import vistas.VistaEntrega;

public class ControladorVistaEntrega implements ActionListener,KeyListener {

	private VistaEntrega vista;
	private Recepcion regRecepcion;
	private Cliente regCliente;
	private Usuario regUsuario;
	private Entrega regEntrega;
	private Reparacion regReparacion;
	private TipoAparato regTipoAparato;
	
	public ControladorVistaEntrega(VistaEntrega vista) {
		this.vista=vista;
		
		regRecepcion=new Recepcion();
		regCliente=new Cliente();
		regUsuario=new Usuario();
		regEntrega=new Entrega();
		regTipoAparato=new TipoAparato();
		
	
	
	}
	public void actionPerformed(ActionEvent accion) {
		if(accion.getSource().equals(vista.getBtnCerrar()))
			vista.dispose();
		else if(accion.getSource().equals(vista.getBtnGuardar())){
			regEntrega.setRecepcion_id(Integer.parseInt(vista.getTextNrecibo().getText()));
			regEntrega.setMonto_total(Double.parseDouble(vista.getTextMontoGeneral().getText()));
			if(regEntrega.create()){
				
				vista.getLblMensaje().setText("Entrega exitosa");
				vaciarCampos();
			}
			else
				vista.getLblMensaje().setText("No se pudo hacer la entrega");
		}else if(accion.getSource().equals(vista.getBtnBuscar())){
vista.getLblMensaje().setText(null);
			
			if(regEntrega.read(Integer.parseInt(vista.getTextNrecibo().getText()))){
				vista.getLblMensaje().setText("Recibo ya Fue entregado");
				
			}else if(regRecepcion.read(Integer.parseInt(vista.getTextNrecibo().getText()))){
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
					regReparacion =new Reparacion();
					ResultSet consulta=regReparacion.read2(Integer.parseInt(vista.getTextNrecibo().getText()));
					int contar=0,fila=0;
					double montoTotal=0;
					try {
						while (consulta.next()) {
							contar++;
							montoTotal+=consulta.getDouble("precio_repuestos")+consulta.getDouble("precio_mano_obra");
							
							regTipoAparato.buscarID(consulta.getInt("tipo_aparato_id"));
							vista.getDatosTabla().insertRow(fila, new String[] {""+contar,regTipoAparato.getTipo(),
																					consulta.getString("detalles_reparacion"),
																					""+consulta.getDouble("precio_repuestos"),
																					""+consulta.getDouble("precio_mano_obra"),
																					""+(consulta.getDouble("precio_repuestos")+
																					consulta.getDouble("precio_mano_obra")),
																					consulta.getString("status")});
							fila++;
							
							}
						
						}catch (SQLException e) {
						e.printStackTrace();
					}
					vista.getTextMontoGeneral().setText(""+montoTotal);
					
				}else
					vista.getLblMensaje().setText("No se encuentra registrado ese número de recibo");
		}
		
	}//fin action listerner
	
	@Override
	public void keyPressed(KeyEvent accion) {
		if(accion.getSource().equals(vista.getTextNrecibo())&&
				(accion.getKeyCode()== KeyEvent.VK_ENTER)&&
				!(vista.getTextNrecibo().getText().trim().isEmpty())){
			
				
		}
		
	}//
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void vaciarCampos(){
		vista.getTextNrecibo().setText(null);
		vista.getTextFechaRecepcion().setText(null);
		vista.getTextFechaEntrega().setText(null);
		vista.getTextCedula().setText(null);
		vista.getTextCliente().setText(null);
		vista.getTextTelefono1().setText(null);
		vista.getTextTelefono2().setText(null);
		vista.getTextCorrero().setText(null);
		vista.getTextTecnico().setText(null);
	
		       for (int i = 0; i < vista.getTablaRepuestoReparacion().getRowCount(); i++) {
		           vista.getDatosTabla().removeRow(i);
		           i-=1;
		       }
		   
		
	}
	public void cargarArtefactos(){
		
	}
	

}//fin clase
