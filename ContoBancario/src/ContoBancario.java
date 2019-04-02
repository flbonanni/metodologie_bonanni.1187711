import java.util.Arrays;

/**
 * 
 * @author Flavia Bonanni
 */

public class ContoBancario
{
    private int IBAN;
    private double disponibilita;
    private String[] elenco = new String[0];

    /**
     * 
     * @param IBAN
     * @param disponibilita
     */
    public ContoBancario(int IBAN, double disponibilita)
    {
        this.IBAN = IBAN;
        this.disponibilita = disponibilita;
    }

    public double getDisponibilita() { return disponibilita; }
    public void setDisponibilita(double x) { disponibilita = x; }
    public int getIBAN() { return IBAN; }

    /**
     * 
     * @param s da aggiungere
     */
    public void aggiungiAElenco(String s)
    {
        String[] elencoCopy = Arrays.copyOf(elenco, elenco.length+1);
        elenco = elencoCopy;
        elenco[elenco.length-1] = s;
    }

    /**
     * 
     * @return elenco
     */
    public String[] getElenco()
    {
        for (int i = 0; i < elenco.length; i++)
        {
            System.out.println(elenco[i]);
        }
        return elenco;
    }

    private Operazione[] elencoOp = new Operazione[0];
    public void aggiungiAElencoOp(Operazione o)
    {
        Operazione[] elencoCopy = Arrays.copyOf(elencoOp, elencoOp.length+1);
        elencoOp = elencoCopy;
        elencoOp[elencoOp.length-1] = o;
    }

    public Operazione[] getElencoOp()
    {
        getElenco();
        return elencoOp;
    }
}
