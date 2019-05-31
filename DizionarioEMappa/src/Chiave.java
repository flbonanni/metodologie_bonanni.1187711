/**
 * Chiave di una coppia
 * @author Flavia Bonanni
 */

public class Chiave implements Comparable<Chiave>
{
	private int k;
	
	public Chiave(int k) { this.k = k; }
	
	public Integer getK() { return k; }

	@Override
	public int compareTo(Chiave c) { return this.getK().compareTo(c.getK()); }
	
	@Override
	public String toString() { return k+"|"; }
}
