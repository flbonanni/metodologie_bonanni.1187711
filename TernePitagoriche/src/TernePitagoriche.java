/**
 * 
 * @author Flavia Bonanni
 */

public class TernePitagoriche
{
	/**
	 * 
	 * @param N
	 */
    public void Pitagorean(int N)
    {
        for (int i = 2; i < N; i++)
        {
            for (int j = 2; j < N; j++)
            {
                for (int k = N; k > 1; k--)
                {
                    if (i < j && (i*i+j*j)/k == k && (i*i+j*j)%k == 0)
                    {
                        System.out.println("a="+i+" b="+j+" c="+k);
                    }
                }
            }
        }
    }

    /**
     * 
     * @param N
     */
    public TernePitagoriche(int N)
    {
        Pitagorean(N);
    }

    public static void main(String[] args)
    {
        new TernePitagoriche(15);
    }
}
