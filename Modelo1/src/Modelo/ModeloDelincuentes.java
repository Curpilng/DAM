package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloDelincuentes {

	private static String DELINCUENTES_LIST="Select * from delincuentes";
	private static String NOMBRE="nombre";
	private static String EDAD="edad";
	private static String SEXO="sexo";
	private static String NAC="nacionalidad";
	private static String DIR="direccion";
	private static String POB="poblacion";
	private static String ANT="antecedentes";
	
	//Almacenamiento de usuarios
	public ArrayList<String> nombres =null;
	public ArrayList<String[]> delincuentes = null;
	//Conexion
	private Connection conexion = null;
	private Statement instruccion = null;
	private ResultSet resultados = null;
	
	
	public ModeloDelincuentes(){
		//Obtenemos la conexion
		conexion = ConectarBD.getConexion();
		
	}
	
	public void guardarAntecedente(String nombreDelincuente,String antecedente){
		try{
			PreparedStatement pst = this.conexion.prepareStatement("UPDATE delincuentes SET antecedentes='"+antecedente+"' WHERE nombre='"+nombreDelincuente+"'");
			pst.executeUpdate();					
		}catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
	public ArrayList<String[]> getDelincuentes(String nombreDelincuente){
		delincuentes=new ArrayList<String[]>();
		try{
			instruccion = this.conexion.createStatement();
			resultados = instruccion.executeQuery("SELECT * FROM delincuentes WHERE nombre='"+nombreDelincuente+"'");

			while(resultados.next()){
				String[] delincuente = new String[7];
				delincuente[0]=resultados.getString(NOMBRE);
				delincuente[1]=resultados.getString(EDAD);
				delincuente[2]=resultados.getString(SEXO);
				delincuente[3]=resultados.getString(NAC);
				delincuente[4]=resultados.getString(DIR);
				delincuente[5]=resultados.getString(POB);
				delincuente[6]=resultados.getString(ANT);
				delincuentes.add(delincuente);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();

		}finally{
			try{
				resultados.close();
				instruccion.close();
			}catch(SQLException excepcion){
				excepcion.printStackTrace();
			}
		}
		
		return delincuentes;
	}
	
	public ArrayList<String> getUsuarios(){
			nombres = new ArrayList<String>();
		try {
			instruccion = this.conexion.createStatement();
			//Lanzamos consulta
			resultados = instruccion.executeQuery(DELINCUENTES_LIST);
			
			//Almacenamos en arraylist los nombres de los usuarios
			while(resultados.next()){
				nombres.add(resultados.getString(NOMBRE));
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
		return nombres;

	}
	
	
	
}
