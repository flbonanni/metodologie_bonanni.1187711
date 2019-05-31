/**
 * Elemento di una coppia
 * @author Flavia Bonanni
 */

public class Elemento 
{
	private String linea;
	
	public Elemento(String linea) { this.linea = linea; }
	
	@Override
	public String toString() { return linea; }
}
