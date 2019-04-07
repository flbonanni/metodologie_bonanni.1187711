/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoSerp extends Pezzo
{
    private String[][] a = {{ "*", "_", "_" },
                            { "*", "*", "_" },
                            { "_", "*", "_" }};

    public PezzoSerp()
    {
        setTetramino(a);
    }
}
