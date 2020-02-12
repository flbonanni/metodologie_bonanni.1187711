import java.util.*;

/**
 * Rappresenta una lista di successioni
 * 
 * @author Flavia Bonanni
 */

public class SuccessioniNumeriche
{
    private Map<String, ArrayList<?>> successioni = new HashMap<>();

    public void addSuccessione(String nome, ArrayList<? extends Number> sequenzaNumerica)
    {
        successioni.put(nome, sequenzaNumerica);
    }

    @Override
    public String toString()
    {
        return successioni.toString();
    }

    public static void main(String[] args)
    {
        SuccessioniNumeriche sn1 = new SuccessioniNumeriche();
        ArrayList<Integer> Fibonacci = new ArrayList<>();
        ArrayList<Double> OneOverN = new ArrayList<>();
        ArrayList<Long> RandomLong = new ArrayList<>();
        Collections.addAll(Fibonacci, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        Collections.addAll(OneOverN, 1.0, 1.0/2, 1.0/3, 1.0/4, 1.0/5, 1.0/6);
        Random r = new Random();
        for (int i = 0; i < 7; i++) Collections.addAll(RandomLong, r.nextLong());
        sn1.addSuccessione("Fibonacci", Fibonacci);
        sn1.addSuccessione("1/n", OneOverN);
        sn1.addSuccessione("RandomLong", RandomLong);
        System.out.println(sn1);
    }
}
