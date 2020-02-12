/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoL extends Pezzo
{
    private String[][] a = {{ "*", " ", " " },
                            { "*", " ", " " },
                            { "*", "*", " " }};

    public PezzoL()
    {
        setTetramino(a);
    }

    /*
    public static void main(String[] args)
    {
        PezzoL l = new PezzoL();
        System.out.println(l.getTetramino()[1][0]);
    } */
}