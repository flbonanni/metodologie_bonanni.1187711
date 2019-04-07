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
}