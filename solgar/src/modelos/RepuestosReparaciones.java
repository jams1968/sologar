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
	
	public boolean create(){
		String sentenciaSql="INSERT INTO repuestos_reparaciones (id,reparacion_id,repuestos_id,cantidad,)"+
	"VALUES ("+this.id+","+this.reparacion_id+","+this.repuestos_id+","+this.cantidad+")";
		
		SqlBD codigoSql = new SqlBD();
		if(codigoSql.agregarRegistro(sentenciaSql))
			return true;
		else
			return false;
	}

}//fin de la clase
