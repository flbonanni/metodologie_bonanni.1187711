package it.uniroma1.fabbricasemanticaJSweet.game;

import static def.dom.Globals.console;
// import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
// import def.dom.HTMLImageElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder;

/**
 * Classe che genera la pagina per TranslationAnnotation
 * @author Flavia Bonanni
 */
public class TranslationAnnotation extends Annotation
{	
	public static final String SERVLET_URL = "example.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) {
		
		TranslationAnnotation TA = new TranslationAnnotation();
		
		HTMLFormElement form = TA.createForm(SERVLET_URL);
		
		HTMLLabelElement description = TA.createDescription();
		
		$(description).css("font-weight", "bold");
		
		HTMLLabelElement hint = TA.createHint("Data la seguente parola e definizione in inglese, fornire una traduzione nella tua lingua madre.");
		HTMLLabelElement word = TA.createWord();
		
		HTMLTextAreaElement translation = TA.createTextarea("Scrivi la tua traduzione qui...");
		
		HTMLInputElement submit = TA.createSubmit();
		HTMLInputElement skip = TA.createSkip();

		HTMLAnchorElement home = TA.createHomeLink();
		HTMLAnchorElement logout = TA.createLogoutLink();
		
		$(skip).css("float"); 
		
		//*****Prendere l'esempio dal server*****//
		
		$.getJSON(REST_URL, "task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("description"); //i.e. json.get("description")
			$(word).text(sWord);
			$(description).text(sDescription);
			return null;
		});
		
		//*****Costruire la pagina*****//
		
		HTMLDivElement divHint = TA.divGenerator("form-group");
		
		$(divHint).append(hint);
		
		HTMLDivElement divWord = TA.divGenerator("form-group");
		
		$(divWord).append(word);

		HTMLDivElement divDescription = TA.divGenerator("form-group");
				
		$(divDescription).append(description);
		
		HTMLDivElement divTranslation = TA.divGenerator("");
				
		HTMLLabelElement label = new HTMLLabelElementBuilder()
				.build();
				
		$(divTranslation).append(label);
		$(divTranslation).append(translation);
		
		HTMLDivElement divButtons = TA.divGenerator("form-group-bottom");

		$(divButtons).append(submit, skip);
		
		HTMLDivElement divLinks = TA.divGenerator("links");

		$(divLinks).append(home, logout);
		
		$(form).css("margin", "0% 1.5%");  
		
		console.log("adding to form");
		
		$(form).append(divHint, divWord);
		$(form).append(divDescription);
		$(form).append(divTranslation);
		$(form).append(divButtons);
		console.log("adding to body");
		
		$("body").append(form, divLinks);
	}
	

}
