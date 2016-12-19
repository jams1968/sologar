package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

import controladoresBD.SqlBD;

public class Recepcion {
	private int id;
	private int recepcion_id;
	private int tipo_aparato_id;
	private String diagnostico_cliente;
	private String detalles_recepcion;
	private String diagnostico_tecnico;
	private double precio_repuestos;
	private double precio_mano_obra;
	private String detalles_reparacion;
	private String status;
	
	private String sentecia_sql_id_auto_increment = "SELECT AUTO_INCREMENT FROM information_schema.TABLES "
			+ "WHERE TABLE_SCHEMA='solgar' AND TABLE_NAME= 'recepciones' ";

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

	public int getTipo_aparato_id() {
		return tipo_aparato_id;
	}

	public void setTipo_aparato_id(int tipo_aparato_id) {
		this.tipo_aparato_id = tipo_aparato_id;
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

	public double getPrecio_repuestos() {
		return precio_repuestos;
	}

	public void setPrecio_repuestos(double precio_repuestos) {
		this.precio_repuestos = precio_repuestos;
	}

	public double getPrecio_mano_obra() {
		return precio_mano_obra;
	}

	public void setPrecio_mano_obra(double precio_mano_obra) {
		this.precio_mano_obra = precio_mano_obra;
	}

	public String getDetalles_reparacion() {
		return detalles_reparacion;
	}

	public void setDetalles_reparacion(String detalles_reparacion) {
		this.detalles_reparacion = detalles_reparacion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSentecia_sql_id_auto_increment() {
		return sentecia_sql_id_auto_increment;
	}

	public void setSentecia_sql_id_auto_increment(String sentecia_sql_id_auto_increment) {
		this.sentecia_sql_id_auto_increment = sentecia_sql_id_auto_increment;
	}
	

}
