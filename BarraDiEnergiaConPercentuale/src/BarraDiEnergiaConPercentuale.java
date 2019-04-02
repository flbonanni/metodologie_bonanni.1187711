/**
 * 
 * @author Flavia Bonanni
 */

public class BarraDiEnergiaConPercentuale extends BarraDiEnergia
{
    int lunghezza;

    // Costruttore con un intero k (lunghezza massima)
    
    public BarraDiEnergiaConPercentuale(int k)
    {
        super(k);
        this.lunghezza = k;
        aggiungiPercentuale();
    }

    public void aggiungiPercentuale()
    {
        int incrementi = 0;
        for (int i = 0; i < lunghezza; i++)
            if (s.charAt(i) == 'O') incrementi++;
        s += " "+calcoloPercentuale(incrementi, lunghezza)+"%";
    }

    public int calcoloPercentuale(int O, int k)
    {
        int percentuale = 100*O/k;
        return percentuale;
    }

    public void incrementa(int k)
    {
        super.incrementa(k);
        aggiungiPercentuale();
    }

    public static void main(String[] args)
    {
        BarraDiEnergiaConPercentuale barrettaCP = new BarraDiEnergiaConPercentuale(10);
        barrettaCP.toString();
        barrettaCP.incrementa(6);
        barrettaCP.toString();
    }
}
