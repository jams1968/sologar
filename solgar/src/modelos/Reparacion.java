package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

import controladoresBD.SqlBD;

public class Reparacion {
	private int id;
	private int recepcion_id;
	private int numero;
	private int tipo_Aparato_id;
	private String tipo;
	private String diagnostico_cliente;
	private String detalles_recepcion;
	private String diagnostico_tecnico;
	private double monto_repuestos;
	private double monto_mano_obra;
	private String detalles_reparacion;
	private char status;
	//----------->constructor<-------------
	public Reparacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reparacion(int numero,String tipo) {
		this.numero=numero;
		this.tipo=tipo;
	}
	public Reparacion(int id, int recepcion_id, int tipo_Aparato_id, String diagnostico_cliente,
			String detalles_recepcion, String diagnostico_tecnico, double monto_repuestos, double monto_mano_obra,
			String detalles_reparacion, char status) {
		super();
		this.id = id;
		this.recepcion_id = recepcion_id;
		this.tipo_Aparato_id = tipo_Aparato_id;
		this.diagnostico_cliente = diagnostico_cliente;
		this.detalles_recepcion = detalles_recepcion;
		this.diagnostico_tecnico = diagnostico_tecnico;
		this.monto_repuestos = monto_repuestos;
		this.monto_mano_obra = monto_mano_obra;
		this.detalles_reparacion = detalles_reparacion;
		this.status = status;
	}
	//----->getter & setter<----------------
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
	public int getTipo_Aparato_id() {
		return tipo_Aparato_id;
	}
	public void setTipo_Aparato_id(int tipo_Aparato_id) {
		this.tipo_Aparato_id = tipo_Aparato_id;
	}
	public String getDiagnostico_cliente() {
		return diagnostico_cliente;
	}
	public void setDiagnostico_cliente(String diagnostico_cliente) {
		this.diagnostico_cliente = diagnostico_cliente;
	}
	public String getDetalles_recepcion() {
		return detalles_recepcion;
	}
	public void setDetalles_recepcion(String detalles_recepcion) {
		this.detalles_recepcion = detalles_recepcion;
	}
	public String getDiagnostico_tecnico() {
		return diagnostico_tecnico;
	}
	public void setDiagnostico_tecnico(String diagnostico_tecnico) {
		this.diagnostico_tecnico = diagnostico_tecnico;
	}
	public double getMonto_repuestos() {
		return monto_repuestos;
	}
	public void setMonto_repuestos(double monto_repuestos) {
		this.monto_repuestos = monto_repuestos;
	}
	public double getMonto_mano_obra() {
		return monto_mano_obra;
	}
	public void setMonto_mano_obra(double monto_mano_obra) {
		this.monto_mano_obra = monto_mano_obra;
	}
	public String getDetalles_reparacion() {
		return detalles_reparacion;
	}
	public void setDetalles_reparacion(String detalles_reparacion) {
		this.detalles_reparacion = detalles_reparacion;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		
		
		// TODO Auto-generated method stub
		return this.getNumero()+"-"+this.getTipo();
	}
	//------------>create<------------------
	
	public boolean create(){
		
		if((recepcion_id!=0)&&(tipo_Aparato_id!=0)&&(diagnostico_cliente!=null)&&(detalles_recepcion!=null)
				&&(diagnostico_tecnico!=null)){
			String sentenciaSql="INSERT INTO reparaciones (recepcion_id,tipo_aparato_id,diagnostico_cliente,"
					+ "detalles_recepcion,diagnostico_tecnico,precio_repuestos,precio_mano_obra,detalles_reparacion,"
					+ "status)"+ "VALUES ("+recepcion_id+","+tipo_Aparato_id+",'"+diagnostico_cliente.toUpperCase()+"','"
					+detalles_recepcion.toUpperCase()+"','"+diagnostico_tecnico.toUpperCase()+"',"+0+","+0+",'"
					+detalles_reparacion+"','"+status+"')";
			
			SqlBD codigoSql = new SqlBD();
			if(codigoSql.agregarRegistro(sentenciaSql)){
				return true;
			}
			else{
								
				return false;
			}
		}
		else return false;
	
	}//fin create
	
	//---------->read por Nro Recibo<------------
	/*public boolean read(int nRecibo){
		String sentenciaSql = "SELECT * FROM reparaciones where recepcion_id="+nRecibo;
		
		SqlBD codigoSql = new SqlBD();
					
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		(recepcion_id,tipo_aparato_id,diagnostico_cliente,"
				+ "detalles_recepcion,diagnostico_tecnico,precio_repuestos,precio_mano_obra,detalles_reparacion,"
				+ "status)
		try {
			while (consulta.next()) {
				setId(consulta.getInt("id"));
				setRecepcion_id(consulta.getInt("recepcion_id"));
				setTipo_Aparato_id(consulta.getInt("tipo_aparato_id"));
				
				
				}
			}catch (SQLException e) {
			e.printStackTrace();
		}
		codigoSql.Desconectar();
		if(this.id==0)return false;
		else return true;
		
	}*///fin read Nrecibo
	

}//fin clase
