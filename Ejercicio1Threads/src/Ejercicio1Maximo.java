
public class Ejercicio1Maximo extends Thread {
	
	int alea[] = new int[100];
	
	//Constructor
	public Ejercicio1Maximo(int aleatorios[]){
		super();
		this.alea = aleatorios;
	}
	
	//Inicio del thread.
	@Override
	public void run(){
		valorMaximo(alea);
	}

	//M�todo para calcular el valor m�ximo.
	public void valorMaximo(int aleatorios[]){
		int valorMaximo = 0;
		
		for(int i=0;i<aleatorios.length;i++){
			if(aleatorios[i]>valorMaximo){
				valorMaximo = aleatorios[i];
			}
		}
		
		System.out.println("El valor maximo es: "+valorMaximo);
		
	}

}


