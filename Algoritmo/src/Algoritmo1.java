
public class Algoritmo1 {
	
	

	public static void main(String[] args) {
		//Definimos las variables
		int miDinero=0;
		int dineroQuePierdo=0;
		int totalDinero=0;
		int ingresos[] ={25,3,60,40,12};
		int gastos[]={-30,-23,-38};
		//Codigo
		
		for(int i=0;i<ingresos.length;i++){
			miDinero+=ingresos[i];
			//Calculo todos mis ingresos.
		}
		
		for(int i=0;i<gastos.length;i++){
			dineroQuePierdo+=gastos[i];
			//Calculo todos mis gastos.
		}
		
		//Calculo el total
		totalDinero=miDinero+dineroQuePierdo;
		
		//Por Pantalla
		System.out.println("Mis ingresos son:"+miDinero);
		System.out.println("Mis gastos son:"+dineroQuePierdo);
		System.out.println("Mis ingresos totales:"+totalDinero);
		
		
	}
	
}
