/**
 * Volontario Fuoco
 * L'unico che può spegnere l'incendio
 * 
 * @author Flavia Bonanni
 */

public class VolontarioFuoco extends Volontario
{
	public void svuotaSecchio(Incendio i) throws BastaAcquaException
	{
		s.setPieno(false);
		
		try 
		{
			i.setIntensita(i.getIntensita() - 1);
		}
		catch(FuocoEstintoException e)
		{
			throw new BastaAcquaException();
		}
	}
}
