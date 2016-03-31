package org.apache.play.concurrent;



import org.apache.play.log.LogUtils;
import org.apache.play.log.Logger;
import org.apache.play.log.LoggerFactory;
import org.apache.play.util.Request;

/**
 * 高性能控制器
 * 异步执行器
 * 
 * @author alex.zhu
 *
 */
public abstract class AsynBizExecutor implements Runnable {

    protected Logger logger = LoggerFactory.getLogger("trace");
    private String reqId = (String) Request.getId();
    private String biz = "";

    public AsynBizExecutor(String biz) {
        this.biz = biz;
        start();
    }

    private void start() {
        Executor.execute(this);
    }

    @Override
    public void run() {
        final long start = System.currentTimeMillis();
        Request.setId(this.getReqId());
        try {
            execute();
        } catch (Exception ex) {
            LogUtils.error(logger, ex);
            onErrors(new RuntimeException(ex));
        } finally {
            LogUtils.timeused(logger, "AsynBizExecutor.execute(" + biz + ")", start);
        }
    }

    public abstract void execute();

    public void onErrors(RuntimeException ex) {

    }

    public String getReqId() {
        return reqId;
    }

}
