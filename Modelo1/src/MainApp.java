import Modelo.ConectarBD;
import Vista.Principal;


public class MainApp {
	

	public static void main(String[] args) {
		
		ConectarBD conectar = new ConectarBD("localhost","delincuentes","root","");
		
		if(conectar.connectDB()==true){
			System.out.println("Se ha conectado!");
		}else{
			System.out.println("No se ha podido conectar");
		}
		
		
		Principal principal = new Principal();
		principal.setVisible(true);

	}

}
