import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class SuccessioneI2 extends SuccessioneGenerica
{
    public Integer generaProssimo(int i) { return i*i; }

    public Iterator<Integer> iterator()
    {
        return getSuccessione().iterator();
    }
}
