/**
 * 
 * @author Flavia Bonanni
 */

public class ScacchieraTris
{
    String[][] scacchiera = new String[3][3];

    public ScacchieraTris()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                scacchiera[i][j] = " ";
            }
        }
    }

    /**
     * 
     * @param simbolo
     * @param i dimensione
     * @param j dimensione
     */
    public void occupa(String simbolo, int i, int j)
    {
        scacchiera[i][j] = simbolo;
    }

    public void stampa()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (j == 2)
                {
                    System.out.println(scacchiera[i][j]);
                }
                else { System.out.print(scacchiera[i][j]+"|"); }
            }
            if (i < 2) { System.out.println("-----"); }
        }
    }

    public boolean check()
    {
        boolean win = false;
        for (int i = 0; i < 3; i++)
        {
            if (((scacchiera[i][0] == scacchiera[i][1] && scacchiera[i][1] == scacchiera[i][2]) && scacchiera[i][0] != " ") || (scacchiera[0][i] == scacchiera[1][i] && scacchiera[1][i] == scacchiera[2][i]) && scacchiera[0][i] != " ")
            {
                win = true;
            }
        }
        if (((scacchiera[0][0] == scacchiera[1][1] && scacchiera[1][1] == scacchiera[2][2]) && scacchiera[0][0] != " ") || ((scacchiera[0][2] == scacchiera[1][1] && scacchiera[1][1] == scacchiera[2][0]) && scacchiera[2][0] != " ")) { win = true; }
        return win;
    }
}
