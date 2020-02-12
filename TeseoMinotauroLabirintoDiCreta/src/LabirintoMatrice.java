import java.util.ArrayList;
import java.util.Collections;

/**
 * Labirinto in forma di matrice 
 * @author Flavia Bonanni
 */

public class LabirintoMatrice
{
    private int N;
    private int M;
    private Cella[][] Labirinto;
    private ArrayList<String> filoDiArianna = new ArrayList<>();

    public LabirintoMatrice(int N, int M)
    {
        this.N = N;
        this.M = M;
        Labirinto = new Cella[N][M];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (Math.random() < 0.5) Labirinto[i][j] = new Muro();
                else Labirinto[i][j] = new Stanza();
            }
        }
        Labirinto[0][0] = new Stanza();
        posizionaMinotauro();
    }

    public boolean percorri(int i, int j)
    {
        boolean result = percorri(i, j, false);
        Collections.reverse(filoDiArianna);
        System.out.println(filoDiArianna);
        return result;
    }

    public boolean percorri(int i, int j, boolean b)
    {
        Labirinto[i][j].setVisited(true);
        filoDiArianna.add("Cella "+i+"-"+j);
        if (Labirinto[i][j].toString() == "M") return true;
        if (i-1 >= 0 && !Labirinto[i-1][j].getVisited()) return b || percorri(i-1, j, b);
        if (j+1 < M && !Labirinto[i][j+1].getVisited()) return b || percorri(i, j+1, b);
        if (i+1 < N && !Labirinto[i+1][j].getVisited()) return b || percorri(i+1, j, b);
        if (j-1 >= 0 && !Labirinto[i][j-1].getVisited()) return b || percorri(i, j-1, b);
        return false;
    }

    public void print()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                System.out.print(Labirinto[i][j]);
            }
            System.out.println();
        }
    }


    public void posizionaMinotauro()
    {
        int numStanze = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (Labirinto[i][j] instanceof Stanza) numStanze++;
            }
        }
        int random = (int)(Math.random() * numStanze-1);
        int count = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (Labirinto[i][j] instanceof Stanza)
                {
                    Stanza s = (Stanza) Labirinto[i][j];
                    if (count == random) s.setMinotauro(true);
                    count++;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        LabirintoMatrice LM = new LabirintoMatrice(5, 6);
        LM.print();
        LM.percorri(0, 0);
    }
}
