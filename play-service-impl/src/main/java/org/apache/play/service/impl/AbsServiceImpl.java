package org.apache.play.service.impl;

import javax.annotation.Resource;

import org.apache.play.config.dict.ConfigComponent;
import org.apache.play.domain.IResult;
import org.apache.play.log.Logger;
import org.apache.play.log.LoggerFactory;
import org.apache.play.service.IService;

import com.alibaba.dubbo.rpc.RpcContext;

public abstract class AbsServiceImpl<T extends IResult> implements IService<T> {
    
    @Resource(name=ConfigComponent.ServiceConfig)
    protected ServiceConfig config;
    
	/**
	 * Logger for this class
	 */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

	public AbsServiceImpl(){
	    
	}
	
	protected static RpcContext context = RpcContext.getContext();
    
    public String getRemoteHost() {
        return context.getRemoteHost();
    }

	public String hello(String name){
		if (logger.isInfoEnabled()) {
			logger.info("hello(String name={}) - start", name); //$NON-NLS-1$
		}

		String returnString = "hello," + name;

		if (logger.isInfoEnabled()) {
			logger.info("hello(String name={}) - end - return value={}", name, returnString); //$NON-NLS-1$
		}
		return returnString;
	}

}
