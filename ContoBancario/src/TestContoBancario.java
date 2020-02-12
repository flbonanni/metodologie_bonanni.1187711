public class TestContoBancario
{
    public static void main(String[] args)
    {
        ContoBancario conto = new ContoBancario(1234, 1000.0);
        ContoBancario altroConto = new ContoBancario(567, 10000.0);

        System.out.println("Conto n° "+conto.getIBAN()+".");
        new SituazioneConto(conto).esegui();

        new PrelevaDenaro(conto, 3.00).esegui();
        new PrelevaDenaro(conto, 2.00).esegui();
        new SvuotaConto(conto).esegui();
        new VersaDenaro(conto, 2000.00).esegui();
        new Bonifico(conto, altroConto, 500).esegui();

        conto.getElencoOp();
        new SituazioneConto(conto).esegui();

        System.out.println("Conto n° "+altroConto.getIBAN()+".");

        altroConto.getElencoOp();
        new SituazioneConto(altroConto).esegui();
    }
}
