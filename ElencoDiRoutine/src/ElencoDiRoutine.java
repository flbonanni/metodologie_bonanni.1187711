import java.util.*;
import java.util.function.Function;

/**
 * 
 * @author Flavia Bonanni
 */

public class ElencoDiRoutine
{
    List<Function<String, Integer>> listaDiFunzioni;

    public ElencoDiRoutine(List<Function<String, Integer>> listaDiFunzioni) { this.listaDiFunzioni = listaDiFunzioni; }

    public void esegui(String stringa) { listaDiFunzioni.forEach((f)-> System.out.println(f.apply(stringa))); }

    public static void main(String[] args)
    {
        Function<String, Integer> showLength = String::length;
        Function<String, Integer> howManyOfAChar = s -> (s.length()-(s.replace("0","").length()));
        Function<String, Integer> valueOf = Integer::valueOf;
        Function<String, Integer> characterSum =  s ->
                {
                    int k = 0;
                    for (int i = 0; i < s.length(); i++)
                    {
                        k += Character.getNumericValue(s.charAt(i));
                    }
                    return k;
                };

        List<Function<String, Integer>> listaNelMain = new ArrayList<>();
        listaNelMain.add(showLength);
        listaNelMain.add(howManyOfAChar);
        listaNelMain.add(valueOf);
        listaNelMain.add(characterSum);
        ElencoDiRoutine EDR = new ElencoDiRoutine(listaNelMain);
        EDR.esegui("1001");
    }
}
