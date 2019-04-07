/**
 * 
 * @author Flavia Bonanni
 */

public abstract class Animale
{
    public enum Taglia  { PICCOLA, MEDIA, GRANDE }

    private String verso;
    private int zampe;
    private Taglia taglia;

    public void setNumeroDiZampe(int x) { zampe = x; }
    public void setVerso(String x) { verso = x; }
    public void setTaglia(Taglia x) { taglia = x; }

    public void emettiVerso() { System.out.print(verso); }

    public int getNumeroDiZampe() { return zampe; }

    public Taglia getTaglia() { return taglia; }
	public void becca() {
		// TODO Auto-generated method stub
		
	}
}
