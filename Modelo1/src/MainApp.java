import Modelo.ConectarBD;
import Vista.Principal;


public class MainApp {
	

	public static void main(String[] args) {
		
		//Creamos la conexión a la base de datos
		ConectarBD conectar = new ConectarBD("localhost","delincuentes","root","");
		
		//Probamos la conexión
		if(conectar.connectDB()==true){
			System.out.println("Se ha conectado!");
		}else{
			System.out.println("No se ha podido conectar");
		}
		
		//Lanzamos el JFrame 
		Principal principal = new Principal();
		principal.setVisible(true);

	}

}
