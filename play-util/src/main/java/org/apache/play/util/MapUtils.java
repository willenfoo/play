package org.apache.play.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Map操作工具类
 * @author willenfoo
 *
 */
public class MapUtils {

	/**
	 * 根据KEY，得到Map中的值
	 * @param map
	 * @param key
	 * @return
	 */
	public static <T> T getValue(Map<String, T> map, String key) {
		return getValue(map, key, null);
	}

	/**
	 * 根据KEY，得到Map中的值，如果为空，返回默认值
	 * @param map
	 * @param key
	 * @param defaultValue  如果为空，默认值
	 * @return
	 */
	public static <T> T getValue(Map<String, T> map, String key, T defaultValue) {
		if (isEmpty(map)) {
			return defaultValue;
		}
		for(Map.Entry<String, T> entry: map.entrySet()) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		return defaultValue;
	}
	
	/**
	 * 判断是否为空
	 * @param map
	 * @return
	 */
	public static <T> boolean isEmpty(Map<String, T> map) {
		return map == null || map.isEmpty();
	}

	/**
	 * 判断是否不为空
	 * @param map
	 * @return
	 */
	public static <T> boolean isNotEmpty(Map<String, T> map) {
		return !isEmpty(map);
	}
	
	/**
	 * 清楚map值为空的key
	 * @param map
	 */
	public static <T> void cleanNullValue(Map<String, T> map) {
		Iterator<Entry<String, T>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,T> entry = it.next();
			if (entry.getValue() == null) {
				 it.remove(); 
			} else if (entry.getValue() instanceof String) {
				if (StringUtils.isEmpty(entry.getValue().toString())) {
					 it.remove(); 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		System.out.println(isEmpty(map));
		System.out.println(isNotEmpty(map));
		
		map.put("key", 111);
		Object value = getValue(map, "key");
		System.out.println(value);
		
		map.put("value", null);
		System.out.println(map);
		cleanNullValue(map);
		System.out.println(map);
	}
}
