/**
 * Incendio
 *  
 * @author Flavia Bonanni
 */

public class Incendio 
{
	private int intensita;
	
	public int getIntensita() { return intensita; }
	public void setIntensita(int i) throws FuocoEstintoException
	{ 
		intensita = i;
		if (intensita == 0) throw new FuocoEstintoException();
	}
	
	public Incendio()
	{
		intensita = (int)(Math.random() * 10)+1;
		System.out.println("Incendio intensità "+intensita);
	}
}
