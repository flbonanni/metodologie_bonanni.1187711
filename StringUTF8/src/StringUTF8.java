/**
 * 
 * @author Flavia Bonanni
 */

public class StringUTF8
{
    private byte[] convertitoInUTF8 = new byte[1];

    public StringUTF8(int[] arrayDiInt)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayDiInt.length; i++)
        {
            sb.append(arrayDiInt[i]);
        }
        int codiceUnito = Integer.parseInt(sb.toString());
        convertitoInUTF8[0] = (byte)codiceUnito;
    }

    @Override
    public String toString()
    {
        String str = new String(convertitoInUTF8);

        System.out.println(str);

        return str;
    }

    public static void main(String[] args)
    {
        StringUTF8 SUTF8 = new StringUTF8(new int[]{7, 0});
        SUTF8.toString();
    }
}