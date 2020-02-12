package it.uniroma1.fabbricasemanticaJSweet.game;

import static def.dom.Globals.console;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLLabelElementBuilder;

/**
 * Classe che genera la pagina per DefinitionAnnotation
 * @author Flavia Bonanni
 */
public class DefinitionAnnotation extends Annotation 
{
	
	public static final String SERVLET_URL = "example.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) 
	{
		DefinitionAnnotation DA = new DefinitionAnnotation();
		
		HTMLFormElement form = DA.createForm(SERVLET_URL);
		HTMLLabelElement description = DA.createDescription();
		$(description).css("font-weight", "bold");
		
		HTMLLabelElement hint = DA.createHint("Data la parola e il suo iperonimo, fornire una definizione nella tua lingua.");
		HTMLLabelElement word = DA.createWord();
		HTMLTextAreaElement translation = DA.createTextarea("Scrivi la tua traduzione qui...");
		
		HTMLInputElement submit = DA.createSubmit();
		HTMLInputElement skip = DA.createSkip();

		HTMLAnchorElement home = DA.createHomeLink();
		HTMLAnchorElement logout = DA.createLogoutLink();

		$(skip).css("float"); 
		
		//*****Prendere l'esempio dal server*****//
		
		$.getJSON(REST_URL, "task=DEFINITION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sHypernym = json.$get("hypernym");
			$(word).text(sWord);
			$(description).text(sHypernym);
			return null;
		});
		
		//*****Costruire la pagina*****//
		
		HTMLDivElement divHint = DA.divGenerator("form-group");
		
		$(divHint).append(hint);
		
		HTMLDivElement divWord =  DA.divGenerator("form-group");
				
		$(divWord).append(word);

		HTMLDivElement divDescription =  DA.divGenerator("form-group");
				
		$(divDescription).append(description);
		
		HTMLDivElement divTranslation =  DA.divGenerator("");
				
		HTMLLabelElement label = new HTMLLabelElementBuilder()
				.build();
				
		$(divTranslation).append(label);
		$(divTranslation).append(translation);
		
		HTMLDivElement divButtons =  DA.divGenerator("form-group-bottom");

		$(divButtons).append(submit, skip);
		
		HTMLDivElement divLinks = DA.divGenerator("links");

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
