import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListaDiInteri<T> 
{	
	public static class ClassBuilder<T> 
	{
		private List<T> lista = new ArrayList<>();
		
		public ClassBuilder add(int ... intArr)
		{
			List<Integer> listaInt = (List<Integer>) lista;
			for (int i : intArr) listaInt.add(i);
			lista = (List<T>) listaInt;
			return this;
		}
		
		public ClassBuilder removeAll (Predicate<Integer> p)
		{
			for (int i = 0; i < lista.size(); i++)
			{
				if (p.test((Integer) lista.get(i))) 
				{
					lista.remove(i);
					i--;
				}
			}
			return this;
		}
		
		public ClassBuilder repeat(int k)
		{
			int size = lista.size();
			for (int i = 0; i < k; i++)
			{
				for (int j = 0; j < size; j++)
				{
					lista.add(lista.get(j));
				}
			}
			return this;
		}
		
		public ClassBuilder toLong()
		{
			int size = lista.size();
			List<Long> listaLong = new ArrayList<Long>(size);
			for (int i = 0; i < size; i++) 
			{
			    listaLong.add(((Integer) lista.get(i)).longValue());
			}
			lista = (List<T>) listaLong;
			return this;
		}
		
		public ListaDiInteri build()
		{
			ListaDiInteri ldi = new ListaDiInteri();
			
			ldi.lista = this.lista;
			
			return ldi;
		}
	}
	
	private List<T> lista = new ArrayList<>();
	
	private ListaDiInteri() { }
	
	@Override
	public String toString() { return lista.toString(); }
	
	public static void main(String[] args)
	{
		ListaDiInteri ldi = new ListaDiInteri.ClassBuilder()
				.add(1, 2, 3, 4)
				.removeAll(s -> (Integer)s <= 2)
				.repeat(3)
				.toLong()
				.build();
		System.out.println(ldi);
	}
}
