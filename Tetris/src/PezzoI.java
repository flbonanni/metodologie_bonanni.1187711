/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoI extends Pezzo
{
    private String[][] a = {{ "_", "*", "_" },
                            { "_", "*", "_" },
                            { "_", "*", "_" }};

    public PezzoI()
    {
        setTetramino(a);
    }
}
