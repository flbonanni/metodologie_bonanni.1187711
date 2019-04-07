import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class SuccessioneInfinita extends SuccessioneGenerica
{
    private static List<Integer> seiCifre = new ArrayList<>(6);

    public Integer generaProssimo(int i)
    {
        int baseSei = 0;
        generaSeiCifre();
        while (i >= 6)
        {
            i = i % 6;
            baseSei = i;
        }
        if (i >= 6) return seiCifre.get(baseSei);
        else return seiCifre.get(i);
    }

    public Iterator<Integer> iterator() { return getSuccessione().iterator(); }

    public void generaSeiCifre()
    {
        for (int j = 0; j < 6; j++)
        {
            int range = (200 - (-200)) + 1;
            seiCifre.add((int)((Math.random() * range) - 200));
        }
    }
}
