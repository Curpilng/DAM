package Controlador;

import Modelo.ConexionDB;
import Modelo.UsuariosModelo;
import Vista.VistaApp;

public class GamesDBApp {

	public static void main(String[] args) {
		ConexionDB conexionMySQL;
		//UsuariosModelo usuarios;
		//Generamos la conexion con la Base de datos
		conexionMySQL = new ConexionDB("localhost","practica6","root","");
		
		//Comprobamos si se ha conectado correctamente
		if(conexionMySQL.connectDB()==true){
			System.out.println("Conectado con exito");
		}else{
			System.out.println("Error en la conexion");
		}
		
		//Lanzamos el JFrame
		VistaApp vistaApp = new VistaApp();
		vistaApp.setVisible(true);
	}

}
