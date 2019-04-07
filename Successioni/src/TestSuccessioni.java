/**
 * 
 * @author Flavia Bonanni
 */

public class TestSuccessioni
{
    public static void main(String[] args)
    {
        SuccessioneI2 i2 = new SuccessioneI2();
        SuccessioneCasuale SC = new SuccessioneCasuale();
        SuccessioneFibonacci fib = new SuccessioneFibonacci();
        SuccessioneInfinita SI = new SuccessioneInfinita();

        for (Integer i : i2) { System.out.print(i+", "); }
        System.out.println();
        for (Integer i : SC) { System.out.print(i+", "); }
        System.out.println();
        for (Integer i : fib) { System.out.print(i+", "); }
        System.out.println();
        for (Integer i : SI) { System.out.print(i+", "); }
        System.out.println();
    }
}
