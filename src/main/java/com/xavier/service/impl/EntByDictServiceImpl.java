package com.xavier.service.impl;

import com.xavier.bean.stc.EntByDict;
import com.xavier.dao.EntByDictDao;
import com.xavier.service.EntByDictService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntByDictServiceImpl implements EntByDictService {

	@Autowired
	private EntByDictDao entByDictDao;

	@Override
	public void save(EntByDict entByDict) {
		this.entByDictDao.save(entByDict);
	}

	@Override
	public String validAndSave(String province, String city, String county, String ent_type, String dict_type, String dict_value, String dict_label, Integer ent_num) {
		StringBuffer msg = new StringBuffer();
		if (StringUtils.isNotBlank(province)) {
			msg.append("province不能为空。\n");
		}
		if (StringUtils.isNotBlank(city)) {
			msg.append("city。\n");
		}
		if (StringUtils.isNotBlank(county)) {
			msg.append("county不能为空。\n");
		}
		if (StringUtils.isNotBlank(ent_type)) {
			msg.append("ent_type不能为空。\n");
		}
		if (StringUtils.isNotBlank(dict_type)) {
			msg.append("dict_type不能为空。\n");
		}
		if (StringUtils.isNotBlank(dict_value)) {
			msg.append("dict_value不能为空。\n");
		}
		EntByDict entByDict = new EntByDict(province, city, county, ent_type, dict_type, dict_value, dict_label, ent_num);
		return msg.toString();
	}
}