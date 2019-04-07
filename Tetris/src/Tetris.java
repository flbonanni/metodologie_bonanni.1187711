import java.util.Scanner;

/**
 * 
 * @author Flavia Bonanni
 */

// somministra i pezzi
// permette di muoverli
// gestisce lo spazio libero
// calcola i punteggi

public class Tetris
{
    private CampoTetris campo;
    private CampoTetris copia;
    private boolean perso = false;
    private Pezzo p;
    private int punti;
    private boolean arrivato = false;

    public Tetris()
    {
        campo = new CampoTetris(20, 11);
        // fotografare lo stato del campo all'inizio di somministra
        // inserisce un nuovo pezzo
        while (!perso)
        {
            somministra();
            // permette di muoverli
            int discesa = 0;
            while (discesa <= 19)
            {
                // presa in input
                System.out.println("Spostare il pezzo con WASD (dove W ruota il pezzo).");
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                // scelta del pezzo
                switch (input)
                {
                    case "a":
                        if (p.getAscissa() - 1 >= 0 && controllaSeVuoto(p, input)) p.left();
                        break;
                    case "s":
                        if (p.getOrdinata() + 3 <= 19 && controllaSeVuoto(p, input)) p.down();
                        break;
                    case "d":
                        if (p.getAscissa() + 3 < 11 && controllaSeVuoto(p, input)) p.right();
                        break;
                    case "w":
                        if ((p.getAscissa() - 1 >= 0) && (p.getOrdinata() + 3 < 20) && (p.getAscissa() + 3 < 11)) p.rotate();
                        break;
                }
                if (p.getOrdinata() + 3 <= 19 && controllaSeVuoto(p, "s")) p.down();
                // per fare un restore dove cambia solo il pezzo spostato
                campo = new CampoTetris(copia);
                campo.inserisci(p.getOrdinata(), p.getAscissa(), p);
                campo.stampa();
                System.out.println("Arrivato è "+arrivato);
                if (!arrivato) discesa = p.getOrdinata()+3;
                else { discesa = 20; }
                System.out.println("La discesa è "+discesa);
            }
            // calcola i punteggi
            if (campo.controlloLinea()) punti += 10;
        }
    }

    /**
     *  somministra i pezzi
     */
    public void creaCopia()
    {
        copia = new CampoTetris(campo);
        /* System.out.println("stampa della copia:");
        copia.stampa(); */
    }

    /**
     *  somministra i pezzi
     */
    public void somministra()
    {
        creaCopia();
        int random = (int)(Math.random() * 5);
        switch (random)
        {
            case 0:
                p = new PezzoT();
                break;
            case 1:
                p = new PezzoL();
                break;
            case 2:
                p = new PezzoSerp();
                break;
            case 3:
                p = new PezzoI();
                break;
            case 4:
                p = new PezzoCubo();
                break;
        }
        p.setOrdinata(0);
        p.setAscissa(4);
        campo.inserisci(0, 4, p);
        campo.stampa();
    }

    /**
     *  gestisce lo spazio libero
     * @param p pezzo
     * @param input
     * @return se è vuoto o pieno
     */
    public boolean controllaSeVuoto(Pezzo p, String input)
    {
        int x = p.getAscissa(); int y = p.getOrdinata();
        boolean vuoto = true;

        switch (input)
        {
            case "a":
                if (y-3 > 0)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        for (int j = -3; j < 0; j++)
                        {
                            if (campo.getCampo()[x + i][y + j] != " ")
                            {
                                vuoto = false;
                                System.out.println("PDF9.A sin c'è qualcosa");
                            }
                        }
                    }
                }
                break;
            case "s":
                if (y+2 < campo.getColonne())
                {
                    for (int i = 3; i < 6; i++)
                    {
                        for (int j = 0; j < 3; j++)
                        {
                            System.out.println("la x e la y del mio pezzo sono "+x+" "+y);
                            System.out.println("vado ad analizzare "+(x+i)+" "+(y+j));
                            System.out.println("Trovo: "+campo.getCampo()[x+i][y+j]);
                            if (campo.getCampo()[y + j][x + i] != " ")
                            {
                                vuoto = false;
                                System.out.println("Sotto c'è qualcosa");
                            }
                        }
                    }
                }
                break;
            case "d":
                if (y+5 < campo.getColonne())
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 3; j < 6; j++)
                    {
                        if (campo.getCampo()[x+i][y+j] != " ")
                        {
                            vuoto = false;
                            System.out.println("PDF9.A des c'è qualcosa");
                        }
                    }
                }
                break;
        }
        System.out.println("vuoto è "+vuoto);
        if (!vuoto)
        {
            // TODO: rimettere true
            arrivato = true;
        }
        return vuoto;
    }

    public static void main(String[]args)
    {
        Tetris tts = new Tetris();
    }
}
