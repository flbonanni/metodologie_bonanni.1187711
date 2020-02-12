/**
 * 
 * @author Flavia Bonanni
 */

public class StringheVerticali
{
	/**
	 * 
	 * @param input
	 * @return la lunghezza della stringa più lunga
	 */
    public int determineMax(String[] input)
    {
        int max = 0;

        for (int i = 0; i < input.length; i++)
        {
            if (input[i].length() > max) { max = input[i].length(); }
        }

        return max;
    }

    /**
     * 
     * @param input
     */
    public void makeVertical(String[] input)
    {
        StringBuilder sb = new StringBuilder();
        StringheVerticali SV = new StringheVerticali();

        for (int j = 0; j < SV.determineMax(input); j++)
        {
            for (int i = 0; i < input.length; i++)
            {
                if (j >= input[i].length()) sb.append(" ");
                else sb.append(input[i].charAt(j));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args)
    {
        StringheVerticali SV = new StringheVerticali();
        SV.makeVertical(new String[] { "ciao", "bella", "ok" });
    }
}