package modelosComboBox;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import modelos.TipoAparato;
import controladoresBD.SqlBD;

public class ComboTipoAparatos extends JComboBox{
	
	private TipoAparato tipoAparato;
	
	public ComboTipoAparatos(){
		super();
		this.removeAllItems();
	}
	
	public void llenar(){
		this.removeAllItems();
		String sentenciaSql;
		
		sentenciaSql= "select * from tipos_aparato";
		SqlBD codigoSql = new SqlBD();
		
		codigoSql.Conectar();
	
		
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		
		tipoAparato = new TipoAparato(0,"Seleccione el tipo de aparato");
		
		this.addItem(tipoAparato);
		
		try {
			while (consulta.next()) {
				tipoAparato = new TipoAparato();
				tipoAparato.setId(consulta.getInt("id"));
				tipoAparato.setTipo(consulta.getString("tipo"));
				this.addItem(tipoAparato);
				this.setCursor(new Cursor(12));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		codigoSql.Desconectar();		
	}

}
