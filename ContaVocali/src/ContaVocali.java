/**
 * 
 * @author Flavia Bonanni
 */

public class ContaVocali
{
	/**
	 * 
	 * @param input
	 */
    public void StampaConto(String input)
    {
        int a = 0;
        int e = 0;
        int i = 0;
        int o = 0;
        int u = 0;

        for (int j = 0; j < input.length(); j++)
        {
            switch (input.charAt(j))
            {
                case 'a':   a++; break;
                case 'e':   e++; break;
                case 'i':   i++; break;
                case 'o':   o++; break;
                case 'u':   u++; break;
            }
        }

        System.out.println("a="+a+", e="+e+", i="+i+", o="+o+", u="+u+".");
    }

    public static void main(String[] args)
    {
        ContaVocali CV = new ContaVocali();
        CV.StampaConto("ciaooo");
    }
}
