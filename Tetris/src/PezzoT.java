/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoT extends Pezzo
{
    private String[][] a = {{ "*", "*", "*" },
                            { "_", "*", "_" },
                            { "_", "_", "_" }};

    public PezzoT()
    {
        setTetramino(a);
    }
}
