import java.util.ArrayList;

/**
 * 
 * @author Flavia Bonanni
 */

public class DiscoA45Giri extends Supporto
{
    public DiscoA45Giri()
    {
        setTracklist(new ArrayList<Brano>(2));
        for (int i = 0; i < 2; i++) getTracklist().add(null);
    }
}
