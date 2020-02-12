import java.util.ArrayList;

/**
 * 
 * @author Flavia Bonanni
 */

public class Nastro extends SupportoFlessibile
{
    private int minuti;

    public Nastro(int minuti)
    {
        this.minuti = minuti;
        setTracklist(new ArrayList<Brano>(minuti/5));
        for (int i = 0; i < minuti/5; i++) getTracklist().add(null);
    }
}
