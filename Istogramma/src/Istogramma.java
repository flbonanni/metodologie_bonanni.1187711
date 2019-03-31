/**
 * 
 * @author Flavia Bonanni
 */

public class Istogramma
{
    int[] arrayDiInt;
    int inizio;
    int intervallo;

    /**
     * 
     * @param inizio
     * @param fine
     */
    public Istogramma(int inizio, int fine)
    {
        this.inizio = inizio;
        intervallo = fine-inizio+1; //+1 per comprendere anche il primo numero
        arrayDiInt = new int[intervallo];
    }

    /**
     * 
     * @param nuovoDato
     */
    public void incrementaUno(int nuovoDato)
    {
        arrayDiInt[nuovoDato-inizio]++;
        // per far funzionare l'incr. relativamente, ovvero anche dove i numeri non partono da 0
    }

    public void stampaOriz()
    {
        StringBuilder sb = new StringBuilder();
        // for al contrario per avere prima il numero più grande
        for (int i = arrayDiInt.length-1; i >= 0; i--)
        {
            sb.setLength(0);
            if (i+inizio < 10) { sb.append(inizio+i+"  | "); }
            else { sb.append(inizio+i+" | "); }
            // per ogni numero, appendi un o a seconda del valore del numero, come indicato nell'array
            for (int j = 0; j < arrayDiInt[i]; j++) { sb.append("o"); }
            System.out.println(sb);
        }
        System.out.println("");
    }

    public void stampaVert()
    {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        // trovare il max
        for (int i = 0; i < arrayDiInt.length; i++)
        {
            if (arrayDiInt[i] > max) { max = arrayDiInt[i]; }
        }
        // ci saranno tante linee quant'è il max
        int copiaDiMax = max;
        for (int i = 0; i < copiaDiMax; i++)
        {
            for (int j = 0; j < arrayDiInt.length; j++)
            {
                if (arrayDiInt[j] >= max) { sb.append("o  "); }
                else { sb.append("_  "); }
            }
            max--;
            sb.append('\n');
        }
        System.out.println(sb);
        for (int i = 0; i < intervallo; i++)
        {
            if (inizio+i < 10) { System.out.print(inizio+i+"  "); }
            else { System.out.print(inizio+i+" "); }
        }
    }

    public static void main(String[] args)
    {
        Istogramma voti = new Istogramma(0, 31);
        voti.incrementaUno(18);
        voti.incrementaUno(18);
        voti.incrementaUno(16);
        voti.stampaOriz();
        Istogramma altro = new Istogramma(86, 98);
        for  (int i = 0; i < 38; i++) { altro.incrementaUno(98); }
        for (int i = 0; i < 42; i++) { altro.incrementaUno(94); }
        altro.stampaOriz();
        voti.stampaVert();
        System.out.println("");
        altro.stampaVert();
    }
}
