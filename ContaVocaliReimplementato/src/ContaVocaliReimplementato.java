/**
 * 
 * @author Flavia Bonanni
 */

public class ContaVocaliReimplementato
{
	/**
	 * 
	 * @param input
	 */
    public void StampaConto(String input)
    {
        int[] arrInt = new int[5];

        for (int j = 0; j < input.length(); j++)
        {
            switch (input.charAt(j))
            {
                case 'a':   arrInt[0]++; break;
                case 'e':   arrInt[1]++; break;
                case 'i':   arrInt[2]++; break;
                case 'o':   arrInt[3]++; break;
                case 'u':   arrInt[4]++; break;
            }
        }

        System.out.println("a="+arrInt[0]+", e="+arrInt[1]+", i="+arrInt[2]+", o="+arrInt[3]+", u="+arrInt[4]+".");
    }

    public static void main(String[] args)
    {
        ContaVocaliReimplementato CVR = new ContaVocaliReimplementato();
        CVR.StampaConto("le aiuole sono pulite");
    }
}
