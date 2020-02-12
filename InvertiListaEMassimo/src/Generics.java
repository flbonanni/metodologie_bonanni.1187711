import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class Generics
{
	/**
	 * data in input una lista di elementi di tipo generico,
	 * restituisce un’altra lista con gli elementi in ordine invertito
	 * @param <T> tipo generico
	 * @param listaDiElementi di tipo generico,
	 * @return un’altra lista con gli elementi in ordine invertito
	 */
	static public <T> ArrayList<T> inverti(ArrayList<T> listaDiElementi)
	{
		ArrayList<T> listaInvertita = new ArrayList<>(listaDiElementi);
		Collections.reverse(listaInvertita);
		return listaInvertita;
	}

	/**
	 * 
	 * @param <T> tipo generico
	 * @param listaDiElementi di tipo generico,
	 * @return il valore massimo
	 */
	@SuppressWarnings("rawtypes")
	static public <T extends Number & Comparable> T max(ArrayList<T> listaDiElementi)
	{
		@SuppressWarnings("unchecked")
		T max = (T) Collections.max(listaDiElementi);
		return max;
	}

	public static void main(String[] args) {

		ArrayList<Double> listaDiDouble = new ArrayList<>();
		listaDiDouble.add(2.0);
		listaDiDouble.add(5.5);
		listaDiDouble.add(3.1);
		System.out.println(Generics.inverti(listaDiDouble));
		ArrayList<Integer> listaDiInteri = new ArrayList<>();
		listaDiInteri.add(2);
		listaDiInteri.add(5);
		listaDiInteri.add(3);
		System.out.println(Generics.max(listaDiInteri));
		System.out.println("***"); 
		System.out.println(Generics.max(listaDiDouble));
	}
}
