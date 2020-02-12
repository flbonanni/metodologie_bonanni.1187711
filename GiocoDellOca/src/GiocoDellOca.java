import java.util.Scanner;

/**
 * 
 * @author Flavia Bonanni
 */

public class GiocoDellOca
{
    private Tabellone T;
    private Giocatore[] g;

    public GiocoDellOca(int N, Giocatore... g)
    {
        this.T = new Tabellone(N, g);
        this.g = g;
    }

    public void giocaUnTurno()
    {
        T.posiziona();
    }

    public boolean vinto()
    {
        if (T.getVinto())
        {
            for (int i = 0; i < g.length; i++) System.out.print("Il giocatore "+i+" ha accumulato "+g[i].getPunti()+ " punti. ");
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        GiocoDellOca gdo = new GiocoDellOca(16, new Giocatore[] { new Giocatore(), new Giocatore() });
        do
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("_____________________________");
            System.out.println("Per giocare, premi un tasto e dai invio.");
            String next = scan.nextLine();
            gdo.giocaUnTurno();
        }
        while(!gdo.vinto());
    }
}
