import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class ArrayInteriIterabile implements Iterable<Integer>
{
    private List<Integer> listaDiInteri = new ArrayList<>();

    public ArrayInteriIterabile(int ... intArray)
    {
        for (int i : intArray)
        listaDiInteri.add(i);
    }

    @Override
    public Iterator<Integer> iterator()
    {
        return listaDiInteri.iterator();
    }

    public static void main(String[] args)
    {
        int[] qualcheIntero = new int[] { 1, 2, 3, 4, 5 };
        ArrayInteriIterabile AII = new ArrayInteriIterabile(qualcheIntero);
        for (Integer i : AII)
        {
            System.out.println(i);
        }
    }
}

// implementando iterable
// importando di java.util.Iterator
// facendo l'override del metodo iterator(), che rende un iterator di interi
// un iterator è come un'enumerazione, ma meglio
// ottengo un oggetto sul quale è possibile iterare
