package org.apache.play.dao.ibatis;

import org.apache.play.cache.IModel;
import org.apache.play.dao.ISDAO;

/**
 * id 为long型的数据访问接口
 * 
 * @author alexzhu
 *
 * @param <T>
 */
public interface ISBatisDAO<T extends IModel> extends IBatisDAO<T>, ISDAO<T> {

  public Class<? extends ISMapper<T>> getMapperClass();

}
