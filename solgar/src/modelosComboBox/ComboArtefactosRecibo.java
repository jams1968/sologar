package modelosComboBox;

import java.sql.ResultSet;

import javax.swing.JComboBox;

import controladoresBD.SqlBD;
import modelos.Cliente;
import modelos.Reparacion;
import modelos.TipoAparato;

public class ComboArtefactosRecibo extends JComboBox<Reparacion> {
	
	private Reparacion regReparacion;
	
	public ComboArtefactosRecibo() {
		super();
		this.removeAllItems();
	}
	
	public void llenar(int recibo_id){
		this.removeAllItems();
		String sentenciaSql;
		
		sentenciaSql= "select * from reparaciones where recepcion_id="+recibo_id;
		
		SqlBD codigoSql = new SqlBD();
		
		codigoSql.Conectar();
		
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		
		regReparacion = new Reparacion();
		int contador=0;
		regReparacion.setNumero(contador);
		regReparacion.setTipo("Selecciones el artefacto a Reparar");
		
		this.addItem(regReparacion);
		TipoAparato tipoAparato=new TipoAparato();
		try {
			while(consulta.next()){
				contador++;
				regReparacion = new Reparacion();
				regReparacion.setNumero(contador);
				
				regReparacion.setId(consulta.getInt("id"));
				regReparacion.setTipo_Aparato_id(consulta.getInt("tipo_aparato_id"));
				tipoAparato.setId(regReparacion.getTipo_Aparato_id());
				tipoAparato.buscarID(regReparacion.getTipo_Aparato_id());
				regReparacion.setTipo(tipoAparato.getTipo());
				regReparacion.setDiagnostico_cliente(consulta.getString("diagnostico_cliente"));
				regReparacion.setDetalles_recepcion(consulta.getString("detalles_recepcion"));
				regReparacion.setDiagnostico_tecnico(consulta.getString("diagnostico_tecnico"));
				regReparacion.setMonto_repuestos(consulta.getDouble("precio_repuestos"));
				regReparacion.setMonto_mano_obra(consulta.getDouble("precio_mano_obra"));
				regReparacion.setDetalles_reparacion(consulta.getString("detalles_reparacion"));
				regReparacion.setStatus(consulta.getString("status").charAt(0));
				this.addItem(regReparacion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		codigoSql.Desconectar();
	}

}
