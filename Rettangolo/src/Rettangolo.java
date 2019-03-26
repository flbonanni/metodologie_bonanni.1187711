/**
 * 
 * @author Flavia Bonanni
 */


public class Rettangolo
{
    int x;
    int y;
    int height;
    int width;
    Colore color;

    /**
     * 
     * @param x
     * @param y
     * @param height
     * @param width
     */
    public Rettangolo(int x, int y, int height, int width)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        color = Colore.NERO;
    }

    /**
     * 
     * @param addHorizontal quantità da aggiungere alla x
     * @param addVertical quantità da aggiungere alla y
     */
    public void trasla(int addHorizontal, int addVertical)
    {
        x += addHorizontal;
        y += addVertical;
    }

    /**
     * 
     * @param tinta
     */
    public void colora(Colore tinta)
    {
        color = tinta;
    }

    public String toString()
    {
        String a = ("L'angolo in alto a sinistra del tuo Rettangolo ha coordinate ("+x+", "+(y+height)+").");
        String b = ("L'angolo in basso a destra del tuo Rettangolo ha coordinate ("+(x+width)+", "+y+").");
        System.out.println(a);
        System.out.println(b);
        return a+b;
    }
}
