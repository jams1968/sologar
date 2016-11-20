/****************************************************************************
 * programa: Persona.java
 * objetivo: clase del modelo persona
 ****************************************************************************/
package modelos;

public class Cliente {
	protected int id;
	protected String documentoIdentidad;
	protected String cliente;
	protected String direccion;
	protected String telefono1;
	protected String telefono2;
	protected String correo;
	protected char status;
	
	//------------>constructores<----------------------
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(int id, String documentoIdentidad, String cliente, String direccion,
			String telefono1, String telefono2, String correo, char status) {
		super();
		this.id = id;
		this.documentoIdentidad = documentoIdentidad;
		this.cliente = cliente;
		this.direccion = direccion;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.correo = correo;
		this.status = status;
	}
	
	public Cliente(int id, String documentoIdentidad, String cliente) {
		super();
		this.id = id;
		this.documentoIdentidad = documentoIdentidad;
		this.cliente = cliente;
	}
	
	//------------>setter && getter<---------------------

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumentoIdentidad() {
		return documentoIdentidad;
	}

	public void setDocumentoIdentidad(String cedula) {
		this.documentoIdentidad = cedula;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.documentoIdentidad+"-"+this.cliente;
	}
	
}
