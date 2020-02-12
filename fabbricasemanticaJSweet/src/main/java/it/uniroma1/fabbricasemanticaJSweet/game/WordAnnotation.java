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
 * Classe che genera la pagina per WordAnnotation
 * @author Flavia Bonanni
 */
public class WordAnnotation extends Annotation
{

	public static final String SERVLET_URL = "example.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) 
	{
		WordAnnotation WA = new WordAnnotation();
		
		HTMLFormElement form = WA.createForm(SERVLET_URL);
		
		console.log("creating desct");
		HTMLLabelElement description = new HTMLLabelElementBuilder()
			.setClassName("form-control-description")
			.build();
		
		HTMLLabelElement hint = WA.createHint("Data la seguente definizione, provare a indovinare il termine definito.");
		
		HTMLTextAreaElement translation = WA.createTextarea("Scrivi la tua risposta qui...");
		
		HTMLInputElement submit = WA.createSubmit();
		HTMLInputElement skip = WA.createSkip();

		HTMLAnchorElement home = WA.createHomeLink();
		HTMLAnchorElement logout = WA.createLogoutLink();
		
		$(skip).css("float"); 
		
		//*****Prendere l'esempio dal server*****//
		 
		$.getJSON(REST_URL, "task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sDescription = json.$get("description");
			$(description).text(sDescription);
			return null;
		});
		
		//*****Costruire la pagina*****//
		
		HTMLDivElement divHint = WA.divGenerator("form-group");
		
		$(divHint).append(hint);
		
		HTMLDivElement divDescription = WA.divGenerator("form-group");
		
		$(divDescription).append(description);
		
		HTMLDivElement divTranslation = WA.divGenerator("");
		
		HTMLLabelElement label = new HTMLLabelElementBuilder()
				.build();
		
		$(divTranslation).append(label);
		$(divTranslation).append(translation);
		
		HTMLDivElement divButtons = WA.divGenerator("form-group-bottom");
		
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divLinks = WA.divGenerator("links");
		
		$(divLinks).append(home, logout);
		
		$(form).css("margin", "0% 1.5%");  
		
		console.log("adding to form");
		
		$(form).append(divHint);
		$(form).append(divDescription);
		$(form).append(divTranslation);
		$(form).append(divButtons);
		console.log("adding to body");

		$("body").append(form, divLinks);
	}
}