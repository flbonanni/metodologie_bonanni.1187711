/**
 * 
 * @author Flavia Bonanni
 */

public class Reimplementazioni
{
	/**
	 * 
	 * @param arrayInt
	 * @param lunghezza
	 * @return nuovo array
	 */
    public static int[] copyOfMio(int[] arrayInt, int lunghezza)
    {
        int[] nuovoArray = new int[lunghezza];
        for (int i = 0; i < lunghezza; i++)
        {
            nuovoArray[i] = arrayInt[i];
            System.out.println(nuovoArray[i]);
        }
        return nuovoArray;
    }

    /**
     * 
     * @param arrayInt
     * @return to string
     */
    public static String toString(int[] arrayInt)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayInt.length-1; i++)
        {
            sb.append(arrayInt[i]+", ");
        }
        sb.append(arrayInt[arrayInt.length-1]+".");
        sb.append('\n');
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args)
    {
        new Reimplementazioni().copyOfMio(new int[] {1, 2, 3}, 1);
        new Reimplementazioni().toString(new int[] {1, 2, 3});
    }
}
