/**
 * Corridoio di un labirinto
 * 
 * @author Flavia Bonanni
 */

public class Corridoio
{
    private int ingressi;
    private boolean Minotauro;
    private Corridoio[] successivi;
    private int n;

    public Corridoio(int ingressi)
    {
        this.ingressi = ingressi;
        successivi = new Corridoio[ingressi];
    }

    public Corridoio[] getSuccessivi() { return successivi; }

    public int getN() { return n; }

    public void setN(int n) { this.n = n; }

    public void setSuccessivo(int n, Corridoio c) { successivi[n] = c; }

    public int getIngressi() { return ingressi; }

    public void putMinotauro() { Minotauro = true; }

    public boolean contieneMinotauro() { return Minotauro; }

    @Override
    public String toString()
    {
        return n+"";
    }
}
