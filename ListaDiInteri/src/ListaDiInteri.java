import java.util.Arrays;

/**
 * 
 * @author Flavia Bonanni
 */

public class ListaDiInteri
{
    int[] arrayInt;

    /**
     * 
     * @param arrayInt
     */
    public ListaDiInteri(int[] arrayInt)
    {
        this.arrayInt = arrayInt;
    }

    /**
     * 
     * @param posizione
     * @return elemento i-esimo
     */
    public int elementoIesimo(int posizione)
    {
        System.out.println("L'elemento in posizione "+posizione+" è "+arrayInt[posizione]+".");
        return arrayInt[posizione];
    }

    /**
     * 
     * @param ricercato
     * @return posizione del ricercato
     */
    public int doveSta(int ricercato)
    {
        int posizione;
        Arrays.sort(arrayInt);
        posizione = Arrays.binarySearch(arrayInt, ricercato);
        System.out.println("L'elemento "+ricercato+" è in posizione "+posizione+".");
        return posizione;
    }

    /**
     * 
     * @return stringa formattata
     */
    public String formStampa()
    {
        String str = Arrays.toString(arrayInt);
        String formattata = str.substring(1, str.length()-1)+".";
        System.out.println("L'array è: "+formattata);
        return formattata;
    }

    /**
     * 
     * @return dimensione
     */
    public int dimensione()
    {
        int dimensione = arrayInt.length;
        System.out.println("L'array ha "+dimensione+" elementi.");
        return dimensione;
    }

    /**
     * 
     * @param ricercato
     * @return se l'elemento ricercato c'è o meno
     */
    public boolean ciSta(int ricercato)
    {
        int posizione;
        Arrays.sort(arrayInt);
        posizione = Arrays.binarySearch(arrayInt, ricercato);
        if (posizione <= -1)
        {
            System.out.println("L'elemento "+ricercato+" non è presente nell'array.");
            return false;
        }
        else
        {
            System.out.println("L'elemento "+ricercato+" è presente nell'array.");
            return true;
        }
    }

    /**
     * 
     * @param daAggiungere
     */
    public void aggiungi(int daAgg)
    {
        int[] copiaLunga = Arrays.copyOf(arrayInt, arrayInt.length+1);
        copiaLunga[copiaLunga.length-1] = daAgg;
        arrayInt = copiaLunga;
        System.out.println(Arrays.toString(copiaLunga));
    }

    /**
     * 
     * @param daAggiungere
     * @param posizione
     */
    public void aggiungiQui(int daAgg, int posizione)
    {
        int[] copiaLunga = Arrays.copyOf(arrayInt, arrayInt.length+1);
        for (int i = arrayInt.length-1; i >= posizione; i--)
        {
            copiaLunga[i+1] = arrayInt[i];
        }
        copiaLunga[posizione] = daAgg;
        arrayInt = copiaLunga;
        System.out.println(Arrays.toString(copiaLunga));
    }

    /**
     * 
     * @param daEliminare
     */
    public void elimina(int daEli)
    {
        int[] copiaStretta = Arrays.copyOf(arrayInt, arrayInt.length-1);
        int daTagliare = 0;
        for (int i = 0; i < arrayInt.length; i++)
        {
            if (arrayInt[i] == daEli)
            {
                daTagliare = i;
                break;
            }
        }
        int segnalibro = 0;
        for (int i = 0; i < daTagliare; i++)
        {
            copiaStretta[i] = arrayInt[i];
            segnalibro = i;
        }
        for (int i = daTagliare+1; i < arrayInt.length; i++)
        {
            copiaStretta[segnalibro + 1] = arrayInt[i];
            segnalibro++;
        }
        arrayInt = copiaStretta;
        System.out.println(Arrays.toString(copiaStretta));
    }

    /**
     * 
     * @param posizione da eliminare
     */
    public void eliminaQui(int posizione)
    {
        int[] copiaStretta = new int[arrayInt.length-1];
        int temp = 0;
        for (int i = 0; i < posizione-1; i++)
        {
            copiaStretta[i] = arrayInt[i];
            temp = i;
        }
        for (int i = posizione-1; i < copiaStretta.length; i++)
        {
            copiaStretta[i] = arrayInt[posizione];
            posizione++;
        }
        arrayInt = copiaStretta;
        System.out.println(Arrays.toString(copiaStretta));
    }

    public static void main(String[] args)
    {
        ListaDiInteri LdI = new ListaDiInteri(new int[] { 1, 2, 10, 2, 42, 7, 8 });
        LdI.elementoIesimo(3);
        LdI.doveSta(42);
        LdI.formStampa();
        LdI.dimensione();
        LdI.ciSta(1); LdI.ciSta(5); LdI.ciSta(43); LdI.ciSta(42);
        LdI.aggiungi(3);
        LdI.aggiungiQui(3, 2);
        LdI.elimina(10);
        LdI.eliminaQui(3);
    }
}
