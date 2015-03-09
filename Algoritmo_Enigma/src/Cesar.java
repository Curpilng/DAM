
public class Cesar {
static String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
static String alfabetoEncriptado ="";
static String palabraEncriptada ="";
static String palabraDesencriptada ="";


/**Comprobamos si es primo relativo de 27,
 * es primo relativo si coincide el divisor solo con 1 y -1,
 * en este caso 27 tiene como divisor también el 3, 
 * asique todo aquel numero que tenga como divisor el 3 no será primo relativo
 */

public Boolean compruebaPrimoRelativo(int a){
	
	Boolean esPrimoRelativo;
	
	if(a % 3 == 0){
		
		esPrimoRelativo=false;
		
	}else{
		
		esPrimoRelativo=true;
	}
	
	return esPrimoRelativo;
	
}


//Encriptamos la palabra
public String encriptadorAfin(int a,int b, String p){
	
	String palabra = p;
	
	for(int i=0;i<alfabeto.length();i++){
		int c = (a*i + b) % 27;
		alfabetoEncriptado += alfabeto.charAt(c);
	}
	
	for(int i=0;i<palabra.length();i++){
		char letraPalabra = palabra.charAt(i);
		
		for(int j=0;j<alfabeto.length();j++){
			if(letraPalabra==alfabeto.charAt(j)){
				palabraEncriptada += alfabetoEncriptado.charAt(j);
				
			}else{
				if(letraPalabra==' '){
					palabraEncriptada += ' ';
				}
				
			}
			
		}
		
		
	}
	
	return palabraEncriptada;
	
}

//Desencriptamos la palabra
public String desencriptadorAfin(int a,int b, String p){
	
	String palabra = p;
	
	for(int i=0;i<alfabeto.length();i++){
		int c = (a*i + b) % 27;
		alfabetoEncriptado += alfabeto.charAt(c);
	}
	
	for(int i=0;i<palabra.length();i++){
		char letraPalabra = palabra.charAt(i);
		
		for(int j=0;j<alfabetoEncriptado.length();j++){
			if(letraPalabra==alfabetoEncriptado.charAt(j)){
				palabraDesencriptada += alfabeto.charAt(j);
				
			}else{
				if(letraPalabra==' '){
					palabraDesencriptada += ' ';
				}
				
			}
			
		}
		
		
	}
	
	return palabraDesencriptada;
	
}

}
