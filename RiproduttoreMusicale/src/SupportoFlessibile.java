import java.util.List;

/**
 * 
 * @author Flavia Bonanni
 */

public abstract class SupportoFlessibile extends Supporto
{
	/**
	 * @param b brano da aggiungere
	 */
    public void add(List<Brano> b) { super.add(b); }

    // overload del metodo add
    /**
     * 
     * @param b brano da aggiungere
     * @param posizione in cui aggiungerlo
     */
    public void add(List<Brano> b, int posizione)
    {
        int input = 0;
        for (int i = 0; i < b.size(); i++)
        {
            if (posizione+i < getTracklist().size()) getTracklist().add(posizione + i, b.get(input++));
        }
    }
}
