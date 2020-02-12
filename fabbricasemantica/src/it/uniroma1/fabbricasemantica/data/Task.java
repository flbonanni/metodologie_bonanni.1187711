package it.uniroma1.fabbricasemantica.data;

/**
 * Interfaccia per i task
 */
public interface Task {

	/**
	 * Metodo per estrarre l'ID di un task
	 * @return forma in String dell'ID di un task
	 */
	default String getTaskID() 
	{
		return toString();
	}
	
}
