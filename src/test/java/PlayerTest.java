import dungeon.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void testSetHealth() {
        Player thePlayer = new Player();
        thePlayer.setHealth(1);
        assertEquals(10, thePlayer.getHealth());
    }
    @Test
    public void testUpdateCoords(){
        Player thePlayer = new Player();
        thePlayer.updateCoords('x', 1);
        assertEquals(1, thePlayer.getX());
        thePlayer.updateCoords('x',-1);
        assertEquals(0, thePlayer.getX());
        thePlayer.updateCoords('y',1);
        assertEquals(1, thePlayer.getY());
        thePlayer.updateCoords('y',-1);
        assertEquals(0,thePlayer.getY());
    }
}