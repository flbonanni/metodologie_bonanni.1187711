/**
 * 
 * @author Flavia Bonanni
 */

public class TestListaLinkataClasseInterna
{
    public static void main(String[] args)
    {
    	ListaLinkataClasseInterna l = new ListaLinkataClasseInterna(4, 8, 15, 16);
        l.add(23);
        l.add(42);
        for (int k : l) System.out.println(k);
        System.out.println(l);
    }
}
