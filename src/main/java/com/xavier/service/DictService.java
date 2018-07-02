package com.xavier.service;

import com.xavier.bean.Dict;

/**
 * 字典项Service
 *
 * @author NewGr8Player
 */
public interface DictService {

	/**
	 * 根据Type 与 Value查询
	 * 首次查询使用数据库，第二次使用缓存
	 *
	 * @param type
	 * @param value
	 * @return
	 */
	Dict searchByValueWithType(String type, String value);
}
