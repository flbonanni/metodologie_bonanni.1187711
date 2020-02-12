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
 * Classe che genera la pagina per SenseValidation
 * @author Flavia Bonanni
 */
public class SenseValidation extends Annotation
{
	public static final String SERVLET_URL = "example.jsp";
	public static final String REST_URL = "nextExample.jsp";
	
	public static void main(String[] args) 
	{
		SenseValidation SV = new SenseValidation();
		
		HTMLFormElement form = SV.createForm(SERVLET_URL);
		
		HTMLLabelElement hint = SV.createHint("Is this the correct sense of the word used in the following sentence?");
		
		HTMLLabelElement word = SV.createWord();
		
		HTMLLabelElement description = SV.createDescription();
		
		HTMLLabelElement example = SV.createExample();
		
		HTMLInputElement radio1 = SV.createRadio();
		
		HTMLLabelElement radio1label = SV.createRadioLabel("YES");
		
		HTMLInputElement radio2 = SV.createRadio();
		
		HTMLLabelElement radio2label = SV.createRadioLabel("NO");
		
		HTMLInputElement submit = SV.createSubmit();
		HTMLInputElement skip = SV.createSkip();

		HTMLAnchorElement home = SV.createHomeLink();
		HTMLAnchorElement logout = SV.createLogoutLink();
		
		//*****Prendere l'esempio dal server*****//
		
		$.getJSON(REST_URL, "task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("description"); //i.e. json.get("description")
			String sExample = json.$get("example");
			$(word).text(sWord);
			$(description).text(sDescription);
			$(example).text(sExample);
			
			return null;
		});
		
		//*****Costruire la pagina*****//
		
		HTMLDivElement divHint = SV.divGenerator("form-group");
		
		$(divHint).append(hint);
		
		HTMLDivElement divWord = SV.divGenerator("form-group");
		
		$(divWord).append(word);
		
		HTMLDivElement divDescription = SV.divGenerator("form-group");
		
		$(divDescription).append(description);
		
		HTMLDivElement divExample = SV.divGenerator("form-group");
		
		$(divExample).append(example);
		
		HTMLDivElement divRadio1 = SV.divGenerator("form.radio1");
		
		$(divRadio1).append(radio1, radio1label);
		
		HTMLDivElement divRadio2 = SV.divGenerator("form.radio2");
		
		$(divRadio2).append(radio2, radio2label);
		
		HTMLDivElement divButtons = SV.divGenerator("form-group-bottom");
		
		$(divButtons).append(submit, skip);
		
		HTMLDivElement divLinks = SV.divGenerator("links");
		
		$(divLinks).append(home, logout);
		
		$(form).css("margin", "0% 1.5%"); 
		
		console.log("adding to form");
		
		$(form).append(divHint, divWord);
		$(form).append(divDescription, divExample);
		$(form).append(divRadio1, divRadio2);
		$(form).append(divButtons);
		console.log("adding to body");

		$("body").append(form, divLinks);
	}
}
