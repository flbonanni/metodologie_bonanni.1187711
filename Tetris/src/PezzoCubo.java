/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoCubo extends Pezzo
{
    private String[][] a = {{ "*", "*", " " },
                            { "*", "*", " " },
                            { " ", " ", " " }};

    public PezzoCubo()
    {
        setTetramino(a);
    }
}
