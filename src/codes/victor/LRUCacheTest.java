package codes.victor;

import org.junit.Assert;

/**
 * Created by victor on 23/02/2017.
 */
public class LRUCacheTest {

    @org.junit.Test
    public void cacheTest() throws Exception {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(cache.get(1), 1);
        cache.put(3, 3);
        Assert.assertEquals(cache.get(2), -1);
    }

}