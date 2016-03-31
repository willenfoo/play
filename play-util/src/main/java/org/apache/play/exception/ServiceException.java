package org.apache.play.exception;

import org.apache.play.exception.basic.ExceptionLevel;
import org.apache.play.exception.basic.IExceptionBody;


/**
 * Service 层异常
 */
public class ServiceException extends ExceptionSupport {
    /**
     * Service 层异常
     * @param iExceptionBody 异常信息主体
     */
    public ServiceException(IExceptionBody iExceptionBody) {
        super(iExceptionBody);
    }


    /**
     * Service 层异常
     * @param iExceptionBody 异常信息主体
     * @param ex 自定义异常信息
     */
    public ServiceException(IExceptionBody iExceptionBody, Exception ex) {
        super(iExceptionBody, ex );
    }

    /**
     * 支持消息format
     * @param iExceptionBody
     * @param args
     */
    public ServiceException(IExceptionBody iExceptionBody,Object ... args) {
        this(iExceptionBody,null,args);
    }



    /**
     * 支持消息formart + 原生exception
     *
     * @see IExceptionBody
     * @param iExceptionBody 异常code 与信息
     * @param args 自定义异常信息
     */
    public ServiceException(final IExceptionBody iExceptionBody,Exception ex,final Object... args) {
        super(iExceptionBody,ex,args);
    }

    @Override
    public ExceptionLevel getLevel() {
        return ExceptionLevel.SERVICE;
    }
}
