import java.util.ArrayList;
import java.util.List;

/**
 * Floppy disk 2.5"
 * 
 * @author Flavia Bonanni
 */

public class FloppyDiskSuMemoria 
{
	// CAMPI
	private List<Byte> memoria = new ArrayList<>(1474560);
	
	private boolean bloccoScrittura;
	
	private int posizioneTestina;
	
	// ECCEZIONI
	class NotEnoughDataException extends Exception
	{ 
		public NotEnoughDataException() { super(); } 
	}
	
	class BloccoScritturaException extends Exception
	{ 
		public BloccoScritturaException() { super(); } 
	}
	
	class DiskAtCapacityException extends Exception
	{ 
		public DiskAtCapacityException() { super(); } 
	}
	
	// METODI
	public void checkData() throws NotEnoughDataException
	{
 		if (posizioneTestina >= memoria.size()) throw new NotEnoughDataException();
	}
	
	public void checkDisk() throws DiskAtCapacityException
	{
		if (posizioneTestina >= 1474560) throw new DiskAtCapacityException();
	}
	
	public void checkBlocco() throws BloccoScritturaException
	{
		if (bloccoScrittura) throw new BloccoScritturaException();
	}
	
	public void posizionaTestina(int k) { posizioneTestina = k; }
	
	public void leggi()
	{
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
			System.out.println("Leggendo da posizione "+(posizioneTestina)+".");
			System.out.println(memoria.subList(posizioneTestina, posizioneTestina += 1440));
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
				memoria.add(b);
				System.out.println("Salvando il dato "+b);
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
			posizioneTestina = 0;
			memoria.clear();
		}
	}
	
	public void attivaBloccoScrittura() { bloccoScrittura = true; }
	public void disattivaBloccoScrittura() { bloccoScrittura = false; }
	
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		FloppyDiskSuMemoria floppy = new FloppyDiskSuMemoria();
		
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
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}
}
