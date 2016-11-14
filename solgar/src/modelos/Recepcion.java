package modelos;

public class Recepcion {
	private int id;
	private int persona_id;
	private int usuario_id;
	private String observaciones;
	private String fecha_recepcion;
	private String fecha_entrega;
	private double abono;
	private char status;

	//------------->constructor<-------------
	public Recepcion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recepcion(int id, int persona_id, int usuario_id, String observaciones, String fecha_recepcion,
			String fecha_entrega, double abono, char status) {
		super();
		this.id = id;
		this.persona_id = persona_id;
		this.usuario_id = usuario_id;
		this.observaciones = observaciones;
		this.fecha_recepcion = fecha_recepcion;
		this.fecha_entrega = fecha_entrega;
		this.abono = abono;
		this.status = status;
	}
	//----------------->setter<----------------

	public void setId(int id) {
		this.id = id;
	}

	public void setPersona_id(int persona_id) {
		this.persona_id = persona_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public void setFecha_recepcion(String fecha_recepcion) {
		this.fecha_recepcion = fecha_recepcion;
	}

	public void setFecha_entrega(String fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}

	public void setAbono(double abono) {
		this.abono = abono;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	//------->getters<-------------

	public int getId() {
		return id;
	}

	public int getPersona_id() {
		return persona_id;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public String getFecha_recepcion() {
		return fecha_recepcion;
	}

	public String getFecha_entrega() {
		return fecha_entrega;
	}

	public double getAbono() {
		return abono;
	}

	public char getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+"";
	}

}
