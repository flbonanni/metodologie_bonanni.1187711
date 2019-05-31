/**
 * Volontario astratto
 * 
 * @author Flavia Bonanni
 */

public abstract class Volontario 
{
	protected Secchio s;
	
	public void riceviSecchio(Secchio s) { this.s = s; } 
	
	public void passaSecchio(Volontario v)
	{
		v.riceviSecchio(s);
		s = null;
	}
}
