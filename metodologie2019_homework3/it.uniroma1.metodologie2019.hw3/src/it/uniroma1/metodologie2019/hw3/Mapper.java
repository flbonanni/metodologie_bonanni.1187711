package it.uniroma1.metodologie2019.hw3;

/**
 * Mappa una versione di WordNet su un'altra
 * 
 *  @author Flavia Bonanni
 */
public class Mapper 
{
	/**
	 * Crea un oggetto WordNetMapping che rappresenta una mappatura tra due versioni di WordNet
	 * 
	 * @param w1 versione sorgente
	 * @param w2 versione destinazione
	 * @return mappatura tra w1 e w2
	 */
	public static WordNetMapping map(WordNet w1, WordNet w2)
	{
		WordNetMapping wnm = new WordNetMapping(w1, w2);
		return wnm;
	}
}
