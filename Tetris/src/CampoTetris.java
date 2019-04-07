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
        // campo[Y][X}
        /*
        campo[19][0] = 3;
        campo[0][0] = 1;
        campo[19][9] = 4;
        campo[0][9] = 2;
        //
        // TETRAMINO PDF9.D'ESEMPIO
        // campo[Y][X}
        /*
        campo[18][1] = 1; // PDF9.A
        campo[18][2] = 1; // PDF9.B
        campo[18][3] = 1; // PDF9.C
        campo[17][2] = 1; // E */
        // TEST per ROTATE
        /*
        campo[18][1] = 1;
        campo[18][2] = 2;
        campo[18][3] = 3;
        campo[17][1] = 4;
        campo[17][2] = 5;
        campo[17][3] = 6;
        campo[16][1] = 7;
        campo[16][2] = 8;
        campo[16][3] = 9;
        /* LEFT
        campo[18][0] = 2;
        campo[18][1] = 2;
        campo[18][2] = 2;
        campo[17][1] = 2; */
        /* DOWN
        campo[17][1] = 2;
        campo[17][2] = 2;
        campo[17][3] = 2;
        campo[16][2] = 2; */
        // ROTATE
        /*
        campo[16][1] = 1;
        campo[17][1] = 2;
        campo[18][1] = 3;
        campo[16][2] = 4;
        campo[17][2] = 5;
        campo[18][2] = 6;
        campo[16][3] = 7;
        campo[17][3] = 8;
        campo[18][3] = 9;
        */
    }

    public int getRighe() { return righe; }
    public int getColonne() { return colonne; }

    /**
     * 
     * @param x
     * @param y
     * @param pezzo
     */
    public void inserisci(int x, int y, Pezzo pezzo)
    {
        String[][] daInserire = pezzo.getTetramino();
        int a = 0;
        for (int i = x; i < x+3; i++)
        {
            int b = 0;
            for (int j = y; j < y+3; j++)
            {
                campo[i][j] = daInserire[a][b];
                b++;
            }
            a++;
        }
    }

    /**
     * 
     * @return true se la riga è piena e quindi da eliminare
     */
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
        System.out.println(" Y| 0123456789 X");
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
