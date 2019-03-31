/**
 * 
 * @author Flavia Bonanni
 */

public class MioArray
{
    int[] arrayDiInt;

    /**
     * 
     * @param arrayDiInt
     */
    public MioArray(int[] arrayDiInt)
    {
        this.arrayDiInt = arrayDiInt;
    }

    /**
     * 
     * @param posizione
     * @param cercato
     * @return true se lo contiene, altrimenti false
     */
    public boolean contiene(int posizione, int cercato)
    {
        return arrayDiInt[posizione] == cercato;
    }

    /**
     * 
     * @return somma dei primi 2
     */
    public int somma2()
    {
        if (arrayDiInt.length < 2)
        {
            if (arrayDiInt.length < 1) { return 0; }
            return arrayDiInt[1];
        }
        int sommaPrimiDue = arrayDiInt[0]+arrayDiInt[1];
        System.out.println(sommaPrimiDue);
        return sommaPrimiDue;
    }

    /**
     * 
     * @param unaPosizione
     * @param altraPosizione
     */
    public void scambia(int unaPosizione, int altraPosizione)
    {
        int appoggio = arrayDiInt[unaPosizione];
        arrayDiInt[unaPosizione] = arrayDiInt[altraPosizione];
        arrayDiInt[altraPosizione] = appoggio;
    }

    /**
     * 
     * @return il più grande tra il primo, l'ultimo, e il dato a metà dell'array
     */
    public int maxTripla()
    {
        int max;
        int meta = arrayDiInt.length/2;
        int a = arrayDiInt[0];
        int b = arrayDiInt[meta];
        int c = arrayDiInt[arrayDiInt.length-1];
        if (a > b && a > c) { max = a; }
        else if (b > a && b > c) { max = b; }
        else { max = c; }
        return max;
    }

    /**
     * 
     * @return array con soli 2 elementi, il primo e l'ultimo
     */
    public int[] falloInDue()
    {
        int[] arrayDuetto = new int[2];
        arrayDuetto[0] = arrayDiInt[0];
        arrayDuetto[1] = arrayDiInt[arrayDiInt.length-1];
        return arrayDuetto;
    }

    /**
     * 
     * @param intArray
     */
    public void stampa(int[] intArray)
    {
        for (int i = 0; i < intArray.length; i++)
        {
            System.out.println(intArray[i]);
        }
    }

    public static void main(String[] args)
    {
        MioArray MA = new MioArray(new int[] {1, 2, 4, 6});
        System.out.println(MA.contiene(3, 2));
        MA.somma2();
        MA.scambia(1, 3);
        System.out.println(MA.maxTripla());
        MA.falloInDue();
    }
}
