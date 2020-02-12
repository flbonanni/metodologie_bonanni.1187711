import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Cartella costruita con il percorso di una cartella reale
 * 
 * @author Flavia Bonanni
 */

public class Cartella
{
    private File cartella;

    public Cartella(String percorso)
    {
        cartella = new File(percorso);
    }

    public File getFile() { return cartella; }

    private String getSpazi(int k)
    {
        StringBuffer sb = new StringBuffer();
        while (k-- > 0) sb.append(" ");
        return sb.toString();
    }

    @Override
    public String toString()
    {
        return getElencoFile(cartella, 0);
    }

    private String getElencoFile(File c, int profondita)
    {
        StringBuffer sb = new StringBuffer();
        for (File f : c.listFiles())
        {
            sb.append(getSpazi(profondita));
            if (f.isDirectory())
            {
                sb.append("<");
                sb.append(f.getName());
                sb.append(">\n");

                sb.append(getElencoFile(f, profondita+1));
            }
            else
            {
                sb.append(f.getName());
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public boolean cerca(File s, File c)
    {
        for (File f : c.listFiles())
        {
            if (f.isDirectory())
            {
                return (cerca(s, f));
            }
            else
            {
                if (f.equals(s)) return true;
            }
        }
        return false;
    }

    public List<File> cercaEstensione(String ext, File c)
    {
        List<File> listaDiFile = new ArrayList<>();
        for (File f : c.listFiles())
        {
            if (f.isDirectory())
            {
                listaDiFile.addAll(cercaEstensione(ext, f));
                // return (listaDiFile);
            }
            else
            {
                if (f.getName().endsWith(ext))
                {
                    listaDiFile.add(f);
                }
            }
        }
        return listaDiFile;
    }

    public List<File> cercaEstensione(File c, String ... ext)
    {
        List<File> listaDiFile = new ArrayList<>();
        for (File f : c.listFiles())
        {
            if (f.isDirectory())
            {
                listaDiFile.addAll(cercaEstensione(f, ext));
                // return (listaDiFile);
            }
            else
            {
                for (String s : ext)
                {
                    if (f.getName().endsWith(s))
                    {
                        listaDiFile.add(f);
                    }
                }
            }
        }
        return listaDiFile;
    }

    public static void main(String[] args)
    {
    	/*
        Cartella c = new Cartella("C:\\Users\\flbon\\OneDrive\\Desktop\\Syenite\\18 foto");
        System.out.println(c.toString());
        c.cercaEstensione(c.getFile(), "png", "jpeg");
        */
    }
}