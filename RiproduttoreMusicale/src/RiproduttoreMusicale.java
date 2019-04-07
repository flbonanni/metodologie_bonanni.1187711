import java.util.List;

/**
 * 
 * @author Flavia Bonanni
 */

public abstract class RiproduttoreMusicale
{
    private Supporto supporto;
    private Brano brano;
    private List<Brano> tracklist;
    private int sel;
    private int playing;

    /**
     * 
     * @param s inserisce il supporto s
     */
    public void inserisciSupporto(Supporto s)
    {
        sel = 0;
        this.supporto = s;
        tracklist = supporto.getTracklist();
        brano = tracklist.get(sel);
        play();
    }

    /**
     * espelle il supporto
     */
    public void espelliSupporto() { supporto = null; }

    /**
     * 
     * @return brano in riproduzione
     */
    public Brano getBrano()
    {
        if (playing == 1) return brano;
        else return null;
    }

    public void play() { playing = 1; }

    public void stop() { playing = 0; }

    public void next() { brano = tracklist.get(++sel); }

    public void prev() { brano = tracklist.get(--sel); }

    @Override
    public String toString()
    {
        return brano.toString();
    }
}
