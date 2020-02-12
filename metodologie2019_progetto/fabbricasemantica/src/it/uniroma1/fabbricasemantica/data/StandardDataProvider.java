package it.uniroma1.fabbricasemantica.data;

import it.uniroma1.fabbricasemantica.wordnet.WordNet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import it.uniroma1.fabbricasemantica.wordnet.Synset;

/**
 * Classe che restituisce i dati necessari per il task ricevuto in input.
 * */
public class StandardDataProvider implements DataProvider<String> 
{
	WordNet wn30 = WordNet.getInstance("3.0");
	
	List<String> fifteenWords = new ArrayList<>();
	String[] strs = { "reach", "vocabulary", "speech", "wildness", "antique", "white", "flagellate", "appreciation", "unfitness", "mess", "strong arm", "staple", "offer", "dawn", "bargain" };
	String[] strsDesc = 
		{  
			"place into the hands or custody of",
			"a listing of the words used in some enterprise",
			"the exchange of spoken words",
			"a feeling of extreme emotional intensity",
			"an elderly man",
			"(usually in the plural) trousers made of flannel or gabardine or tweed or white cloth",
			"whip",
			"delicate discrimination (especially of aesthetic values)",
			"lacking the power to perform",
			"eat in a mess hall",
			"use physical force against",
			"necessary or important, especially regarding food or commodities",
			"mount or put up",
			"the first light of day",
			"negotiate the terms of an exchange"
		};
	String[] translatedStrs = 
		{
			"mettere nelle mani o nella custodia di", 
			"per guadagnare con fatica", 
			"l'atto di raggiungere o confidare in",
			"un elenco delle parole utilizzate in alcune aziende",
			"il sistema di tecniche o simboli che servono come mezzo di espressione (come nelle arti o nei mestieri)",
			"conoscenza delle parole dell'utente",
			"lo scambio di parole pronunciate",
			"l'atto di fornire una comunicazione orale formale a un pubblico",
			"(lingua) comunicazione tramite passaparola",
			"una sensazione di estrema intensita' emotiva",
			"uno stato intrattabilmente barbaro o incolto",
			"una disposizione indisciplinata a fare a proprio piacimento",
			"un uomo anziano",
			"dare un aspetto antico a",
			"appartenente da o di lunga data",
			"(di solito al plurale) pantaloni fatti di flanella o gabardine o tweed o panno bianco",
			"delle notti d'estate alle latitudini settentrionali dove il sole tramonta a malapena",
			"libero da imperfezioni morali o impurità; incontaminato",
			"frusta",
			"avere o assomigliare a una ciglia o frusta (come fa un flagello)",
			"un protozoo vivente di solito non fotosintetico con appendici a frusta; alcuni sono patogeni per l'uomo e altri animali",
			"apprezzamento (soprattutto sul piano estetico)",
			"un'espressione di gratitudine",
			"un aumento di prezzo o valore",
			"privo del potere di esibirsi",
			"la qualità di non essere adatto",
			"cattive condizioni fisiche; essere fuori forma o fuori condizione (come da una vita di agio e lusso)",
			"mangiare in una mensa",
			"(spesso seguito da of) un numero elevato o quantità o estensione",
			"un pasto consumato in una mensa dal personale di servizio",
			"usare la forza fisica contro",
			"spinto dalla forza fisica soprattutto contro la resistenza",
			"gestire con forza",
			"necessario o importante; soprattutto per quanto riguarda il cibo o le materie prime",
			"fissarlo o fissarlo con una graffetta o graffette",
			"dispositivo di fissaggio della carta costituito da una breve lunghezza di filo a forma di U che può fissare insieme le carte",
			"montare",
			"qualcosa offerto (come proposta o offerta)",
			"minaccia di fare qualcosa",
			"la prima luce del giorno",
			"il primo periodo",
			"diventare leggero",
			"negoziare i termini di uno scambio",
			"un accordo tra le parti (di solito è arrivato dopo la discussione) che fissa gli obblighi di ciascuna",
			"un acquisto vantaggioso"
		}; 
	
	@Override 
	public String getData(Task task) 
	{
		// lista di Synset della versione di WordNet caricata
		List<Synset> lista = new ArrayList<Synset>(wn30.getSynsetNetwork().values());
					
		// generatore di numeri random da 0 alla grandezza della lista
		int range = (lista.size()-1)+1;
		int random = ((int)(Math.random() * range));
					
		Synset s = lista.get(random);
		if (task == StandardTask.TRANSLATION_ANNOTATION) 
		{ 
			return "{" +
					"\"word\": \""+s.getSynonyms().get(0)+"\"," +
					"\"description\": \""+s.getGloss()+"\"" +
					"}"; 
		}
		else if (task == StandardTask.WORD_ANNOTATION) 
		{
			return "{\"description\": \""+s.getGloss()+"\""+"}";
		}
		else if (task == StandardTask.DEFINITION_ANNOTATION) 
		{
			Collection<Synset> adjs = wn30.getRelatedSynsets(s, "@");
			while (adjs.size() == 0)
			{
				random = ((int)(Math.random() * range));
				s = lista.get(random);
				adjs = wn30.getRelatedSynsets(s, "@");
			}
			Synset hyp = adjs.iterator().next();
			
			return "{" + 
					"\"word\": \""+s.getSynonyms().get(0)+"\"," +
					"\"hypernym\": \""+hyp.getSynonyms().get(0)+"\"" +
					"}";
		}
		else if (task == StandardTask.SENSE_ANNOTATION) 
		{
			List<String> examples = s.getExamples();
					
			// trova la parola a partire dalla stringa. la stringa = WORD
			List<Synset> synonyms = wn30.getSynsets(s.getSynonyms().get(0));

			while (examples == null || synonyms == null || examples.size() <= 0 || synonyms.size() <= 2)
			{ 
				random = ((int)(Math.random() * range));
				s = lista.get(random);
				examples = s.getExamples();
				synonyms = wn30.getSynsets(s.getSynonyms().get(0));
			}
					
			List<String> synDesc = new ArrayList<>();
			for (Synset syn : synonyms) synDesc.add(syn.getGloss());
					
			List<String> descAndSynDesc = new ArrayList<String>();
			descAndSynDesc.add(s.getGloss());
			descAndSynDesc.addAll(synDesc);
			Collections.shuffle(descAndSynDesc); 
			
			return "{" + 
					"\"word\": \""+s.getSynonyms().get(0)+"\"," +
					"\"description\": \""+s.getGloss()+"\"," +
					"\"senses\": [\""+descAndSynDesc.get(0)+"\", \""+descAndSynDesc.get(1)+"\", \""+descAndSynDesc.get(2)+"\", \""+descAndSynDesc.get(3)+"\"]" + 
					"}";
		}
		else if (task == StandardTask.TRANSLATION_VALIDATION) 
		{
			
					int randomWord = (int)(Math.random() * 15);
					List<String> translations = new ArrayList<>();
					translations.add("<nessuna>");
					translations.add(translatedStrs[randomWord*3+0]);
					translations.add(translatedStrs[randomWord*3+1]);
					translations.add(translatedStrs[randomWord*3+2]);
					Collections.shuffle(translations);
			
			return "{" +
					"\"word\": \""+strs[randomWord]+"\"," +
					"\"description\": \""+strsDesc[randomWord]+"\"," +
					"\"translations\": [\""+translations.get(0)+"\", \""+translations.get(1)+"\", \""+translations.get(2)+"\", \""+translations.get(3)+"\"]" +
					"}";
		}
		else if (task == StandardTask.SENSE_VALIDATION) 
		{
			List<String> examples = s.getExamples();
			
			while (examples == null || examples.size() <= 0)
			{ 
				random = ((int)(Math.random() * range));
				s = lista.get(random);
				examples = s.getExamples();
			}
			return "{" + 
					"\"word\": \""+s.getSynonyms().get(0)+"\"," +
					"\"description\": \""+s.getGloss()          +"\"," +
					"\"example\"    : \""+s.getExamples().get(0)+"\"" +
					"}";
		}
		else if (task == StandardTask.MY_ANNOTATION) 
		{
			return "{" + 
					"\"word\": \""+s.getSynonyms().get(0)+"\"," +
					"\"description\": \""+s.getGloss()          +"\"" +
					"}";
		}
		return null; 
	}
}
