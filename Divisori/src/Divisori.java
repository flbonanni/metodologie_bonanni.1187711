/**
 * 
 * @author Flavia Bonanni
 */

public class Divisori
{
	/**
	 * 
	 * @param integer
	 */
    public void ProperDiv(int integer)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < integer; i++)
        {
            if ((integer % i) == 0)
            {
                sb.append(i+", ");
            }
        }
        StringBuilder sc = new StringBuilder();
        sc.append(sb.substring(0, sb.length()-2));

        System.out.println(sc);
    }

    public static void main(String[] args)
    {
        Divisori Test = new Divisori();
        Test.ProperDiv(100);
    }
}
