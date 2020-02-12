package it.uniroma1.fabbricasemanticaJSweet.game;

import static def.dom.Globals.console;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.jquery.JQueryXHR;
import def.js.JSON;

/**
 * Classe che genera la pagina per MyAnnotation
 * @author Flavia Bonanni
 */
public class MyAnnotation extends Annotation
{
	public static final String SERVLET_URL = "example.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) 
	{
		MyAnnotation MA = new MyAnnotation();
		
		HTMLFormElement form = MA.createForm(SERVLET_URL);
		
		HTMLLabelElement hint = MA.createHint("The following description of the word is a translation from another language. Rate this translation:");
		
		HTMLLabelElement word = MA.createWord();
		
		HTMLLabelElement description = MA.createDescription();
	
		HTMLLabelElement rangeLabel1 = MA.createRangeLabel("Comprehensibility"); 
		
		HTMLInputElement range1 = MA.createRange();
		
		HTMLLabelElement rangeLabel2 = MA.createRangeLabel("Grammatical precision");
		
		HTMLInputElement range2 = MA.createRange();
		
		HTMLLabelElement rangeLabel3 = MA.createRangeLabel("Naturalness");
		
		HTMLInputElement range3 = MA.createRange();
		
		HTMLLabelElement rangeLabel4 = MA.createRangeLabel("Authenticity");
		
		HTMLInputElement range4 = MA.createRange();
		
		HTMLInputElement submit = MA.createSubmit();
		HTMLInputElement skip = MA.createSkip();
		
		HTMLAnchorElement home = MA.createHomeLink();
		HTMLAnchorElement logout = MA.createLogoutLink();
		
		//*****Prendere l'esempio dal server*****//
		
		$.getJSON(REST_URL, "task=MY_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description"); 
			$(word).text(sWord);
			$(description).text(sDescription);
			
			return null;
		});
		
		//*****Costruire la pagina*****//
		
		HTMLDivElement divHint = MA.divGenerator("form-group");
		
		$(divHint).append(hint);
		
		HTMLDivElement divWord = MA.divGenerator("form-group");
		
		$(divWord).append(word);
		
		HTMLDivElement divDescription = MA.divGenerator("form-group");
		
		$(divDescription).append(description);
		
		HTMLDivElement divRange = MA.divGenerator("form-group");
		
		$(divRange).append(rangeLabel1, range1, "<br />", rangeLabel2, range2, "<br />", rangeLabel3, range3, "<br />", rangeLabel4, range4);
		
		HTMLDivElement divButtons = MA.divGenerator("form-group-bottom");
		
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divLinks = MA.divGenerator("links");
		
		$(divLinks).append(home, logout);
		
		$(form).css("margin", "0% 1.5%"); 
		
		console.log("adding to form");

		$(form).append(divHint, divWord);
		$(form).append(divDescription);
		$(form).append(divRange);
		$(form).append(divButtons);
		console.log("adding to body");

		$("body").append(form, divLinks);
	}
}


