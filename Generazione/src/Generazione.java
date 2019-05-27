import java.util.Arrays;
import java.util.function.Predicate;

/**
 * costruita con un insieme di caratteri e
 * dotata di un metodo genera che, dato in input un intero k,
 * restituisca l’elenco completo delle stringhe di lunghezza k
 * utilizzando caratteri nell'insieme in input
 * @author Flavia Bonanni
 */

public class Generazione
{
    char[] charArray;

    public Generazione(char ... charArray) { this.charArray = charArray; }

    public String[] genera(int k, Predicate<Integer> p) throws Exception
    {
        if (p.test(charArray.length)) return genera(k);
        else throw new Exception();
    }

    public String[] genera(int k)
    {
        String[] strArray = new String[(int)Math.pow(charArray.length, k)];
        String s = genera("", k);
        int index = 0;
        for (int i = 0; i < strArray.length; i++)
        {
            strArray[i] = s.substring(index, index+k);
            index += k;
        }
        return strArray;
    }

    public String genera(String prefisso, int k)
    {
        String s = "";
        if (k == 0) return prefisso + "";
        for (char c : charArray)
        {
            String nuovoPrefisso = prefisso + c;
            s = s + genera(nuovoPrefisso, k-1);
        }
        return s;
    }

    public static void main(String[] args) throws Exception
    {
        char[] charArray = { 'a', 'b' };
        Generazione g = new Generazione(charArray);
        String[] strArray = g.genera(3);
        System.out.println(Arrays.toString(strArray));
        
        Predicate<Integer> arrayNotEmpty = (i) -> i > 0;
        String[] strArray2 = g.genera(3, arrayNotEmpty);
        System.out.println(Arrays.toString(strArray2));
    }
}
