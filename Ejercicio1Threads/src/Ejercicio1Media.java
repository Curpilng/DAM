
public class Ejercicio1Media extends Thread {
	
	int alea[] = new int[100];
	
	//Constructor
	public Ejercicio1Media(int aleatorios[]){
		super();
		this.alea = aleatorios;
	}
	
	//Inicio del thread.
	@Override
	public void run(){
		calculaMedia(alea);
	}
	
	//Método para calcular la media.
	public void calculaMedia(int aleatorios[]){
		int media = 0;
		
		for(int i=0;i<aleatorios.length;i++){
			media = media + aleatorios[i];
		}
		
		media = media/aleatorios.length;
		System.out.println("La media es: "+media);
		
	}
	

}
