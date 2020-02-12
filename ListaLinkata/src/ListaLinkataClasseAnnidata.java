import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class ListaLinkataClasseAnnidata implements Iterable<Integer>
{
    private Elemento first;

    // ogni elemento è costruito da un k (contenuto) e un next (elemento a cui punta)
    // l'elemento si puù costruire anche senza alcun next
    static private class Elemento
    {
        private Integer k;
        private Elemento next;

        public Elemento(Integer k, Elemento next)
        {
            this.k = k;
            this.next = next;
        }

        public Elemento(Integer k)
        {
            this(k, null);
        }
    }

    @Override // per Iterable
    public Iterator<Integer> iterator()
    {
        return  new CustomIterator();
    }


    // costruzione esplicita di un iterator
    public class CustomIterator implements Iterator
    {
        Elemento e = first;

        @Override
        public boolean hasNext()
        {
            return /* true if */ e != null;
        }

        // vorrei ritoranre l'elemento ma non posso perché l'iterator funziona solo su primitivi e Object
        @Override
        public Integer next()
        {
            if (!hasNext()) return null;
            Integer k = e.k;
            e = e.next;
            return k;
        }
    }

    public int size()
    {
        Elemento e = first;
        if (e == null) { return 0; }
        else
        {
            int size = 1;
            while (e.next != null)
            {
                size++;
                e = e.next;
            }
            return size;
        }
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void print()
    {
        Elemento e = first;
        int c = 0;
        while (c < size())
        {
            System.out.println(e.k);
            e = e.next;
            c++;
        }
    }

    public void add(Integer element) { add(size(), element); }

    public void add(int index, Integer k)
    {
        Elemento e = first;
        // se non c'è niente
        if (e == null)
        {
            // System.out.println("La lista è vuota, dichiaro che il primo elemento è "+k+" e che non punta a nulla");
            first = new Elemento(k, null);
        }
        // altrimenti
        else
        {
            // se non mi è chiesto di aggiungerlo al primo posto
            // lo aggiungo all'indice richiesto o al primo disponibile!
            if (index >= 1)
            {
                int c = 0;
                while (e.next != null && c < index)
                {
                    e = e.next;
                    c++;
                }
                if (e.next == null)
                {
                    e.next = new Elemento(k, null);
                }
                // se trovi già qualcosa dove voglio mettere il nuovo elemento... (condizione c < index)
                else
                {
                    Elemento prossimo = e;
                    e = new Elemento(k, prossimo);
                }
            }
            // se devo metterlo proprio al primo posto
            else
            {
                // System.out.println("Sto inserendo l'elemento "+k+" all'indice 0");
                Elemento second = first;
                first = new Elemento(k, second);
                // System.out.println("Post inserimento, in prima posizione c'è "+first.k+" (indice 0), in seconda posizione c'è "+second.k+" (indice 1)");
            }
        }
    }

    private Elemento elementAt(int index)
    {
        Elemento e = first;
        for (int i = 0; i <= index; i++)
        {
            e = e.next;
        }
        return e;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");

        // DONE: non vede il primo elemento, forse perché parte da 0 ma l'indice del primo è 1?
        // DONE: non vede l'ultimo elemento, non so perché
        //       non vedeva l'ultimo perché hasNext() dava true se aveva un prossimo, anziché dare true se esso stesso non era null
        //       quindi di fatto l'iterator non poteva arrivare fino in fondo, né vedere il primo
        //       dato che si basava sempre su cosa c'era di prossimo
        Iterator<Integer> i = iterator();

        while(i.hasNext())
        {
            sb.append((i.next()));
            if (i.hasNext()) sb.append(", ");
            else sb.append(" ");
        }

        sb.append("]");

        return sb.toString();
    }

    public int indexOf(Object o)
    {
        Elemento e = first;
        int c = 0;
        while (e != o && c < size())
        {
            if (e.k == (int)o) return c;
            e = e.next;
            c++;
        }
        return -1;
    }

    public boolean remove(Object o)
    {
        Elemento e = first;
        int c = 0;
        while (c < size())
        {
            if (e.k == o)
            {
                e.k = e.next.k;
                e.next = e.next.next;
            }
            e = e.next;
            c++;
            return true;
        }
        return false;
    }

    public void remove(int index)
    {
        Elemento e = first;
        for (int i = 0; i < size(); i++)
        {
            if (indexOf(e) == index) { e = null; }
        }
    }

    public static void main(String[] args)
    {
    	ListaLinkataClasseAnnidata l = new ListaLinkataClasseAnnidata();
        l.add(5);
        l.add(2);
        l.add(3);
        l.add(0, 42);
        System.out.println(l.remove(Integer.valueOf(42)));
        System.out.println(l);
        System.out.println(l.indexOf(10));
        System.out.println(l.indexOf(3));

        for (Integer k : l)
            System.out.println(k);

    }
}
