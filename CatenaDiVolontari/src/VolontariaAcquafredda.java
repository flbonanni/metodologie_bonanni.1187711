/**
 * Volontaria Acquafredda
 * L'unica che può riempire il secchio
 * 
 * @author Flavia Bonanni
 */

public class VolontariaAcquafredda extends Volontario
{
	public void riempiSecchio(Secchio s)
	{
		s.setPieno(true);
	}
}
