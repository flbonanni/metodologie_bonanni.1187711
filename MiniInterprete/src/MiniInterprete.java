import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * 
 * @author Flavia Bonanni
 * @param <T> tipo da interpretare
 */

public class MiniInterprete<T>
{
	private T tipo;
	
	public MiniInterprete(T tipo) { this.tipo = tipo; }
	
	public Object parse(String nomeMetodoEParametri)
	{
		Class<?> c = tipo.getClass();
		Method[] metodi = c.getDeclaredMethods();
		String nomeMetodo = nomeMetodoEParametri.substring(0, nomeMetodoEParametri.indexOf('('));
		String parametri = nomeMetodoEParametri.substring(nomeMetodoEParametri.indexOf('(')+1, nomeMetodoEParametri.indexOf(')'));
		String[] parametriDivisi = null;
		if (parametri.contains(","))
		{ 
			parametriDivisi = parametri.split(", "); 
		}
		else if (parametri.length() > 0)
		{
			parametriDivisi = new String[1];
			parametriDivisi[0] = parametri;
		}
		Method metodo = null;
		for (Method m : metodi)
		{
			if (m.getName().equals(nomeMetodo))
			{
				metodo = m;
				break;
			}
		}
		try 
		{
			if (parametriDivisi == null) return metodo.invoke(tipo);
			else
			{
				Parameter[] prmt = metodo.getParameters();
				Object[] objArr = new Object[parametriDivisi.length];
				for (int i = 0; i < prmt.length; i++)
				{
					if (prmt[i].getType().equals(int.class)) objArr[i] = Integer.parseInt(parametriDivisi[i]);
					else objArr[i] = parametriDivisi[i];
				}
				return metodo.invoke(tipo, objArr);
			}
		} 
		catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new MiniInterprete("ciao").parse("length()"));
		System.out.println(new MiniInterprete("ciao").parse("charAt(3)"));
	}
}
