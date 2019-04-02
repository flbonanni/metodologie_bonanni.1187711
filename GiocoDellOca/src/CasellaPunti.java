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
        System.out.print("Questa casella dà "+x+" punti. ");
        g.setPunti(g.getPunti()+x);
    }
}

