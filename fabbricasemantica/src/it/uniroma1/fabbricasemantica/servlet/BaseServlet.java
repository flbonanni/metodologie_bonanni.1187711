package it.uniroma1.fabbricasemantica.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe astratta per implementare la rogica richiesta nel backend.
 */
public abstract class BaseServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6784574842574L;

	/**
	 * Metodo per intercettare richieste HTTP GET.
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doSomething(request, response);
	}

	/**
	 * Metodo per intercettare richieste HTTP POST.
	 * */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doSomething(request, response);
	}

	/**
	 * Metodo che implementa la logica richiesta nelle specifiche del backend.
	 * */
	protected abstract void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	
}
