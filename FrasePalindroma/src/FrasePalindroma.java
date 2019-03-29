/**
 * 
 * @author Flavia Bonanni
 */

public class FrasePalindroma
{
	/**
	 * 
	 * @param input
	 */
    public void isPalindrome (String input)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder halfString = new StringBuilder();
        StringBuilder secondHalf = new StringBuilder();
        sb.append(input);
        halfString.append(sb.substring(0, sb.length()/2));
        secondHalf.append(sb.substring(sb.length()/2+1, sb.length()));

        if (halfString.toString().equals(reverseString(secondHalf).toString()))
        {
            System.out.println("Hai trovato un palindromo.");
        }
        else { System.out.println("Non è un palindromo."); }
    }

    /**
     * @param obj da invertire
     * @return stringa invertita
     */
    public StringBuilder reverseString(StringBuilder obj)
    {
        StringBuilder jbo = new StringBuilder();
        for (int i = obj.length()-1; i >= 0; i--)
        {
            jbo.append(obj.charAt(i));
        }
        return jbo;
    }

    public static void main(String[] args)
    {
        FrasePalindroma FP = new FrasePalindroma();
        FP.isPalindrome("angelalavalalegna");
        FP.isPalindrome("itopinonavevanonipoti");
    }
}
