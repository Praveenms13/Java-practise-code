import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddTest {
    @Test
    public void twoPlusTwoEqualsFour() {
        Add adder = new Add();
        int result = adder.add(2, 2);
        assertEquals(4, result);
        assertTrue(result == 4);
    }
    @Test
    public void threePlusTwoEqualsFive() {
        Add adder = new Add();
        int result = adder.add(3, 2);
        assertEquals(5, result);
        assertTrue(result == 5);
        // assertNotEquals();
        // assertTrue();
        // assertFalse();
        // assertNull();
        // assertNotNull();
    }
}
