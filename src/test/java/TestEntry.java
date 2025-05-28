import dungeon.engine.Entry;
import dungeon.engine.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEntry {
    @Test
    public void testActivate() {
        Player p = new Player();
        Entry entry = new Entry();
        assertTrue(entry.checkActive());
        entry.activate(p);
        assertEquals("E", p.getOverlapping());
        assertFalse(entry.checkActive());
    }
}