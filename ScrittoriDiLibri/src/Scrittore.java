public abstract class Scrittore 
{
	public enum GenereLibro { AVVENTURA, GIALLO, FUMETTO; }
	
	public Libro pubblica(GenereLibro genere)
	{
		Libro libro = null;
		
		switch(genere)
		{
			case AVVENTURA: libro = new LibroAvventura(); break;
			case GIALLO: libro = new LibroGiallo(); break;
			case FUMETTO: libro = new Fumetto(); break;
		}
		
		libro.impagina();
		
		return libro;
	}
}
