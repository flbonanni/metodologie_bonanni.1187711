/**
 * 
 * @author Flavia Bonanni
 */

public class Giocatore
{
    private int posizione;
    private int punti;

    public int getPosizione() { return posizione; }
    public void setPosizione(int x) { posizione = x; }
    public int getPunti() { return punti; }
    public void setPunti(int x) { punti = x; }

    /**
     * 
     * @return risultato del lancio del dado
     */
    public int tiraDadi()
    {
        int random = (int) (Math.random() * 6) + 1;
        System.out.print("Il giocatore ha tirato un "+random+". ");
        return posizione += random;
    }
}
