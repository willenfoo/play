package org.apache.play.cache.dao;

import org.apache.play.cache.CacheVersion;
import org.apache.play.cache.ICacheVersion;
import org.apache.play.dao.IDAO;
import org.apache.play.dao.IFKDAO;
import org.apache.play.dao.ISDAO;


public interface ICacheVersionDAO<T extends CacheVersion> extends ISDAO<T>, IFKDAO<T>, IDAO<T>,ICacheVersion<T> {

  
}
