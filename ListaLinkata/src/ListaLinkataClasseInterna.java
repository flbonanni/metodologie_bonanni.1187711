import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class ListaLinkataClasseInterna implements Iterable<Integer>
{
    private List<Integer> listaDiInteri = new ArrayList<>();

    // costruttore della classe, aggiunge alla lista linkata ogni @param dato in input
    public ListaLinkataClasseInterna(int ... intArray) { for (int i : intArray) add(i); }

    // metodo della Lista Linkata che chiama il metodo nella classe
    public void add(int i)
    {
    	ListaLinkataClasseInterna.Implementazione imp = new ListaLinkataClasseInterna.Implementazione();
        imp.add(i);
    }

    // classe annidata che aggiunge effettivamente il singolo elemento
    public class Implementazione
    {
        public void add(int i)
        {
            listaDiInteri.add(i);
        }
    }

    public Iterator<Integer> iterator()
    {
        return listaDiInteri.iterator();
    }
}
