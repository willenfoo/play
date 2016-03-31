package org.apache.play.reflection.invoker;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Clinton Begin
 */
public class SetFieldInvoker implements Invoker {
    private Field field;

    public SetFieldInvoker(Field field) {
        this.field = field;
    }

    public Object invoke(Object target, Object[] args) throws IllegalAccessException,
            InvocationTargetException {
        field.set(target, args[0]);
        return null;
    }

    public Class<?> getType() {
        return field.getType();
    }
}
