import java.util.ArrayList;

public class Borsa implements Subject
{
   private ArrayList<Observer> observers = new ArrayList<Observer>();
   private Transazione t;
   
   public void segnalaCambiamenti(Transazione t)
   {
	   this.t = t;
	   notificaObservers(); 
   }

	@Override
	public void registraObserver(Observer o) 
	{
		observers.add(o);
	}
	
	@Override
	public void rimuoviObserver(Observer o)
	{
		observers.remove(o);
	}
	
	@Override
	public void notificaObservers()
	{
		for (Observer o : observers) o.analizza(t);
	}
	
	public static void main(String[] args)
	{
		Borsa b = new Borsa();
		b.registraObserver(new AnalizzatoreStatistiche());
		b.registraObserver(new AnalizzatoreTrend());
		Transazione t1 = new Transazione("Banca di Roma", 2000);
		b.segnalaCambiamenti(t1);
		Transazione t2 = new Transazione("Banca di Cefalù", 1500);
		b.segnalaCambiamenti(t2);
	}
}