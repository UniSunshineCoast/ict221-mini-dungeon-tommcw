import dungeon.engine.Ladder;
import dungeon.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLadder {
    @Test
    public void testActivate() {
        Player p = new Player();
        Ladder l = new Ladder();

        l.activate(p);
        assertTrue(p.getVictorious());
        assertEquals("E",p.getOverlapping());
    }
}