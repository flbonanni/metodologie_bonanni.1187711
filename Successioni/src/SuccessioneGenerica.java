import java.util.*;

/**
 * 
 * @author Flavia Bonanni
 */

public abstract class SuccessioneGenerica implements Iterable<Integer>
{
    private List<Integer> successione = new ArrayList<>();

    public List<Integer> getSuccessione() { return successione; }
    public void setSuccessione(List<Integer> l) { successione = l; }

    public SuccessioneGenerica() { for (int i = 0; i < 100; i++) getSuccessione().add(generaProssimo(i)); }

    public Integer generaProssimo(int i) { return null; }
}
