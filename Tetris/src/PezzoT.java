/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoT extends Pezzo
{
    private String[][] a = {{ "*", "*", "*" },
                            { " ", "*", " " },
                            { " ", " ", " " }};

    public PezzoT()
    {
        setTetramino(a);
    }
}
