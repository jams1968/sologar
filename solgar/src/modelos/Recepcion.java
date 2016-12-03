package modelos;

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
	
	// Datos Cliente
	
	private String doc_identida;
	private String cliente;
	private String telefono1;
	private String telefono2;
	private String direccion;
	private String correo;
	
	private String sentecia_sql_id_auto_increment = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA='solgar' AND TABLE_NAME= 'recepciones' ";

}
