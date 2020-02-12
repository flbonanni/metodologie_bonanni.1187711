import java.util.ArrayList;
import java.util.List;

class TorreDiHanoi
{
    private int N;
    private List<Integer> palo1 = new ArrayList<>();
    private List<Integer> palo2 = new ArrayList<>();
    private List<Integer> palo3 = new ArrayList<>();

    /**
     * @param N numero di dischi
     */
    public TorreDiHanoi(int N)
    {
        this.N = N;
        for (int i = N; i >= 1; i--) palo1.add(i);
        System.out.println(palo1.toString());
        System.out.println(palo2.toString());
        System.out.println(palo3.toString());
        sposta(N, 1, 3, 2);
    }

    /**
     * @param n disco da spostare
     * @param partenza palo di partenza
     * @param arrivo palo di arrivo
     * @param appoggio palo di appoggio
     */
    public void sposta(int n, int partenza, int arrivo, int appoggio)
    {
        if (n == 1)
        {
            System.out.println("Sposta il disco 1 dal palo " +  partenza + " al palo " + arrivo);
            registraSpostamento(1, partenza, arrivo);
            System.out.println(palo1.toString());
            System.out.println(palo2.toString());
            System.out.println(palo3.toString());
            return;
        }
        sposta(n-1, partenza, appoggio, arrivo);
        System.out.println("Sposta il disco " + n + " dal palo " +  partenza + " al palo " + arrivo);
        registraSpostamento(n, partenza, arrivo);
        System.out.println(palo1.toString());
        System.out.println(palo2.toString());
        System.out.println(palo3.toString());
        sposta(n-1, appoggio, arrivo, partenza);
    }

    /**
     * @param n disco spostato
     * @param partenza palo di partenza
     * @param arrivo palo di arrivo
     */
    public void registraSpostamento(int n, int partenza, int arrivo)
    {
        switch (partenza)
        {
            // cast ad Integer per non confonderlo con la versione del metodo remove che toglie l'elemento all'indice i
            case 1:
                palo1.remove((Integer) n);
                break;
            case 2:
                palo2.remove((Integer) n);
                break;
            case 3:
                palo3.remove((Integer) n);
                break;
        }
        switch (arrivo)
        {
            case 1:
                palo1.add(n);
                break;
            case 2:
                palo2.add(n);
                break;
            case 3:
                palo3.add(n);
                break;
        }
    }

    public static void main(String args[])
    {
        TorreDiHanoi TdH = new TorreDiHanoi(64);
    }
}