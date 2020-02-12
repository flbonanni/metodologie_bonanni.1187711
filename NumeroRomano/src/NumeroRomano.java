/**
 * 
 * @author Flavia Bonanni
 */

public class NumeroRomano
{
    private String numero;

    /**
     * 
     * @param numero
     */
    public NumeroRomano(String numero) { this.numero = numero; }

    /**
     * 
     * @return intero
     */
    public int toInteger()
    {
        int traduzione = 0;
        int[] intArray = new int[numero.length()];
        for (int i = 0; i < numero.length(); i++)
        {
            intArray[i] = toInt(numero.charAt(i));
        }
        for (int i = 0; i < intArray.length-1; i++)
        {
            if (intArray[i] < intArray[i+1]) traduzione += (intArray[i+1]-intArray[i]);
            else traduzione += intArray[i];
        }
        traduzione += intArray[intArray.length-1];
        return traduzione;
    }

    /**
     * 
     * @param a carattere
     * @return intero
     */
    public int toInt(char a)
    {
        switch(a)
        {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        NumeroRomano NR = new NumeroRomano("LXXXVIII");
        System.out.println(NR.toInteger());
    }
}
