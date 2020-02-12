/**
 * 
 * @author Flavia Bonanni
 */

public class Tabellone
{
    private int lunghezza;
    private Giocatore[] giocatori;
    private Casella[] tabellone;
    private boolean vinto;

    public Tabellone(int N, Giocatore... g)
    {
        this.lunghezza = N;
        this.giocatori = g;
        this.tabellone = new Casella[lunghezza];
        System.out.println("Lista di caselle generate, in ordine:");
        for (int i = 0; i < lunghezza-1; i++)
        {
            int random = (int) (Math.random() * 3);
            // int range = (max - min) + 1;
            // return (int)(Math.random() * range) + min;
            int range = (10 - (-10)) + 1;
            int random2 = (int) (Math.random() * range) + (-10);
            switch(random)
            {
                case 0:
                    tabellone[i] = new CasellaVuota();
                    System.out.println(i+": la casella è vuota");
                    break;
                case 1:
                    tabellone[i] = new CasellaSpostaGiocatore(random2);
                    System.out.println(i+": la casella sposta il giocatore di "+random2+" caselle");
                    break;
                case 2:
                    tabellone[i] = new CasellaPunti(random2);
                    System.out.println(i+": la casella aggiunge al giocatore di "+random2+" punti");
                    break;
            }
        }
        tabellone[lunghezza-1] = new CasellaVuota();
        System.out.println(lunghezza-1+": la casella è vuota");
        System.out.println("*************START*************");
    }

    public void posiziona()
    {
        for (int i = 0; i < giocatori.length; i++)
        {
            System.out.println("_____________________________");
            System.out.print("Turno del giocatore n. "+i+". ");
            giocatori[i].tiraDadi();
            if (giocatori[i].getPosizione() >= lunghezza) { giocatori[i].setPosizione(lunghezza+(lunghezza-2-giocatori[i].getPosizione())); System.out.println("Il giocatore n. "+i+" era andato oltre, ora è in posizione "+giocatori[i].getPosizione()+"."); }
            if (giocatori[i].getPosizione() < 0) { giocatori[i].setPosizione(0); System.out.println("Il giocatore è stato riportato all'inizio."); }
            checkCasella(giocatori[i]);
            // check se oltre o se vinto
            if (giocatori[i].getPosizione() == lunghezza-1)
            {
                System.out.println("Il giocatore ha vinto!");
                vinto = true;
            }
            if (giocatori[i].getPosizione() >= lunghezza) { giocatori[i].setPosizione(lunghezza+(lunghezza-2-giocatori[i].getPosizione())); System.out.println("Il giocatore n. "+i+" era andato oltre, ora è in posizione "+giocatori[i].getPosizione()+"."); }
            if (giocatori[i].getPosizione() < 0) { giocatori[i].setPosizione(0); System.out.println("Il giocatore è stato riportato all'inizio."); }
            else if (giocatori[i].getPosizione() != (lunghezza-1)) { System.out.println("Il giocatore è in posizione "+giocatori[i].getPosizione()+"."); }
        }
    }

    public boolean getVinto() { return vinto; }

    public void checkCasella(Giocatore g) { tabellone[g.getPosizione()].effetto(g); }
}
