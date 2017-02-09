package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import controladoresBD.SqlBD;
import librerias.Funciones;

public class Recepcion {
	private int id;
	private int cliente_id;
	private int usuario_id;
	private String fecha_recepcion;
	private String fecha_entrega;
	private Funciones funciones;
	
//------------------------>constructores<--------------------
	
	public Recepcion(int id, int cliente_id, int usuario_id, String fecha_recepcion, String fecha_entrega) {
		super();
		funciones=new Funciones();
		this.id = id;
		this.cliente_id = cliente_id;
		this.usuario_id = usuario_id;
		this.fecha_recepcion = fecha_recepcion;
		this.fecha_entrega = fecha_entrega;
	}

	public Recepcion() {
		super();
		funciones=new Funciones();
		// TODO Auto-generated constructor stub
	}

	//---------------------getter & setter<--------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getFecha_recepcion() {
		return fecha_recepcion;
	}

	public void setFecha_recepcion(String fecha_recepcion) {
		this.fecha_recepcion = fecha_recepcion;
	}

	public String getFecha_entrega() {
		return fecha_entrega;
	}

	public void setFecha_entrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
//-------->read<-------------
public boolean read(int nRecibo){
	
	String sentenciaSql = "SELECT * FROM recepciones where id="+nRecibo;
				
	SqlBD codigoSql = new SqlBD();
				
	ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
	try {
		while (consulta.next()) {
			setId(consulta.getInt("id"));
			setCliente_id(consulta.getInt("cliente_id"));
			setUsuario_id(consulta.getInt("usuario_id"));
			setFecha_recepcion(consulta.getString("fecha_recepcion"));
			setFecha_entrega(consulta.getString("fecha_entrega"));
			}
		}catch (SQLException e) {
		e.printStackTrace();
	}
	codigoSql.Desconectar();
	if(this.id==0)return false;
	else return true;
}//fin read

//------------------>create<---------------------
public boolean create(){
	
	if((cliente_id!=0)&&(usuario_id!=0)&&(fecha_recepcion!=null)&&(fecha_entrega!=null)){
			
		String sentenciaSql="INSERT INTO recepciones (cliente_id,usuario_id,fecha_recepcion,fecha_entrega)"
				+ "VALUES ("+cliente_id+","+usuario_id+",'"
				+funciones.CambiarFechaUSa(fecha_recepcion)+"','"+fecha_entrega+"')";
		//System.out.println(sentenciaSql);
		//JOptionPane.showMessageDialog(null,sentenciaSql);
		SqlBD codigoSql = new SqlBD();
		if(codigoSql.agregarRegistro(sentenciaSql))
			return true;
		else
			return false;
	}
	else return false;
}//fin create

	
	public static void main(String[] args) {
		Recepcion registro=new Recepcion(1,13,7,"22/12/2016","31/12/2016");
		
		

	}


}//fin de la clase
