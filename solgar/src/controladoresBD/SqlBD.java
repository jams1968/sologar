/********************************************************************************
 * Programa:SqlBD.java
 * Objetivo: ejecuta las distintas sentencias Sql
 *******************************************************************************/
package controladoresBD;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SqlBD extends ConexionBD{


	public SqlBD(){
		super();
		//this.Conectar();
	}
	
	
//-----------------------> agregar registro<-------------------------
public boolean agregarRegistro(String codigoSql){
	this.Conectar();				
	boolean salida = false;
	try{
		stm =  con.createStatement();
		stm.executeUpdate(codigoSql);
			salida = true;
	}catch (SQLException e) {
		//System.out.println(e);
	}
	
	this.Desconectar();
	return salida;
	}//---------fin de ingresar



//-----------------------------------> consultas de tabla<--------------------------
public ResultSet ConsultaTabla(String codigoSql){
	this.Conectar();
	this.resultadoConsulta=null;
	String sentencia=codigoSql;
	try{
		//this.Conectar();
		stm = con.createStatement();
		resultadoConsulta =(ResultSet) stm.executeQuery(sentencia);
		
		//this.Desconectar();
		}catch(Exception e){
		//System.out.println(e);
		}
		return resultadoConsulta;
	}//fin conculta



//------------------->crear tablas<-----------------
public boolean crearTabla(String codigoSql){
	boolean salida=false;
	this.Conectar();
	 try{
		stm = con.createStatement();
	 	stm.execute(codigoSql);
	 	salida=true;

	 }catch(SQLException e){}

	 this.Desconectar();
	 return salida;

}//fin de crear

}// fin d ela clase