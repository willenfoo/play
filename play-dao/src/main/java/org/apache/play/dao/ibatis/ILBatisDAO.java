package org.apache.play.dao.ibatis;

import org.apache.play.cache.IModel;
import org.apache.play.dao.ILDAO;

/**
 * id 为long型的数据访问接口
 * 
 * @author alexzhu
 *
 * @param <T>
 */
public interface ILBatisDAO<T extends IModel> extends IBatisDAO<T>, ILDAO<T> {

  public Class<? extends ILMapper<T>> getMapperClass();

}
