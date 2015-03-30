public class DatosGenerales {
	
	private String nombreDivisas[] = {"Dolares","Libras","Yen"};
	private Float valorDivisas[]={1.25f,0.74f,129.87f};
	
	
	public String[] getNombre(){
		return nombreDivisas;
	}
	
	public Float[] getValor(){
		return valorDivisas;
	}
}
