import java.util.ArrayList;
import java.util.List;

/**
 * Catena di volontari
 *  
 * @author Flavia Bonanni
 */

public class FIRE 
{
	private Incendio i;
	private List<Volontario> catena = new ArrayList<>();
	
	public FIRE(Incendio i)
	{
		Secchio s = new Secchio();
		this.i = i;
		
		catena.add(new VolontariaAcquafredda());
		for (int j = 0; j < 3; j++)
		{
			catena.add(new VolontarioComune());
		}
		catena.add(new VolontarioFuoco());
		
		estinguiIncendio(s);
	}
	
	public void estinguiIncendio(Secchio s)
	{
		while(i.getIntensita() > 0)
		{
			catena.get(0).riceviSecchio(s);
			((VolontariaAcquafredda) catena.get(0)).riempiSecchio(s);
			for (int i = 0; i < 4; i++)
			{
				catena.get(i).passaSecchio(catena.get(i+1));
			}
			try
			{
				((VolontarioFuoco) catena.get(4)).svuotaSecchio(i);
			}
			catch(BastaAcquaException e)
			{
				break;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Incendio incendio = new Incendio();
		FIRE fire = new FIRE(incendio);
		Secchio s = new Secchio();
		fire.estinguiIncendio(s);
	}
}
