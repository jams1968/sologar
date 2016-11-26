package librerias;

import javax.swing.JLabel;
import javax.swing.JTextField;

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
	
	

}
