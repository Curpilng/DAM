package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuariosModelo {
	//Select usuarios
	private static String USUARIOS_LIST="Select * from usuarios";
	private static String NOMBRE="nombre";
	
	//Almacenamiento de usuarios
	public ArrayList<String> usuarios =null;
	
	//Conexion
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet resultados = null;
	
	
	public UsuariosModelo(){
		//Obtenemos la conexion
		conexion = ConexionDB.getConexion();
		
		usuarios = new ArrayList<String>();
	}
	
	public ArrayList getUsuarios(){
		try {
			instruccion = this.conexion.createStatement();
			//Lanzamos consulta
			resultados = instruccion.executeQuery(USUARIOS_LIST);
			
			//Almacenamos en arraylist los nombres de los usuarios
			while(resultados.next()){
				usuarios.add(resultados.getString(NOMBRE));
			}
			
			return usuarios;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return usuarios;
		}finally{
			try{
				resultados.close();
				instruccion.close();
				conexion.close();
			}catch(SQLException excepcion){
				excepcion.printStackTrace();
			}
		}
	}
	
}
