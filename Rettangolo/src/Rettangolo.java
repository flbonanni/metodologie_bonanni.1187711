public class Rettangolo
{
    int x;
    int y;
    int height;
    int width;
    Colore color;

    public Rettangolo(int x, int y, int height, int width)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        color = Colore.NERO;
    }

    public void trasla(int addHorizontal, int addVertical)
    {
        x += addHorizontal;
        y += addVertical;
    }

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
