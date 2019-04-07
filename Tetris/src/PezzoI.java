/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoI extends Pezzo
{
    private String[][] a = {{ " ", "*", " " },
                            { " ", "*", " " },
                            { " ", "*", " " }};

    public PezzoI()
    {
        setTetramino(a);
    }
}
