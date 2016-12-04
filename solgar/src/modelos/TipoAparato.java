package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

import controladoresBD.SqlBD;

public class TipoAparato {
	private int id;
	private String tipo;
	//------------>constructor<--------------
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"-"+this.tipo;
	}


	public TipoAparato() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TipoAparato(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	//------------------->buscar>------------
	public boolean buscar(){
		String sentenciaSql = "SELECT * FROM tipos_Aparato where tipo='"+tipo+ "'";
			
		SqlBD codigoSql = new SqlBD();
			
			ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
			try {
				
				while (consulta.next()) {
					setId(consulta.getInt("id"));
					setTipo(consulta.getString("tipo"));
				}
			}catch (SQLException e) {

					e.printStackTrace();
			}
		
			codigoSql.Desconectar();
			if(this.id==0)
				return false;
			else return true;
		}//fin buscar
	
	//------------------------> create<----------------
	public boolean create(){
		if((tipo!=null)){
			String sentenciaSql="INSERT INTO tipos_aparato (tipo) VALUES ('"+tipo+"')";
			SqlBD codigoSql = new SqlBD();
			if(codigoSql.agregarRegistro(sentenciaSql))
				return true;
			else
				return false;
		}
		else return false;
	}//fin create
	//------------------------>update<----------------
	public boolean update(){
		if((tipo!=null)){
			String sentenciaSql="UPDATE tipos_aparato SET tipo='"+tipo+" where id="+id;
			SqlBD codigoSql = new SqlBD();
			if(codigoSql.agregarRegistro(sentenciaSql))
				return true;
			else
				return false;
		}
		else return false;
	}//fin create
	
	//eliminar 

	public boolean eliminar(){

		String sentenciaSql = "DELETE FROM tipos_aparato where tipo ='"+tipo+ "'";
			
		if((tipo!=null)){
					
			SqlBD codigoSql = new SqlBD();
			if(codigoSql.agregarRegistro(sentenciaSql))
				return true;
			else
				return false;
		}
		else return false;
	
		
	}
	// fin eliminar

}//fin da la clase
