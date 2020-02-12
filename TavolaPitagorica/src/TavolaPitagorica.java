/**
 * 
 * @author Flavia Bonanni
 */

public class TavolaPitagorica
{
    int[][] tavola;
    int M;

    /**
     * 
     * @param N
     */
    public TavolaPitagorica(int N)
    {
        this.M = N;
        M++;
        tavola = new int[M][M];

        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < M; j++)
            {
                tavola[i][j] = i*j;
            }
        }
    }

    public void stampa()
    {
        System.out.print("x   ");
        for (int i = 0; i < M; i++)
        {
            if (i > 9) { System.out.print(i+"  "); }
            else { System.out.print(i+"   "); }
        }
        System.out.println("");
        int sin = 0;
        for (int i = 0; i < M; i++)
        {
            if (i > 9) { System.out.print(sin+"  "); }
            else { System.out.print(sin+"   "); }
            sin++;
            for (int j = 0; j < M; j++)
            {
                if (i*j > 99) { System.out.print(i*j+" "); }
                else if (i*j > 9) { System.out.print(i*j+"  "); }
                else { System.out.print(i*j+"   "); }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args)
    {
        TavolaPitagorica TP = new TavolaPitagorica(10);
        TP.stampa();
    }
}
