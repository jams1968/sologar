package modelos;

public class Repuestos {
	
	private int id;
	private String codigo;
	private String repuesto;
	private String marca;
	private int cantidad;
	private double precio_venta;
	private String descripcion;
	private int tipo_aparato_id;
	
	public Repuestos() {
		super();
	}

	public Repuestos(int id, String codigo, String repuesto) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.repuesto = repuesto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRepuesto() {
		return repuesto;
	}

	public void setRepuesto(String repuesto) {
		this.repuesto = repuesto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTipo_aparato_id() {
		return tipo_aparato_id;
	}

	public void setTipo_aparato_id(int tipo_aparato_id) {
		this.tipo_aparato_id = tipo_aparato_id;
	}

	@Override
	public String toString() {
		return id+"-"+codigo+"-"+repuesto;
	}
	
	
	
	
	
	

}
