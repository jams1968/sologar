package pdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controladoresBD.SqlBD;
import librerias.Funciones;
import modelos.Cliente;
import modelos.Recepcion;
import modelos.Reparacion;
import modelos.Repuesto;
import modelos.TipoAparato;
import modelos.Usuario;


public class repuestosPDF {
	private PdfPTable tablaDetalle;
	private PdfPCell cell;
	private Document documento;
	private PdfWriter writer;
	private String salida,titulo, parrafo;
	private TipoAparato regTipoAparato;
	private Repuesto regRepuesto;
	private Funciones funciones;
	private Paragraph detalle,detalle2;
	private Paragraph lineaBlanco;
	
	public repuestosPDF(){
		regTipoAparato=new TipoAparato();
		regRepuesto=new Repuesto();
		
		writer=null;
		parrafo=null;
		funciones=new Funciones();
		funciones.chequearCarpeta("../solgar/reportesPdf");
		salida="../solgar/reportesPdf/inventario_Repuestos.pdf";
		String salto="\n";
		lineaBlanco=new Paragraph(salto);
		
		try{
			 documento = new Document(PageSize.LETTER,10, 10, 10, 10);
			 writer = PdfWriter.getInstance(documento,new FileOutputStream(salida));
			 writer.setInitialLeading(5);
			
			
		      documento.open();
		 }catch(Exception error){}
		encabezado();
		
		
		try{
			documento.close();
		}catch(Exception error){}
		
		
		File path = new File (salida);
		
		try{
			Desktop.getDesktop().open(path);
			
		}catch(Exception error){}
		
	}

	//------------------>encabezado<----------------------	
	public void  encabezado() {
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String hoy = formato.format(fechaActual);
		
			titulo= "INVENTARIO DE REPUESTOS";

			
		
			try{
				Image fondo=null;
				
				fondo = Image.getInstance("../solgar/reportesPdf/logoSologa2r.png");
						
				fondo.setAlignment(Element.ALIGN_LEFT);
				fondo.scaleToFit(200,100);//escala de la imagen
				fondo.setAlignment(Image.LEFT|Image.UNDERLYING);
				documento.add(fondo);
				
				String salto="\n";
				Paragraph lineaBlanco=new Paragraph(salto);
				//for(int i=0;i<1;i++) documento.add(lineaBlanco);
				documento.add(lineaBlanco);
				documento.add(lineaBlanco);
				detalle=new Paragraph(titulo,FontFactory.getFont(FontFactory.COURIER, 16, Font.UNDERLINE, BaseColor.BLUE));
				
				detalle.setAlignment(Element.ALIGN_CENTER);
				//Lo añadimos al documento
				documento.add(detalle);
			
				parrafo="Fecha:"+ hoy;
			
				detalle=new Paragraph(parrafo,FontFactory.getFont(FontFactory.COURIER, 12));
				detalle.setAlignment(Element.ALIGN_RIGHT);
				documento.add(detalle);
				documento.add(lineaBlanco);
				
			
			
				//--------------------repuestos <-----------
				tablaDetalle=new PdfPTable(8);
				tablaDetalle.setWidthPercentage(100);
				
				PdfPCell celda=new PdfPCell(new Paragraph("N°",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("CÓDIGO",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("REPUESTO",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("MARCA",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				
				celda=new PdfPCell(new Paragraph("CANTIDAD",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				documento.add(tablaDetalle);
				
				celda=new PdfPCell(new Paragraph("PRECIO",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("DESCRIPCIÓN",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("TIPO APARATO",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				
				//------------>detalle aparatos<-------------
				 //--------------
				 String sentenciaSql = "SELECT * FROM repuestos a JOIN tipos_aparato b on a.tipo_Aparato_id = b.id ";
				 	
				 SqlBD codigoSql = new SqlBD();
				
					
					ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
					int contador=0;
					double mRep,mMo;
					mRep=0;
					mMo=0;
					try {
						
						while (consulta.next()) {
							
							
							regRepuesto.setId(consulta.getInt("id"));
							regRepuesto.setCodigo(consulta.getString("codigo"));
							regRepuesto.setRepuesto(consulta.getString("repuesto"));
							regRepuesto.setMarca(consulta.getString("marca"));
							regRepuesto.setCantidad(consulta.getInt("cantidad"));
							regRepuesto.setPrecio_venta(consulta.getDouble("precio_venta"));
							regRepuesto.setDescripcion(consulta.getString("descripcion"));
							regRepuesto.setAparato_tipo(consulta.getString("tipo"));
							
							
							regTipoAparato.buscarID(consulta.getInt("tipo_Aparato_id"));
						
							mMo+=(regRepuesto.getPrecio_venta()*regRepuesto.getCantidad());
							contador++;
							celda=new PdfPCell(new Paragraph(""+contador,FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							String cadena=null;
							if(regRepuesto.getCantidad()<5)
								cadena=""+regRepuesto.getCodigo()+"*";
							else
								cadena=""+regRepuesto.getCodigo()+" ";
							
							celda=new PdfPCell(new Paragraph(cadena,FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(regRepuesto.getRepuesto(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(regRepuesto.getMarca(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							
							
							celda=new PdfPCell(new Paragraph(""+regRepuesto.getCantidad(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(""+regRepuesto.getPrecio_venta(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(""+regRepuesto.getDescripcion(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							celda=new PdfPCell(new Paragraph(regTipoAparato.getTipo(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
						}
					}catch (SQLException e) {

							e.printStackTrace();
					}
				
					codigoSql.Desconectar();
					float[] medidaCeldas4 ={1,2,3,3,2,2,5,3};
					tablaDetalle.setWidths(medidaCeldas4);
					
					documento.add(tablaDetalle);
					
					tablaDetalle=new PdfPTable(1);
					tablaDetalle.setWidthPercentage(100);
				
					DecimalFormat formateador = new DecimalFormat("###,###.##");
					//Este daria a la salida 1,000
					
					celda=new PdfPCell(new Paragraph("Total Monto Repuestos Bs.:"+formateador.format (mMo),FontFactory.getFont("arial",10,Font.BOLD)));
					celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
					celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
					tablaDetalle.addCell(celda);
					
					float[] medidaCeldas5 ={5};
					tablaDetalle.setWidths(medidaCeldas5);
					documento.add(tablaDetalle);
					titulo= "* cantidad de repuestos  inferior a 5";
					detalle=new Paragraph(titulo,FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, BaseColor.BLACK));
					
					detalle.setAlignment(Element.ALIGN_RIGHT);
					//Lo añadimos al documento
					documento.add(detalle);
					documento.add(lineaBlanco);
					documento.add(lineaBlanco);
					
					
					
			
			}catch(Exception error){}

		}


	public static void main(String[] args) {
		new repuestosPDF();

	}

}
