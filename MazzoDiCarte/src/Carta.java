/**
 * 
 * @author Flavia Bonanni
 */

public class Carta
{
    private String seme;
    private int valore;

    /**
     * 
     * @param seme
     * @param valore
     */
    public Carta(String seme, int valore)
    {
        this.seme = seme;
        this.valore = valore;
    }

    @Override
    public String toString()
    {
        String stringaCarta = "";

        switch(valore)
        {
            case 1:
                stringaCarta = ("asso di "+seme);
                break;
            case 2: case 3: case 4:
            case 5: case 6: case 7:
            case 8: case 9: case 10:
                stringaCarta = (valore+" di "+seme);
                break;
            case 11:
                stringaCarta = ("jack di "+seme);
                break;
            case 12:
                stringaCarta = ("regina di "+seme);
                break;
            case 13:
                stringaCarta = ("re di "+seme);
                break;
        }
        System.out.println(stringaCarta);
        return stringaCarta;
    }
}
