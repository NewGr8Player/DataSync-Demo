package com.xavier.service.impl;

import com.xavier.bean.EntInfo;
import com.xavier.dao.EntInfoDao;
import com.xavier.service.EntByDictService;
import com.xavier.service.EntInfoService;
import com.xavier.util.UpdateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 企业信息Service实现
 *
 * @author NewGr8Player
 */
@Service
public class EntInfoServiceImpl implements EntInfoService {

	private Logger logger = LoggerFactory.getLogger(EntInfoService.class);

	@Autowired
	private EntInfoDao entInfoDao;
	@Autowired
	private EntByDictService entByDictService;

	@Override
	public void save(EntInfo entInfo) {
		if (null != entInfo && null != entInfo.getId()) {
			//TODO Spring-Data-JPA 无法忽略null值进行Insert或者Update
			Optional<EntInfo> obj = entInfoDao.findById(entInfo.getId());
			EntInfo entity = new EntInfo();
			UpdateTool.copyNonNullProperties(entInfo, entity);
			if (obj.isPresent()) {
				UpdateTool.copyNonNullProperties(obj.get(), entity);
			} else {
				//TODO 验证并保存相关数据
				entByDictService.validAndSave(
						entity.getProvince(),
						entity.getCity(),
						entity.getCounty(),
						entity.getEntTypeCode(),
						"",
						"",
						"",
						0
				);
			}
			this.entInfoDao.save(entity);
		} else {
			logger.info("传入无效对象,不进行持久化操作!");
		}

	}

	@Override
	public void deleteById(String id) {
		this.entInfoDao.deleteById(id);
	}
}
