/**
 * Test dell'interfaccia valutabile
 * 
 * @author Flavia Bonanni
 */

public class ValutaValutabili
{
    MockObject[] objArray;

    /**
     * @param objArray di oggetti
     */
    public ValutaValutabili(MockObject ... objArray) { this.objArray = objArray; }

    public boolean valutaInAnd() { return valutaInAnd(0, true); }

    public boolean valutaInOr() { return valutaInOr(0, false); }

    /**
     * @param k indice di ricorsione
     * @param b il risultato booleano finora
     * @return valore boolean and tra oggetti
     */
    public boolean valutaInAnd(int k, boolean b)
    {
        if (k == objArray.length-1) return b;
        boolean obj1 = objArray[k].getB();
        boolean obj2 = objArray[k+1].getB();
        // System.out.println("boolean = "+b);
        // System.out.println("oggetto "+k+" "+obj1);
        // System.out.println("oggetto "+(k+1)+" "+obj2);
        boolean c = obj1 && obj2;
        // System.out.println(c);
        // System.out.println("********");
        return (b && valutaInAnd(k+1, c));
    }

    /**
     * @param k indice di ricorsione
     * @param b il risultato booleano finora
     * @return valore boolean or tra oggetti
     */
    public boolean valutaInOr(int k, boolean b)
    {
        if (k == objArray.length-1) return b;
        boolean obj1 = objArray[k].getB();
        boolean obj2 = objArray[k+1].getB();
        // System.out.println("boolean = "+b);
        // System.out.println("oggetto "+k+" "+obj1);
        // System.out.println("oggetto "+(k+1)+" "+obj2);
        boolean c = obj1 || obj2;
        // System.out.println(c);
        // System.out.println("********");
        return (b || valutaInOr(k+1, c));
    }

    public static void main(String[] args)
    {
        MockObject[] list = new MockObject[3];
        for (int i = 0; i < list.length; i++)
        {
            list[i] = new MockObject();
            System.out.println(list[i].getB());
        }
        ValutaValutabili vv = new ValutaValutabili(list);
        System.out.println("L'AND tra gli oggetti vale: "+vv.valutaInAnd());
        System.out.println("L'OR tra gli oggetti vale: "+vv.valutaInOr());
    }
}
