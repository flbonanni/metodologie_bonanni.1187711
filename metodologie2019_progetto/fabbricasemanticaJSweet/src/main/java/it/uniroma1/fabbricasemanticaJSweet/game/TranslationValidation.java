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
 * Classe che genera la pagina per TranslationValidation
 * @author Flavia Bonanni
 */
public class TranslationValidation extends Annotation
{
	public static final String SERVLET_URL = "example.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) 
	{
		TranslationValidation TV = new TranslationValidation();
		
		HTMLFormElement form = TV.createForm(SERVLET_URL);
		
		HTMLLabelElement hint = TV.createHint("Select the correct translation of the following word:"); 
		
		HTMLLabelElement word = TV.createWord();
		
		HTMLLabelElement description = TV.createDescription();
		
		HTMLInputElement radio1 = TV.createRadio();
		
		HTMLLabelElement radio1label = TV.createRadioLabel("");
		
		HTMLInputElement radio2 = TV.createRadio();
		
		HTMLLabelElement radio2label = TV.createRadioLabel("");
		
		HTMLInputElement radio3 = TV.createRadio();
		
		HTMLLabelElement radio3label = TV.createRadioLabel("");
		
		HTMLInputElement radio4 = TV.createRadio();
		
		HTMLLabelElement radio4label = TV.createRadioLabel("");
		
		HTMLInputElement submit = TV.createSubmit();
		HTMLInputElement skip = TV.createSkip();

		HTMLAnchorElement home = TV.createHomeLink();
		HTMLAnchorElement logout = TV.createLogoutLink();
		
		//*****Prendere l'esempio dal server*****//
		
		$.getJSON(REST_URL, "task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("description"); //i.e. json.get("description")
			String[] sRadios = json.$get("translations");
			$(word).text(sWord);
			$(description).text(sDescription);
			$(radio1label).text(sRadios[0]);
			$(radio2label).text(sRadios[1]);
			$(radio3label).text(sRadios[2]);
			$(radio4label).text(sRadios[3]);
			
			return null;
		});
		
		//*****Costruire la pagina*****//
		
		HTMLDivElement divHint = TV.divGenerator("form-group");
		
		$(divHint).append(hint);
		
		HTMLDivElement divWord = TV.divGenerator("form-group");
		
		$(divWord).append(word);
		
		HTMLDivElement divDescription = TV.divGenerator("form-group");
		
		$(divDescription).append(description);
		
		HTMLDivElement divRadio1 = TV.divGenerator("form.radio1");
		
		$(divRadio1).append(radio1, radio1label);
		
		HTMLDivElement divRadio2 = TV.divGenerator("form.radio2");
		
		$(divRadio2).append(radio2, radio2label);
		
		HTMLDivElement divRadio3 = TV.divGenerator("form.radio3");
		
		$(divRadio3).append(radio3, radio3label);
		
		HTMLDivElement divRadio4 = TV.divGenerator("form.radio4");
		
		$(divRadio4).append(radio4, radio4label);
		
		HTMLDivElement divButtons = TV.divGenerator("form-group-bottom");
		
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divLinks = TV.divGenerator("links");
		
		$(divLinks).append(home, logout);
		
		$(form).css("margin", "0% 1.5%"); 
		
		console.log("adding to form");

		$(form).append(divHint, divWord);
		$(form).append(divDescription);
		$(form).append(divRadio1, divRadio2, divRadio3, divRadio4);
		$(form).append(divButtons);
		console.log("adding to body");

		$("body").append(form, divLinks);
	}
}
