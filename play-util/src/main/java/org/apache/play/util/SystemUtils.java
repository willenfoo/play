package org.apache.play.util;

import java.lang.management.ManagementFactory;

public class SystemUtils {

	/**
	 * 获取当前应用的进程id号
	 * 
	 * @return
	 */
	public static String getProcessId() {
		return ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
	}
}
