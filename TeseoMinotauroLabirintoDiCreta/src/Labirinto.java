import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * classe che rappresenta il Labirinto 
 * @author Flavia Bonanni
 */

public class Labirinto
{
    Corridoio[] corridoi = new Corridoio[20];
    Corridoio ingresso;
    ArrayList<Integer> filoDiArianna = new ArrayList<>();

    public Labirinto()
    {
        int random = (int)((Math.random() * 5) +1);
        ingresso = new Corridoio(random);
        ingresso.setN(0);
        for (int i = 0; i < corridoi.length; i++)
        {
            corridoi[i] = new Corridoio(0);
        }
        for (int i = 0; i < corridoi.length; i++)
        {
            random = (int) ((Math.random() * 5)+1);
            corridoi[i] = new Corridoio(random);
            corridoi[i].setN(i+1);
        }
        stabilisciAdiacenti(ingresso);
        for (Corridoio c : corridoi) stabilisciAdiacenti(c);
        int posMinotauro = (int)(Math.random() * 21);
        corridoi[posMinotauro].putMinotauro();
    }

    /**
     * imposta a quali corridoi si può arrivare partendo dal @param corridoio c
     * @param c corridoio
     */
    public void stabilisciAdiacenti(Corridoio c)
    {
        for (int i = 0; i < c.getIngressi(); i++)
        {
            int random = (int)(Math.random() * 20);
            {
                c.setSuccessivo(i, corridoi[random]);
            }
        }
    }

    /**
     * percorso nel Labirinto
     */
    public void percorri()
    {
        boolean Minotauro = false;
        Corridoio c = ingresso;
        filoDiArianna(0);
        System.out.println("Sei all'ingresso.");
        System.out.println("L'ingresso ha "+ingresso.getIngressi()+" porte.");
        System.out.println("Dove vuoi andare? Digita il numero corrispondente alla porta scelta.");
        Scanner scan = new Scanner(System.in);
        int next = scan.nextInt();
        c = ingresso.getSuccessivi()[next-1];
        if (c.contieneMinotauro()) System.out.println("Hai trovato il Minotauro!");
        else
        {
            while (!Minotauro)
            {
                System.out.println("Sei nel corridoio "+c.getN()+".");
                filoDiArianna(c.getN());
                System.out.println("Questo corridoio ha "+c.getIngressi()+" porte.");
                System.out.println("Dove vuoi andare? Digita il numero corrispondente alla porta scelta.");
                scan = new Scanner(System.in);
                next = scan.nextInt();
                c = c.getSuccessivi()[next-1];
                if (c.contieneMinotauro())
                {
                    Minotauro = true;
                    System.out.println("Hai trovato il Minotauro nel corridoio "+c.getN()+"!");
                    Collections.reverse(filoDiArianna);
                    System.out.println(filoDiArianna);
                }
            }
        }
    }

    /**
     * Filo di Arianna contenente i corridoi
     * @param a
     */
    public void filoDiArianna(int a)
    {
        filoDiArianna.add(a);
    }

    /**
     * stampa
     */
    public void print()
    {
        System.out.println("Il corridoio 0 ha "+ingresso.getIngressi()+" ingressi.");
        System.out.println("Dal corridoio 0 si va ai corridoi "+Arrays.toString(ingresso.getSuccessivi()));
        for (Corridoio c : corridoi)
        {
            System.out.println("Il corridoio "+c.getN()+" ha "+c.getIngressi()+" ingressi.");
            System.out.println("Dal corridoio "+c.getN()+" si va ai corridoi "+Arrays.toString(c.getSuccessivi()));
            if (c.contieneMinotauro()) System.out.println("Il corridoio "+c.getN()+" contiene il Minotauro!");
        }
    }

    public static void main(String[] args)
    {
        Labirinto l = new Labirinto();
        l.print();
        l.percorri();
    }
}
