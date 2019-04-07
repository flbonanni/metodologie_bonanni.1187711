/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoSerp extends Pezzo
{
    private String[][] a = {{ "*", " ", " " },
                            { "*", "*", " " },
                            { " ", "*", " " }};

    public PezzoSerp()
    {
        setTetramino(a);
    }
}

