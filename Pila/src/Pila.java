import java.util.Arrays;

/**
 * Classe generica Pila implementata mediante
 * lista di elementi (provate anche con l’array)
 * La classe è costruita con la dimensione iniziale dell’array
 * 
 * @author Flavia Bonanni
 * @param <T> tipo di oggetto da mettere/togliere dalla Pila
 */

public class Pila<T>
{
	public int size;
	private T[] tArr; // Object[] tArr
	private int k = -1;
	
	@SuppressWarnings("unchecked")
	public Pila(int size)
	{
		this.size = size;
		tArr = (T[])new Object[size]; // tArr = (Object[]) new Object[size];
	}

	/**
	 * inserisce un elemento in cima alla pila
	 * @param o elemento da inserire
	 */
	public void push(T o) // push(Object o)
	{
		if (k == tArr.length-1) tArr = Arrays.copyOf(tArr, tArr.length*2);
		tArr[++k] = o;
	}

	/**
	 * restituisce l’elemento in cima alla pila
	 * @return elemento in cima alla pila
	 */
	public T peek() // public Object peek
	{
		if (k == -1) return null;
		return tArr[k];
	}

	/**
	 * elimina e restituisce l’elemento in cima alla pila
	 * @return elemento in cima alla pila
	 */
	public T pop() // public Object pop
	{
		if (k == -1) return null;
		return tArr[k--];
	}
	
	/**
	 * restituisce true se la pila è vuota
	 * @return true se la pila è vuota
	 */
	public boolean isEmpty()
	{
		return (k == -1) ? true : false;
	}
}