import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Flavia Bonanni
 */

public class NumerareFile 
{
	private File f;
	
	public NumerareFile(File f)
	{
		this.f = f;
	}
	
	public void numera()
	{
		File n = new File(f.getName()+".num");
		try
		{
			Scanner in = new Scanner(f);
			int i = 0;
			PrintWriter out = new PrintWriter(n);
			
			while(in.hasNext())
			{
				out.println(i +": " + in.nextLine());
				i++;
			}
			out.close();
			in.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args)
	{
		File f = new File("Moon.txt");
		NumerareFile nf = new NumerareFile(f);
		nf.numera();
	}
}
