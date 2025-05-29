import dungeon.engine.GameEngine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameEngineTest {
    @Test
    public void testGetSize() {
        GameEngine ge = new GameEngine(10);
        assertEquals(10, ge.getSize());
    }

    @Test
    public void testRaiseDifficulty(){
        GameEngine ge = new GameEngine(10);
        assertEquals(3, ge.getDifficulty());
        ge.raiseDifficulty();
        assertEquals(5, ge.getDifficulty());
        for (int i = 0; i < 3; i++){
            ge.raiseDifficulty();
        }
        assertEquals(10, ge.getDifficulty());
    }
}
