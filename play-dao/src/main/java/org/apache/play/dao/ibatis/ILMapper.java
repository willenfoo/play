package org.apache.play.dao.ibatis;

import org.apache.play.cache.IModel;

/**
 * 主键为长整型的 ibatis 数据访问接口
 * 
 * @author alexzhu
 *
 * @param <T>
 */
public interface ILMapper<T extends IModel> extends IMapper<T>,IBatchMapper<T> {

  public T queryById(Long id);

  public Long insert(IModel params);

}
