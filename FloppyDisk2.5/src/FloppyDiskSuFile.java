import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Floppy disk 2.5"
 * 
 * @author Flavia Bonanni
 */

public class FloppyDiskSuFile 
{
	// CAMPI
	private boolean bloccoScrittura;
	
	private File memoria = new File("memoria.txt");
	
	private RandomAccessFile f;
	
	private long posizioneTestina;
	
	// COSTRUTTORE
	public FloppyDiskSuFile()
	{	
		try
		{
			f = new RandomAccessFile(memoria, "rw");
			f.setLength(1474560);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		clear();
	}
	
	@SuppressWarnings("serial")
	// ECCEZIONI
	class NotEnoughDataException extends Exception
	{ 
		public NotEnoughDataException() { super(); } 
	}
	
	@SuppressWarnings("serial")
	class BloccoScritturaException extends Exception
	{ 
		public BloccoScritturaException() { super(); } 
	}
	
	@SuppressWarnings("serial")
	class DiskAtCapacityException extends Exception
	{ 
		public DiskAtCapacityException() { super(); } 
	}
	
	// METODI
	public void checkData() throws NotEnoughDataException
	{
 		try 
 		{
			if (f.getFilePointer() >= memoria.length()) throw new NotEnoughDataException();
		} 
 		catch (IOException e) 
 		{
			e.printStackTrace();
		}
	}
	
	public void checkDisk() throws DiskAtCapacityException
	{
		try 
		{
			if (f.getFilePointer() >= 1474560) throw new DiskAtCapacityException();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void checkBlocco() throws BloccoScritturaException
	{
		if (bloccoScrittura) throw new BloccoScritturaException();
	}
	
	public void posizionaTestina(int k) 
	{ 
		try 
		{
			f.seek(k);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
	}
	
	public void leggi()
	{
		try 
		{
			f.seek(posizioneTestina);
		} 
		catch (IOException e2) 
		{
			e2.printStackTrace();
		}
		
		boolean letturaValida = true;
		
		try
		{
			checkData();
			checkDisk();
		}
		catch(NotEnoughDataException NEDE)
		{
			letturaValida = false;
			System.out.println("Memoria vuota nella sezione selezionata.");
		}
		catch(DiskAtCapacityException DACE)
		{
			letturaValida = false;
			System.out.println("Lettura disco completata.");
		}
		if (letturaValida) 
		{
			try 
			{
				System.out.println("Leggendo da posizione "+(f.getFilePointer())+".");
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			try 
			{
				System.out.println(f.read());
				// bytes = new byte[bytes.length+1440];
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		try 
		{
			posizioneTestina = f.getFilePointer();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void scrivi(List<Byte> input)
	{
		boolean scritturaValida = true;
		
		for(Byte b : input)
		{
			try
			{
				checkBlocco();
				checkDisk();
			}
			catch(BloccoScritturaException BSE)
			{
				scritturaValida = false;
				System.out.println("Blocco scrittura abilitato. Impossibile scrivere.");
			}
			catch(DiskAtCapacityException DACE)
			{
				scritturaValida = false;
				System.out.println("Disco pieno.");
			}
		
			if (scritturaValida)
			{
				try 
				{
					f.writeByte(b);
					System.out.println("Salvando il dato "+b);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
			}
			scritturaValida = true;
		}
	}
	
	public void formatta()
	{
		boolean formattazioneValida = true;
		
		try
		{
			checkBlocco();
		}
		catch(BloccoScritturaException BSE)
		{
			formattazioneValida = false;
			System.out.println("Blocco scrittura abilitato. Impossibile scrivere");
		}
		
		if(formattazioneValida)
		{
			System.out.println("Formattando...");
			System.out.println("Formattazione completata");
			clear();
		}
	}
	
	public void clear()
	{
		try 
		{
			new PrintWriter("memoria.txt").close();
			f = new RandomAccessFile(memoria, "rw");
			posizionaTestina(0);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void attivaBloccoScrittura() { bloccoScrittura = true; }
	public void disattivaBloccoScrittura() { bloccoScrittura = false; }
	public void cleanUp()
	{ 
		try 
		{
			f.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		FloppyDiskSuFile floppy = new FloppyDiskSuFile();
		
		// DUMMY DATA
		List<Byte> input1 = new ArrayList<>();
		List<Byte> input2 = new ArrayList<>();
		List<Byte> input3 = new ArrayList<>();
		
		for (int i = 0; i < 1500; i++) input1.add((byte) 'F');
		for (int i = 0; i < 1500500; i++) input2.add((byte) 'B');
		for (int i = 0; i < 1500; i++) input3.add((byte) 'D');
		
		// TEST
		floppy.leggi();
		floppy.scrivi(input1);
		floppy.leggi();
		floppy.formatta();
		floppy.leggi();
		floppy.scrivi(input1);
		floppy.attivaBloccoScrittura();
		floppy.scrivi(input3);
		floppy.leggi();
		floppy.disattivaBloccoScrittura();
		floppy.scrivi(input3);
		floppy.leggi();
		floppy.scrivi(input2);
		for(int i = 0; i < 1023; i++) floppy.leggi(); 
		floppy.cleanUp();
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}
}
