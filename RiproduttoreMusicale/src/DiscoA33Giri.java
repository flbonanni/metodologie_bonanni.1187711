import java.util.ArrayList;

/**
 * 
 * @author Flavia Bonanni
 */

public class DiscoA33Giri extends Supporto
{
    public DiscoA33Giri()
    {
        setTracklist(new ArrayList<Brano>(14));
        for (int i = 0; i < 14; i++) getTracklist().add(null);
    }
}
