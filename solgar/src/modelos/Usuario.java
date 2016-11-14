/****************************************************************************
 * programa: Usuario.java
 * objetivo: clase del modelo usuario
 ****************************************************************************/
package modelos;
public class Usuario extends Persona{
	private int id;
	private int persona_id;
	private String login;
	private String clave;
	private int nivel_usuario;
	private char status;
	//---------------------contructor-------------------
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(int id, int cedula, String apellidos, String nombres, String direccion, String telefono1,
			String telefono2, String correo, char status, int id2, int persona_id, String login, String clave,
			int nivel_usuario, char status2) {
		super(id, cedula, apellidos, nombres, direccion, telefono1, telefono2, correo, status);
		id = id2;
		this.persona_id = persona_id;
		this.login = login;
		this.clave = clave;
		this.nivel_usuario = nivel_usuario;
		status = status2;
	}
	//---------->setter<-------------
	public void setId(int id) {
		this.id = id;
	}
	public void setPersona_id(int persona_id) {
		this.persona_id = persona_id;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public void setNivel_usuario(int nivel_usuario) {
		this.nivel_usuario = nivel_usuario;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	//----------------->getetr<------------
	public int getId() {
		return id;
	}
	public int getPersona_id() {
		return persona_id;
	}
	public String getLogin() {
		return login;
	}
	public String getClave() {
		return clave;
	}
	public int getNivel_usuario() {
		return nivel_usuario;
	}
	public char getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		return this.login;
	}
	
	
	

}
