import dungeon.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void testsetHealth() {
        Player thePlayer = new Player();
        thePlayer.setHealth(1);
        assertEquals(10, thePlayer.getHealth());
    }
}