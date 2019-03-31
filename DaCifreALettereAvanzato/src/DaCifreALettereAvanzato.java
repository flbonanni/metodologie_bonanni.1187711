/**
 * 
 * @author Flavia Bonanni
 */

public class DaCifreALettereAvanzato
{
    String stringaTradotta;

    /**
     * 
     * @param stringaInInput
     * @return stringa tradotta
     */
    public String daCifreALettere(String stringaInInput)
    {
        StringBuilder sb = new StringBuilder();
        // ECCEZIONE per lo zero da solo
        if (stringaInInput.length() == 1 && stringaInInput.charAt(0) == '0')
        {
            sb.append("zero");
        }
        else
        {
            // SE QUATTRO CIFRE
            if (stringaInInput.length() > 3)
            {
                switch (stringaInInput.charAt(stringaInInput.length() - 4))
                {
                    case '1':
                        sb.append("mille ");
                        break;
                    case '2':
                        sb.append("duemila ");
                        break;
                    case '3':
                        sb.append("tremila ");
                        break;
                    case '4':
                        sb.append("quattromila ");
                        break;
                    case '5':
                        sb.append("cinquemila ");
                        break;
                    case '6':
                        sb.append("seimila ");
                        break;
                    case '7':
                        sb.append("settemila ");
                        break;
                    case '8':
                        sb.append("ottomila ");
                        break;
                    case '9':
                        sb.append("novemila ");
                        break;
                }
            }
            // SE TRE CIFRE
            if (stringaInInput.length() > 2)
            {
                switch (stringaInInput.charAt(stringaInInput.length() - 3))
                {
                    case '0':
                        break;
                    case '1':
                        sb.append("cento ");
                        break;
                    case '2':
                        sb.append("duecento ");
                        break;
                    case '3':
                        sb.append("trecento ");
                        break;
                    case '4':
                        sb.append("quattrocento ");
                        break;
                    case '5':
                        sb.append("cinquecento ");
                        break;
                    case '6':
                        sb.append("seicento ");
                        break;
                    case '7':
                        sb.append("settecento ");
                        break;
                    case '8':
                        sb.append("ottocento ");
                        break;
                    case '9':
                        sb.append("novecento ");
                        break;
                }
            }
            if (stringaInInput.length() > 1)
            {
                // ECCEZIONE per 1, 2, ..., 9 alla penultima
                switch (stringaInInput.charAt(stringaInInput.length() - 2))
                {
                    // ECCEZIONE per 1 alla penultima
                    case '1':
                    {
                        sb.setLength(0);
                        switch (stringaInInput.charAt(stringaInInput.length() - 1))
                        {
                            case '0':
                                sb.append("dieci");
                                break;
                            case '1':
                                sb.append("undici");
                                break;
                            case '2':
                                sb.append("dodici");
                                break;
                            case '3':
                                sb.append("tredici");
                                break;
                            case '4':
                                sb.append("quattordici");
                                break;
                            case '5':
                                sb.append("quindici");
                                break;
                            case '6':
                                sb.append("sedici");
                                break;
                            case '7':
                                sb.append("diciassette");
                                break;
                            case '8':
                                sb.append("diciotto");
                                break;
                            case '9':
                                sb.append("diciannove");
                                break;
                        }
                        break;
                    }
                    case '2':
                        sb.append("venti ");
                        break;
                    case '3':
                        sb.append("trenta ");
                        break;
                    case '4':
                        sb.append("quaranta ");
                        break;
                    case '5':
                        sb.append("cinquanta ");
                        break;
                    case '6':
                        sb.append("sessanta ");
                        break;
                    case '7':
                        sb.append("settanta ");
                        break;
                    case '8':
                        sb.append("ottanta ");
                        break;
                    case '9':
                        sb.append("novanta ");
                        break;
                }
            }
            // ULTIMA (/UNICA) CIFRA
            switch (stringaInInput.charAt(stringaInInput.length() - 1))
            {
                case '1':
                    sb.append("uno");
                    break;
                case '2':
                    sb.append("due");
                    break;
                case '3':
                    sb.append("tre");
                    break;
                case '4':
                    sb.append("quattro");
                    break;
                case '5':
                    sb.append("cinque");
                    break;
                case '6':
                    sb.append("sei");
                    break;
                case '7':
                    sb.append("sette");
                    break;
                case '8':
                    sb.append("otto");
                    break;
                case '9':
                    sb.append("nove");
                    break;
            }
            // CANCELLA SPAZIO IN CODA
            if (sb.charAt(sb.length()-1) == ' ')
            {
                sb.setLength(sb.length()-1);
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
        char[] risultato = { '0', '0', '0', '0' };
        String[] arrayDaStringa = stringaInInput.split(" ");
        char[] arrayDiAppoggio = new char[4];
        char[] arrayDiAppoggioC = new char[5];

        // non ci saranno mai 5 parole, quindi il 4 e' fuori range
        // ovvero una cifra sicura da usare per segnalare l'inesistentza
        int mila = 4; // non contiene mila
        int cento = 4; // non contiene cento

        boolean markerMille = false;
        boolean markerCento = false;
        boolean markerDecine = false;

        for (int i = 0; i < arrayDaStringa.length; i++) // analizza ogni parola
        {
            if (arrayDaStringa[i].equals("mille"))
            {
                markerMille = true;
                risultato[0] = '1';
            }
            for (int j = 0; j < arrayDaStringa[i].length(); j++) // analizza dentro ogni parola
            {
                if (j+3 < arrayDaStringa[i].length())
                {
                    arrayDiAppoggio[0] = arrayDaStringa[i].charAt(j);
                    arrayDiAppoggio[1] = arrayDaStringa[i].charAt(j + 1);
                    arrayDiAppoggio[2] = arrayDaStringa[i].charAt(j + 2);
                    arrayDiAppoggio[3] = arrayDaStringa[i].charAt(j + 3);
                }
                String a = new String(arrayDiAppoggio);
                if (a.equals("mila"))
                {
                    markerMille = true;
                    mila = i;
                }
            }
            for (int j = 0; j < arrayDaStringa[i].length(); j++) // analizza dentro ogni parola
            {
                if (j+4 < arrayDaStringa[i].length())
                {
                    arrayDiAppoggioC[0] = arrayDaStringa[i].charAt(j);
                    arrayDiAppoggioC[1] = arrayDaStringa[i].charAt(j + 1);
                    arrayDiAppoggioC[2] = arrayDaStringa[i].charAt(j + 2);
                    arrayDiAppoggioC[3] = arrayDaStringa[i].charAt(j + 3);
                    arrayDiAppoggioC[4] = arrayDaStringa[i].charAt(j + 4);
                }
                String a = new String(arrayDiAppoggioC);
                if (a.equals("cento"))
                {
                    markerCento = true;
                    cento = i;
                }
            }
            switch (arrayDaStringa[i])
            {
                case "novanta":
                    markerDecine = true;
                    risultato[2] = '9';
                    break;
                case "ottanta":
                    markerDecine = true;
                    risultato[2] = '8';
                    break;
                case "settanta":
                    markerDecine = true;
                    risultato[2] = '7';
                    break;
                case "sessanta":
                    markerDecine = true;
                    risultato[2] = '6';
                    break;
                case "cinquanta":
                    markerDecine = true;
                    risultato[2] = '5';
                    break;
                case "quaranta":
                    markerDecine = true;
                    risultato[2] = '4';
                    break;
                case "trenta":
                    markerDecine = true;
                    risultato[2] = '3';
                    break;
                case "venti":
                    markerDecine = true;
                    risultato[2] = '2';
                    break;
                case "diciannove":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '9';
                case "diciotto":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '8';
                case "diciassette":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '7';
                case "sedici":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '6';
                case "quindici":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '5';
                case "quattordici":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '4';
                case "tredici":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '3';
                case "dodici":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '2';
                case "undici":
                    markerDecine = true;
                    risultato[2] = '1';
                    risultato[3] = '1';
                case "dieci":
                    markerDecine = true;
                    risultato[2] = '1';
                    break;
                case "nove":
                    risultato[3] = '9';
                    break;
                case "otto":
                    risultato[3] = '8';
                    break;
                case "sette":
                    risultato[3] = '7';
                    break;
                case "sei":
                    risultato[3] = '6';
                    break;
                case "cinque":
                    risultato[3] = '5';
                    break;
                case "quattro":
                    risultato[3] = '4';
                    break;
                case "tre":
                    risultato[3] = '3';
                    break;
                case "due":
                    risultato[3] = '2';
                    break;
                case "uno":
                    risultato[3] = '1';
                    break;
                case "zero":
                    risultato[3] = '0';
                    break;
            }
        }
        if (mila != 4)
        {
            switch(arrayDaStringa[mila].charAt(0))
            {
                case 'd':
                    risultato[0] = '2';
                    break;
                case 't':
                    risultato[0] = '3';
                    break;
                case 'q':
                    risultato[0] = '4';
                    break;
                case 'c':
                    risultato[0] = '5';
                    break;
                case 's':
                    if (arrayDaStringa[mila].charAt(2) == 'i')
                    {
                        risultato[0] = '6';
                    }
                    else { risultato[0] = '7'; }
                    break;
                case 'o':
                    risultato[0] = '8';
                    break;
                case 'n':
                    risultato[0] = '9';
                    break;
            }
        }
        if (cento != 4)
        {
            switch(arrayDaStringa[cento].charAt(0))
            {
                case 'c':
                    if (arrayDaStringa[cento].charAt(1) == 'e')
                    {
                        risultato[1] = '1';
                    }
                    else { risultato[1] = '5'; }
                    break;
                case 'd':
                    risultato[1] = '2';
                    break;
                case 't':
                    risultato[1] = '3';
                    break;
                case 'q':
                    risultato[1] = '4';
                    break;
                case 's':
                    if (arrayDaStringa[cento].charAt(2) == 'i')
                    {
                        risultato[1] = '6';
                    }
                    else { risultato[1] = '7'; }
                    break;
                case 'o':
                    risultato[1] = '8';
                    break;
                case 'n':
                    risultato[1] = '9';
                    break;
            }
        }

        String r = new String(risultato);
        if (!markerMille)
        {
            r = r.substring(1,4);
            if (!markerCento)
            {
                r = r.substring(1,3);
                if (!markerDecine)
                {
                    r = r.substring(1,2);
                }
            }
        }
        System.out.println(r);
        return r;
    }

    public static void main(String[] args)
    {
        DaCifreALettereAvanzato DCALA = new DaCifreALettereAvanzato();
        DCALA.daCifreALettere("0");
        DCALA.daCifreALettere("10");
        DCALA.daCifreALettere("999");
        DCALA.daCifreALettere("8452");
        DCALA.daLettereACifre("quattromila quattrocento cinquanta due");
        DCALA.daLettereACifre("mille due");
        DCALA.daLettereACifre("cento novanta nove");
        DCALA.daLettereACifre("undici");
        DCALA.daLettereACifre("nove");
        DCALA.daLettereACifre("zero");
    }
}
