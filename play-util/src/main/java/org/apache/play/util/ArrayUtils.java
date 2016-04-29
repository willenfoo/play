package org.apache.play.util;

/**
 * 数组操作工具类
 * 
 * @author willenfoo
 *
 */
public class ArrayUtils {

	/**
	 * 判断是否为空
	 * 
	 * @param array
	 * @return
	 */
	public static <T> boolean isEmpty(T[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * 判断是否不为空
	 * 
	 * @param array
	 * @return
	 */
	public static <T> boolean isNotEmpty(T[] array) {
		return !isEmpty(array);
	}

	public static <T> String arrayToString(T[] array) {
		if (array != null) {
			StringBuilder sb = new StringBuilder();
			for (T t : array) {
				sb.append(t + ",");
			}
			sb.deleteCharAt(sb.length() - 1);
			return sb.toString();
		}
		return null;
	}

}
