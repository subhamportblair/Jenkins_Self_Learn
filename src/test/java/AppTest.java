import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testApp() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testAppMessage() {
        String message = "Hello from my Java App!";
        assertNotNull(message);
    }
}
