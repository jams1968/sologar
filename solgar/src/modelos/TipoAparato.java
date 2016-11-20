package modelos;

public class TipoAparato {
	private int id;
	private String tipo;
	//------------>constructor<--------------
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"-"+this.tipo;
	}


	public TipoAparato() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TipoAparato(int id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
