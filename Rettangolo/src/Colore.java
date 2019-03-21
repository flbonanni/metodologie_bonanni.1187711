public class Colore
{
    int R;
    int G;
    int B;

    public Colore(int R, int G, int B)
    {
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public static final Colore BIANCO = new Colore(255, 255, 255);
    public static final Colore NERO = new Colore(0, 0, 0);
}
