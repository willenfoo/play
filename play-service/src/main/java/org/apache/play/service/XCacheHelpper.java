package org.apache.play.service;

import org.apache.play.cache.CacheVersionStack;
import org.apache.play.log.Logger;
import org.apache.play.log.LoggerFactory;
import org.aspectj.lang.ProceedingJoinPoint;
public class XCacheHelpper {

    public static Object process(ProceedingJoinPoint pjp) throws Throwable{
        try {
            CacheVersionStack.init();
            return pjp.proceed(); 
        } 
        catch(Exception ex){
            _logger.error(ex);
            throw ex;
        }
        finally {
        	
//        	new AsynBizExecutor("syn.cache") {
//				
//				@Override
//				public void execute() {
//					ICacheVersion<CacheVersion> cacher = CacheVersionStack.getCacher();
//					Map<String,Integer> recs = CacheVersionStack.getRecIncs();
//					Map<String,Integer> tabs = CacheVersionStack.getTabIncs();
//					
//					cacher.incrObjRecVersion(null, null);
//				}
//			};
        	
			CacheVersionStack.unset();
        }
    }
    private transient static Logger _logger = LoggerFactory.getLogger(XCacheHelpper.class);
}
