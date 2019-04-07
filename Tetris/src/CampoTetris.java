/**
 * 
 * @author Flavia Bonanni
 */

public class CampoTetris
{
    private String[][] campo;
    private int righe;
    private int colonne;

    public CampoTetris(CampoTetris copia)
    {
        this.righe = copia.righe;
        this.colonne = copia.colonne;
        String[][] copiacampo = new String[righe][colonne];
        for (int i = 0; i < righe; i++)
        {
            for (int j = 0; j < colonne; j++)
            {
                copiacampo[i][j] = copia.campo[i][j];
            }
        }
        this.campo = copiacampo;
    }

    public String[][] getCampo() { return campo; }

    public CampoTetris(int righe, int colonne)
    {
        this.righe = righe;
        this.colonne = colonne;
        campo = new String[righe][colonne];
        for (int i = 0; i < righe; i++)
        {
            for (int j = 0; j < colonne; j++)
            {
                campo[i][j] = " ";
            }
        }
    }

    public int getRighe() { return righe; }
    public int getColonne() { return colonne; }

    // FIXME: ho invertito all'interno dei due for j e i e b e a
    public void inserisci(int x, int y, Pezzo pezzo)
    {
        String[][] daInserire = pezzo.getTetramino();
        int a = 0;
        for (int i = x; i < x+3; i++)
        {
            int b = 0;
            for (int j = y; j < y+3; j++)
            {
                campo[j][i] = daInserire[b][a];
                b++;
            }
            a++;
        }
    }

    public boolean controlloLinea()
    {
        int piena = 0;
        boolean trovata = false;
        for (int i = 0; i < righe; i++)
        {
            for (int j = 0; j < colonne; j++)
            {
                if (campo[i][j] == "*") piena++;
            }
            if (piena == 10)
            {
                System.out.println("LINEA PIENA");
                trovata = true;
                for (int j = 0; j < colonne; j++)
                {
                    campo[i][j] = " ";
                }
            }
        }
        return trovata;
    }

    public void stampa()
    {
        // codice per stampa con riferimenti
        int a = 0;
        System.out.println(" Y| 01234567891 X");
        System.out.println("--|-------------");
        for (int i = 0; i < righe; i++)
        {
            if (a < 10) System.out.print(" "+a+"| ");
            else System.out.print(a+"| ");
            for (int j = 0; j < colonne; j++)
            {

                System.out.print(campo[i][j]);
            }
            a++;
            System.out.println();
        }
    }
}
