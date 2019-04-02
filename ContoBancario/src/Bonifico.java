/**
 * 
 * @author Flavia Bonanni
 */

public class Bonifico extends Operazione
{
    ContoBancario conto;
    ContoBancario altroConto;
    double quantita;

    /**
     * 
     * @param conto
     * @param altroConto
     * @param quantita
     */
    public Bonifico(ContoBancario conto, ContoBancario altroConto, double quantita)
    {
        this.conto = conto;
        this.altroConto = altroConto;
        this.quantita = quantita;
    }

    public void esegui()
    {
        new PrelevaDenaro(conto, quantita).esegui();
        new VersaDenaro(altroConto, quantita).esegui();
    }
}
