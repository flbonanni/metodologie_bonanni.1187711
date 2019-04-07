import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Flavia Bonanni
 */

public class TestRiproduttoreMusicale
{
    public static void main(String[] args)
    {
        String b = "Britney Spears";
        List<Brano> britney = new ArrayList<>();
        britney.add(new Brano("...Baby One More Time", b));
        britney.add(new Brano("(You Drive Me) Crazy", b));
        britney.add(new Brano("Crazy", b));
        MemoriaUSB mUSB = new MemoriaUSB();
        mUSB.add(britney);
        LettoreMP3 iPod = new LettoreMP3();
        iPod.inserisciSupporto(mUSB);
        iPod.toString();
        iPod.stop();
        iPod.play();
        iPod.next();
        iPod.getBrano();
        iPod.toString();
        List<Brano> system = new ArrayList<>();
        system.add(new Brano("Toxicity", "System of a Down"));
        mUSB.add(system, 3);
        iPod.next(); iPod.next();
        iPod.toString();
    }
}
