package it.uniroma1.fabbricasemantica.data;

/**
 * Interfaccia che rappresenta il metodo usato per ottenere i dati necessari ai vari task per funzionare.
 * */
public interface DataProvider<T> {
	
	/**
	 * Restituisce un oggetto di tipo <T> per il Task passato in input.
	 * */
	T getData(Task task);

}
