import java.util.Arrays;

/**
 * 
 * @author Flavia Bonanni
 */

public class Sequenza
{
    private int[] intArray;

    /**
     * 
     * @param intArray
     */
    public Sequenza(int[] intArray) { this.intArray = intArray; }

    /**
     * 
     * @return media
     */
    public int getMedia()
    {
        int sum = 0;
        for (int i = 0; i < intArray.length; i++) sum += intArray[i];
        return sum/intArray.length;
    }

    /**
     * 
     * @return moda
     */
    public int getModa()
    {
        int max = 0;
        int maggiore = 0;
        for (int i = 0; i < intArray.length; i++)
        {
            int conto = 0;
            for (int j = 0; j < intArray.length; j++)
            {
                if (intArray[i] == intArray[j]) conto++;
                if (conto > max)
                {
                    max = conto;
                    maggiore = intArray[i];
                }
            }
        }
        return maggiore;
    }

    /**
     * 
     * @return mediana
     */
    public int getMediana()
    {
        int[] intArray2 = Arrays.copyOf(intArray, intArray.length);
        Arrays.sort(intArray2);
        return intArray2[intArray.length/2];
    }

    public static void main(String[] args)
    {
        int[] intArray = { 4, 3, 6, 2, 3, 4, 7, 12, 15, 3 };
        Sequenza sq = new Sequenza(intArray);
        System.out.println(sq.getMedia());
        System.out.println(sq.getMediana());
        System.out.println(sq.getModa());
    }
}
