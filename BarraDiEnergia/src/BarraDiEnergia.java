/**
 * 
 * @author Flavia Bonanni
 */

public class BarraDiEnergia
{
    public String s = "";
    private int lunghezza;

    // public BarraDiEnergia() {}

    /**
    * 
    * @param k lunghezza massima
    */
    public BarraDiEnergia(int k)
    {
        this.lunghezza = k;
        for (int i = 0; i < k; i++)
            s += "=";
    }

    /**
     * Metodo per incrementare di uno
     * @param k
     */
    public void incrementa(int k)
    {
        String t = "";
        int start = 0;
        for (int i = 0; i < k; i++)
            t += "O";
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '=') start = i;
            break;
        }
        String primaMeta = s.substring(0, start);
        s = primaMeta+t;
        int differenza = lunghezza-s.length();
        for (int i = 0; i < differenza; i++)
            s += "=";
    }


    /**
     *  Metodo per stampare, in stile "OOO====="
     */
    @Override
    public String toString()
    {
        System.out.println(s);
        return s;
    }

    public static void main(String[] args)
    {
        BarraDiEnergia barretta = new BarraDiEnergia(10);
        barretta.toString();
        barretta.incrementa(3);
        barretta.toString();
    }
}
