import java.text.*;

/**
 * 
 * @author Flavia Bonanni
 */

public class DistributoreDiBevande
{
    private Prodotto[] contenutoDistributore;
    private double importo;

    public DistributoreDiBevande(int N) { contenutoDistributore = new Prodotto[N]; }

    /**
     * 
     * @param importo
     */
    public void inserisciImporto(double importo) { this.importo = importo; }

    /**
     * 
     * @param P
     * @return prodotto contenuto
     */
    public Prodotto getProdotto(int P)
    {
        double soldiSpesi = 0;
        importo -= contenutoDistributore[P].getPrezzo();
        return contenutoDistributore[P];
    }

    public double getSaldo() { return importo; }

    public double getResto()
    {
        double saldo = importo;
        importo = 0;
        return saldo;
    }

    public void carica()
    {
        for (int i = 0; i < contenutoDistributore.length; i++)
        {
            int random = (int) (Math.random() * 3);
            {
                switch (random)
                {
                    case 0:
                        contenutoDistributore[i] = new Caffe();
                        break;
                    case 1:
                        contenutoDistributore[i] = new Cappuccino();
                        break;
                    case 2:
                        contenutoDistributore[i] = new Cioccolato();
                        break;
                }
            }
        }
    }

    public void stampa()
    {
        for (int i = 0; i < contenutoDistributore.length; i++) { System.out.println(contenutoDistributore[i]); }
    }

    public static void main(String[] args)
    {
        DecimalFormat df = new DecimalFormat("#0.00");
        DistributoreDiBevande ddb = new DistributoreDiBevande(8);
        ddb.carica();
        ddb.inserisciImporto(5.0);
        ddb.getProdotto(0);
        ddb.getProdotto(1);
        ddb.getProdotto(2);
        System.out.println(df.format(ddb.getResto()));
    }
}
