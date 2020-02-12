package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet per il reindirizzamento tra i vari task
 */
@WebServlet(name="ExampleServlet", urlPatterns="/example.jsp")
public class ExampleServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<String> pages = new ArrayList<String>();
		pages.add("translationAnnotation.jsp");
		pages.add("wordAnnotation.jsp");
		pages.add("definitionAnnotation.jsp");
		pages.add("senseAnnotation.jsp");
		pages.add("translationValidation.jsp");
		pages.add("senseValidation.jsp");
		pages.add("myAnnotation.jsp");
		
		// Se è stato premuto next, allora un task a caso
		if (((String) request.getParameter("submit_button")) == null)
		{
	        Random random = new Random();
			response.sendRedirect(pages.get(random.nextInt(pages.size())));
		}
		// Altrimenti torna alla pagina di provenienza
		else
		{		
			if (request.getHeader("referer").equals("http://localhost:8080/fabbricasemantica/translationAnnotation.html")) response.sendRedirect("translationAnnotation.jsp");
			else if (request.getHeader("referer").equals("http://localhost:8080/fabbricasemantica/wordAnnotation.html")) response.sendRedirect("wordAnnotation.jsp");
			else if (request.getHeader("referer").equals("http://localhost:8080/fabbricasemantica/definitionAnnotation.html")) response.sendRedirect("definitionAnnotation.jsp");
			else if (request.getHeader("referer").equals("http://localhost:8080/fabbricasemantica/senseAnnotation.html")) response.sendRedirect("senseAnnotation.jsp"); 
			else if (request.getHeader("referer").equals("http://localhost:8080/fabbricasemantica/translationValidation.html")) response.sendRedirect("translationValidation.jsp");
			else if (request.getHeader("referer").equals("http://localhost:8080/fabbricasemantica/senseValidation.html")) response.sendRedirect("senseValidation.jsp");
			else if (request.getHeader("referer").equals("http://localhost:8080/fabbricasemantica/myAnnotation.html")) response.sendRedirect("myAnnotation.jsp");
		}
	}
}
