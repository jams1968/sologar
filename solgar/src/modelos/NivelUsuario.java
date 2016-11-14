/****************************************************************************
 * programa: NivelUsuario.java
 * objetivo: clase del modelo nivel de usuario
 ****************************************************************************/
package modelos;

public class NivelUsuario {
	private int id;
	private int nivel;
	private String nombre;
	private char status;
	//--------------------->constructores<-------------
	public NivelUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NivelUsuario(int id, int nivel, String nombre, char status) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.nombre = nombre;
		this.status = status;
	}
	//--------------->setters<-----------------
	public void setId(int id) {
		this.id = id;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	//----------------->getters<------------------
	public int getId() {
		return id;
	}
	public int getNivel() {
		return nivel;
	}
	public String getNombre() {
		return nombre;
	}
	public char getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nivel+"-"+this.nombre;
	}
	

}
