package org.apache.play.reflection.wrapper;

import org.apache.play.reflection.MetaObject;

/**
 * @author Clinton Begin
 */
public interface ObjectWrapperFactory {

  boolean hasWrapperFor(Object object);
  
  ObjectWrapper getWrapperFor(MetaObject metaObject, Object object);
  
}
