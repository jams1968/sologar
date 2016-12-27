/******************************************************************************
 * Programa: ConexionBD.java
 * Objetivo: establece la conexion a MySql con la BD
 ******************************************************************************/
package controladoresBD;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class ConexionBD {
	
		protected String urlBD = null;
		protected String usuario=null;
		protected String clave = null;
		protected String baseDatos = null;
		
		protected java.sql.Connection con= null;
		protected java.sql.Statement stm=null;
		protected PreparedStatement pstm = null;
		protected ResultSet resultadoConsulta = null;
		
		//-------------->constructor<-----------
		public   ConexionBD(){
			
			try{
				// carga el driver
				Class.forName("com.mysql.jdbc.Driver");
				/*JOptionPane.showMessageDialog
				(null,"Conectado Satisfactoriamente a MYSQL",null,1);*/
				
			}catch(ClassNotFoundException e){
				JOptionPane.showMessageDialog
				(null,"Problemas con el Driver",null,0);
			}
		}//fin
		
	//-------------->conectar Base de Datos <-------------------- 
	public boolean Conectar( ){
		baseDatos="bd_sologar";
		urlBD = "jdbc:mysql://localhost/"+baseDatos;
		usuario = "root";
		clave = "";
		boolean salida = false;
		try{
			con = DriverManager.getConnection
						(urlBD,usuario,clave);
			/*JOptionPane.showMessageDialog
			(null,"Usted se ha Conectado a: "+
			baseDatos,null,1);*/
			salida = true;
		}catch(SQLException e){
			JOptionPane.showMessageDialog
			(null,"No puede abrir la Base de Datos",
					null,0);
		}
		return salida;
	}
	//--------------> desconectar Base de Datos <-------------------- 
	public boolean Desconectar(){
		boolean salida = false;
		try{
			con.close();
			/*JOptionPane.showMessageDialog
			(null,"Usted se ha Desconectado de: "+
			baseDatos,null,1);*/
			salida = true;
			
		}catch(SQLException e){
			
			JOptionPane.showMessageDialog
			(null,"No se puede cerrar la Base de Datos"
					,null,0);
		}
		return salida;
	}
}// fin de la clase
