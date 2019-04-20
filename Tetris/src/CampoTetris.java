/**
 * 
 * @author Flavia Bonanni
 */

public class CampoTetris
{
    private String[][] campo;
    private int righe;
    private int colonne;

    /**
     * restituisce una copia dell'istanza di CampoTetris:
     * @param copia data in input
     */
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
    // public void setCampo(String[][] campo) { this.campo = campo; }

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

    /**
     * inserisce nelle coordinate
     * @param x
     * @param y
     * @param pezzo dato in input
     */
    public void inserisci(int x, int y, Pezzo pezzo)
    {
        String[][] daInserire = pezzo.getTetramino();
        int c = 0;
        for (int i = x; i < x+3; i++)
        {
            int d = 0;
            for (int j = y; j < y+3; j++)
            {
                campo[j][i] = daInserire[d][c];
                d++;
            }
            c++;
        }
    }

    /**
     * "pulisce" un quadrato 3x3 nella mia tabella
     * corrispondente alla coordinate:
     * @param x
     * @param y
     */
    public void pulisci(int x, int y)
    {
        for (int i = x; i < x+3; i++)
        {
            for (int j = y; j < y+3; j++)
            {
                campo[j][i] = " ";
            }
        }
    }

    /**
     * controlla se ci sono solo asterischi in una linea
     * in tal caso, la "pulisce"
     * @return true se la linea è piena
     */
    public int controlloLinea()
    {
        int trovata = -1;
        for (int i = 0; i < righe; i++)
        {
            int piena = 0;
            for (int j = 0; j < colonne; j++)
            {
                if (campo[i][j] == "*") piena++;
            }
            if (piena == 11)
            {
                // System.out.println("LINEA PIENA");
                trovata = i;
                for (int j = 0; j < colonne; j++)
                {
                    campo[i][j] = " ";
                }
            }
        }
        return trovata;
    }

    public boolean controlloColonna()
    {
        int piena = 0;
        for (int j = 0; j < colonne; j++)
        {
            if (campo[0][j] == "*") return true;
        }
        return false;
    }

    /**
     * stampa il campo completo di cornice
     */
    public void stampa()
    {
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
