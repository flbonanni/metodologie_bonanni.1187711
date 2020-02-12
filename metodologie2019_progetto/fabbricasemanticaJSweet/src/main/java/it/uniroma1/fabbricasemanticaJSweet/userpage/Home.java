package it.uniroma1.fabbricasemanticaJSweet.userpage;

import static def.dom.Globals.console;
import static def.jquery.Globals.$;

import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLImageElement;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLAnchorElementBuilder;
import it.uniroma1.fabbricasemanticaJSweet.builder.HTMLImageElementBuilder;

/**
 * Classe che genera l'homepage
 * @author Flavia Bonanni
 */
public class Home extends AuthPage
{
	public static final String TASK_URL = "example.jsp";
	public static final String SERVLET_URL = "logout.jsp";
	public static final String pathToButton = "images/button.jpg";
	
	public static void main(String[] args) 
	{
		Home home = new Home();
		
		console.log("Adding image");
		HTMLImageElement startButton = new HTMLImageElementBuilder()
				.setSrc(pathToButton)
				.setHeight(700)
				.setWidth(1518)
				.build();
	
		console.log("Creating link to task");
		HTMLAnchorElement toTask = new HTMLAnchorElementBuilder()
				.setName("toTask")
				.setHref(TASK_URL)
				.build();
		
		console.log("Creating link to logout");
		HTMLAnchorElement logout = new HTMLAnchorElementBuilder()
				.setText("Logout")
				.setName("Logout")
				.setHref(SERVLET_URL)
				.build();
		
		console.log("Creating divs");
		
		HTMLDivElement divImage = home.divGenerator("image");
		
		$(toTask).append(startButton);
		$(divImage).append(toTask);
		
		HTMLDivElement divLogout = home.divGenerator("link");
		
		$(divLogout).append(logout);
		
		$("body").append(divImage, divLogout);
	}
	
}
