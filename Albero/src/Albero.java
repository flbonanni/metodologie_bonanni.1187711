import java.util.*;

/**
 * Rappresenta un albero n-ario (con un numero variabile di figli per ciascun nodo) i cui nodi contengono un valore intero
 * 
 * @author Flavia Bonanni
 */

public class Albero
{
    private Nodo root;

    static public class Nodo
    {
        private List<Nodo> figli;
        private int valore;

        public Nodo(List<Nodo> figli, int valore)
        {
            this.figli = figli;
            this.valore = valore;
        }

        public void add(Nodo n)
        {
            if (figli == null) figli = new ArrayList<>();
            figli.add(n);
        }
    }

    public void add(int ... interi) throws RootsNotEqual
    {
        if (root == null) root = new Nodo(null, interi[0]);
        if (root.valore != interi[0]) { throw new RootsNotEqual(); }
        else
        {
            if (interi.length >= 1) { interi = Arrays.copyOfRange(interi, 1, interi.length); }
            add(root, interi);
        }
    }

    public void add(Nodo tempRoot, int ... interi)
    {
        boolean present = false;
        int index = -1;

        for (int i = 0; i < interi.length; i++)
        {
            if (tempRoot.figli != null)
            {
                for (int j = 0; j < tempRoot.figli.size()-1; j++)
                {
                    if (tempRoot.figli.get(j).valore == interi[0]) present = true;
                }
            }
            if (!present) { tempRoot.add(new Nodo(null, interi[0])); }
            for (Nodo f : tempRoot.figli)
            {
                index++;
                if (f.valore == interi[0])
                {
                    if (index <= tempRoot.figli.size()-1) tempRoot = tempRoot.figli.get(index);
                    if (interi.length >= 1) interi = Arrays.copyOfRange(interi, 1, interi.length);
                    add(tempRoot, interi);
                    break;
                }
            }
            break;
        }
    }

    public void remove(int r) throws NodeNotFound
    {
        if (!contains(r)) throw new NodeNotFound();
        if (root.valore == r)
        {
            for (int i = 1; i < root.figli.size(); i++)
            {
                root.figli.get(0).figli.add(root.figli.get(i));
            }
            root = root.figli.get(0);
        }
        else { remove(root, r); }
    }

    public void remove(Nodo tempRoot, int r)
    {
        if (tempRoot.figli != null)
        {
            for (int i = 0; i < tempRoot.figli.size(); i++)
            {
                if (tempRoot.figli.get(i).valore == r)
                {
                    for (Nodo n : tempRoot.figli.get(i).figli) tempRoot.figli.add(n);
                    tempRoot.figli.remove(i);
                }
                else
                {
                    tempRoot = tempRoot.figli.get(i);
                    remove(tempRoot, r);
                    break;
                }
            }
        }
    }

    public boolean contains(int val) { return contains(root, val); }

    private boolean contains(Nodo n, int val)
    {
        boolean found = false;
        if (n == null) return found;
        if (n.valore == val) found = true;
        else if (n.figli != null) for (Nodo f : n.figli) { return contains(f, val); }
        return found;
    }

    public void print()
    {
        System.out.println("La radice è "+root.valore+".");
        for (Nodo n : root.figli)
        {
            System.out.println(n.valore+" è figlio della radice.");
            printChildren(n);
        }
    }

    public void printChildren(Nodo n)
    {
        if (n.figli != null)
        {
            for (Nodo figlio : n.figli)
            {
                System.out.println("Il nodo "+n.valore+" ha come figlio "+figlio.valore+".");
                printChildren(figlio);
            }
        }
    }

    public static void main(String[] args) throws RootsNotEqual, NodeNotFound
    {
        Albero pioppo = new Albero();

        pioppo.add( new int[] { 1, 2, 5 });
        pioppo.add( new int[] { 1, 4, 0, 0 } );
        pioppo.add( new int[] { 1, 3, 6 });
        pioppo.print();
        System.out.println("**********");
        pioppo.add( new int[] { 1, 2, 7 });
        pioppo.print();
    }
}
