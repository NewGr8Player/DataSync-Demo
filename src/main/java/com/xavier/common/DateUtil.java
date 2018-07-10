package com.xavier.common;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author NewGr8Player
 */
public class DateUtil {

	/**
	 * <p>Example</p>
	 * <p>当前日期: 2018年7月10日15:04:56</p>
	 * <p>格式化后: 2018-07-10 03:03:48 上午</p>
	 */
	public static final String YMD_DASH_WITH_SECONED_12 = "yyyy-MM-dd hh:mm:ss a";

	/**
	 * <p>Example</p>
	 * <p>当前日期: 2018年7月10日15:04:56</p>
	 * <p>格式化后: 2018-07-10 15:03:48</p>
	 */
	public static final String YMD_DASH_WITH_SECONED_24 = "yyyy-MM-dd HH:mm:ss";

	/**
	 * <p>Example</p>
	 * <p>当前日期: 2018年7月10日15:04:56</p>
	 * <p>格式化后: 20180710150348</p>
	 */
	public static final String YMD_WITH_SECONED_24 = "yyyyMMddHHmmss";

	/**
	 * <p>Example</p>
	 * <p>当前日期: 2018年7月10日15:04:56</p>
	 * <p>格式化后: 20180710</p>
	 */
	public static final String YMD = "yyyyMMdd";

	/**
	 * <p>Example</p>
	 * <p>当前日期: 2018年7月10日15:04:56</p>
	 * <p>格式化后: 20180710</p>
	 */
	public static final String YMD_DASH = "yyyy-MM-dd";

	/**
	 * 获得指定格式当前日期的字符串
	 *
	 * @param format
	 * @return
	 */
	public static String getNowDateString(@NotNull String format) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 日期类型转为字符串
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(@NotNull Date date, @NotNull String format) {
		return dateToLocalDateTime(date).format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 日期类型转为字符串
	 *
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(@NotNull LocalDate date, @NotNull String format) {
		return date.format(DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 字符串转为日期类型
	 *
	 * @param dateString
	 * @param format
	 * @return
	 */
	public static LocalDate stringToLocalDate(@NotNull String dateString, @NotNull String format) {
		return LocalDate.parse(dateString, DateTimeFormatter.ofPattern(format));
	}

	/**
	 * 日期字符串有效性验证
	 * 有效返回转换后的Date对象
	 * 否则返回null
	 *
	 * @param dateStr
	 * @return
	 */
	public static Date dateStrValidator(@NotNull String dateStr) {
		if (StringUtils.isNotBlank(dateStr)) {
			try {
				return DateUtils.parseDate(dateStr, ConstVars.PARSE_PATTERNS);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * {@link java.util.Date} 转换为 {@link java.time.LocalDateTime}
	 *
	 * @param date {@link java.util.Date}
	 * @return
	 */
	public static LocalDateTime dateToLocalDateTime(@NotNull Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		return LocalDateTime.ofInstant(instant, zone);
	}

	/**
	 * {@link java.util.Date} 转换为 {@link java.time.LocalDate}
	 *
	 * @param date {@link java.util.Date}
	 * @return
	 */
	public static LocalDate dateToLocalDate(@NotNull Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return localDateTime.toLocalDate();
	}

	/**
	 * {@link java.util.Date} 转换为 {@link java.time.LocalTime}
	 *
	 * @param date {@link java.util.Date}
	 * @return
	 */
	public static LocalTime dateToLocalTime(@NotNull Date date) {
		Instant instant = date.toInstant();
		ZoneId zone = ZoneId.systemDefault();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
		return localDateTime.toLocalTime();
	}


	/**
	 * {@link java.time.LocalDateTime} 转换为 {@link java.util.Date}
	 *
	 * @param localDateTime {@link java.time.LocalDateTime}
	 * @return
	 */
	public static Date localDateTimeToDate(@NotNull LocalDateTime localDateTime) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		return Date.from(instant);
	}


	/**
	 * {@link java.time.LocalDate} 转换为 {@link java.util.Date}
	 *
	 * @param localDate {@link java.time.LocalDate}
	 * @return
	 */
	public static Date localDateToDate(@NotNull LocalDate localDate) {
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
		return Date.from(instant);
	}

	/**
	 * {@link java.time.LocalDate}{@link java.time.LocalTime} 转换为 {@link java.util.Date}
	 *
	 * @param localDate {@link java.time.LocalDate}
	 * @param localTime {@link java.time.LocalTime}
	 * @return
	 */
	public static Date LocalTimeToDate(@NotNull LocalDate localDate, @NotNull LocalTime localTime) {
		LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
		ZoneId zone = ZoneId.systemDefault();
		Instant instant = localDateTime.atZone(zone).toInstant();
		return Date.from(instant);
	}

	/**
	 * 获取偏移量后的日期
	 *
	 * @param localDate 日期
	 * @param off       偏移量
	 * @param unit      偏移量单位，实现{@link java.time.temporal.TemporalUnit}的类，比如{@link java.time.temporal.ChronoUnit}
	 * @return
	 */
	public static LocalDate offDate(@NotNull LocalDate localDate, @NotNull long off, @NotNull TemporalUnit unit) {
		return localDate.plus(off, unit);
	}
}