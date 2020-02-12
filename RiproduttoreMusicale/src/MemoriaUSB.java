import java.util.ArrayList;

/**
 * 
 * @author Flavia Bonanni
 */

public class MemoriaUSB extends SupportoFlessibile
{
    public MemoriaUSB()
    {
        setTracklist(new ArrayList<Brano>(1024));
        for (int i = 0; i < 1024; i++) getTracklist().add(null);
    }
}