/**
 * 
 * @author Flavia Bonanni
 */

public class DaCifreALettere
{
    String stringaTradotta;

    /**
     * 
     * @param stringaInInput
     * @return stringa output
     */
    public String daCifreALettere(String stringaInInput)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringaInInput.length(); i++)
        {
            switch (stringaInInput.charAt(i))
            {
                case '0': sb.append("zero"); break;
                case '1': sb.append("uno"); break;
                case '2': sb.append("due"); break;
                case '3': sb.append("tre"); break;
                case '4': sb.append("quattro"); break;
                case '5': sb.append("cinque"); break;
                case '6': sb.append("sei"); break;
                case '7': sb.append("sette"); break;
                case '8': sb.append("otto"); break;
                case '9': sb.append("nove"); break;
            }
            if (i < stringaInInput.length()-1)
            {
                sb.append(" ");
            }
        }
        System.out.println(sb);
        return stringaTradotta = sb.toString();
    }

    /**
     * 
     * @param stringaInInput
     * @return stringa tradotta
     */
    public String daLettereACifre (String stringaInInput)
    {
        StringBuilder sb = new StringBuilder();
        String arrayDiStringa[] = stringaInInput. split(" ");
        for (int i = 0; i < arrayDiStringa.length; i++)
        {
            switch (arrayDiStringa[i])
            {
                case "zero": sb.append("0"); break;
                case "uno": sb.append("1"); break;
                case "due": sb.append("2"); break;
                case "tre": sb.append("3"); break;
                case "quattro": sb.append("4"); break;
                case "cinque": sb.append("5"); break;
                case "sei": sb.append("6"); break;
                case "sette": sb.append("7"); break;
                case "otto": sb.append("8"); break;
                case "nove": sb.append("9"); break;
            }
        }
        System.out.println(sb);
        return stringaTradotta = sb.toString();
    }

    public static void main(String[]args)
    {
        DaCifreALettere DCAL = new DaCifreALettere();
        DCAL.daCifreALettere("8452");
        DCAL.daLettereACifre("otto quattro cinque due");
    }
}
