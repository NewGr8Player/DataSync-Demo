package com.xavier.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	/**
	 * 下划线转驼峰
	 *
	 * @param inputString
	 * @param firstCharacterLowercase
	 * @return
	 */
	public static String getCamelCaseString(String inputString, boolean firstCharacterLowercase) {
		if (inputString == null || "".equals(inputString)) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("([A-Za-z\\d]+)(_)?");
		Matcher matcher = pattern.matcher(inputString);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(firstCharacterLowercase && matcher.start() == 0 ? Character.toLowerCase(word.charAt(0)) : Character.toUpperCase(word.charAt(0)));
			int index = word.lastIndexOf('_');
			if (index > 0) {
				sb.append(word.substring(1, index).toLowerCase());
			} else {
				sb.append(word.substring(1).toLowerCase());
			}
		}
		return sb.toString();
	}
}
