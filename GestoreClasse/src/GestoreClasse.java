import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;
import java.util.TreeSet;

/**
 * Gestisce una classe tramite i meccanismi della reflection 
 * @author Flavia Bonanni
 */

public class GestoreClasse 
{
	private String nomeClasse;
	private Class<?> c = this.getClass();
	
	public GestoreClasse(String nomeClasse)
	{ 
		this.nomeClasse = nomeClasse;
	}
	
	/**
	 * restituisce i nomi dei campi
	 * @return nomi dei campi
	 */
	public Set<String> getNomiCampi()
	{
		Set<String> nomi = new TreeSet<>();
		Field[] fields = c.getDeclaredFields();
		for (Field f : fields) nomi.add(f.getName());
		return nomi;
	}
	
	/**
	 * restituisce i nomi dei metodi
	 * @return nomi dei metodi
	 */
	public Set<String> getNomiMetodi()
	{
		Set<String> nomi = new TreeSet<>();
		Method[] methods = c.getDeclaredMethods();
		for (Method f : methods) nomi.add(f.getName());
		return nomi;
	}
	
	/**
	 * restituisce nomi dei metodi che tornano un certo tipo
	 * @param tipo da tornare
	 * @return nomi dei metodi
	 */
	public Set<String> getNomiMetodi(Class<?> tipo)
	{
		Set<String> nomi = new TreeSet<>();
		Method[] methods = c.getDeclaredMethods();
		for (Method f : methods)
		{
			if (f.getReturnType().equals(tipo)) nomi.add(f.getName());
		}
		return nomi;
	}
	
	/**
	 * invoca il metodo su un oggetto
	 * @param nomeMetodo nome del metodo da invocare
	 * @param o oggetto
	 * @param parametri del metodo
	 */
	public void invoca(String nomeMetodo, Object o, Object ... parametri)
	{
		Method[] methods = o.getClass().getDeclaredMethods();
		for (Method m : methods)
		{
			int i = 0;
			boolean same = true;
			for (Parameter parametro : m.getParameters())
			{
				if (!parametro.getType().equals(parametri[i].getClass()))
				{
					if (parametro.getType().equals(int.class))
					{
						if (parametri[i].getClass().equals(Integer.class)) { same = true; }
						else
						{
							 same = false;
							 break;
						}
					}
					else if (parametro.getType().equals(byte.class))
					{
						if (parametri[i].getClass().equals(Byte.class)) { same = true; }
						else
						{
							 same = false;
							 break;
						}
					}
					else if (parametro.getType().equals(short.class))
					{
						if (parametri[i].getClass().equals(Short.class)) { same = true; }
						else
						{
							 same = false;
							 break;
						}
					}
					else if (parametro.getType().equals(long.class))
					{
						if (parametri[i].getClass().equals(Long.class)) { same = true; }
						else
						{
							 same = false;
							 break;
						}
					}
					else if (parametro.getType().equals(float.class))
					{
						if (parametri[i].getClass().equals(Float.class)) { same = true; }
						else
						{
							 same = false;
							 break;
						}
					}
					else if (parametro.getType().equals(double.class))
					{
						if (parametri[i].getClass().equals(Double.class)) { same = true; }
						else
						{
							 same = false;
							 break;
						}
					}
					else if (parametro.getType().equals(boolean.class))
					{
						if (parametri[i].getClass().equals(Boolean.class)) { same = true; }
						else
						{
							 same = false;
							 break;
						}
					}
					else
					{
						same = false;
						break;
					}
				}
				
				i++;
			}
			if (same)
			{
				try 
				{
					m.invoke(o, parametri);
				} 
				catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		GestoreClasse gc = new GestoreClasse("GestoreClasse");
		System.out.println(gc.getNomiCampi());
		System.out.println(gc.getNomiMetodi());
		System.out.println(gc.getNomiMetodi(Set.class));
		Cornice cornice = new Cornice();
		gc.invoca("printBorder", cornice, 3);
	}
}
