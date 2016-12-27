/****************************************************************************
 * programa: Usuario.java
 * objetivo: clase del modelo usuario
 ****************************************************************************/
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

import controladoresBD.SqlBD;

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

	public void setClave(String cs) {
		this.clave = cs;
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
	
	//-------->buscar<------------
	public boolean buscarID(int  xId){
					
		String sentenciaSql = "SELECT * FROM usuarios where id='"+xId+ "'";
						
		SqlBD codigoSql = new SqlBD();
					
		ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
		try {
							
		while (consulta.next()) {
			setId(consulta.getInt("id"));
			setCedula(consulta.getString("cedula"));
			setNombre(consulta.getString("nombre"));
			setApellido(consulta.getString("apellido"));
			}
		}catch (SQLException e) {

			e.printStackTrace();
		}
				
		codigoSql.Desconectar();
		if(this.id==0)
			return false;
		else return true;
	}//fin buscar

}//fin de la clase
