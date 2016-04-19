package org.apache.play.util;

import java.util.List;

/**
 * List操作工具类
 * @author willenfoo
 *
 */
public class ListUtils {

	/**
	 * 判断是否为空
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * 判断是否不为空
	 * @param list
	 * @return
	 */
	public static <T> boolean isNotEmpty(List<T> list) {
		return !isEmpty(list);
	}
	
}