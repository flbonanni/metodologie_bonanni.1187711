/**
 * 
 * @author Flavia Bonanni
 */

public class StringaVerticale
{
	/**
	 * 
	 * @param input
	 */
    public void StringaVerticale(String input)
    {
        int i = 0;
        for (i = 0; i < input.length() - 1; i++)
        {
            System.out.println(input.charAt(i));
        }
        System.out.print(input.charAt(i));
    }

    public static void main(String[] args)
    {
        StringaVerticale SV = new StringaVerticale();
        SV.StringaVerticale("ciao");
    }
}
