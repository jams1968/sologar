package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

import controladoresBD.SqlBD;

public class Repuesto {
	
	private int id;
	private String codigo;
	private String repuesto;
	private String marca;
	private int cantidad;
	private double precio_venta;
	private String descripcion;
	private int tipo_aparato_id;
	private String aparato_tipo;
	
	public Repuesto() {
		super();
	}

	public Repuesto(int id, String codigo, String repuesto) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.repuesto = repuesto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(String repuesto) {
		this.repuesto = repuesto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTipo_aparato_id() {
		return tipo_aparato_id;
	}

	public void setTipo_aparato_id(int tipo_aparato_id) {
		this.tipo_aparato_id = tipo_aparato_id;
	}

	public String getAparato_tipo() {
		return aparato_tipo;
	}

	public void setAparato_tipo(String aparato_tipo) {
		this.aparato_tipo = aparato_tipo;
	}

	@Override
	public String toString() {
		return id+"-"+codigo+"-"+repuesto;
	}
	//------------------>update<---------------------
	public boolean create(){
		
		if((codigo!=null)&&
			(repuesto!=null)&&
			(marca!=null)&&
			(cantidad>0)&&
			(precio_venta>0)&&	
			(descripcion!=null)&&	
			(tipo_aparato_id>0)){
		
				String sentenciaSql="INSERT INTO repuestos (codigo,repuesto,marca,cantidad,precio_venta,descripcion,tipo_aparato_id)"
						+ "VALUES ('"+codigo+"','"+repuesto+"','"+ marca+"',"+cantidad+","+precio_venta+",'"+descripcion
								+"',"+tipo_aparato_id+")";
				SqlBD codigoSql = new SqlBD();
				if(codigoSql.agregarRegistro(sentenciaSql))
					return true;
				else
					return false;
		}
		else return false;
	}//fin create
	
	//-------------->modificar<-------------------
	public  boolean update(){
		if((codigo!=null)&&
				(repuesto!=null)&&
				(marca!=null)&&
				(cantidad>0)&&
				(precio_venta>0)&&	
				(descripcion!=null)&&	
				(tipo_aparato_id>0)){
			
			
			String sentenciaSql="UPDATE repuestos SET "
					+ "repuesto='"+ repuesto+"', marca='"+marca
					+"', cantidad="+cantidad+", precio_venta="+precio_venta
					+",descripcion='"+descripcion
					+"',tipo_aparato_id="+tipo_aparato_id
					+ " where codigo='"+codigo+"'";
		
			SqlBD codigoSql = new SqlBD();
			if(codigoSql.agregarRegistro(sentenciaSql))
				return true;
			else
				return false;
		}
		else return false;
	}
	
	//-------->buscar<------------
	public boolean buscar(String xCodigo){
	
		Repuesto registro=new Repuesto();
		String sentenciaSql = "SELECT * FROM repuestos where codigo='"+xCodigo+ "'";
		
		SqlBD codigoSql = new SqlBD();
		
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		try {
			
			while (consulta.next()) {
				setId(consulta.getInt("id"));
				setCodigo(consulta.getString("codigo"));
				setRepuesto(consulta.getString("repuesto"));
				setMarca(consulta.getString("marca"));
				setCantidad(consulta.getInt("cantidad"));
				setPrecio_venta(consulta.getDouble("precio_venta"));
				setDescripcion(consulta.getString("descripcion"));
				setTipo_aparato_id(consulta.getInt("tipo_aparato_id"));
				
				
			}
		}catch (SQLException e) {

				e.printStackTrace();
		}
	
		codigoSql.Desconectar();
		if(this.id==0)
			return false;
		else return true;
	}//fin buscar
	
	

}
