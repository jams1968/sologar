package modelos;

import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico {
	
	protected String titulo;
	protected String abcisa;
	protected String ordenada;
	protected DefaultCategoryDataset data;
	protected int orientacion;
	protected boolean leyenda;
	protected boolean etiqueta;
	protected boolean url;
	
	//------->constructores<-------------
	public Grafico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grafico(String titulo, String abcisa, String ordenada, DefaultCategoryDataset data, int orientacion,
			boolean leyenda, boolean etiqueta, boolean url) {
		super();
		this.titulo = titulo;
		this.abcisa = abcisa;
		this.ordenada = ordenada;
		this.data = data;
		this.orientacion = orientacion;
		this.leyenda = leyenda;
		this.etiqueta = etiqueta;
		this.url = url;
	}
	//--->getter y setter<---------

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAbcisa() {
		return abcisa;
	}

	public void setAbcisa(String abcisa) {
		this.abcisa = abcisa;
	}

	public String getOrdenada() {
		return ordenada;
	}

	public void setOrdenada(String ordenada) {
		this.ordenada = ordenada;
	}

	public DefaultCategoryDataset getData() {
		return data;
	}

	public void setData(DefaultCategoryDataset data) {
		this.data = data;
	}

	public int getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(int orientacion) {
		this.orientacion = orientacion;
	}

	public boolean isLeyenda() {
		return leyenda;
	}

	public void setLeyenda(boolean leyenda) {
		this.leyenda = leyenda;
	}

	public boolean isEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(boolean etiqueta) {
		this.etiqueta = etiqueta;
	}

	public boolean isUrl() {
		return url;
	}

	public void setUrl(boolean url) {
		this.url = url;
	}
	
	

}
