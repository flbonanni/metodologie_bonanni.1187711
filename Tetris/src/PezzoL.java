/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoL extends Pezzo
{
    private String[][] a = {{ "*", "_", "_" },
                            { "*", "_", "_" },
                            { "*", "*", "_" }};

    public PezzoL()
    {
        setTetramino(a);
    }
}
