import org.example.Filter;
import org.example.LimitedCache;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCacheTest {

    @Test
    public void LimitedCacheTestPut() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        assertEquals(limitedCache.size(), 2);
    }
    @Test
    public void LimitedCacheTestGet() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        assertEquals(limitedCache.get("One"), "Test1");
        assertEquals(limitedCache.get("Three"), null);
    }
    @Test
    public void LimitedCacheTestContainsKey() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        assertEquals(limitedCache.containsKey("One"), true);
        assertEquals(limitedCache.containsKey("Three"), false);
    }
    @Test
    public void LimitedCacheTestSize() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        assertEquals(limitedCache.size(), 2);
    }
    @Test
    public void FilterTest(){
        List<String> src = List.of("qwert", "venrm", "sff", "ssss", "gbvdavAV", "ryrehewe");
        List<String> dest = new ArrayList<>();
        Filter.copyIf(src, dest, o -> o.length() > 4);
        assertEquals(dest.size(), 4);
    }
}
