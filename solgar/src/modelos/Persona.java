/****************************************************************************
 * programa: Persona.java
 * objetivo: clase del modelo persona
 ****************************************************************************/
package modelos;

public class Persona {
	protected int id;
	protected int cedula;
	protected String apellidos;
	protected String nombres;
	protected String direccion;
	protected String telefono1;
	protected String telefono2;
	protected String correo;
	protected char status;
	
	//------------>constructores<----------------------
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Persona(int id, int cedula, String apellidos, String nombres, String direccion, String telefono1,
			String telefono2, String correo, char status) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.apellidos = apellidos;
		this.nombres = nombres;
		this.direccion = direccion;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.correo = correo;
		this.status = status;
	}

	//---------->setter<----------------
	public void setId(int id) {
		this.id = id;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	//------------>getter<---------------------
	public int getId() {
		return id;
	}
	public int getCedula() {
		return cedula;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public String getCorreo() {
		return correo;
	}
	public char getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		
		return this.cedula+"-"+this.apellidos+" "+this.nombres;
	}

	
	
	

}
