import java.util.Scanner;

/**
 * 
 * @author Flavia Bonanni
 */

public class CampoMinato
{
    private int N;
    private int M;
    private int m;
    private int[][] campo;
    private int[][] scoperte;
    private int x;
    private int y;

    /**
     * 
     * @param N
     * @param M
     * @param mine
     */
    public CampoMinato(int N, int M, int m)
    {
        this.N = N;
        this.M = M;
        this.m = m;
        campo = new int[N][M];
        scoperte = new int[N][M];
        disponiMina();
        // mette nella cella il numero di mine circostanti
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (campo[i][j] != -1) { campo[i][j] = scandaglia(i, j); }
            }
        }
     
        play();
    }

    public void play()
    {
        do
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Coordinata x?");
            x = input.nextInt();
            System.out.println("Coordinata y?");
            y = input.nextInt();
            scopri(x, y);
            toString();
        }
        while (vinto() == 0);
    }

    public void disponiMina()
    {
        int[][] mineDisposte = new int[M][N];
        int contaMine = 0;
        while (contaMine < m)
        {
            int rand1 = (int) (Math.random() * N);
            int rand2 = (int) (Math.random() * M);
            if (campo[rand1][rand2] != -1)
            {
                campo[rand1][rand2] = -1;
                contaMine++;
            }
        }
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public int scopri(int x, int y)
    {
        // segna che la cella è ora visibile al/la giocatore/trice
        scoperte[x][y] = 1;
        // metti il contenuto della cella in una var
        int casellaScoperta = campo[x][y];
        // se c'è un mina
        if (casellaScoperta == -1) { return -1; }
        // se c'è un numero sarà scoperto, v. scoperte[x][y]
        if (scandaglia(x,y) != 0) { return scandaglia(x,y); }
        // se non c'è n'è una mina n'è un numero
        if (casellaScoperta == 0)
        {
            ricerca(x,y);
        }
        return 0;
    }

    /**
     * 
     * @param x
     * @param y
     */
    public void ricerca(int x, int y)
    {
        // x, y è vuota
        // se non è già stata visitata, vai alla cella in alto a sinistra
        if (x-1 >= 0 && y-1 >= 0 && scoperte[x-1][y-1] == 0)
        {
            // segnala come visitata
            scoperte[x-1][y-1] = 1;
            // se è 0
            if (scandaglia(x-1, y-1) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x-1, y-1);
            }
        }
        // altrimenti la cella in alto al centro
        if (x-1 >= 0 && scoperte[x-1][y] == 0)
        {
            // segnala come visitata
            scoperte[x-1][y] = 1;
            // se è 0
            if (scandaglia(x-1, y) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x-1, y);
            }
        }
        // altrimenti la cella in alto a destra
        if (x-1 >= 0 && y+1 < M && scoperte[x-1][y+1] == 0)
        {
            // segnala come visitata
            scoperte[x-1][y+1] = 1;
            // se è 0
            if (scandaglia(x-1, y+1) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x-1, y+1);
            }
        }
        // altrimenti la cella a sinistra
        if (y-1 >= 0 && scoperte[x][y-1] == 0)
        {
            // segnala come visitata
            scoperte[x][y-1] = 1;
            // se è 0
            if (scandaglia(x, y-1) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x, y-1);
            }
        }
        // altrimenti la cella a destra
        if (y+1 < M && scoperte[x][y+1] == 0)
        {
            // segnala come visitata
            scoperte[x][y+1] = 1;
            // se è 0
            if (scandaglia(x, y+1) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x, y+1);
            }
        }
        // altrimenti la cella in basso a sinistra
        if (x+1 < N && y-1 >= 0 && scoperte[x+1][y-1] == 0)
        {
            // segnala come visitata
            scoperte[x+1][y-1] = 1;
            // se è 0
            if (scandaglia(x+1, y-1) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x+1, y-1);
            }
        }
        // altrimenti la cella in basso al centro
        if (x+1 < N && scoperte[x+1][y] == 0)
        {
            // segnala come visitata
            scoperte[x+1][y] = 1;
            // se è 0
            if (scandaglia(x+1, y) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x+1, y);
            }
        }
        // altrimenti la cella in basso a destra
        if (x+1 < N && y+1 < M && scoperte[x+1][y+1] == 0)
        {
            // segnala come visitata
            scoperte[x+1][y+1] = 1;
            // se è 0
            if (scandaglia(x+1, y+1) == 0)
            {
                // ricomincia la ricerca con la SUA cella in alto a sinistra
                ricerca(x+1, y+1);
            }
        }

    }

    /**
     * 
     * @param x
     * @param y
     * @return numero di mine intorno a una cella
     */
    public int scandaglia(int x, int y)
    {
        int conto = 0;
        for (int i = -1; i <= +1; i++)
        {
            if (x-1 >= 0 && M > y+i && y+i >= 0)
            {
                if (campo[x-1][y+i] == -1)
                {
                    conto++;
                }
            }
            if (M > y+i && y+i >= 0)
            {
                if (campo[x][y+i] == -1)
                {
                    // non contare te stessa
                    if (y+i != y)
                    {
                        conto++;
                    }
                }
            }
            if (x+1 < N && M > y+i && y+i >= 0)
            {
                if (campo[x+1][y+i] == -1)
                {
                    conto++;
                }
            }
        }
        return conto;
    }

    public void stampa()
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (campo[i][j] != -1) { System.out.print(campo[i][j]); }
                else { System.out.print("X"); }
            }
            System.out.println();
        }
    }
    
    @Override
    public String toString()
    {
        String output = "";
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (scoperte[i][j] == 1)
                {
                    if (campo[i][j] != -1)
                    {
                        System.out.print(campo[i][j]);
                        output += campo[i][j];
                    }
                    else
                    {
                        System.out.print("X");
                        output += "X";
                    }
                }
                else
                {
                    System.out.print("_");
                    output += "_";
                }
            }
            System.out.println();
            output += '\n';
        }
        return output;
    }

    public int vinto()
    {
        int tot = N*M;
        int celleScoperte = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (scoperte[i][j] == 1) { celleScoperte++; }
            }
        }
        if (scopri(x, y) == -1)
        {
            System.out.println("perso");
            return -1;
        }
        else if (tot == m + celleScoperte)
        {
        System.out.println("vinto");
        return 1;
        }
        else
        {
            System.out.println("in gioco");
            return 0;
        }
    }

    public static void main(String[] args)
    {
        CampoMinato CM = new CampoMinato(9, 9, 10);
    }
}
