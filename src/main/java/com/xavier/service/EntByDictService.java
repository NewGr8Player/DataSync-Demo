package com.xavier.service;

import com.xavier.bean.stc.EntByDict;

public interface EntByDictService {
	/**
	 * EntByDict新增
	 *
	 * @param entByDict
	 */
	void save(EntByDict entByDict);

	/**
	 * 验证各项的值,符合要求后保存
	 *
	 * @param province
	 * @param city
	 * @param county
	 * @param ent_type
	 * @param dict_type
	 * @param dict_value
	 * @param dict_label
	 * @param ent_num
	 * @return
	 */
	String validAndSave(
			String province,
			String city,
			String county,
			String ent_type,
			String dict_type,
			String dict_value,
			String dict_label,
			Integer ent_num
	);
}
