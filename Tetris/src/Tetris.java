import java.util.Scanner;

/**
 * 
 * @author Flavia Bonanni
 */

// somministra i pezzi
// permette di muoverli
// gestisce lo spazio libero
// calcola i punteggi

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tetris
{
    private CampoTetris campo;
    private CampoTetris copia;
    private boolean perso = false;
    private Pezzo p;
    private int punti;
    private boolean arrivato = false;
    private boolean collSpazioStella = false;
    private List<Integer> collisioni = new ArrayList<>();
    private String input;

    public Tetris()
    {
        // creazione del campo
        campo = new CampoTetris(20, 11);

        // finchè non è vinto, somministra un pezzo
        while (!perso)
        {
            arrivato = false;
            collSpazioStella = false;
            somministra();

            // fintanto che ordinata+2, ovvero il bordo di sotto del pezzo
            // è minore della lunghezza del campo...
            while (p.getOrdinata()+2 < 19 && !arrivato)
            {
                // chiedo input
                System.out.println("Spostare il pezzo con WASD (dove W ruota il pezzo).");
                Scanner scan = new Scanner(System.in);
                input = scan.nextLine();

                // rispondo al comando dell'utente (WASD)
                switch (input)
                {
                    case "a":
                        caseA();
                        break;
                    case "s":
                        caseS();
                        break;
                    case "d":
                        caseD();
                        break;
                    case "w":
                        p.rotate();
                        break;
                }

                // calo naturale del pezzo
                if (p.getOrdinata() + 3 <= 19)
                {
                    caseS();
                }

                // ricostruisco il campo dalla copia
                // inserisco nelle sue nuove coordinate il pezzo
                // all'ascissa e ordinata contenuta in se stesso

                campo = new CampoTetris(copia);
                campo.inserisci(p.getAscissa(), p.getOrdinata(), p);

                // più un'eccezione per la collisione spazio-stella
                if (collSpazioStella)
                {
                    for (int i = 0; i < collisioni.size()-1; i+=2)
                    {
                        campo.getCampo()[collisioni.get(i)][collisioni.get(i+1)] = "*";
                    }
                }

                // stampo il campo
                campo.stampa();

            }
            // se il pezzo è atterrato, aggiungerlo all'elenco delle coordinate da
            // riempire con asterisco sempre
            if (arrivato || p.getOrdinata()+2 >= 19)
            {
                collSpazioStella = true;
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if (campo.getCampo()[p.getOrdinata()+i][p.getAscissa()+j] == "*")
                        {
                            collisioni.add(p.getOrdinata() + i);
                            collisioni.add(p.getAscissa() + j);
                        }
                    }
                }
            }

            // controlla tre volte: un pezzo solo potrebbe togliere fino a tre righe
            for (int i = 0; i < 3; i++)
            {
                int controllo = campo.controlloLinea();
                if (controllo != -1)
                {
                    punti += 10;
                    System.out.println("PUNTI = "+punti);
                    eliminaRiga(controllo);
                }
            }
            if (campo.controlloColonna())
            {
                perso = true;
                System.out.println("Sorry, you lost!");
            }
        }
    }

    /**
     * crea una copia del campo
     */
    public void creaCopia()
    {
        copia = new CampoTetris(campo);
    }

    /**
     * somministra i pezzi
     * fotografa lo stato del campo prima di inserire
     * e ne tiene da parte una copia
     * genera un numero random da 0 a 4
     * a cui corrisponde un pezzo random
     * nel pezzo vengono registrate le coordinate iniziali (0,4)
     * nel campo viene inserito il pezzo alle coordinate (0,4)
     * il campo viene stampato
     */
    public void somministra()
    {
        creaCopia();
        int random = (int) (Math.random() * 5);
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
        campo.inserisci(4, 0, p);
        campo.stampa();
    }

    /**
     * sposta le coordinate a sinistra
     */
    public void caseA()
    {
        // se non vado oltre il limite sinistro, e se sotto non c'è niente
        // sposto le coordinate a sinistra
        if (p.getAscissa() - 1 >= 0 && controllaSeVuoto("sin")) p.left();

        // se andrei oltre il limite sinistro, ma ho una colonna vuota nel mio pezzo, shifto il pezzo
        shift("a");
    }

    /**
     * sposta le coordinate a giù
     */
    public void caseS()
    {
        // se non vado oltre il limite inferiore
        // sposto le coordinate in giù
        // (+2 per raggiungere il bordo di sotto del pezzo, +1 per lo shift in basso)
        if (p.getOrdinata() + 3 <= 19 && controllaSeVuoto("giu")) p.down();

        // se non vado oltre il limite inferiore, ma mi ritrovo con una riga bianca, shifto il pezzo
        shift("s");

        if (p.getOrdinata() + 3 <= 19) collisione();
    }

    /**
     * crea una lista di coordinate in cui ci sono collisioni spazio-asterisco
     * e dà la casella all'asterisco
     */
    public void collisione()
    {
        for (int i = p.getAscissa(); i < p.getAscissa() + 3; i++)
        {
            if (campo.getCampo()[p.getOrdinata() + 2][i] == " " && campo.getCampo()[p.getOrdinata() + 3][i] == "*")
            {
                collSpazioStella = true;
                collisioni.add(p.getOrdinata() + 3);
                collisioni.add(i);
            }
        }
    }

    public void caseD()
    {
        // se non vado oltre il limite destro, sposto le coordinate a sinistra
        if (p.getAscissa() + 3 < 11 && controllaSeVuoto("des")) p.right();

        // se andrei oltre il limite destro, ma ho una colonna vuota nel mio pezzo, lo croppo
        shift("d");
    }

    /**
     * controlla se nelle tre celle subito sotto/sinistra/destra
     * al pezzo c'è qualcosa
     * @param direzione nella quale controllare
     * @return false se trova qualcosa
     */
    public boolean controllaSeVuoto(String direzione)
    {
        int x = p.getAscissa();
        int y = p.getOrdinata();

        switch (direzione)
        {
            case "giu":
                if (y + 3 >= campo.getRighe()) { return false; }
                for (int j = 0; j < 3; j++)
                {
                    // la collisione stellina su stellina a volte rileva due stelline
                    // di un pezzo già esistente, ed è quindi un errore segnare che il pezzo è già arrivato
                    // distinguo tra stellina del mio pezzo e stellina del campo
                    if (p.getTetramino()[2][0 + j] == "*" && campo.getCampo()[y + 3][x + j] == "*")
                    {
                        arrivato = true;
                        return false;
                    }
                }
                break;

            case "sin":
                if (x - 1 < 0) return false;
                for (int j = 0; j < 3; j++)
                {
                    if (campo.getCampo()[y + j][x - 1] == "*")
                    {
                        return false;
                    }
                }
                break;

            case "des":
                if (x + 3 >= campo.getColonne()) return false;
                for (int j = 0; j < 3; j++)
                {
                    if (campo.getCampo()[y + j][x + 3] == "*")
                    {
                        return false;
                    }
                }
                break;
        }

        return true;
    }

    /**
     * controlla se i pezzi hanno un lato vuoto e, in questo caso,
     * li shifta internamente secondo la
     * @param direzione data in input
     */
    public void shift(String direzione)
    {
        switch(direzione)
        {
            case "a":
                if (((p.getAscissa() - 1) == -1) && (p.getTetramino()[0][0] == " ") && (p.getTetramino()[1][0] == " ") && (p.getTetramino()[2][0] == " "))
                {
                    String[][] shift = {{p.getTetramino()[0][1], p.getTetramino()[0][2], " "},
                            {p.getTetramino()[1][1], p.getTetramino()[1][2], " "},
                            {p.getTetramino()[2][1], p.getTetramino()[2][2], " "}};
                    p.setTetramino(shift);
                    p.right();
                }
                break;
            case "s":
                // provo a togliere il criterio dell'ordinata per lo shift
                // ma aggiungo una restrizione sulla lettera
                if ((p.getTetramino()[2][0] == " ") && (p.getTetramino()[2][1] == " ") && (p.getTetramino()[2][2] == " "))
                {
                    String[][] shift = {{" ", " ", " "},
                            {p.getTetramino()[0][0], p.getTetramino()[0][1], p.getTetramino()[0][2]},
                            {p.getTetramino()[1][0], p.getTetramino()[1][1], p.getTetramino()[1][2]}};
                    p.setTetramino(shift);
                    p.up();
                }
                break;
            case "d":
                if (((p.getAscissa() + 3) == 11) && (p.getTetramino()[0][2] == " ") && (p.getTetramino()[1][2] == " ") && (p.getTetramino()[2][2] == " "))
                {
                    String[][] shift = {{" ", p.getTetramino()[0][0], p.getTetramino()[0][1]},
                            {" ", p.getTetramino()[1][0], p.getTetramino()[1][1]},
                            {" ", p.getTetramino()[2][0], p.getTetramino()[2][1]}};
                    p.setTetramino(shift);
                    p.left();
                }
                break;
        }
    }

    /**
     * elimina la
     * @param riga piena
     * rimuove tutte le sue occorrenze nella lista collisioni
     * shifta la lista collisioni di 1 in basso
     */
    public void eliminaRiga(int riga)
    {
        CampoTetris vuoto = new CampoTetris(20, 11);
        for (int i = 0; i < riga; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                vuoto.getCampo()[i+1][j] = campo.getCampo()[i][j];
            }
        }
        for (int i = riga+1; i < 20; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                vuoto.getCampo()[i][j] = campo.getCampo()[i][j];
            }
        }
        campo = vuoto;
        copia = vuoto;
        int limite = collisioni.size()-1;
        for (int i = 0; i < limite; i+=2)
        {
            if (collisioni.get(i) == riga)
            {
                collisioni.remove(i);
                collisioni.remove(i);
                limite -= 2;
                i -= 2;
            }
        }
        for (int i = 0; i < collisioni.size() - 1; i += 2)
        {
            int attuale = collisioni.get(i);
            attuale += 1;
            if (attuale <= riga) collisioni.set(i, attuale);

        }
    }

    public static void main(String[] args)
    {
        Tetris tts = new Tetris();
    }
}