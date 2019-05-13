package it.uniroma1.metodologie2019.hw3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Caricamento della versione di WordNet, creazione di una rete di Synset, indicizzazione delle parole con le loro relazioni
 * 
 * @author Flavia Bonanni
 */
public class Loader 
{
	public static boolean versionNotFound;
	private WordNet w;
	
	/**
	 * Caricatore di WordNet e della rete di relazioni
	 * 
	 * @param p path di WordNet da cui caricare
	 * @param w istanza di WordNet
	 */
	public Loader(String p, WordNet w)
	{	
		this.w = w;
		
		fileRead(p);
		
		// creare relazioni (specificando il tipo di relazione) tra i synset
		w.getSynsetNetwork().entrySet().parallelStream()
			.forEach(v -> 
			{
				Synset s = v.getValue();
				for (int i = 0; i < s.getP_cnt(); i++)
				{
					StringBuilder sb = new StringBuilder();
					sb.append(s.getPtr()[i][1]).append(s.getPtr()[i][2]);
					Synset t = findSynset(sb.toString());
					WordNetRelation r = null;
					switch(s.getPOS())
					{
						case NOUN: 
							r = WordNetNounRelations.find(s.getPtr()[i][0]);
							break;
						case VERB:
							r = WordNetVerbRelations.find(s.getPtr()[i][0]);
							break;
						case ADJECTIVE:
							r = WordNetAdjectiveRelations.find(s.getPtr()[i][0]);
							break;
						case ADVERB:
							r = WordNetAdverbRelations.find(s.getPtr()[i][0]);
							break;
					}
					s.addPointer(r, t);
				}
			});
	}
	
	/**
	 * Trova un Synset a partire dal suo ID
	 * 
	 * @param id del synset da cercare
	 * @return Synset corrispondente
	 */
	public Synset findSynset(String id) { return w.getSynsetNetwork().get(id); }
	
	/**
	 * Legge un file riga per riga usando stream e files.lines,
	 * comprende un'eccezione per versione non trovata
	 * 
	 * @param p path da cui leggere
	 */
	public void fileRead(String p)
	{
		// 
		Path path = Paths.get(p);
				
		for (int i = 0; i < 4; i++)
		{
			String fileName = Paths.get(path.toString()).resolve("data.adj").toString();
			switch(i)
			{
				case 1:
					fileName = Paths.get(path.toString()).resolve("data.adv").toString();
					break;
				case 2:
					fileName = Paths.get(path.toString()).resolve("data.noun").toString();
					break;
				case 3:
					fileName = Paths.get(path.toString()).resolve("data.verb").toString();
					break;
			}
				
			try (Stream<String> stream = Files.lines(Paths.get(fileName)))
			{
				stream
					.filter(s -> !s.startsWith("  "))
					.forEach(s -> 
					{ 
						Synset synset = new Synset(s);
						w.addToSynsetNetwork(synset);
					});
			} 
			catch (IOException e) {	versionNotFound = true;	}
		}
	}
}
