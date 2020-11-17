package schooltimetabling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test void testMain() {
    String[] args = null;

    try {
      App.main(args);
    } catch (Exception e) {
      fail("Expected no exceptions");
    }
  }
}
