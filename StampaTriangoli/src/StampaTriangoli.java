/**
 * 
 * @author Flavia Bonanni
 */

public class StampaTriangoli
{
	/**
	 * 
	 * @param N
	 */
    public void StampaTriangoli(int N)
    {
        int numeroRighe = (N+1)/2;
        int numeroVuoti = (N-1)/2;
        int numeroAst = 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbLaterale = new StringBuilder();
        StringBuilder sbAst = new StringBuilder();

        for (int i = 0; i < numeroRighe; i++) // crea tre righe
        {
            // per ogni riga
            for (int j = 0; j < numeroVuoti; j++)
            {
                sbLaterale.append(" ");
            }
            for (int j = 0; j < numeroAst; j++)
            {
                sbAst.append("*");
            }
            sb.append(sbLaterale).append(sbAst).append(sbLaterale).append('\n');
            sbLaterale.setLength(0);
            sbAst.setLength(0);
            numeroVuoti--;
            numeroAst += 2;
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args)
    {
        new StampaTriangoli().StampaTriangoli(9);
    }
}
