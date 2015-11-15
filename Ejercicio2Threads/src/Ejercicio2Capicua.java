
public class Ejercicio2Capicua implements Runnable {
	private String palabra;

	//Constructor
	public Ejercicio2Capicua(String palabra){
		this.palabra = palabra;
	}

	//Inicio del thread.
	@Override
	public void run() {

		if(this.capicua(palabra)){
			System.out.println(palabra+" es capicua");
		}else{
			System.out.println(palabra+" no lo es");
		}

	}

	//Método para saber si es capicua o no.
	public boolean capicua(String cadena){

		String s1 ="";
		String s2 ="";
		char ch1[] = cadena.toCharArray();

		for(int i=0;i<ch1.length;i++){
			s1 = s1+ch1[i];
		}

		for(int i=ch1.length;i>0;i--){
			s2 = s2+ch1[i-1];
		}

		if(s1.equals(s2)){
			return true;
		}else{
			return false;
		}


	}

}
