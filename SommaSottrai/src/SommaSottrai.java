public class SommaSottrai
{
    /**
     * @author Flavia Bonanni 1187711
     */

    private int[] intArray;

    /**
     * @param intArray = lista di interi
     */
    public SommaSottrai(int... intArray)
    {
        this.intArray = intArray;
        System.out.println(sommaSottrai(0, 0));
    }

    /**
     * @param k indice di scorrimento dell'array
     * @param semiSomma somma parziale
     * @return la somma dei valori della lista in posizione dispari, da cui vengono sottratti i valori in posizione pari
     * [2, 5, 3, 7, 11, 1] = 2-5+3-7+11-1=3
     */
    public int sommaSottrai(int k, int semiSomma)
    {
        if(k == intArray.length-2) return semiSomma + sottrai(intArray[k], intArray[k+1]);
        int somma = semiSomma + sottrai(intArray[k], intArray[k+1]);
        return sommaSottrai(k+2, somma);
    }

    public int sottrai(int a, int b) { return a-b; }

    public static void main(String[] args)
    {
        SommaSottrai ss = new SommaSottrai(new int[] { 2, 5, 3, 7, 11, 1 });
    }
}
