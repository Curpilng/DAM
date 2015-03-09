import java.util.Scanner;


public class Enigma {
	static Cesar cesar = new Cesar();
	static int a;
	static int b = -1;
	static String palabra;
	static String palabraEncriptada;
	static String palabraDesencriptada;
	static Scanner sc;
	static int opcion;
	
	public static void main(String[] args) {

		introduceAB();
		eligeOpcion();
		palabra=introducePalabra().toUpperCase();
		if(opcion==1){
			
			palabraEncriptada = cesar.encriptadorAfin(a, b, palabra);
			System.out.println("La palabra encriptada es: "+palabraEncriptada);
			
		}else{
			
			palabraDesencriptada = cesar.desencriptadorAfin(a, b, palabra);
			System.out.println("La palabra desencriptada es: "+palabraDesencriptada);
		}
		

	}
	
	//Le pedimos al usuario que introduzca la palabra que quiere encriptar o desencriptar
	public static String introducePalabra(){
		
		sc = new Scanner(System.in);
		
		if(opcion==1){
			System.out.println("Introduce palabra para encriptar");
			palabra = sc.nextLine();
		}else{
			System.out.println("Introduce palabra para desencriptar");
			palabra = sc.nextLine();
			
		}
		sc.close();
		return palabra;
	}
	
	//Le pedimos al usuario que elija lo que va a hacer
	public static void eligeOpcion(){
		sc = new Scanner(System.in);
		while(opcion!=1 && opcion !=2){
		System.out.println("Introduce '1' para encriptar o '2' para desencriptar ");
		opcion = sc.nextInt();
		}
		
		
	}
	
	
	/*Introducimos a y b para realizar la encriptacion,
	o desencriptacion mas adelante. Tienen que ser un numero
	entre 0 y 26 incluyendolos. a tiene que ser primo relativo de 27 */
	public static void introduceAB(){
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce 'a', un numero entre 0 y 26, primo relativo de 27");	
		a = sc.nextInt();
		
		while(a<0 || a>26 || cesar.compruebaPrimoRelativo(a)!=true){
			System.out.println("Introduce 'a', un numero entre 0 y 26, primo relativo de 27");	
			a = sc.nextInt();
		}
		

		
		while(b<0 || b>26){
			System.out.println("Introduce 'b', un numero entre 0 y 26");	
			b = sc.nextInt();
		}
		
		
	}

}
