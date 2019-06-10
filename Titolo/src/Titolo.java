import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Titolo implements Comparable
{
	public enum Allineamento { CX, SX, DX }
	private Allineamento allineamento;
	private List<Riga> righe;
	
	public Titolo(Allineamento a) { this(a, new ArrayList<>()); }
	public Titolo(Allineamento a, List<Riga> righe) { allineamento = a; this.righe = righe; }
	public void add(Riga r) { righe.add(r); }
	public boolean isCentered() { return allineamento == Allineamento.CX; }
	@Override public String toString() { return righe.toString(); }
	public Allineamento getAllineamento() { return allineamento; }
	public List<Riga> getRighe() { return new ArrayList<>(righe); }
	
	static public class Riga
	{
		private String riga;
		private int numero;
		
		public Riga(String riga, int numero) { this.riga = riga; this.numero = numero; }
		public Riga(String riga) { this(riga, -1); }
		@Override public String toString() { return (numero == -1 ? "" : numero+": ")+riga; }
	}
	
	@Override
	public int compareTo(Object arg0) 
	{
		return this.getRighe().get(0).toString().compareTo(((Titolo)arg0).getRighe().get(0).toString());
	}
	
	public static void main(String[] args)
	{
		Titolo.Riga r11 = new Riga("you- you stay here with me, okay?");
		Titolo.Riga r12 = new Riga("You stay here with me.");
		Titolo.Riga r13 = new Riga("Raising your bite against the bitter dark");
		Titolo.Riga r14 = new Riga("Your bright longing");
		List<Riga> righeT1 = new ArrayList<>();
		righeT1.add(r11); righeT1.add(r12); righeT1.add(r13); righeT1.add(r14);
		Titolo t1 = new Titolo(Titolo.Allineamento.CX, righeT1);
		
		Titolo.Riga r21 = new Riga("Your brilliant fists of loss");
		List<Riga> righeT2 = new ArrayList<>();
		righeT2.add(r21);
		Titolo t2 = new Titolo(Titolo.Allineamento.SX, righeT2);
		
		Titolo.Riga r31 = new Riga("Friend");
		Titolo.Riga r32 = new Riga("if the only thing we have to gain in staying is each other");
		Titolo.Riga r33 = new Riga("my god that's plenty");
		Titolo.Riga r34 = new Riga("my god that's enough");
		List<Riga> righeT3 = new ArrayList<>();
		righeT3.add(r31); righeT3.add(r32); righeT3.add(r33); righeT3.add(r34); 
		Titolo t3 = new Titolo(Titolo.Allineamento.DX, righeT3);
		
		Titolo.Riga r41 = new Riga("my god that is so so much for the light to give");
		Titolo.Riga r42 = new Riga("each of us at each other's backs whispering over and over and over");
		List<Riga> righeT4 = new ArrayList<>();
		righeT4.add(r41); righeT4.add(r42);
		Titolo t4 = new Titolo(Titolo.Allineamento.CX, righeT4);
		
		Titolo.Riga r51 = new Riga("\"Live\"");
		Titolo.Riga r52 = new Riga("\"Live\"");
		Titolo.Riga r53 = new Riga("\"Live\"");
		List<Riga> righeT5 = new ArrayList<>();
		righeT5.add(r51); righeT5.add(r52); righeT5.add(r53);
		Titolo t5 = new Titolo(Titolo.Allineamento.SX, righeT5);
		
		List<Titolo> titoli = new ArrayList<>();
		titoli.add(t1); titoli.add(t2); titoli.add(t3); titoli.add(t4); titoli.add(t5);
		
		Set<Titolo> maxUnaRiga = titoli
				.stream()
				.filter(t -> t.getRighe().size() <= 1)
				.collect(Collectors.toSet());
		System.out.println("Quanti titoli hanno al più una riga? "+ maxUnaRiga.size());
		System.out.println();
		
		List<Titolo> centratiOrdinati = titoli
				.stream()
				.filter(t -> t.getAllineamento().equals(Titolo.Allineamento.CX))
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Lista dei titoli centrati e ordinati alfabeticamente: "+ centratiOrdinati);
		System.out.println();
		
		Map<Titolo.Allineamento, List<Titolo>> daAllALista = titoli
				.stream()
				.collect(Collectors.groupingBy(Titolo::getAllineamento));
		System.out.println("Mappa da allineamento a lista di titoli: "+ daAllALista);
		System.out.println();
		
		Map<Titolo.Allineamento, Set<Titolo>> daAllAInsieme = titoli
				.stream()
				.collect(Collectors.groupingBy(Titolo::getAllineamento, Collectors.toSet()));
		System.out.println("Mappa da allineamento a insieme di titoli: "+ daAllAInsieme);
		System.out.println();
		
		Map<Titolo.Allineamento, String> daAllAConcatenazione = titoli
				.stream()
				.collect(Collectors.toMap(
						Titolo::getAllineamento,
						Titolo::toString,
						(string1, string2) -> string1 + ";" + string2
						));
		System.out.println("Mappa da allineamento a stringhe di titoli: "+ daAllAConcatenazione);
		System.out.println();

		Map<Titolo.Allineamento, List<String>> daAllAListaStringhe = titoli
				.stream()
				.collect(Collectors.groupingBy(Titolo::getAllineamento,
						Collectors.mapping(Titolo::toString, Collectors.toList())));
		System.out.println("Mappa da allineamento a lista di stringhe di titoli: "+ daAllAListaStringhe);
		System.out.println();
		
		Set<String> insiemeDiStringheDiRighe = titoli
				.stream()
				.map(t -> t.getRighe().toString())
				.collect(Collectors.toSet());
		System.out.println("Insieme di righe sotto forma di stringa: "+ insiemeDiStringheDiRighe);
		System.out.println();
		
		Map<String, Integer> conteggiDiParole1 = insiemeDiStringheDiRighe
				.stream()
				.map(w -> w.split("], "))
				.flatMap(Arrays::stream)
				.map(s -> s.split(" "))
				//.flatMap(Arrays::stream)
				.collect(Collectors.toMap(
						a -> Arrays.toString(a),
						a -> a.length
						)); 
		System.out.println("Numero di parole per stringa: " +conteggiDiParole1);
	}
}