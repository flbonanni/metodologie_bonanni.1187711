import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilteredFile
{
   private Path path;

   // TODO: eliminare
   private boolean filter1(String s) { return s.startsWith(" "); }
   private boolean filter2(String s) { return s.contains(" "); }
   
   private Function<String, Boolean> filtro1;
   private Function<String, Boolean> filtro2;
   
   final public static Function<String, Boolean>
   				STARTS_WITH_SPACE = s -> s.startsWith(" "),
   				CONTAINS_SPACE = s -> s.contains(" "),
   				ENDS_WITH_SPACE = s -> s.endsWith(" ");

   public FilteredFile(Path path)
   {
      this.path = path;
   }
   
   public void setFiltro1(Function<String, Boolean>  filtro1) { this.filtro1 = filtro1; }
   
   public void setFiltro2(Function<String, Boolean>  filtro2) { this.filtro2 = filtro2; }

   public Stream<String> stream() throws IOException
   {
      return Files.lines(path).filter(s -> filtro1.apply(s)).filter(s -> filtro2.apply(s));
   }
   
   public static void main(String[] args)
   {
	   Path path = Paths.get("Wheat.txt");
	   FilteredFile ff = new FilteredFile(path);
	   
	   ff.setFiltro1(STARTS_WITH_SPACE);
	   ff.setFiltro2(ENDS_WITH_SPACE);
	   
	   try 
	   {
		   ff.stream()
		   .forEach(m -> System.out.println(m));
	   } 
	   catch (IOException e) 
	   {
		   e.printStackTrace();
	   }
   }
}