package modelosComboBox;

import java.sql.ResultSet;

import javax.swing.JComboBox;

import controladoresBD.SqlBD;
import modelos.Repuesto;
import modelos.TipoAparato;

public class ComboRepuestos extends JComboBox<Repuesto> {
	
	private Repuesto regRepuesto;
	
	public ComboRepuestos() {
		super();
		this.removeAllItems();
	}
	
	public void llenar(){
		this.removeAllItems();
		String sentenciaSql;
		
		sentenciaSql= "select * from repuestos" ;
		
		SqlBD codigoSql = new SqlBD();
		
		codigoSql.Conectar();
		regRepuesto=new Repuesto();
		regRepuesto.setCodigo("");
		regRepuesto.setRepuesto("Seleccione Repuesto a usar");
		regRepuesto.setCantidad(0);
		regRepuesto.setAparato_tipo("");
		this.addItem(regRepuesto);
		
		
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		try {
			while(consulta.next()){
				regRepuesto=new Repuesto();
				
				regRepuesto.setId(consulta.getInt("id"));
				regRepuesto.setCodigo(consulta.getString("codigo"));
				regRepuesto.setRepuesto(consulta.getString("repuesto"));
				regRepuesto.setMarca(consulta.getString("marca"));
				regRepuesto.setCantidad(consulta.getInt("cantidad"));
				regRepuesto.setPrecio_venta(consulta.getDouble("precio_venta"));
				regRepuesto.setDescripcion(consulta.getString("descripcion"));
				regRepuesto.setTipo_aparato_id(consulta.getInt("tipo_aparato_id"));
				
				TipoAparato tipo=new TipoAparato();
				tipo.buscarID(regRepuesto.getTipo_aparato_id());
				regRepuesto.setAparato_tipo(tipo.getTipo());
				this.addItem(regRepuesto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		codigoSql.Desconectar();
	}

}
