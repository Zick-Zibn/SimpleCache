import org.example.Filter;
import org.example.LimitedCache;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class SimpleCacheTest {

    @Test
    public void LimitedCacheTestPut() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        Assert.assertEquals(limitedCache.size(), 2);
    }
    @Test
    public void LimitedCacheTestGet() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        Assert.assertEquals(limitedCache.get("One"), "Test1");
        Assert.assertEquals(limitedCache.get("Three"), null);
    }
    @Test
    public void LimitedCacheTestContainsKey() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        Assert.assertEquals(limitedCache.containsKey("One"), true);
        Assert.assertEquals(limitedCache.containsKey("Three"), false);
    }
    @Test
    public void LimitedCacheTestSize() {
        LimitedCache<String, String> limitedCache = new LimitedCache<>(7);

        limitedCache.put("One", "Test1");
        limitedCache.put("Two", "Test2");
        Assert.assertEquals(limitedCache.size(), 2);
    }
    @Test
    public void FilterTest(){
        List<String> src = List.of("qwert", "venrm", "sff", "ssss", "gbvdavAV", "ryrehewe");
        List<String> dest = new ArrayList<>();
        Filter.copyIf(src, dest, o -> o.length() > 4);
        Assert.assertEquals(dest.size(), 4);
    }
}
