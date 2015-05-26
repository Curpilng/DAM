package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloUsuarios {
	//Select usuarios
	private static String USUARIOS_LIST="Select * from usuarios";
	private static String USUARIO="usuario";
	private static String PASS="pass";

	
	//Almacenamiento de usuarios
	public ArrayList<String> usuarios =null;
	public String pass;
	
	//Conexion
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet resultados = null;
	
	
	public ModeloUsuarios(){
		//Obtenemos la conexion
		conexion = ConectarBD.getConexion();
		
	}
	
	public String logIn(String usuario){
		try {
			instruccion = this.conexion.createStatement();
			//Lanzamos consulta
			resultados = instruccion.executeQuery("Select pass from usuarios where usuario='"+usuario+"'");
			
			//Almacenamos en arraylist los nombres de los usuarios
			while(resultados.next()){
				pass = resultados.getString(PASS);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				resultados.close();
				instruccion.close();
			}catch(SQLException excepcion){
				excepcion.printStackTrace();
			}
		}
		return pass;
	}
	
	public ArrayList<String> getUsuarios(){
		usuarios = new ArrayList<String>();
		try {
			instruccion = this.conexion.createStatement();
			//Lanzamos consulta
			resultados = instruccion.executeQuery(USUARIOS_LIST);
			
			//Almacenamos en arraylist los nombres de los usuarios
			while(resultados.next()){
				usuarios.add(resultados.getString(USUARIO));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				resultados.close();
				instruccion.close();
			}catch(SQLException excepcion){
				excepcion.printStackTrace();
			}
		}
		return usuarios;
	}
	
}