import java.lang.Math;

/**
 * 
 * @author Flavia Bonanni
 */

public class MazzoDiCarte
{
    static String[] semiDiCarte = new String[]{"cuori", "fiori", "picche", "quadri"};
    Carta[] arrayCarte = new Carta[52];

    public MazzoDiCarte()
    {
        int k = 0;
        for (int i = 0; i < semiDiCarte.length; i++)
        {
            for (int j = 1; j <= 13; j++)
            {
                arrayCarte[k] = new Carta(semiDiCarte[i], j);
                k++;
            }
        }
    }

    public void mescola()
    {
        int[] register = new int[52];
        Carta[] arrayCopia = new Carta[52];

        for (int i = 0; i < arrayCarte.length; i++)
        {
            int random = (int) (Math.random() * 52);
            if (register[random] == 0)
            {
                arrayCopia[random] = arrayCarte[i];
                register[random] = 1;
            }
            else { i--; }
        }
        arrayCarte = arrayCopia;
    }

    public void distribuisci()
    {
        for (int i = 0; i < arrayCarte.length; i++)
        {
            arrayCarte[i].toString();
        }
    }
}
