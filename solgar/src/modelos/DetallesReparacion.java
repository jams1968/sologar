package modelos;

public class DetallesReparacion {
	private int id;
	private String codigo;
	private int reparacion_id;
	private int repuesto_id;
	private int cantidad;

	//-------------------->constructor<-------------
	public DetallesReparacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//-------------> getter>----------------

	public int getId() {
		return id;
	}

	public int getReparacion_id() {
		return reparacion_id;
	}

	public int getRepuesto_id() {
		return repuesto_id;
	}

	public int getCantidad() {
		return cantidad;
	}
	public double getMonto(double precio){
		return this.cantidad*precio;
		
	}
	public String getCodigo() {
		return codigo;
	}
	//------------->setter<-------------------

	public void setId(int id) {
		this.id = id;
	}

	public void setReparacion_id(int reparacion_id) {
		this.reparacion_id = reparacion_id;
	}

	public void setRepuesto_id(int repuesto_id) {
		this.repuesto_id = repuesto_id;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
