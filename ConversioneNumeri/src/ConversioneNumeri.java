/**
 * 
 * @author Flavia Bonanni
 */

public class ConversioneNumeri
{
	/**
	 * 
	 * @param daConvertire numero da convertire
	 * @param Base
	 * @return convertito
	 */
    public String conversione(int daConvertire, int Base)
    {
        String result = convertAll(daConvertire, Base);
        return result;
    }

    /**
     * 
     * @param obj da invertire
     * @return StringBuilder invertita
     */
    public StringBuilder reverseString(StringBuilder obj)
    {
        StringBuilder jbo = new StringBuilder();
        for (int i = obj.length()-1; i >= 0; i--)
        {
            jbo.append(obj.charAt(i));
        }
        return jbo;
    }

    /**
     * 
     * @param daConvertire
     * @return convertito in base 16
     */
    public StringBuilder supportoSedici(int daConvertire)
    {
        StringBuilder abcdef = new StringBuilder();
        switch (daConvertire)
        {
            case 10: abcdef.append("A"); break;
            case 11: abcdef.append("B"); break;
            case 12: abcdef.append("C"); break;
            case 13: abcdef.append("D"); break;
            case 14: abcdef.append("E"); break;
            case 15: abcdef.append("F"); break;
        }
        return abcdef;
    }

    /**
     * 
     * @param daConvertire
     * @param Base
     * @return convertito
     */
    public String convertAll(int daConvertire, int Base)
    {
        StringBuilder sb = new StringBuilder();
        int holder = daConvertire;

        while (holder / Base != 0)
        {
            if (holder % Base < 10) { sb.append(holder % Base); }
            else { sb.append(supportoSedici(holder % Base)); }
            holder = holder / Base;
        }
        if (holder / Base == 0)
        {
            if (holder % Base < 10) { sb.append(holder % Base); }
            else { sb.append(supportoSedici(holder % Base)); }
        }
        String baseNum = reverseString(sb).toString();
        System.out.println(baseNum);
        return baseNum;
    }

    public static void main(String[] args)
    {
        ConversioneNumeri CN = new ConversioneNumeri();
        CN.conversione(99, 2);
        CN.conversione(99, 3);
        CN.conversione(99, 4);
        CN.conversione(99, 5);
        CN.conversione(99, 6);
        CN.conversione(99, 7);
        CN.conversione(99, 8);
        CN.conversione(99, 9);
        CN.conversione(99, 10);
        CN.conversione(99, 11);
        CN.conversione(99, 12);
        CN.conversione(99, 13);
        CN.conversione(99, 14);
        CN.conversione(99, 15);
        CN.conversione(99, 16);
    }
}
