public class Test 
{
	public static void main(String[] args)
	{
		Scrittore stephenKing = new ScrittoreDiGialli();

		stephenKing.pubblica(Scrittore.GenereLibro.GIALLO);
	}
}
