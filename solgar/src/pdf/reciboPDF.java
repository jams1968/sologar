package pdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.ImageIcon;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import controladoresBD.SqlBD;
import librerias.Funciones;
import modelos.Cliente;
import modelos.Recepcion;
import modelos.Reparacion;
import modelos.TipoAparato;
import modelos.Usuario;
import vistas.VistaRecepcion;

public class reciboPDF {
	private PdfPTable tablaDetalle;
	private PdfPCell cell;
	private Document documento;
	private PdfWriter writer;
	private String salida,titulo, parrafo;
	private Recepcion regRecibo;
	private Usuario regUsuario;
	private Cliente regCliente;
	private TipoAparato regTipoAparato;
	private Reparacion regReparacion;
	private Funciones funciones;
	private Paragraph detalle,detalle2;
	private Paragraph lineaBlanco;
	
	public reciboPDF(int nRecibo){
		regRecibo=new Recepcion();
		regCliente=new Cliente();
		regUsuario=new Usuario();
		regReparacion=new Reparacion();
		
		regRecibo.read(nRecibo);
		regCliente.buscarID(regRecibo.getCliente_id());
		regUsuario.buscarID(regRecibo.getUsuario_id());
		
		writer=null;
		parrafo=null;
		funciones=new Funciones();
		funciones.chequearCarpeta("../solgar/reportesPdf");
		salida="../solgar/reportesPdf/reciboN"+regRecibo.getId()+".pdf";
		String salto="\n";
		lineaBlanco=new Paragraph(salto);
		
		try{
			 documento = new Document(PageSize.LETTER,10, 10, 10, 10);
			 writer = PdfWriter.getInstance(documento,new FileOutputStream(salida));
			 writer.setInitialLeading(5);
			
			
		      documento.open();
		 }catch(Exception error){}
		encabezado(1);
		titulo= "__________________________________________________________________________";
		detalle=new Paragraph(titulo,FontFactory.getFont(FontFactory.COURIER, 12));
		detalle.setAlignment(Element.ALIGN_CENTER);
		try {
			documento.add(detalle);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		encabezado(2);
		
		try{
			documento.close();
		}catch(Exception error){}
		
		
		File path = new File (salida);
		
		try{
			Desktop.getDesktop().open(path);
			
		}catch(Exception error){}
		
	}

	//------------------>encabezado<----------------------	
	public void  encabezado(int repetido) {
		
			titulo= "RECIBO N°:"+ regRecibo.getId();

			String fechaR = funciones.CambiarFechaVen(regRecibo.getFecha_recepcion());
			String fechaE = funciones.CambiarFechaVen(regRecibo.getFecha_entrega());
			
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
			
				detalle=new Paragraph(titulo,FontFactory.getFont(FontFactory.COURIER, 16, Font.UNDERLINE, BaseColor.BLUE));
				
				detalle.setAlignment(Element.ALIGN_CENTER);
				//Lo añadimos al documento
				documento.add(detalle);
			
				parrafo="Fecha Recepción:"+ fechaR;
			
				detalle=new Paragraph(parrafo,FontFactory.getFont(FontFactory.COURIER, 12));
				detalle.setAlignment(Element.ALIGN_RIGHT);
				documento.add(detalle);
				parrafo="Fecha Entrega:"+ fechaE;
				
				detalle=new Paragraph(parrafo,FontFactory.getFont(FontFactory.COURIER, 12));
				detalle.setAlignment(Element.ALIGN_RIGHT);
				documento.add(detalle);
			
				lineaBlanco=new Paragraph(salto);
				documento.add(lineaBlanco);
				//cliente
				String correo;
			
				
				if(regCliente.getCorreo()==null)
					correo="no posee correo electronico";
				else 
					correo=regCliente.getCorreo();
				//detalles del cliente
				tablaDetalle=new PdfPTable(6);
				tablaDetalle.setWidthPercentage(100);
				//etiqueta cedula
				PdfPCell celda=new PdfPCell(new Paragraph("CI o Rif:",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setBorder(PdfPCell.NO_BORDER);
				tablaDetalle.addCell(celda);
				//variable cedula
				celda=new PdfPCell(new Paragraph(regCliente.getDocumentoIdentidad(),FontFactory.getFont("arial",10,Font.BOLD)));
				celda.setBorder(PdfPCell.NO_BORDER);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				tablaDetalle.addCell(celda);
				
				//etiqueta cliente
				celda=new PdfPCell(new Paragraph("Cliente:",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setBorder(PdfPCell.NO_BORDER);
				tablaDetalle.addCell(celda);
				//variable cliente
				celda=new PdfPCell(new Paragraph(regCliente.getCliente(),FontFactory.getFont("arial",10,Font.BOLD)));
				celda.setBorder(PdfPCell.NO_BORDER);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				tablaDetalle.addCell(celda);
				
				//etiqueta celular
				celda=new PdfPCell(new Paragraph("Celular:",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setBorder(PdfPCell.NO_BORDER);
				tablaDetalle.addCell(celda);
				//variable celular
				celda=new PdfPCell(new Paragraph(regCliente.getTelefono1(),FontFactory.getFont("arial",10,Font.BOLD)));
				celda.setBorder(PdfPCell.NO_BORDER);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				tablaDetalle.addCell(celda);
		
				
				
				
				// ASIGNAS LAS MEDIDAS A LA TABLA (ANCHO)
				float[] medidaCeldas ={5,5,5,5,5,7};
						// {0.09f, 0.03f, 0.03f, 0.03f};
	
				tablaDetalle.setWidths(medidaCeldas);
				//tablaDetalle.addCell(celda);
				
				documento.add(tablaDetalle);
				
				//----->linea 2<-----
				//detalles del cliente
				tablaDetalle=new PdfPTable(4);
				tablaDetalle.setWidthPercentage(100);
				//etiqueta otro telefono
				celda=new PdfPCell(new Paragraph("Otro Teléfono:",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setBorder(PdfPCell.NO_BORDER);
				tablaDetalle.addCell(celda);
				//variable otro telefono
				celda=new PdfPCell(new Paragraph(regCliente.getTelefono2(),FontFactory.getFont("arial",10,Font.BOLD)));
				celda.setBorder(PdfPCell.NO_BORDER);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				tablaDetalle.addCell(celda);
				
				//etiqueta correo
				celda=new PdfPCell(new Paragraph("Correo Electrónico:",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setBorder(PdfPCell.NO_BORDER);
				tablaDetalle.addCell(celda);
				//variable otro telefono
				celda=new PdfPCell(new Paragraph(correo,FontFactory.getFont("arial",10,Font.BOLD)));
				celda.setBorder(PdfPCell.NO_BORDER);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				tablaDetalle.addCell(celda);
				
				
				
				float[] medidaCeldas1 ={3,6,3,5};
				tablaDetalle.setWidths(medidaCeldas1);
				//tablaDetalle.addCell(celda);
				
				documento.add(tablaDetalle);
				// {0.09f, 0.03f, 0.03f, 0.03f};

				
				//----->linea 3<-----
			
				tablaDetalle=new PdfPTable(4);
				tablaDetalle.setWidthPercentage(100);
				//etiqueta direccion
				celda=new PdfPCell(new Paragraph("Dirección:",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setBorder(PdfPCell.NO_BORDER);
				tablaDetalle.addCell(celda);
				//variable direccion
				celda=new PdfPCell(new Paragraph(regCliente.getDireccion(),FontFactory.getFont("arial",10,Font.BOLD)));
				celda.setBorder(PdfPCell.NO_BORDER);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				tablaDetalle.addCell(celda);
				
				//etiqueta tecnico
				celda=new PdfPCell(new Paragraph("Receptor:",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				celda.setBorder(PdfPCell.NO_BORDER);
				tablaDetalle.addCell(celda);
				//variable otro telefono
				celda=new PdfPCell(new Paragraph(regUsuario.getNombre()+" "+regUsuario.getApellido(),FontFactory.getFont("arial",10,Font.BOLD)));
				celda.setBorder(PdfPCell.NO_BORDER);
				celda.setHorizontalAlignment(Element.ALIGN_LEFT);
				tablaDetalle.addCell(celda);
				
				
				
				float[] medidaCeldas3 ={3,18,5,7};
				tablaDetalle.setWidths(medidaCeldas3);
				//tablaDetalle.addCell(celda);
				
				documento.add(tablaDetalle);
				
				//encabezado de datos
				documento.add(lineaBlanco);
				titulo= "ARTEFACTOS A REPARAR";
				detalle=new Paragraph(titulo,FontFactory.getFont(FontFactory.COURIER, 14, Font.UNDERLINE, BaseColor.BLUE));
				
				detalle.setAlignment(Element.ALIGN_CENTER);
				//Lo añadimos al documento
				documento.add(detalle);
				documento.add(lineaBlanco);
				//-------------------->artefactos<-----------
				tablaDetalle=new PdfPTable(7);
				tablaDetalle.setWidthPercentage(100);
				
				celda=new PdfPCell(new Paragraph("N°",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("Tipo Aparato",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("Información Cliente",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("Detalles Aparato",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				
				celda=new PdfPCell(new Paragraph("Diagnóstico Técnico",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				documento.add(tablaDetalle);
				
				celda=new PdfPCell(new Paragraph("Repuestos Bs",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				celda=new PdfPCell(new Paragraph("Mano Obra Bs",FontFactory.getFont("arial",10,Font.NORMAL)));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tablaDetalle.addCell(celda);
				
				
				//------------>detalle aparatos<-------------
				 //--------------
				 String sentenciaSql = "SELECT * FROM reparaciones a JOIN recepciones b on a.recepcion_id = b.id "
				 		+ "where b.id="+regRecibo.getId();
				 SqlBD codigoSql = new SqlBD();
				
					
					ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
					int contador=0;
					double mRep,mMo;
					mRep=0;
					mMo=0;
					try {
						
						while (consulta.next()) {
							regReparacion=new Reparacion();
							regTipoAparato=new TipoAparato();
							regTipoAparato.buscarID(consulta.getInt("tipo_aparato_id"));
							
							regReparacion.setDiagnostico_cliente(consulta.getString("diagnostico_cliente"));
							regReparacion.setDetalles_recepcion(consulta.getString("detalles_recepcion"));
							regReparacion.setDiagnostico_tecnico(consulta.getString("diagnostico_tecnico"));
							regReparacion.setMonto_repuestos(consulta.getDouble("precio_repuestos"));
							regReparacion.setMonto_mano_obra(consulta.getDouble("precio_mano_obra"));
							mRep+=regReparacion.getMonto_repuestos();
							mMo+=regReparacion.getMonto_mano_obra();
							contador++;
							celda=new PdfPCell(new Paragraph(""+contador,FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(regTipoAparato.getTipo(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(regReparacion.getDiagnostico_cliente(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(regReparacion.getDetalles_recepcion(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(regReparacion.getDiagnostico_tecnico(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(""+regReparacion.getMonto_repuestos(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
							celda=new PdfPCell(new Paragraph(""+regReparacion.getMonto_mano_obra(),FontFactory.getFont("arial",10,Font.NORMAL)));
							celda.setHorizontalAlignment(Element.ALIGN_CENTER);
							tablaDetalle.addCell(celda);
							
						}
					}catch (SQLException e) {

							e.printStackTrace();
					}
				
					codigoSql.Desconectar();
					float[] medidaCeldas4 ={1,5,4,4,4,3,3};
					tablaDetalle.setWidths(medidaCeldas4);
					
					documento.add(tablaDetalle);
					
					tablaDetalle=new PdfPTable(3);
					tablaDetalle.setWidthPercentage(100);
					celda=new PdfPCell(new Paragraph("Total Repuestos Bs.:"+mRep,FontFactory.getFont("arial",10,Font.BOLD)));
					celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
					celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
					tablaDetalle.addCell(celda);
					
					celda=new PdfPCell(new Paragraph("Total Mano Obra Bs.:"+mMo,FontFactory.getFont("arial",10,Font.BOLD)));
					celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
					celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
					tablaDetalle.addCell(celda);
					
					celda=new PdfPCell(new Paragraph("Total Recibo Bs.:"+(mRep+mMo),FontFactory.getFont("arial",10,Font.BOLD)));
					celda.setHorizontalAlignment(Element.ALIGN_RIGHT);
					celda.setBackgroundColor(BaseColor.LIGHT_GRAY);
					tablaDetalle.addCell(celda);
					
					float[] medidaCeldas5 ={5,5,5};
					tablaDetalle.setWidths(medidaCeldas5);
					documento.add(tablaDetalle);
					
					documento.add(lineaBlanco);
					documento.add(lineaBlanco);
					titulo= "__________________________";
					detalle=new Paragraph(titulo,FontFactory.getFont(FontFactory.COURIER, 12));
					detalle.setAlignment(Element.ALIGN_CENTER);
					documento.add(detalle);
					String caso;
					if(repetido==1) caso="Copia Cliente";
					else caso="Original Sologar";
					titulo= "Firma y Sello \n"+caso;
					detalle=new Paragraph(titulo,FontFactory.getFont(FontFactory.COURIER, 8));
					detalle.setAlignment(Element.ALIGN_CENTER);
					documento.add(detalle);
					
					
			
			}catch(Exception error){}

		}


	public static void main(String[] args) {
		new reciboPDF(6);

	}

}
