import java.util.List;

/**
 * 
 * @author Flavia Bonanni
 */

public abstract class Supporto
{
    private List<Brano> tracklist;

    public List<Brano> getTracklist() { return tracklist; }
    public void setTracklist(List<Brano> b) { tracklist = b; }

    /**
     * 
     * @param b da aggiungere alla tracklist
     */
    public void add(List<Brano> b)
    {
        int primaPosizioneVuota = 0;
        int input = 0;
        primaPosizioneVuota = tracklist.indexOf(null);
        if (primaPosizioneVuota == -1) { primaPosizioneVuota = 0; }
        for (int i = 0; i < b.size(); i++)
        {
            if (primaPosizioneVuota + i < tracklist.size()) tracklist.add(primaPosizioneVuota + i, b.get(input++));
            // nella List tracklist all'indice primaposizionevuota+i, inserisci quello che c'è nella List b all'indice input++;
        }
    }
}
