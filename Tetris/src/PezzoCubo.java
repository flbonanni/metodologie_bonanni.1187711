/**
 * 
 * @author Flavia Bonanni
 */

public class PezzoCubo extends Pezzo
{
    private String[][] a = {{ "*", "*", "_" },
                            { "*", "*", "_" },
                            { "_", "_", "_" }};

    public PezzoCubo()
    {
        setTetramino(a);
    }
}
