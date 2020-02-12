import java.util.Scanner;

/**
 * 
 * @author Flavia Bonanni
 */

public class GiocoDelQuindici
{
    private int[][] tabella;

    // Costruttore deve inizializzare una tabellina 4x4 con 15 tessere posizionate casualmente.
    public GiocoDelQuindici()
    {
        tabella = new int[4][4];
        /* solo per testing
        int daPiazzare = 1;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                tabella[i][j] = daPiazzare;
                daPiazzare++;
            }
        }
        tabella[3][2] = 0;
        tabella[3][3] = 15;
        */
        mischia();
    }

    public void play()
    {
        while (!vinto())
        {
            stampa();
            Scanner scan = new Scanner(System.in);
            System.out.println("Indicare coordinata y, coordinata x, e direzione [su, giù, sinistra, destra], separate da virgola e senza spazio. Esempio: 3,2,giu");
            String myLine = scan.nextLine();
            String[] input = myLine.split(",");
            scorri(Integer.parseInt(input[0]), Integer.parseInt(input[1]), input[2]);
        }
        System.out.println("Hai vinto!");
    }
    //Implementare un metodo vinto che restituisce un booleano corrispondente alla vincita del giocatore
    //ovvero se le caselle sono da 1 a 15 con lo spazio in posizione 16.
    public boolean vinto()
    {
        boolean ordine = false;
        int numeroGiusto = 1;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (tabella[i][j] == numeroGiusto)
                {
                    numeroGiusto++;
                }
            }
        }
        if (numeroGiusto == 16 && tabella[3][3] == 0) { ordine = true; }
        return ordine;
    }

    /**
     * 
     * @param x posizione della casella
     * @param y posizione della casella
     * @param direzione in cui spostare la casella
     */
    public void scorri(int x, int y, String direzione)
    {
        int daSpostare = tabella[x][y];
        tabella[x][y] = 0;
        switch(direzione)
        {
            case "su":
                x--;
                break;
            case "giù":
                x++;
                break;
            case "sinistra":
                y--;
                break;
            case "destra":
                y++;
                break;
        }
        tabella[x][y] = daSpostare;
    }

    // Implementare un metodo privato mischia che dispone casualmente le tessere - utilizzato anche dal costruttore.
    public void mischia()
    {
        int cifra = 1;

        while (cifra < 16)
        {
            int rand1 = (int) (Math.random() * 4);
            int rand2 = (int) (Math.random() * 4);
            if (tabella[rand1][rand2] == 0)
            {
                tabella[rand1][rand2] = cifra;
                cifra++;
            }
        }
    }

    public void stampa()
    {
        System.out.println("    0  1  2  3 X");
        System.out.println("_______________");
        int coordinataY = 0;
        for (int i = 0; i < 4; i++)
        {
            System.out.print(coordinataY+"|");
            coordinataY++;
            for (int j = 0; j < 4; j++)
            {

                if (tabella[i][j] == 0) { System.out.print("  _"); }
                else
                {
                    if (tabella[i][j] < 10) { System.out.print("  " + tabella[i][j]); }
                    else { System.out.print(" " + tabella[i][j]); }
                }
            }
            System.out.println();
        }
        System.out.println("Y");
    }

    public static void main(String[] args)
    {
        GiocoDelQuindici gioco = new GiocoDelQuindici();
        gioco.play();
    }
}
