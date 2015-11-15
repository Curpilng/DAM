import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class Ejercicio2Principal {
	
private ThreadPoolExecutor executor;
	
	//Creamos un threadPool con 3 Threads.
	public Ejercicio2Principal(){
		executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(3);
	}
	
	//Método para lanzar la tarea.
	public void ejecutaTasca(Ejercicio2Capicua c){
		executor.execute(c);
	}
	
	//Método para apagar el threadPool
	public void acabaTasca(){
		executor.shutdown();
	}
	
	public static void main(String[] args) {
		
		//Array con 25 palabras.
		String palabras[] = {"hola","eae","fmggmf","capicua","valencia","etrttrte","hjmfmy","ffddsf","htthhtth","hrtshrh","hrts","srhrz","srgth","ujtdj","fdggt","bfdbdf","bgb","asdffdsa","adf","afsd","dfadfs","fsdafsdf","fdavsfa","fgdbb","fgdf"};
		
		Ejercicio2Principal principal = new Ejercicio2Principal();
		
		for(int i=0;i<palabras.length;i++){
			principal.ejecutaTasca(new Ejercicio2Capicua(palabras[i]));
		}
		
		principal.acabaTasca();
		

	}

}
