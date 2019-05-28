import java.util.ArrayList;
import java.util.List;

/**
 * Definiamo una sequenza " a gradini " come una
 * successione in cui ciascun elemento dista esattamente
 * 1 dal precedente (la sequenza «7 8 9 10 11 12 11 10 11
 * 
 * @author Flavia Bonanni
 */

public class SequenzaAGradini 
{
	private List<Integer> gradini = new ArrayList<>();
	
	class IncompatibleStepException extends Exception
	{ 
		public IncompatibleStepException() { super(); } 
	}
	
	/**
	 * Test per eventuali anomalie
	 * @param x valore da testare
	 * @throws IncompatibleStepException eccezione in caso di anomalia
	 */
	public void check(int x) throws IncompatibleStepException
	{
		if (gradini.size() > 0) 
		{ 
			if (gradini.get(gradini.size()-1)+1 != x && gradini.get(gradini.size()-1)-1 != x) throw new IncompatibleStepException();
		}
	}
	
	/**
	 * Aggiunge un valore alla sequenza
	 * @param x valore da aggiungere alla sequenza
	 */
	public void aggiungi(int x)
	{
		boolean semaphore = true;
	
		if (gradini.size() > 0)
		{
			try
			{
				check(x);
			}
			catch(IncompatibleStepException ISE)
			{
				semaphore = false;
				System.out.println("Stai cercando di mettere un '"+x+"' subito dopo un '"+ gradini.get(gradini.size()-1) +"'.");
				System.out.println("Non si può fare! Tenta con un valore diverso.");
			}
		}
		if (semaphore) gradini.add(x);
	}
	
	public void print()
	{
		System.out.println(gradini);
	}
	
	public static void main(String[] args)
	{
		SequenzaAGradini SAG = new SequenzaAGradini();
		SAG.aggiungi(11);
		SAG.aggiungi(12);
		SAG.aggiungi(11);
		SAG.aggiungi(10);
		SAG.print();
		
		SequenzaAGradini SAG2 = new SequenzaAGradini();
		SAG2.aggiungi(1);
		SAG2.aggiungi(2);
		SAG2.aggiungi(8);
		SAG2.aggiungi(7);
		SAG2.aggiungi(3);
		SAG2.print();
	}
}
