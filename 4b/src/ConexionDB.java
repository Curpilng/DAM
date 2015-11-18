import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ConexionDB {

	public static void main(String[] args) {
		
		//Variables
		Connection conexion;
		String url = "jdbc:postgresql://localhost/AD4A";
		String user = "postgres";
		String pw = "flo.dam2";
		
		//Cargamos la clase jdbc para poder obtener la conexión
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//Obtenemos la conexión con el DriverManager
		try {
			conexion = DriverManager.getConnection(url, user, pw);
			System.out.println("Conexión realizada");
			
			while(opcion(conexion)!=true){
				System.out.println("No se ha introducido correctamente");
			}
				
			conexion.close();
		} catch (SQLException e) {
			if(e.getSQLState().equals("28000")){
				System.out.println("Error de autentificación");
			}else{
				System.err.println("Error al realizar la conexión con la base de datos");
			}
				
		}
		
		
		

	}
	
	//Método que realiza el select
	public static void select(Connection conexion){
		PreparedStatement pst;
		try {
			Statement instruccion = (Statement) conexion.createStatement();
			ResultSet conjuntoResultados = instruccion.executeQuery("SELECT * FROM \"Asignatura\"");
			while(conjuntoResultados.next()){
				System.out.print("Id: "+conjuntoResultados.getObject("id")+" ");
				System.out.print("Asignatura: "+conjuntoResultados.getObject("asignatura")+" ");
				System.out.print("Nombre: "+conjuntoResultados.getObject("nombre")+" ");
				System.out.print("Inicio: "+conjuntoResultados.getObject("inicio")+" ");
				System.out.print("Fin: "+conjuntoResultados.getObject("fin")+" ");
				System.out.print("Entregada: "+conjuntoResultados.getObject("entregada"));
				System.out.println();
			}
			
			instruccion.close();
			conjuntoResultados.close();
		} catch (SQLException e) {
			System.err.println("Error al realizar el select");
		}
			
	}
	
	//Método que realiza el insert
	public static void insertar(Connection conexion){
		PreparedStatement pst;
		try {
			pst = conexion.prepareStatement("Insert into \"Asignatura\"(asignatura,nombre,inicio,fin,entregada) Values ('fdgdf','5a','2015-12-09','2015-12-10',true);");
			pst.execute();
			System.out.println("Insert realizado con éxito");
			pst.close();
		} catch (SQLException e) {
			System.err.println("Error al realizar el insert");
		}
			
	}
	
	//Método que controla la opción escogida
	public static Boolean opcion(Connection conexion){
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce '1' para realizar un select o '2' para un insert" );
		String opcion = sc.nextLine();
		
		if(opcion.equals("1")){
			select(conexion);
			sc.close();
			return true;
		}else{
			if(opcion.equals("2")){
				insertar(conexion);
				sc.close();
				return true;
			}
		}
		
		return false;
		
	}

}