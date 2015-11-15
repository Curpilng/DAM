
public class Ejercicio1Minimo extends Thread {
	
	int alea[] = new int[100];
	
	//Constructor
	public Ejercicio1Minimo(int aleatorios[]){
		super();
		this.alea = aleatorios;
	}
	
	//Inicio del thread.
	@Override
	public void run(){
		valorMinimo(alea);
	}
	
	//Método para calcular el valor mínimo.
	public void valorMinimo(int aleatorios[]){
		int valorMinimo = aleatorios.length+1;
		
		for(int i=0;i<aleatorios.length;i++){
			if(aleatorios[i]<valorMinimo){
				valorMinimo = aleatorios[i];
			}
		}
		
		System.out.println("El valor minimo es: "+valorMinimo);
		
	}

}
