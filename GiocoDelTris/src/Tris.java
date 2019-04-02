import java.util.Scanner;

/**
 * 
 * @author Flavia Bonanni
 */

public class Tris
{
    public static void main(String[] args)
    {
        boolean win = false;
        String[] risposta = new String[2];
        ScacchieraTris ST = new ScacchieraTris();

        System.out.println("START");
        int turn = 0;
        while (!win)
        {
            Scanner input = new Scanner(System.in);
            if (turn % 2 == 0)
            {
                System.out.println("Giocatore X, coordinate X e Y della prossima mossa separate da uno spazio:");
            }
            else { System.out.println("Giocatore O, coordinate X e Y della prossima mossa separate da uno spazio:"); }
            String mossa = input.nextLine();
            risposta = mossa.split(" ");
            if (turn % 2 == 0)
            {
                ST.occupa("X", Integer.parseInt(risposta[0]), Integer.parseInt(risposta[1]));
            }
            else { ST.occupa("O", Integer.parseInt(risposta[0]), Integer.parseInt(risposta[1])); }
            ST.stampa();
            win = ST.check();
            turn++;
        }
        if (turn % 2 == 0) { System.out.println("Complimenti giocatore O!"); }
        else { System.out.println("Complimenti giocatore X!"); }
    }
}
