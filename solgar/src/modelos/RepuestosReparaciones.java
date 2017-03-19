package modelos;

import controladoresBD.SqlBD;

public class RepuestosReparaciones {
	private int id;
	private int reparacion_id;
	private int repuestos_id;
	private int cantidad;
	
	
	public RepuestosReparaciones() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public int getReparacion_id() {
		return reparacion_id;
	}


	public int getRepuestos_id() {
		return repuestos_id;
	}


	public int getCantidad() {
		return cantidad;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public void setReparacion_id(int reparacion_id) {
		this.reparacion_id = reparacion_id;
	}


	public void setRepuestos_id(int repuestos_id) {
		this.repuestos_id = repuestos_id;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public boolean create(){
		String sentenciaSql="INSERT INTO repuestos_reparaciones (reparacion_id,repuestos_id,cantidad)"+
	"VALUES ("+this.reparacion_id+","+this.repuestos_id+","+this.cantidad+")";
		//System.out.println(sentenciaSql);
		SqlBD codigoSql = new SqlBD();
		if(codigoSql.agregarRegistro(sentenciaSql))
			return true;
		else
			return false;
	}
	

}//fin de la clase
