/****************************************************************************
 * programa: Usuario.java
 * objetivo: clase del modelo usuario
 ****************************************************************************/
package modelos;
public class Usuario{
	private int id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String direccion;
	private String login;
	private String clave;
	private int nivel_usuario;
	
	//---------------------contructor-------------------
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getNivel_usuario() {
		return nivel_usuario;
	}

	public void setNivel_usuario(int nivel_usuario) {
		this.nivel_usuario = nivel_usuario;
	}
	
	@Override
	public String toString() {
		
		return id+"-"+nombre+"-"+apellido;
	}
	
	

}
