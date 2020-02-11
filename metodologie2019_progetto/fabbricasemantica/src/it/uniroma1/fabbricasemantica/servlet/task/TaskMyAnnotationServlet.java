package it.uniroma1.fabbricasemantica.servlet.task;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet per il task MyAnnotation
 * @author Flavia Bonanni
 */
@WebServlet(name = "TaskMyAnnotationServlet", urlPatterns = "/myAnnotation.jsp")
public class TaskMyAnnotationServlet extends BaseServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("myAnnotation.html");
	}

}
