package it.uniroma1.metodologie2019.hw3;

import java.util.Optional;

/** 
 * Mappatura tra due versioni di WordNet
 * 
 * @author Flavia Bonanni
 */

public class WordNetMapping 
{
	@SuppressWarnings("unused")
	private WordNet w1;
	private WordNet w2;
	
	/**
	 * Istanza di mappatura tra due versioni di WordNet
	 * 
	 * @param w1 versione di WordNet sorgente
	 * @param w2 versione di WordNet destinazione
	 */
	public WordNetMapping(WordNet w1, WordNet w2) 
	{
		this.w1 = w1;
		this.w2 = w2;
	}

	/**
	 * Mappa un Synset su un'altra versione di WordNet se ha un indice di somiglianza maggiore/uguale a 0.8
	 * @param s Synset da mappare
	 * @return eventuale abbinamento del Synset s
	 */
	public Optional<SynsetPairing> getMapping(Synset s)
	{
		SynsetPairing sp = new SynsetPairing(s, w2);
		return Optional.ofNullable(sp.getScore() < 0.8 ? null : sp);
	}
}
