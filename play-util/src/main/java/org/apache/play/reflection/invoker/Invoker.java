package org.apache.play.reflection.invoker;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Clinton Begin
 */
public interface Invoker {
  Object invoke(Object target, Object[] args) throws IllegalAccessException, InvocationTargetException;

  Class<?> getType();
}