import java.util.Arrays;

/**
 * Classe costruita con una stringa
 * @author Flavia Bonanni
 */

public class Permutazioni
{
    private String stringa;

    public Permutazioni(String stringa) { this.stringa = stringa; }

    /**
     * restituisce l'elenco completo delle permutazioni della stringa
     * @return elenco completo delle permutazioni della stringa
     */
    public String[] generaPermutazioni()
    {
        String[] strArray = new String[fattoriale(stringa.length())];
        String risultato = generaPermutazioni(stringa, 0, stringa.length()-1);
        int index = 0;
        for (int i = 0; i < strArray.length; i++)
        {
            strArray[i] = risultato.substring(index, index+stringa.length());
            index += stringa.length()+1;
        }
        System.out.println(Arrays.toString(strArray));
        return strArray;
    }

    public int fattoriale(int k)
    {
        if (k == 0) return 1;
        return k*fattoriale(k-1);
    }

    private String generaPermutazioni(String str, int inizio, int fine)
    {
        String s = "";
        if (inizio == fine)
            return str+"_";
        else {
            for (int i = inizio; i <= fine; i++) {
                str = scambia(str, inizio, i);
                s = s + generaPermutazioni(str, inizio + 1, fine);
                str = scambia(str, inizio, i);
            }
        }
        return s;
    }

    public String scambia(String s, int i, int j)
    {
        char c;
        char[] charArray = s.toCharArray();
        c = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = c;
        return String.valueOf(charArray);
    }

    public static void main(String[] args)
    {
        Permutazioni p = new Permutazioni("abc");
        p.generaPermutazioni();
    }
}
