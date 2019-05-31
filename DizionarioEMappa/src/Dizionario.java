/**
 * Interfaccia dizionario
 * @author Flavia Bonanni
 */

public interface Dizionario 
{
	Elemento search(Chiave k);
	
	void add(Chiave k, Elemento e);
	
	Elemento delete(Chiave k);
	
	int size();
}
