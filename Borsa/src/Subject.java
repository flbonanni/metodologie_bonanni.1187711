public interface Subject
{
   void registraObserver(Observer o);
   void rimuoviObserver(Observer o);
   void notificaObservers();
}