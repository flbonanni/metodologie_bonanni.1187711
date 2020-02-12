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
 * Classe che genera la pagina per SenseAnnotation
 * @author Flavia Bonanni
 */
public class SenseAnnotation extends Annotation
{
	public static final String SERVLET_URL = "example.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) 
	{
		SenseAnnotation SA = new SenseAnnotation();
		
		HTMLFormElement form = SA.createForm(SERVLET_URL);
		
		HTMLLabelElement hint = SA.createHint("Select the correct meaning of the word in the following sentence:");
		HTMLLabelElement word = SA.createWord();
		HTMLLabelElement description = SA.createDescription();
		
		HTMLInputElement radio1 = SA.createRadio();
		
		HTMLLabelElement radio1label = SA.createRadioLabel("");
		
		HTMLInputElement radio2 = SA.createRadio();
		
		HTMLLabelElement radio2label = SA.createRadioLabel("");
		
		HTMLInputElement radio3 = SA.createRadio();
		
		HTMLLabelElement radio3label = SA.createRadioLabel("");
		
		HTMLInputElement radio4 = SA.createRadio();
		
		HTMLLabelElement radio4label = SA.createRadioLabel("");
		
		HTMLInputElement submit = SA.createSubmit();
		HTMLInputElement skip = SA.createSkip();

		HTMLAnchorElement home = SA.createHomeLink();
		HTMLAnchorElement logout = SA.createLogoutLink();
		
		//*****Prendere l'esempio dal server*****//
		
		$.getJSON(REST_URL, "task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); 
			String sDescription = json.$get("description");
			String[] sRadios = json.$get("senses");
			$(word).text(sWord);
			$(description).text(sDescription);
			$(radio1label).text(sRadios[0]);
			$(radio2label).text(sRadios[1]);
			$(radio3label).text(sRadios[2]);
			$(radio4label).text(sRadios[3]);
			
			return null;
		});
		
		//*****Costruire la pagina*****//
		
		HTMLDivElement divHint = SA.divGenerator("form-group");
		
		$(divHint).append(hint);
		
		HTMLDivElement divWord = SA.divGenerator("form-group");
		
		$(divWord).append(word);
		
		HTMLDivElement divDescription = SA.divGenerator("form-group");
		
		$(divDescription).append(description);
		
		HTMLDivElement divRadio1 = SA.divGenerator("form.radio1");
		
		$(divRadio1).append(radio1, radio1label);
		
		HTMLDivElement divRadio2 = SA.divGenerator("form.radio2");
		
		$(divRadio2).append(radio2, radio2label);
		
		HTMLDivElement divRadio3 = SA.divGenerator("form.radio3");
		
		$(divRadio3).append(radio3, radio3label);
		
		HTMLDivElement divRadio4 = SA.divGenerator("form.radio4");
		
		$(divRadio4).append(radio4, radio4label);
		
		HTMLDivElement divButtons = SA.divGenerator("form-group-bottom");
		
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divLinks = SA.divGenerator("links");
		
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
