/****************************************************************************
 * programa: Persona.java
 * objetivo: clase del modelo persona
 ****************************************************************************/
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

import controladoresBD.SqlBD;

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
	
	//-------->buscar<------------
		public boolean buscar(String xDocumento){
		
			Repuesto registro=new Repuesto();
			String sentenciaSql = "SELECT * FROM clientes where doc_identidad='"+xDocumento+ "'";
			
			SqlBD codigoSql = new SqlBD();
			
			ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
			try {
				
				while (consulta.next()) {
					setId(consulta.getInt("id"));
					setDocumentoIdentidad(consulta.getString("doc_identidad"));
					setCliente(consulta.getString("cliente"));
					setTelefono1(consulta.getString("telefono1"));
					setTelefono2(consulta.getString("telefono2"));
					setDireccion(consulta.getString("direccion"));
					setCorreo(consulta.getString("email"));
					
					
				}
			}catch (SQLException e) {

					e.printStackTrace();
			}
		
			codigoSql.Desconectar();
			if(this.id==0)
				return false;
			else return true;
		}//fin buscar
		//-------->buscar<------------
		public boolean buscarID(int  xDocumento){
				
			Repuesto registro=new Repuesto();
			String sentenciaSql = "SELECT * FROM clientes where id='"+xDocumento+ "'";
					
			SqlBD codigoSql = new SqlBD();
				
			ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
			try {
						
			while (consulta.next()) {
				setId(consulta.getInt("id"));
				setDocumentoIdentidad(consulta.getString("doc_identidad"));
				setCliente(consulta.getString("cliente"));
				setTelefono1(consulta.getString("telefono1"));
				setTelefono2(consulta.getString("telefono2"));
				setDireccion(consulta.getString("direccion"));
				setCorreo(consulta.getString("email"));
				}
			}catch (SQLException e) {

				e.printStackTrace();
			}
				
			codigoSql.Desconectar();
			if(this.id==0)
					return false;
			else return true;
		}//fin buscar
		//------------------>create<---------------------
		public boolean create(){
			
			if((documentoIdentidad!=null)&&
				(cliente!=null)&&
				(telefono1!=null)&&
				(direccion!=null)){
				
					String sentenciaSql="INSERT INTO clientes (doc_identidad,cliente,telefono1,telefono2,direccion,email)"
							+ "VALUES ('"+documentoIdentidad+"','"+cliente.toUpperCase()+"','"
							+telefono1+"','"+telefono2+"','"+direccion.toUpperCase()+"','"
							+correo+"')";
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
			if((documentoIdentidad!=null)&&
					(cliente!=null)&&
					(telefono1!=null)&&
					(direccion!=null)){
				
				
				String sentenciaSql="UPDATE clientes SET "
						+ "cliente='"+ cliente.toUpperCase()+"', telefono1='"+telefono1
						+"',telefono2='"+telefono2+"',direccion='"+direccion.toUpperCase()
						+"',email='"+correo+"' where doc_identidad='"+this.documentoIdentidad+"'";
			
				SqlBD codigoSql = new SqlBD();
				if(codigoSql.agregarRegistro(sentenciaSql))
					return true;
				else
					return false;
			}
			else return false;
		}
		//-------->delete<------------
		public boolean delete(){

			String sentenciaSql = "DELETE FROM clientes where doc_identidad='"+documentoIdentidad+ "'";
				
			if((documentoIdentidad!=null)){
			
				SqlBD codigoSql = new SqlBD();
				if(codigoSql.agregarRegistro(sentenciaSql))
					return true;
				else
					return false;
			}
			else return false;
		   
			
		}
		// fin delete
				
}//fin de la clase
