import dungeon.engine.MeleeMutant;
import dungeon.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMeleeMutant {
    @Test
    public void testActivate() {
        Player p = new Player();
        MeleeMutant m = new MeleeMutant();
        m.activate(p);
        assertEquals(8, p.getHealth());
        assertEquals(2,p.getScore());
        m.activate(p);
        assertEquals(8, p.getHealth()); // health should not drop
        assertEquals(2,p.getScore());
        m.setActive(); // bring the MeleeMutant back to life
        m.activate(p);
        assertEquals(6, p.getHealth());
        assertEquals(4,p.getScore());
        assertEquals(" ",p.getOverlapping());
    }
}