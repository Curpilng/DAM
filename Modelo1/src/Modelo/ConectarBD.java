package Modelo;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;


public class ConectarBD {
	// Datos de la conexion
	static final String CONTROLADOR_MYSQL="com.mysql.jdbc.Driver";

	//Datos de la Base de Datos
	private String url;
	private String bbdd;
	private String user;
	private String pass;
	
	//Conexion
	static Connection conexion = null;//Maneja la conexion
	

	public ConectarBD(String URL, String BBDD, String USER, String PASS){
		this.url=URL;
		this.bbdd=BBDD;
		this.user=USER;
		this.pass=PASS;
		
	}
	
	public boolean connectDB(){
		try{
			//Carga el controlador MySQL
			Class.forName(CONTROLADOR_MYSQL);
			//Conectarnos a la BBDD
			conexion = DriverManager.getConnection("jdbc:mysql://"+this.url+"/"+this.bbdd,this.user,this.pass);
		}catch(SQLException excepcionSQL){
			excepcionSQL.printStackTrace();
			return false;
		}catch(ClassNotFoundException noSeEncontro){
			noSeEncontro.printStackTrace();
			return false;
		}
	return true;
	}
	
	//Nos devuelve la conexion
	public static Connection getConexion(){
		return conexion;
	}
	
}
