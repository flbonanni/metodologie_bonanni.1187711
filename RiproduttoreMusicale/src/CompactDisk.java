import java.util.ArrayList;

/**
 * 
 * @author Flavia Bonanni
 */

public class CompactDisk extends Supporto
{
    public CompactDisk()
    {
        setTracklist(new ArrayList<Brano>(20));
        for (int i = 0; i < 20; i++) getTracklist().add(null);
    }
}