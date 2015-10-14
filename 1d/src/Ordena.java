import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Ordena {

	//Declaramos variables
	static Scanner sc;
	static String og,des;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		//Llamamos a métodos
		String Origen = ficheroOrigen();
		String Destino = ficheroDestino();
		
		sc.close();
		
		//Declaramos archivos file
		File origen = new File(Origen);
		File destino = new File(Destino);
		
		try {
			ordenarFichero(origen,destino,1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Método para introducir el nombre del fichero de origen
	public static String ficheroOrigen(){
	
		System.out.println("Introduce el nombre del archivo de origen:");
		og = sc.nextLine();
		return og;
	}
	
	//Método para introducir el nombre del fichero de destino
	public static String ficheroDestino(){
		
		System.out.println("Introduce el nombre del archivo de destino:");
		des = sc.nextLine();
		return des;
	}
	
	//Método que ordena el fichero de orden natural o inverso, depende del valor tipo_orden.
	//Si tipo_orden es 1 orden natural, si es 0 orden inverso
	public static void ordenarFichero (File origen, File destino, int tipo_orden) throws IOException{
		
		//Declaramos variables
		FileReader fr1 = new FileReader(origen);
		FileWriter fw1 = new FileWriter(destino);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		String contenido = "";
		ArrayList<Character> inverso=new ArrayList<Character>();
		int c1;

		//Leemos el archivo de origen y nos guardamos su contenido
		while((c1=fr1.read())!=-1){
			contenido=contenido+(char)c1;
		}
		
		//Si es 1 copiamos el archivo con orden natural
		if(tipo_orden==1){
			fw1.write(contenido);
		}else{
			//Si es 0 vamos a copiarlo a la inversa
			if(tipo_orden==0){
				
				//Copiamos el contenido en un ArrayList
				for(int i=0;i<contenido.length();i++){
					inverso.add(contenido.charAt(i));
				}
				
				//Convertimos ArrayList en Array
				char contenidoInverso[]=new char[inverso.size()];
				for(int j=0;j<inverso.size();j++){
					contenidoInverso[j] = inverso.get(j);
				}
				
				//Leemos el array a la inversa
				for(int k=contenidoInverso.length;k>0;k--){
					fw1.write(contenidoInverso[k-1]);
				}
			}
			
		}
		
		//Cerramos 
        fr1.close();
		fw1.close();
		bw1.close();
		
	}

}
