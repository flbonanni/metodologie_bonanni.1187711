package it.uniroma1.fabbricasemantica.servlet.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.uniroma1.fabbricasemantica.data.DataProvider;
import it.uniroma1.fabbricasemantica.data.StandardDataProvider;
import it.uniroma1.fabbricasemantica.data.StandardTask;
import it.uniroma1.fabbricasemantica.data.Task;
import it.uniroma1.fabbricasemantica.servlet.BaseServlet;

/**
 * Servlet template
 */
@WebServlet(name="NewExampleServlet", urlPatterns="/nextExample.jsp")
public class NewExampleServiceServlet extends BaseServlet {
	private static final long serialVersionUID = 8783416660707020469L;
	
	private Map<String, Task> tasks;
	private DataProvider<String> dataProvider;
	
	/* N.B. Il metodo init() e' da considerarsi il costruttore della classe.
	 * Ogni volta che si devono inizializzare dei valori, estendere sempre il metodo init()
	 * e mai il costruttore!
	 * */
	@Override
	public void init() throws ServletException 
	{
		super.init();
		dataProvider = new StandardDataProvider();
		tasks = Arrays.stream(StandardTask.values()).collect(Collectors.toMap(Task::getTaskID, s -> s));
		
	}

	@Override
	protected void doSomething(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String sTask = (String) request.getParameter("task");
		Task task = tasks.get(sTask);
		String json = dataProvider.getData(task);
		response.getWriter().write(json);
	}


}
