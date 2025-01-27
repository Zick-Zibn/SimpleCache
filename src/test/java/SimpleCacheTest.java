import org.example.LimitedCache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCacheTest {

    @Test
    public void LimitedCacheTestPut() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("One", "Test1");
        assertEquals(limitedCache.size(), 2);
    }
}
