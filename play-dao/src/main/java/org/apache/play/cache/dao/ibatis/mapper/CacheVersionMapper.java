package org.apache.play.cache.dao.ibatis.mapper;

import org.apache.play.cache.CacheVersion;
import org.apache.play.dao.ibatis.ISMapper;

public interface CacheVersionMapper extends ISMapper<CacheVersion> {

  int incrVersion(CacheVersion objName);

  int incrRecVersion(CacheVersion objName);

  int incrTabVersion(CacheVersion objName);
}
