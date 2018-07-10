package com.xavier.service.impl;

import com.xavier.bean.Dict;
import com.xavier.dao.DictDao;
import com.xavier.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 字典项Service实现
 *
 * @author NewGr8Player
 */
@Service
public class DictServiceImpl implements DictService {

	@Autowired
	private DictDao dictDao;

	@Override
	@Cacheable(value = "dict")
	public Dict searchByValueWithType(String type, String value) {
		return this.dictDao.searchByValueWithType(type, value);
	}
}
