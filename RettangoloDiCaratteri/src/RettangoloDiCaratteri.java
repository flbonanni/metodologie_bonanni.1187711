/**
 * 
 * @author Flavia Bonanni
 */

public class RettangoloDiCaratteri
{
    int x;
    int y;
    int height;
    int width;
    StringBuilder sb = new StringBuilder();
    StringBuilder mainChar = new StringBuilder();
    StringBuilder otherChar = new StringBuilder();

    /**
     * 
     * @param x
     * @param y
     * @param height
     * @param width
     */
    public RettangoloDiCaratteri(int x, int y, int height, int width)
    {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        mainChar.append("*");
        otherChar.append("$");
    }

    public void draw()
    {
        sb.setLength(0);
        StringBuilder sc = new StringBuilder();

        for (int i = 0; i < y; i++)
        {
            sb.append("_");
            sb.append('\n');
        }
        for (int i = 0; i < x; i++)
        {
            sc.append("_");
        }
        for (int i = 0; i < height; i++)
        {
            sb.append(sc);
            for (int j = 0; j < width; j++)
            {
                sb.append(mainChar);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public void drawVerticalStripes()
    {
        sb.setLength(0);
        StringBuilder sd = new StringBuilder();

        for (int i = 0; i < y; i++)
        {
            sb.append("_");
            sb.append('\n');
        }
        for (int i = 0; i < x; i++)
        {
            sd.append("_");
        }
        for (int i = 0; i < height; i++)
        {
            sb.append(sd);
            for (int j = 0; j < width; j++)
            {
                if (j % 2 == 0)
                {
                    sb.append(mainChar);
                }
                else { sb.append(otherChar); }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public void drawHorizontalStripes()
    {
        sb.setLength(0);
        StringBuilder se = new StringBuilder();

        for (int i = 0; i < y; i++)
        {
            sb.append("_");
            sb.append('\n');
        }
        for (int i = 0; i < x; i++)
        {
            se.append("_");
        }
        for (int i = 0; i < height; i++)
        {
            sb.append(se);
            if (i % 2 == 0)
            {
                for (int j = 0; j < width; j++)
                {
                    sb.append(mainChar);
                }
            }
            else
            {
                for (int j = 0; j < width; j++)
                {
                    sb.append(otherChar);
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public void drawChessboard()
    {
        sb.setLength(0);
        StringBuilder sf = new StringBuilder();
        for (int i = 0; i < y; i++)
        {
            sb.append("_");
            sb.append('\n');
        }
        for (int i = 0; i < x; i++)
        {
            sf.append("_");
        }
        for (int i = 0; i < height; i++)
        {
            sb.append(sf);
            if (i % 2 == 0)
            {
                for (int j = 0; j < width; j++)
                {
                    if (j % 2 == 0)
                    {
                        sb.append(mainChar);
                    }
                    else { sb.append(otherChar); }
                }
            }
            else
            {
                for (int j = 0; j < width; j++)
                {
                    if (j % 2 == 0)
                    {
                        sb.append(otherChar);
                    }
                    else { sb.append(mainChar); }
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    /**
     * 
     * @param chosenChar carattere
     */
    public void setCarattere(String chosenChar)
    {
        mainChar.setLength(0);
        mainChar.append(chosenChar);
    }

    /**
     * 
     * @param chosenChar carattere 1
     * @param otherChosen carattere 2
     */
    public void setCaratteri(String chosenChar, String otherChosen)
    {
        setCarattere(chosenChar);
        otherChar.setLength(0);
        otherChar.append(otherChosen);
    }

    /**
     * 
     * @param xx destinazione x
     * @param yy destinazione y
     */
    public void moveIt(int xx, int yy)
    {
        x = xx;
        y = yy;
    }

    /**
     * 
     * @return stringa di caratteri
     */
    public String getCaratteri()
    {
        System.out.println(mainChar+" "+otherChar.toString());
        return mainChar+" "+otherChar.toString();
    }

    public static void main(String[] args)
    {
        RettangoloDiCaratteri RDC = new RettangoloDiCaratteri(2, 1, 3, 4);
        RDC.draw();
        RDC.setCaratteri("<", ">");
        RDC.drawVerticalStripes();
        RDC.drawHorizontalStripes();
        RDC.drawChessboard();
        RDC.moveIt(8, 3);
        RDC.setCaratteri(".", ";");
        RDC.draw();
        RDC.getCaratteri();
    }
}