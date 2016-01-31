package org.mc.tests;

import org.mc.utils.LRUCache;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LRUCacheTests {
    private static final int NOT_FOUND = -1;
    private static final int MAX_ITEMS = 3;

    @Test
    public void cache_holds_only_MAX_ITEMS_elements() {
        LRUCache cache = createCache();

        for (int v : new int[] { 1, 2, 3, 4, 5 })
            cache.set(v, 0);

        Assert.assertEquals(cache.get(1), NOT_FOUND);
        Assert.assertEquals(cache.get(2), NOT_FOUND);
        Assert.assertEquals(cache.get(3), 0);
        Assert.assertEquals(cache.get(4), 0);
        Assert.assertEquals(cache.get(5), 0);
    }

    @Test
    public void cache_keeps_only_recently_used_elements() {
        LRUCache cache = createCache();

        cache.set(1, 0);
        cache.set(2, 0);
        cache.set(3, 0);

        // use 1 - recently used: 1 3 2
        cache.get(1);

        cache.set(4, 0);

        // we expect 4 1 and 3 in cache (most recently used elements)
        Assert.assertEquals(cache.get(4), 0);
        Assert.assertEquals(cache.get(1), 0);
        Assert.assertEquals(cache.get(3), 0);
        Assert.assertEquals(cache.get(2), NOT_FOUND);
    }

    @Test
    public void get_returns_NOT_FOUND_when_value_is_not_in_cache() {
        LRUCache cache = createCache();

        Assert.assertEquals(cache.get(3), NOT_FOUND);
    }

    @Test
    public void get_returns_value_used_in_set_call() {
        LRUCache cache = createCache();

        cache.set(5, 101);

        Assert.assertEquals(cache.get(5), 101);
    }

    private LRUCache createCache() {
        return new LRUCache(MAX_ITEMS);
    }
}
