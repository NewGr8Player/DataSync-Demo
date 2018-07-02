package com.xavier.service.impl;

import com.xavier.bean.EntInfo;
import com.xavier.dao.EntInfoDao;
import com.xavier.service.EntInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 企业信息Service实现
 *
 * @author NewGr8Player
 */
@Service
public class EntInfoServiceImpl implements EntInfoService {

	@Autowired
	private EntInfoDao entInfoDao;

	@Override
	public void save(EntInfo entInfo) {
		this.entInfoDao.save(entInfo);
	}

	@Override
	public void deleteById(String id) {
		this.entInfoDao.deleteById(id);
	}
}
