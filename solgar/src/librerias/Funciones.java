package librerias;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTextField;

import controladoresBD.SqlBD;

public class Funciones {
	//--------------_>metodo para encriptar<-----------
			public String Encriptar(String xCadena){
				String salida;
				xCadena=xCadena.trim();
				int[] valor=new int[xCadena.length()+1];
				int aleatorio=(int) (Math.random()*9)+1; // Generación de número aleatorio
				char devolverCadena;
				
				//Convertir a ASCII
				
				valor[0]=aleatorio;
				for(int i=0;i<xCadena.length();i++){
					valor[i+1]=(xCadena.charAt(i))+aleatorio;
					
				}
				valor[xCadena.length()]=(xCadena.charAt(xCadena.length()-1))+aleatorio;
				
			
				salida=String.valueOf(valor[0]);
				
				for(int i=1;i<valor.length;i++){
					devolverCadena=(char)valor[i];
					salida+=devolverCadena;
				}
				salida=salida.trim();
				return salida;
				
			}
			//-------------_> desencriptar<--------------
			public String Desencriptar(String xCadena){
				String salida=null;
				xCadena=xCadena.trim();
				int[] valor=new int[xCadena.length()-1];
				int aleatorio=Integer.parseInt(xCadena.substring(0,1));//aleatorio
				char devolverCadena;
				
				//Convertir en ASCII"
			
				for(int i=1;i<xCadena.length();i++){
					valor[i-1]=(xCadena.charAt(i))-aleatorio;
				}
				
				
				for(int i=0;i<valor.length;i++){
					if(i==0) salida=String.valueOf((char)valor[i]);
					else{
						salida+=(char)valor[i];
					}
					
				}
				salida=salida.trim();
				return salida;
				
			}	
//---------------> proximo Id<--------------------------
public int proximoID(String sentenciaSql){
			
	SqlBD codigoSql = new SqlBD();
						
	ResultSet consulta = codigoSql.ConsultaTabla(sentenciaSql);
	int valor=0;
	try {
			while (consulta.next()) {
				valor=Integer.parseInt(consulta.getString(1));
			}
		}catch (SQLException e) {

					e.printStackTrace();
	}
	

	return valor;
}//fin proximo	
//---------> chequear directorio y crea <-----------------------
public void chequearCarpeta(String carpeta){
	//"../reyconca/reportesPdf");
	File folder = new File(carpeta);
	if (!folder.isDirectory())
		folder.mkdir();
}
//--------------->cambiar fecha a USA<-------------------
public String CambiarFechaUSa(String xFecha){
	String[] dat1= xFecha.split("/");
	String dia,mes,anno;
	mes=dat1[1];
	dia=dat1[0];
	anno=dat1[2];
	String fecha2=anno+"/"+mes+"/"+dia;
	
	
	return fecha2;
	
}
//--------------->cambiar fecha a Ven<-------------------
public String CambiarFechaVen(String xFecha){
	String[] dat1= xFecha.split("-");
	String dia,mes,anno;
	mes=dat1[1];
	dia=dat1[2];
	anno=dat1[0];
	String fecha2=dia+"/"+mes+"/"+anno;
	
	
	return fecha2;
	
}


}//fin de la clase
