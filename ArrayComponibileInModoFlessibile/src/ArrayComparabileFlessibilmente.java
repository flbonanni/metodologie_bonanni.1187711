import java.util.Comparator;
import java.util.Arrays;

/**
 * 
 * @author Flavia Bonanni
 *  Si progetti una classe generica che modella un array di
	elementi
	La classe fornisce un metodo di comparazione standard in ordine
	naturale del tipo generico
 */

public class ArrayComparabileFlessibilmente<T extends Comparable<?>> implements Comparable<Object>
{
	private T[] valori;

	public ArrayComparabileFlessibilmente(T ... valori) { this.valori = valori; } 
	
	private Comparator<ArrayComparabileFlessibilmente> comparatore = CONFRONTO_NORMALE; 

	final public static Comparator<ArrayComparabileFlessibilmente>
			CONFRONTO_NORMALE = (a1, a2) -> Arrays.compare(a1.getValori(), a2.getValori()),
			LESSICOGRAFICO = (a1, a2) -> a1.getValori()[0].compareTo(a2.getValori()[0]),
			LESSICOGRAFICO_INVERSO = LESSICOGRAFICO.reversed(),
			DIMENSIONE = (a1, a2) -> ((Comparable<Integer>) a1.getValori().length).compareTo(a2.getValori().length); 
	
	@Override
	public int compareTo(Object o) { return comparatore.compare(this, (ArrayComparabileFlessibilmente<T>) o); } 
	
	public T[] getValori() { return valori; }
	
	public void setFunction(Comparator<ArrayComparabileFlessibilmente> comparatore) { this.comparatore = comparatore; } 

	// TESTING
	public static void main(String[] args)
	{
		//ArrayComparabileFlessibilmente<Integer> acf1 = new ArrayComparabileFlessibilmente<>(1, 2, 3, 4);
		//ArrayComparabileFlessibilmente<Integer> acf2 = new ArrayComparabileFlessibilmente<>(99, 98);
		ArrayComparabileFlessibilmente<String> acf1 = new ArrayComparabileFlessibilmente<>("cane", "gatto");
		ArrayComparabileFlessibilmente<String> acf2 = new ArrayComparabileFlessibilmente<>("ananas");
		System.out.println(acf1.compareTo(acf2));
		acf1.setFunction(LESSICOGRAFICO);
		System.out.println(acf1.compareTo(acf2));
		acf1.setFunction(LESSICOGRAFICO_INVERSO);
		System.out.println(acf1.compareTo(acf2));
		acf1.setFunction(DIMENSIONE);
		System.out.println(acf1.compareTo(acf2));
	}
}
