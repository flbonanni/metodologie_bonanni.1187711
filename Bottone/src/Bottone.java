abstract class Bottone implements Callback
{
    abstract public void esegui();
   
    public static void main(String[] args)
    {
 	    Bottone2 button = new Bottone2(4, 2);
	    button.esegui();
 	    System.out.println(button.getLabel());
    }
}

class Bottone1 extends Bottone implements Callback
{
	private Callback c = () -> System.out.println("ciao");
	@Override
    public void esegui() { c.esegui(); }
}

class Bottone2 extends Bottone
{
    private int k, j;
    private String label;
    public Bottone2(int k, int j) {  this.k = k; this.j = j; }
    private Callback c = () -> label = ""+k/j;
    
    public String getLabel() { return label; }

    @Override
    public void esegui() { c.esegui(); }
}


