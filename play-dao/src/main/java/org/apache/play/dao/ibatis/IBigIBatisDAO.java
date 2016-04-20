package org.apache.play.dao.ibatis;

import org.apache.play.cache.IModel;
import org.apache.play.dao.IBIDAO;

/**
 * id 为long型的数据访问接口
 * 
 * @author alexzhu
 *
 * @param <T>
 */
public interface IBigIBatisDAO<T extends IModel> extends IBatisDAO<T>, IBIDAO<T> {

  public Class<? extends IBigIMapper<T>> getMapperClass();

}
