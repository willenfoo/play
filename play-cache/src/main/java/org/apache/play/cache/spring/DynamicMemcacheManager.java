package org.apache.play.cache.spring;

import java.util.List;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

public class DynamicMemcacheManager extends AbstractCacheManager {

    private List<Cache> caches;

    
    protected List<? extends Cache> loadCaches() {
        return caches;
    }

    public void setCaches(List<Cache> caches) {
        this.caches = caches;
    }

}
