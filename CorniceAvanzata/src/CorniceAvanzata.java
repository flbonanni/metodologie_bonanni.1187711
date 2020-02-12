/**
 * 
 * @author Flavia Bonanni
 */

public class CorniceAvanzata
{
    int j = 0;

    /**
     * 
     * @param N ampiezza della cornice
     * @param testo da metterci dentro
     */
    public void printBorder(int N, String testo)
    {
        StringBuilder sc = new StringBuilder();
        sc.append(upperLower(N));
        sc.append("\n");
        for (int i = 2; i < N; i++)
        {
            sc.append(leftRight(N, testo));
        }
        sc.append(upperLower(N));
        System.out.println(sc);
        j = 0;
    }

    /**
     * 
     * @param N ampiezza della cornice
     * @return lato superiore o inferiore
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
     * @param N ampiezza della cornice
     * @param testo da metterci dentro
     * @return lato destro o sinistro
     */
    public StringBuilder leftRight(int N, String testo)
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

    public static void main(String[] args)
    {
        CorniceAvanzata CA = new CorniceAvanzata();
        CA.printBorder(6, "Cornici in Java");
        CA.printBorder(3, "Fla");
    }
}
