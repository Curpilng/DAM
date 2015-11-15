
public class Ejercicio1Principal {
	
	public static void main(String[] args) {
		
		//Creamos array de 100 elementos y lo llenamos con números aleatorios.
		int aleatorios[] = new int[100];
		
		for(int i=0;i<aleatorios.length;i++){
			aleatorios[i] = (int)Math.floor(Math.random()*101);
			System.out.println("Valor "+(i+1)+": "+aleatorios[i]);
		}
		
		//Iniciamos los 3 threads, pasandoles el array de números.
		Ejercicio1Media media = new Ejercicio1Media(aleatorios);
		media.start();
		try {
			media.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Ejercicio1Maximo maximo = new Ejercicio1Maximo(aleatorios);
		maximo.start();
		try {
			maximo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Ejercicio1Minimo minimo = new Ejercicio1Minimo(aleatorios);
		minimo.start();
		
	}
	
	
	

	
	

}
