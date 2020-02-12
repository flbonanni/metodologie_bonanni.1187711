/**
 * 
 * @author Flavia Bonanni
 */

public class TestEspressione
{
    public static void main(String[] args)
    {
        // -(5+(3/2)-2)*x
        Costante _5 = new Costante(5);
        Costante _2 = new Costante(2);
        Costante _3 = new Costante(3);
        Variabile x1 = new Variabile("x1", 3);
        Variabile x2 = new Variabile("x2", 6);
        EspressioneComposta _3div2 = new EspressioneComposta(_3,"/",_2);
        EspressioneComposta _5piu3div2 = new EspressioneComposta(_5,"+",_3div2);
        EspressioneComposta _5piu3div2men2 = new EspressioneComposta(_5piu3div2,"-",_2);
        EspressioneComposta _men5piu3div2men2 = new EspressioneComposta("-", _5piu3div2men2);
        EspressioneComposta _men5piu3div2men2perx1 = new EspressioneComposta(_men5piu3div2men2,"*",x1);
        EspressioneComposta _men5piu3div2men2perx2 = new EspressioneComposta(_men5piu3div2men2,"*",x2);
        System.out.println(_men5piu3div2men2perx1.getValore());
        System.out.println(_men5piu3div2men2perx2.getValore());
    }



}
