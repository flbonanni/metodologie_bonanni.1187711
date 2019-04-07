/**
 * 
 * @author Flavia Bonanni
 */

public abstract class Pezzo
{
    private int y;
    private int x;
    private String[][] tetramino;

    public void setOrdinata(int a) { y = a; }
    public int getOrdinata() { return y; }
    public int getAscissa() { return x; }
    public void setAscissa(int a) { x = a; }
    public void setTetramino(String[][] a) { tetramino = a; }
    public String[][] getTetramino() { return tetramino; }

    public void left() { x--; }
    public void right() { x++; }
    public void down() { y++; }

    public void rotate()
    {
        String[][] copy = new String[3][3];
        int k = 2;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                // System.out.println(i+" "+j+", "+j+" "+k);
                copy[i][j] = tetramino[j][k];
            }
            k--;
        }
        tetramino = copy;
    }

    public void stampa()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(tetramino[i][j]);
            }
            System.out.println();
        }
    }
}