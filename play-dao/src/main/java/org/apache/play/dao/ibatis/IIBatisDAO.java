package org.apache.play.dao.ibatis;

import org.apache.play.cache.IModel;
import org.apache.play.dao.IIDAO;

public interface IIBatisDAO<T extends IModel> extends IBatisDAO<T>, IIDAO<T> {

  public Class<? extends IIMapper<T>> getMapperClass();

}
