package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.EntInfo;
import com.xavier.common.ConstVars;
import com.xavier.common.DateUtil;
import com.xavier.dao.EntInfoDao;
import com.xavier.service.DictService;
import com.xavier.service.EntInfoService;
import com.xavier.util.UpdateTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
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
	private DictService dictService;

	@Override
	public void save(EntInfo entInfo) {
		if (null != entInfo && null != entInfo.getId()) {
			Optional<EntInfo> obj = this.entInfoDao.findById(entInfo.getId());
			EntInfo entity = new EntInfo();
			UpdateTool.copyNonNullProperties(entInfo, entity);
			if (obj.isPresent()) {
				UpdateTool.copyNonNullProperties(obj.get(), entity);
			}
			this.entInfoDao.save(entity);
		} else {
			logger.debug("传入无效对象,不进行持久化操作!");
		}
	}

	@Override
	public Optional<EntInfo> searchById(String id) {
		return this.entInfoDao.findById(id);
	}

	@Override
	public EntInfo entInfoCollector(List<CanalEntry.Column> list) {
		EntInfo entInfo = new EntInfo();
		for (CanalEntry.Column e : list) {
			switch (e.getName()) {
				case "id":
					entInfo.setId(e.getValue());
					break;
				case "entNo":
					entInfo.setEntNo(e.getValue());
					break;
				case "cardNo":
					entInfo.setCardNo(e.getValue());
					break;
				case "entName":
					entInfo.setEntName(e.getValue());
					break;
				case "entType":
					entInfo.setEntTypeCode(e.getValue());/* 行业门类Code */
					entInfo.setEntTypeName(dictService.searchByValueWithType(ConstVars.ENT_TYPE, e.getValue()).getLabel());/* 行业门类Label */
					break;
				case "legalPerson":
					entInfo.setLegalPerson(e.getValue());
					break;
				case "telephone":
					entInfo.setTelephone(e.getValue());
					break;
				case "otherPerson":
					entInfo.setOtherPerson(e.getValue());
					break;
				case "otherTelephone":
					entInfo.setOtherTelephone(e.getValue());
					break;
				case "idCard":
					entInfo.setIdcard(e.getValue());
					break;
				case "supervision":
					entInfo.setSupervision(e.getValue());
					break;
				case "entState":
					entInfo.setStateTypeCode(e.getValue());/* 企业状态Code */
					entInfo.setStateTypeName(dictService.searchByValueWithType(ConstVars.ENT_STATE, e.getValue()).getLabel());/* 企业状态Label */
					break;
				case "promoteStatus":
					entInfo.setPromoteStatus(Integer.parseInt(e.getValue()));
					break;
				case "researchDate":
					entInfo.setResearchDate(DateUtil.dateStrValidator(e.getValue()));
					break;
				case "promoteDate":
					entInfo.setPromoteDate(DateUtil.dateStrValidator(e.getValue()));
					break;
				case "buildDate":
					entInfo.setBuildDate(DateUtil.dateStrValidator(e.getValue()));
					break;
				/* 以下为系统字段 */
				case "createId":
					entInfo.setCreateBy(e.getValue());
					break;
				case "createDate":
					entInfo.setCreateDate(DateUtil.dateStrValidator(e.getValue()));
					break;
				case "operId":
					entInfo.setUpdateBy(e.getValue());
					break;
				case "operDate":
					entInfo.setUpdateDate(DateUtil.dateStrValidator(e.getValue()));
					break;
				case "sortId":
					entInfo.setSort(Integer.parseInt(e.getValue()));
					break;
				case "status":
					entInfo.setStatus(Integer.parseInt(e.getValue()));
					break;
			}
		}
		return entInfo;
	}

	@Override
	public EntInfo pozMapCollector(List<CanalEntry.Column> list) {
		EntInfo entInfo = new EntInfo();
		int length = list.size();
		boolean flag = true;
		for (int i = 0; i < length; i++) {
			if (flag && "tblName".equals(list.get(i).getName())
					&& ConstVars.ENT_INFO_SOURCE_TABLE.equals(list.get(i).getValue())) {
				flag = false;
				i = 0;
			}
			if (!flag) {
				switch (list.get(i).getName()) {
					case "tblId":
						entInfo.setId(list.get(i).getValue());
						break;
					case "pointX":
						entInfo.setLng(list.get(i).getValue());
						break;
					case "pointY":
						entInfo.setLat(list.get(i).getValue());
						break;
				}
			}
		}
		return entInfo;
	}

	@Override
	public EntInfo addressInfoCollector(List<CanalEntry.Column> list) {
		EntInfo entInfo = new EntInfo();
		int length = list.size();
		boolean flag = true;
		for (int i = 0; i < length; i++) {
			if (flag && "tblName".equals(list.get(i).getName())
					&& ConstVars.ENT_INFO_SOURCE_TABLE.equals(list.get(i).getValue())) {
				flag = false;
				i = 0;
			}
			if (!flag) {
				switch (list.get(i).getName()) {
					case "tblId":
						entInfo.setId(list.get(i).getValue());
						break;
					case "province":
						entInfo.setProvince(list.get(i).getValue());
						break;
					case "city":
						entInfo.setCity(list.get(i).getValue());
						break;
					case "county":
						entInfo.setCounty(list.get(i).getValue());
						break;
					case "detail":
						entInfo.setDetail(list.get(i).getValue());
						break;
				}
			}

		}
		return entInfo;
	}
}
