/**
 * Contiene un metodo ricorsivo che, dato in input un array
 * di stringhe, ne restituisca la loro concatenazione
 * @author Flavia Bonanni
 */

public class Concatena
{
    public String concatena(String[] strArray)
    {
        return concatena(strArray, 0);
    }

    public String concatena(String[] strArray, int index)
    {
        if (index == strArray.length-1) return strArray[index];
        return strArray[index] += concatena(strArray, ++index);
    }

    public void print(String[] strArray)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArray.length; i++)
        {
            sb.append(strArray[i]);
            sb.append("-");
        }
        System.out.println(sb);
    }

    public static void main(String[] args)
    {
        System.out.println(new Concatena().concatena(new String[] {"abc", "de", "f"}));
    }
}
