import dungeon.engine.HealthPotion;
import dungeon.engine.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHealthPotion {
    @Test
    public void testActivate() {
        Player p = new Player();
        p.setHealth(-8); // damage the player 10-8 = 2hp remaining
        HealthPotion hp = new HealthPotion();
        hp.activate(p); // should restore +4hp to the player and deactivate
        assertEquals(6, p.getHealth());
        hp.activate(p); //check deactivated behaviour
        assertEquals(6, p.getHealth());
        assertEquals(" ",p.getOverlapping());
    }
}