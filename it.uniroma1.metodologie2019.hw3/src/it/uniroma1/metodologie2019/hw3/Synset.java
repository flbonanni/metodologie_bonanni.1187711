package it.uniroma1.metodologie2019.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Synset con tutti i suoi attributi
 * 
 * @author Flavia Bonanni
 */

public class Synset 
{
	private String offset;
	private String lex_filenum;
	private POS POS;
	private String id; // offset + POS
	private int w_cnt;
	private List<String> synonyms = new ArrayList<>(); // size = w_cnt
	private int p_cnt;
	private String[][] ptr; // PTR array
	private Map<WordNetRelation, List<Synset>> pointers = new HashMap<>();
	private String gloss;
	private List<String> examples = new ArrayList<>();
	
	@SuppressWarnings("static-access")
	/**
	 * Istanza di un ogget Synset
	 * 
	 * @param synset riga del file POS.data che contiene le informazioni sul Synset
	 */
	public Synset(String synset)
	{
		// offset
		offset = synset.substring(0, 8);
	 	
		// lex_filenum
		lex_filenum = synset.substring(9, 11);
		
		// POS e id
		switch(synset.substring(12, 13))
		{
			case "n": 
				POS = POS.NOUN;
				id = offset+"n";
				break;
			case "v":
				POS = POS.VERB;
				id = offset+"v";
				break;
			case "a":
			case "s":
				POS = POS.ADJECTIVE;
				id = offset+"a";
				break;
			case "r":
				POS = POS.ADVERB;
				id = offset+"r";
				break;
		}
		
		// w_cnt
		w_cnt = Integer.parseInt(synset.substring(14, 16), 16);
		
		// variabile d'appoggio
		int w_cnt2 = w_cnt*2;
		
		// synonyms
		String[] synsetEnding = synset.substring(17, synset.length()).split(" ");
		for (int i = 0; i < w_cnt2; i+=2)
		{
			synonyms.add(synsetEnding[i]);
		}
		
		// p_cnt
		p_cnt = Integer.parseInt(synsetEnding[w_cnt*2]);
	
		// ptr e relazioni
		ptr = new String[p_cnt][3];
		// ptr[0][0] = [tipo di relazione]
		// ptr[0][1] = [offset]
		// ptr[0][2] = [POS]
		// etc con 0 che diventa 1, 2, 3... fino al num di relazioni esistenti
		for (int i = 0; i < p_cnt; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				ptr[i][j] = synsetEnding[++w_cnt2];
			}
			w_cnt2++;
		}
		
		// gloss
		StringBuilder sb = new StringBuilder();
		boolean glossStart = false;
		int glossN = 0;
		for (int i = 0; i < synsetEnding.length; i++) 
		{
			if (synsetEnding[i].equals("|")) 
			{ 
				glossStart = true;
				glossN = i;
			}
            if (glossStart) 
            { 
            	if (i > glossN)
            	{
            		sb.append(synsetEnding[i]); 
            		sb.append(" ");
            	}
            }
        }
		
		// example
		String exampleString = "";
		for (int i = 0; i < sb.length(); i++)
		{
			if ((sb.charAt(i) == ';' || sb.charAt(i) == ':' | sb.charAt(i) == ')') && (i+2 < sb.length() && sb.charAt(i+2) == '"')) 
				{
					exampleString = sb.substring(i+2, sb.length()).toString();
					sb.delete(i, sb.length());
					break;
			}
		}
		String[] exampleArr = null;
		if (exampleString != null)
		{
			if (exampleString.contains("\"; \"")) exampleArr = exampleString.split("\"; \"");
			else 
			{
				exampleArr = new String[1];
				exampleArr[0] = exampleString;
			}
		}
		if (exampleArr != null) for (String s : exampleArr) examples.add(s.trim().replace("\"", ""));
		if (examples.get(0).isEmpty()) examples = null;
		
        gloss = sb.toString().trim();
	}
	
	// GETTERS
	/**
	 * Ritorna l'offset
	 * 
	 * @return offset
	 */
	public String getOffset() { return offset; }
	
	/**
	 * Ritorna il lex filenum
	 * 
	 * @return lex filenum
	 */
	public String getLex_filenum() { return lex_filenum; }
	
	/**
	 * Ritorna il POS
	 * 
	 * @return POS
	 */
	public POS getPOS() { return POS; }
	
	/**
	 * Ritorna l'ID
	 * 
	 * @return ID
	 */
	public String getID() { return id; }
	
	/**
	 * Ritorna il word count
	 * 
	 * @return word count
	 */
	public int getW_cnt() { return w_cnt; }
	
	/**
	 * Ritorna i sinonimi
	 * 
	 * @return sinonimi
	 */
	public List<String> getSynonyms() { return synonyms; }
	
	/**
	 * Ritorna il pointer count
	 * 
	 * @return pointer count
	 */
	public int getP_cnt() { return p_cnt; }
	
	/**
	 * Ritorna i pointers come matrice
	 * 
	 * @return pointers come matrice
	 */
	public String[][] getPtr() { return ptr; }
	
	/**
	 * Ritorna i pointers come mappa
	 * 
	 * @return pointers come mappa
	 */
	public Map<WordNetRelation, List<Synset>> getPointers() { return pointers; }
	
	/**
	 * Ritorna la glossa
	 * 
	 * @return glossa
	 */
	public String getGloss() { return gloss; }
	
	/**
	 * Ritorna gli esempi
	 * 
	 * @return esempi
	 */
	public List<String> getExamples() { return examples; }
	
	
	
	// SETTERS
	/**
	 * Imposta l'offset
	 * 
	 * @param offset del Synset
	 */
	public void setOffset(String offset) { this.offset = offset; }
	
	/**
	 * Imposta il lex filenum
	 * 
	 * @param lex_filenum lex filenum del Synset
	 */
	public void setLex_filenum(String lex_filenum) { this.lex_filenum = lex_filenum; }
	
	/**
	 * Imposta il POS
	 * 
	 * @param POS del Synset
	 */
	public void setPOS(POS POS) { this.POS = POS; }
	
	/**
	 * Imposta l'ID
	 * 
	 * @param id del Synset
	 */
	public void setID(String id) { this.id = id; }
	
	/**
	 * Imposta il word count
	 * 
	 * @param w_cnt word count del Synset
	 */
	public void setW_cnt(int w_cnt) { this.w_cnt = w_cnt; }
	
	/**
	 * Imposta i sinonimi
	 * 
	 * @param synonyms sinonimi del Synset
	 */
	public void setSynonyms(List<String> synonyms) { this.synonyms = synonyms; }
	
	/**
	 * Imposta il pointer count
	 * 
	 * @param p_cnt pointer count del Synset
	 */
	public void setP_cnt(int p_cnt) { this.p_cnt = p_cnt; }
	
	/**
	 * Imposta i pointers come matrice
	 * 
	 * @param ptr pointers come matrice
	 */
	public void setPtr(String[][] ptr) { this.ptr = ptr; }
	
	/**
	 * Imposta i pointers come mappa
	 * 
	 * @param pointers pointers come mappa
	 */
	public void setPointers(Map<WordNetRelation, List<Synset>> pointers) { this.pointers = pointers; }
	
	/**
	 * Imposta la gossa
	 * 
	 * @param gloss glossa del Synset
	 */
	public void setGloss(String gloss) { this.gloss = gloss; }
	
	/**
	 * Imposta gli esempi
	 * 
	 * @param examples esempi del Synset
	 */
	public void setExamples(List<String> examples) { this.examples = examples; }
	

	// ALTRO
	/**
	 * Aggiunge un collegamento tra Synset nella rete dei Synset
	 * 
	 * @param r tipo di relazione
	 * @param s Synset da aggiungere
	 */
	public void addPointer(WordNetRelation r, Synset s)
	{ 
		pointers.computeIfAbsent(r, k -> new ArrayList<>()).add(s);
	}
	
	/**
	 * Identifica se un Synset contiene un certo lemma
	 * 
	 * @param str lemma da cercare
	 * @return true se il lemma è compreso nei sinonimi del Synset
	 */
	public boolean contains(String str) { return (synonyms.indexOf(str) != -1);	}
	
	@Override
	public String toString() { return getSynonyms()+"["+getOffset()+"]:"+getGloss(); }
}
