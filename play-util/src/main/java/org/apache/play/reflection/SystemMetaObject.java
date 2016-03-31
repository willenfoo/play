package org.apache.play.reflection;

import org.apache.play.reflection.factory.DefaultObjectFactory;
import org.apache.play.reflection.factory.ObjectFactory;
import org.apache.play.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.play.reflection.wrapper.ObjectWrapperFactory;

 

/**
 * @author Clinton Begin
 */
public class SystemMetaObject {

  public static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
  public static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
  public static final MetaObject NULL_META_OBJECT = MetaObject.forObject(NullObject.class, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);

  private static class NullObject {
  }
  
  public static MetaObject forObject(Object object) {
    return MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
  }
  
}