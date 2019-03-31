/**
 * 
 * @author Flavia Bonanni
 */

public class Cornice
{
    StringBuilder sc = new StringBuilder();

    /**
     * 
     * @param N ampiezza
     * @param testo
     */
    public void makeBorder(int N, String testo)
    {
        sc.append(upperLower(N));
        sc.append("\n");
        int j = 0;
        for (int i = 2; i < N; i++)
        {
            sc.append(leftRight(N, testo, j));
            j+=(N-2);
        }
        sc.append(upperLower(N));
    }

    /**
     * 
     * @param N ampiezza
     * @return bordo sopra o sotto
     */
    public StringBuilder upperLower(int N)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
        {
            sb.append("*");
        }

        return sb;
    }

    /**
     * 
     * @param N ampiezza
     * @param testo
     * @param j ampiezza testo
     * @return righe di centro
     */
    public StringBuilder leftRight(int N, String testo, int j)
    {
        StringBuilder sd = new StringBuilder();
        sd.append("*");
        for (int i = 2; i < N; i++)
        {
            if (j < testo.length())
            {
                sd.append(testo.charAt(j));
                j++;
            }
            else { sd.append(" "); }
        }
        sd.append("*");
        sd.append("\n");
        return sd;
    }

    @Override
    public String toString()
    {
        System.out.println(sc);
        return sc.toString();
    }

    /**
     * 
     * @param n ampiezza
     * @param stringa
     */
    public Cornice(int n, String stringa)
    {
        makeBorder(n, stringa);
    }

    public static void main(String[] args)
    {
        new Cornice(6, "Cornici in Java").toString();
    }
}


