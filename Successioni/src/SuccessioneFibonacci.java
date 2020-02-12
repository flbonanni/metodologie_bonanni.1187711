import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class SuccessioneFibonacci extends SuccessioneGenerica
{
    public Integer generaProssimo(int i)
    {
        if (i <= 1) return 1;
        else return (int) getSuccessione().get(i-2) + getSuccessione().get(i-1);
    }

    public Iterator<Integer> iterator()
    {
        return getSuccessione().iterator();
    }
}
