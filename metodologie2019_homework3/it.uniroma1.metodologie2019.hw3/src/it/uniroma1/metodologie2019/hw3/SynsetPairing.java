package it.uniroma1.metodologie2019.hw3;

import java.util.Arrays;
import java.util.List;

/**
 * Abbinamento tra due Synset corrispondenti
 * 
 * @author Flavia Bonanni
 */

public class SynsetPairing 
{
	private Synset source;
	private Synset target;
	private double score; // valore 0.0 < x <= 1.0, dove 1.0 e' l'uguaglianza completa
	private WordNet w;
	private String lookUpWord;
	private POS lookUpPOS;
	
	/**
	 * Abbinamento tra due Synset
	 * 
	 * @param s Synset da abbinare
	 * @param w WordNet in cui cercare il suo abbinamento
	 */
	public SynsetPairing(Synset s, WordNet w) 
	{
		this.source = s;
		this.w = w;
		lookUpWord = source.getSynonyms().get(0);
		lookUpPOS = s.getPOS();
		compare();
	}
	
	/**
	 * Trova possibili abbinamenti con il Synset s in base al lemma
	 * @return possibili abbinamenti
	 */
	public List<Synset> possibleMatches()	{ return w.getSynsets(lookUpWord, lookUpPOS); }

	/** 
	 * Trova possibili abbinamenti di un Synset e  richiama il calcolo del punteggio di similarita'
	 */
	public void compare()
	{
		List<Synset> targetList = possibleMatches();
		
		targetList.forEach(n ->
		{
			double tempScore = calculateScore(source, n);
			if (tempScore > score) 
			{
				target = n;
				score = tempScore;
			}
			if (score >= 0.99) score = 1.0;
		});
	}
	
	/**
	 * Calcola il punteggio di similarita' tra due Synset:
	 * confronto glosse score massimo 0.33;
	 * confronto esempi score massimo 0.33;
	 * confronto sinonimi score massimo 0.33.
	 * 
	 * @param s Synset sorgente
	 * @param t Synset destinazione
	 * @return punteggio di similarita'
	 */
	public double calculateScore(Synset s, Synset t)
	{
		double partialScore = 0.0;
		
		// confronto glosse
		if (s.getGloss().equals(t.getGloss())) partialScore += 0.33;
		if (partialScore == 0.0) partialScore += sentenceScore(s.getGloss(), t.getGloss());
		
		// confronto esempi
		String sExamples = null;
		String tExamples = null;
		if(s.getExamples() != null) sExamples = String.join(" ", s.getExamples());
		if(t.getExamples() != null) tExamples = String.join(" ", t.getExamples());
		if (sExamples != null && tExamples != null)
		{
			if (sExamples.equals(tExamples)) partialScore += 0.33;
		}
		if (sExamples == null && tExamples == null) partialScore += 0.33;
		
		// confronto sinonimi
		String synonymsOfS = String.join(" ", s.getSynonyms().toString()).replace("[", "").replace("]", "").replace(",", "");
		String synonymsOfT = String.join(" ", t.getSynonyms().toString()).replace("[", "").replace("]", "").replace(",", "");
		partialScore += sentenceScore(synonymsOfS, synonymsOfT);

		return partialScore;
	}
	
	/**
	 * Calcola il punteggio di similarita' tra due stringhe
	 * 
	 * @param s Stringa sorgente
	 * @param t String destinazione
	 * @return punteggio di similarita'
	 */
	public double sentenceScore(String s, String t)
	{
		double sentenceSimilarity = 0.0;
		
		List<String> sArr = Arrays.asList(s.split(" "));
		List<String> tArr = Arrays.asList(t.split(" "));
		
		for (String str : sArr)
		{
			if(tArr.contains(str)) sentenceSimilarity += 1;
		}
		
		return (sentenceSimilarity*2/(sArr.size()+tArr.size()))/3;
	}
	
	// GETTERS
	/**
	 * Ritorna il Synset sorgente
	 * 
	 * @return Synset sorgente
	 */
	public Synset getSource() { return source; }
	
	/**
	 * Ritorna il Synset destinazione
	 * 
	 * @return Synset destinazione
	 */
	public Synset getTarget() { return target; }
	
	/**
	 * Ritorna il punteggio di similarita'
	 * 
	 * @return punteggio di similarita'
	 */
	public double getScore() { return score; }
	
	// SETTERS
	/**
	 * Imposta il Synset sorgente
	 * 
	 * @param s Synset sorgente
	 */
	public void setSource(Synset s) { source = s; }
	
	/**
	 * Imposta il Synset destinazione
	 * 
	 * @param s Synset destinazione
	 */
	public void setTarget(Synset s) { target = s; }
	
	/**
	 * Imposta il punteggio di similarita'
	 * 
	 * @param d punteggio di similarita'
	 */
	public void setScore(double d) { score = d; }
}
