package org.apache.play.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.*;

public final class StringUtils {

	public static String fenToYuan(String str) {
		if (!isEmpty(str)) {
			DecimalFormat format = new DecimalFormat("#0.00");
			return format.format(Double.parseDouble(str) / 100);
		}
		return null;
	}

	public static String yuanToFen(String str) {
		if (!isEmpty(str)) {
			DecimalFormat format = new DecimalFormat("#");
			return format.format(Double.parseDouble(str) * 100);
		}
		return null;
	}

	public static String convertColumn(String columnName) {
		String[] array = columnName.split("_");
		StringBuilder sb = new StringBuilder();
		if (array.length == 1) {
			sb.append(array[0]);
		} else {
			for (int j = 0; j < array.length; j++) {
				if (j == 0) {
					sb.append(StringUtils.firstLetterToLowerCase(array[j]));
				} else {
					sb.append(StringUtils.firstLetterToUpperCase(array[j]));
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 判断字符串是否 在指定的长度内
	 */
	public static boolean isLength(String str, int min, int max) {
		if (str == null) {
			return false;
		} else {
			int length = str.length();
			if (length < min) {
				return false;
			} else if (length > max) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否是 指定长度
	 */
	public static boolean isLength(String str, int length) {
		if (str == null) {
			return false;
		} else {
			if (str.length() == length) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否为整数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		if (isEmpty(str)) {
			return false;
		} else {
			try {
				Integer.valueOf(str);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	}

	/**
	 * 判断是否为整数
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isLong(String str) {
		if (isEmpty(str)) {
			return false;
		} else {
			try {
				Long.valueOf(str);
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	}

	public static boolean isDate(String str, String pattern) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (Exception e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		if (isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否符合Email样式.
	 * 
	 * @param str
	 *            传入的字符串
	 * @return 是Email样式返回true,否则返回false
	 */
	public static boolean isEmail(String str) {
		if (isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern
				.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * 
	 * @param str
	 *            传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		if (isEmpty(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 是否为空白,包括null和""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 是否为空白,包括null和""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 判断是不是合法手机 handset 手机号码
	 */
	public static boolean isHandset(String handset) {
		if (isEmpty(handset)) {
			return false;
		}
		try {
			if (!handset.substring(0, 1).equals("1")) {
				return false;
			}
			if (handset == null || handset.length() != 11) {
				return false;
			}
			String check = "^[0123456789]+$";
			Pattern regex = Pattern.compile(check);
			Matcher matcher = regex.matcher(handset);
			return matcher.matches();
		} catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * 生成一个随机数,生成的随机数【有重复】的数字
	 * 
	 * @param several
	 *            得到多少位的随机数
	 * @return
	 */
	public static String random(int several) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < several; i++) {
			sb.append(random.nextInt(9));
		}
		return sb.toString();
	}

	/**
	 * 生成一个随机数,生成的随机数【没有重复】的数字,生成的长度最多是10位的随机数
	 * 
	 * @param several
	 *            得到多少位的随机数,不能够大于10
	 * @return
	 */
	public static String randomNoRepeat(int several) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int length = array.length;
		if (several > length) {
			several = length;
		}
		Random rand = new Random();
		for (int i = length; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < several; i++) {
			sb.append(array[i]);
		}
		return sb.toString();
	}

	/**
	 * 去掉字符串二旁的空格
	 * 
	 * @param str
	 * @return
	 */
	public static String trim(String str) {
		return str != null ? str.trim() : null;
	}

	public static String replaceBlank(String str) {
		if (str != null) {
			Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
			Matcher matcher = pattern.matcher(str);
			str = matcher.replaceAll("");
		}
		return str;
	}

	public static String replaceBlankAll(String str) {
		if (str != null) {
			Pattern pattern = Pattern.compile("\\s*|\t|\r|\n");
			Matcher matcher = pattern.matcher(str);
			str = matcher.replaceAll("");
			str = str.replaceAll("null", "");
		}
		return str;
	}

	public static boolean isIntegerSize(String str, int length) {
		if (StringUtils.isEmpty(str) || length < 0) {
			return false;
		}
		String regex = "^\\d{" + length + "}$";
		Pattern pattern = Pattern.compile(regex);
		; // 正则表达式
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static boolean isIntegerSize(String str, int min, int max) {
		if (StringUtils.isEmpty(str) || min > max) {
			return false;
		}
		String regex = "^\\d{" + min + "," + max + "}$";
		Pattern pattern = Pattern.compile(regex);
		; // 正则表达式
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 得到一个订单号
	 * 
	 * @return
	 */
	public static String getOrderId() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentTime = new Date();// 得到当前系统时间
		Random random = new Random();
		return formatter.format(currentTime) + random.nextInt(9)
				+ random.nextInt(9) + random.nextInt(9) + random.nextInt(9)
				+ random.nextInt(9) + random.nextInt(9);
	}

	/**
	 * 得到一个订单号
	 * @return
	 */
	public synchronized static String getSerialVersionUID() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date currentTime = new Date();// 得到当前系统时间
		Random random = new Random();
		return formatter.format(currentTime) + random.nextInt(9)
				+ random.nextInt(9) + random.nextInt(9) + random.nextInt(9)
				+ random.nextInt(9);
	}

	public static String firstLetterToUpperCase(String str) {
		return str.replaceFirst(str.substring(0, 1), str.substring(0, 1)
				.toUpperCase());
	}

	public static String firstLetterToLowerCase(String str) {
		return str.replaceFirst(str.substring(0, 1), str.substring(0, 1)
				.toLowerCase());
	}

	public static boolean equals(CharSequence cs1, CharSequence cs2) {
		return cs1 == null ? cs2 == null : cs1.equals(cs2);
	}
	
}
