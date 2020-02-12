/**
 * 
 * @author Flavia Bonanni
 */

public class CasellaPunti extends Casella
{
    private int x;

    public CasellaPunti(int x) { this.x = x; }

    public void effetto(Giocatore g)
    {
        System.out.print("Questa casella d� "+x+" punti. ");
        g.setPunti(g.getPunti()+x);
    }
}

