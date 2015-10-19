import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class StreamBytes {

	static Scanner sc;
	static String og,des;
	static FileInputStream fi = null;
	static FileOutputStream fo = null;
	static DataOutputStream dos = null;
	
	public static void main(String[] args) {
		abrirFichero();
	}
	
	/*Definir el perfil que se desee para esta función*/
	public static void copiaBytes(String origen, String destino) {
		int c;
		int bytes = 0;
		File file = null;
		try {
			file = new File(origen);
			fi = new FileInputStream(file);
			fo = new FileOutputStream(destino);
			dos = new DataOutputStream(fo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		/*try {
			while((c=fi.read())!=-1){
				bytes=bytes+1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		int i= (int)file.length();
		byte[] buffer = new byte[i];
		try {
			fi.read(buffer);
			fo.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			fi.close();
			fo.close();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/*Definir el perfil que se desee para esta función*/
	public static void abrirFichero() {
		sc = new Scanner(System.in);
		
		String Origen = ficheroOrigen();
		String Destino = ficheroDestino();
		
		sc.close();
		
		copiaBytes(Origen,Destino);
	}
	
	public static String ficheroOrigen(){
		
		System.out.println("Introduce el nombre del archivo de origen:");
		og = sc.nextLine();
		return og;
	}
	
	public static String ficheroDestino(){
		
		System.out.println("Introduce el nombre del archivo de destino:");
		des = sc.nextLine();
		return des;
	}
	
}
