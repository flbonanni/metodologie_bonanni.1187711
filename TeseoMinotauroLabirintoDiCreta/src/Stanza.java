/**
 * Stanza di un labirinto
 * 
 * @author Flavia Bonanni
 */

public class Stanza extends Cella
{
    private boolean Minotauro;

    public boolean getMinotauro() { return Minotauro; }

    public void setMinotauro(boolean b) { Minotauro = b; }

    @Override
    public String toString()
    {
        if (Minotauro) return "M";
        return "_";
    }
}
