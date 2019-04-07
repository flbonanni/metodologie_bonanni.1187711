import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class SuccessioneCasuale extends SuccessioneGenerica
{
    public Integer generaProssimo(int i)
    {
        int range = (200 - (-200)) + 1;
        return (int)((Math.random() * range) - 200);
    }

    public Iterator<Integer> iterator()
    {
        return getSuccessione().iterator();
    }
}
