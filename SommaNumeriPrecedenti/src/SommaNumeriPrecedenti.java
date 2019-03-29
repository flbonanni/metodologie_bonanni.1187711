/**
 * 
 * @author Flavia Bonanni
 */

public class SommaNumeriPrecedenti
{
	/**
	 * 
	 * @param a addendo
	 * @param b addendo
	 * @param N numeri della sequenza in cui ogni numero è la somma dei due precedenti
	 */
    public void PrintSequence (int a, int b, int N)
    {
        int[] myArray = new int[N+2];
        myArray[0] = a;
        myArray[1] = b;
        for (int i = 2; i < N+2; i++)
        {
            myArray[i] = myArray[i-2]+myArray[i-1];
        }
        for (int j = 0; j < myArray.length-1; j++)
        {
            System.out.print(myArray[j]+", ");
        }
        System.out.print(myArray[myArray.length-1]);
    }

    public static void main(String[] args)
    {
        SommaNumeriPrecedenti SNP = new SommaNumeriPrecedenti();
        SNP.PrintSequence(2, 3, 6);
    }
}
