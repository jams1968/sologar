package modelosComboBox;

import java.sql.ResultSet;

import javax.swing.JComboBox;

import controladoresBD.SqlBD;
import modelos.Cliente;
import modelos.TipoAparato;

public class ComboClientes extends JComboBox<Cliente>{
	
	private Cliente cliente;

	public ComboClientes() {
		super();
		this.removeAllItems();
	}
	
	public void llenar(){
		this.removeAllItems();
		String sentenciaSql;
		
		sentenciaSql= "select * from clientes";
		SqlBD codigoSql = new SqlBD();
		
		codigoSql.Conectar();
		
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		
		cliente = new Cliente(0,"","Seleccione el cliente");
		
		this.addItem(cliente);
		
		try {
			while(consulta.next()){
				cliente = new Cliente();
				cliente.setId(consulta.getInt("id"));
				cliente.setDocumentoIdentidad(consulta.getString("doc_identida"));
				cliente.setCliente(consulta.getString("cliente"));
				this.addItem(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		codigoSql.Desconectar();
		
	}

}
