package modelos;

public class TipoAparato {
	private int id;
	private String nombre;
	private char status;
	//------------>constructor<--------------
	public TipoAparato() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoAparato(int id, String nombre, char status) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.status = status;
	}
	//----->setter<---------------
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	//------->getters<-------------
	public int getId() {
		return id;
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
		return this.id+"-"+this.nombre;
	}

}
