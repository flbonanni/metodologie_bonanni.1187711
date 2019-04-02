/**
 * 
 * @author Flavia Bonanni
 */

public class CasellaSpostaGiocatore extends Casella
{
    private int x;

    public CasellaSpostaGiocatore(int x) { this.x = x; }

    public void effetto(Giocatore g)
    {
        System.out.print("Questa casella sposta di "+x+" caselle. ");
        g.setPosizione(g.getPosizione()+x);
    }
}
