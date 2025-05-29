import dungeon.engine.Trap;
import dungeon.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrapTest {
    @Test
    public void testActivate() {
        Player p = new Player();
        Trap myTrap = new Trap();
        myTrap.activate(p);
        assertEquals(8, p.getHealth());
        myTrap.activate(p);
        assertEquals(6, p.getHealth());
        assertEquals("T",p.getOverlapping());
    }
}