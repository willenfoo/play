package org.apache.play.concurrent;

import org.apache.play.config.DynamicThreadPool;

public class Executor {
    protected static org.slf4j.Logger _logger = org.slf4j.LoggerFactory.getLogger("trace");

    public static void execute(Runnable command) {
        DynamicThreadPool.getInstance().getPool().execute(command);
    }

    public static void destory() {
        DynamicThreadPool.getInstance().getPool().shutdown();
    }
}
