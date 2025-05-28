import dungeon.engine.Gold;
import dungeon.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGold {
    @Test
    public void testActivate() {
        Player p = new Player();
        Gold gold = new Gold();
        gold.activate(p); // The player should get increased score
        assertEquals(2, p.getScore());
        gold.activate(p); // The gold should not be collected twice
        assertEquals(2, p.getScore());
        assertEquals(" ",p.getOverlapping());
    }
}