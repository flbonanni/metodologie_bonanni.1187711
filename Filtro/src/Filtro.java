import java.util.Arrays;

/**
 * 
 * @author Flavia Bonanni
 */

public class Filtro
{
    int[] arrayInt;

    /**
     * 
     * @param arrayInt
     */
    public Filtro(int[] arrayInt)
    {
        this.arrayInt = arrayInt;
    }

    /**
     * 
     * @param k
     * @return nuovo array < k
     */
    public int[] passaBasso(int k)
    {
        int piuPiccoli = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (arrayInt[i] <= k) { piuPiccoli++; }
        }
        int[] arrayNuovo = Arrays.copyOf(arrayInt, piuPiccoli);
        int l = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (arrayInt[i] <= k)
            {
                arrayNuovo[l] = arrayInt[i];
                l++;
            }
        }
        stampa(arrayNuovo);
        return arrayNuovo;
    }

    /**
     * 
     * @param k
     * @return nuovo array > k
     */
    public int[] passaAlto(int k)
    {
        int piuGrandi = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (arrayInt[i] >= k) { piuGrandi++; }
        }
        int[] arrayNuovo = Arrays.copyOf(arrayInt, piuGrandi);
        int l = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (arrayInt[i] >= k)
            {
                arrayNuovo[l] = arrayInt[i];
                l++;
            }
        }
        stampa(arrayNuovo);
        return arrayNuovo;
    }

    /**
     * 
     * @param k
     * @return array senza k
     */
    public int[] filtra(int k)
    {
        int senzaUno = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (arrayInt[i] == k) { senzaUno++; }
        }
        int[] arrayNuovo = Arrays.copyOf(arrayInt, arrayInt.length-senzaUno);
        int l = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (arrayInt[i] != k)
            {
                arrayNuovo[l] = arrayInt[i];
                l++;
            }
        }
        stampa(arrayNuovo);
        return arrayNuovo;
    }

    /**
     * 
     * @param arrayK
     * @return array senza arrayK
     */
    public int[] filtraArray(int[] arrayK)
    {
        int coincidenze = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            for (int j = 0; j < arrayK.length; j++)
            {
                if (arrayInt[i] == arrayK[j]) { coincidenze++; }
            }
        }
        int[] arrayNuovo = Arrays.copyOf(arrayInt, arrayInt.length-coincidenze);
        int l = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            boolean nonCoincide = true;
            for (int j = 0; j < arrayK.length; j++)
            {
                if (arrayInt[i] == arrayK[j]) { nonCoincide = false; }
            }
            if (nonCoincide)
            {
                arrayNuovo[l] = arrayInt[i];
                l++;
            }
        }
        stampa(arrayNuovo);
        return arrayNuovo;
    }

    /**
     * 
     * @param arrayStampare
     */
    public void stampa(int[] arrayStampare)
    {
        for (int i = 0; i < arrayStampare.length-1; i++)
        {
            System.out.print(arrayStampare[i]+", ");
        }
        System.out.println(arrayStampare[arrayStampare.length-1]+".");
    }

    public static void main(String[] args)
    {
        Filtro F = new Filtro(new int[] { 1, 2, 10, 2, 42, 7, 8 });
        F.passaBasso(8);
        F.passaAlto(9);
        F.filtra(2);
        F.filtraArray(new int[] { 2, 7, 42});
    }
}