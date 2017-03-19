package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import controladoresBD.SqlBD;

public class Entrega {
	private int id;
	private int recepcion_id;
	private double monto_total;
	private String fecha_salida;
	
	public Entrega() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecepcion_id() {
		return recepcion_id;
	}

	public void setRecepcion_id(int recepcion_id) {
		this.recepcion_id = recepcion_id;
	}

	public double getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}

	public String getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	//-------->read<-------------
	public boolean read(int nRecibo){
		
		String sentenciaSql = "SELECT * FROM entregados where recepcion_id="+nRecibo;
					
		SqlBD codigoSql = new SqlBD();
					
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		try {
			while (consulta.next()) {
				setId(consulta.getInt("id"));
				setRecepcion_id(consulta.getInt("recepcion_id"));
				setMonto_total(consulta.getDouble("monto_total"));
				setFecha_salida(consulta.getString("fecha_salida"));
				
			}
			}catch (SQLException e) {
			e.printStackTrace();
		}
		codigoSql.Desconectar();
		if(this.id==0)return false;
		else return true;
	}//fin read
	
	//----------->create<--------------
	public boolean create(){
		Calendar calendario = Calendar.getInstance();
		Calendar c = new GregorianCalendar();
		String dia_hoy,mes_hoy,year_hoy;
		dia_hoy = Integer.toString(c.get(Calendar.DATE));
		mes_hoy = Integer.toString(c.get(Calendar.MONTH)+1);
		year_hoy = Integer.toString(c.get(Calendar.YEAR));
		setFecha_salida(year_hoy+"/"+mes_hoy+"/"+dia_hoy);
		

		String sentenciaSql="INSERT INTO entregados (recepcion_id,monto_total,fecha_salida)"
				+ "VALUES ("+recepcion_id+","+monto_total+",'"+fecha_salida+"')";
		System.out.println(sentenciaSql);
		if((recepcion_id!=0)&&(monto_total!=0)){
			SqlBD codigoSql = new SqlBD();
			if(codigoSql.agregarRegistro(sentenciaSql))
				return true;
			
		}
		return false;
	
	}
	
	
}//fin de la clase