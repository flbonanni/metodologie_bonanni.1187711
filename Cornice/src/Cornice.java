/**
 * 
 * @author Flavia Bonanni
 */

public class Cornice
{
	/**
	 * 
	 * @param N ampiezza della cornice
	 */
    public void printBorder(int N)
    {
        StringBuilder sc = new StringBuilder();
        sc.append(upperLower(N));
        sc.append("\n");
        for (int i = 2; i < N; i++)
        {
            sc.append(leftRight(N));
        }
        sc.append(upperLower(N));
        System.out.println(sc);
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
     * @return lato destro o sinistro
     */
    public StringBuilder leftRight(int N)
    {
        StringBuilder sd = new StringBuilder();
        sd.append("*");
        for (int i = 2; i < N; i++)
        {
            sd.append(" ");
        }
        sd.append("*");
        sd.append("\n");
        return sd;
    }

    public static void main(String[] args)
    {
        Cornice cornice = new Cornice();
        cornice.printBorder(5);
        cornice.printBorder(3);
    }
}
