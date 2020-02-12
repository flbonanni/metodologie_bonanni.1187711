import java.util.Map;
import java.util.TreeMap;

/**
 * Mappa che implementa un dizionario
 *  
 * @author Flavia Bonanni
 */

public class Mappa implements Dizionario 
{
	// CAMPI
	private Map<Chiave, Elemento> mappa = new TreeMap<Chiave, Elemento>();
	
	// ECCEZIONI
	@SuppressWarnings("serial")
	class ElementNotFoundException extends Exception
	{
		public ElementNotFoundException() { super(); }
	}
	
	@SuppressWarnings("serial")
	class ElementAlreadyContainedException extends Exception
	{
		public ElementAlreadyContainedException() { super(); }
	}
	
	// CHECKS
	public void checkKey(Chiave k) throws ElementNotFoundException
	{
		if (!(mappa.containsKey(k))) { throw new ElementNotFoundException(); }
	}
	
	public void checkUnique(Chiave k) throws ElementAlreadyContainedException
	{
		if (mappa.containsKey(k)) { throw new ElementAlreadyContainedException(); }
	}

	@Override
	/**
	 * Trova un elemento se presente
	 * @param k chiave dell'elemento da cercare
	 */
	public Elemento search(Chiave k)
	{
		boolean found = true;
		try
		{
			checkKey(k);
		}
		catch(ElementNotFoundException e)
		{
			found = false;
			System.out.println("Element not found.");
		}
		if (found) 
		{
			System.out.println(mappa.get(k));
			return mappa.get(k);
		}
		return null;
		
	}

	@Override
	/**
	 * Aggiunge una coppia al dizionario
	 * @param k chiave
	 * @param e elemento
	 */
	public void add(Chiave k, Elemento e) 
	{
		boolean add = true;
		try
		{
			checkUnique(k);
		}
		catch(ElementAlreadyContainedException a)
		{
			add = false;
			System.out.println("Element already contained in dictionary.");
		}
		if (add)
		{ 
			mappa.put(k, e);
			// System.out.println("Added element "+e+"."); 
		}
	}

	@Override
	/**
	 * Elimina una chiave dal dizionario
	 * @param k chiave dell'elemento da eliminare
	 */
	public Elemento delete(Chiave k) 
	{
		boolean delete = true;
		try
		{
			checkKey(k);
		}
		catch(ElementNotFoundException f)
		{
			delete = false;
			System.out.println("Element not found.");
		}
		if (delete) 
		{ 
			Elemento e = mappa.get(k);
			System.out.println("Deleted element "+e+".");
			mappa.remove(k);
			return e;
		}
		return null;
	}

	@Override
	public int size() { return mappa.size(); }
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (Chiave c: mappa.keySet())
		{
            String key = c.toString();
            String value = mappa.get(c).toString();  
            sb.append(key + " " + value);
            sb.append('\n');
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		Mappa m = new Mappa();
		Chiave c1 = new Chiave(1);
		Chiave c2 = new Chiave(2);
		Chiave c3 = new Chiave(3);
		Chiave c4 = new Chiave(4);
		Chiave c5 = new Chiave(5);
		Chiave c6 = new Chiave(6);
		Chiave c7 = new Chiave(7);
		Elemento e1 = new Elemento("- rupi kaur");
		Elemento e2 = new Elemento("first we leave the womb for air");
		Elemento e3 = new Elemento("in search of a better life");
		Elemento e4 = new Elemento("perhaps we are all immigrants");
		Elemento e5 = new Elemento("some of  us just happen to leave entire countries");
		Elemento e6 = new Elemento("then the suburbs for the filthy city");
		Elemento e7 = new Elemento("trading one home for another");
		m.add(c1, e4);
		m.add(c2, e7);
		m.add(c3, e2);
		m.add(c4, e6);
		m.add(c5, e3);
		m.add(c6, e5);
		m.add(c7, e1);
		System.out.println(m);
	}
}
