package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.EntInfo;
import com.xavier.service.DictService;
import com.xavier.service.EntInfoCvtService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 企业信息日志数据转换为JavaBean
 *
 * @author NewGr8Player
 */
@Service
public class EntInfoCvtServiceImpl implements EntInfoCvtService {

	/* 日期转换出错则使用null值填充，即不更新表中字段 */
	public static final String[] parsePatterns = {"yyyy-MM-dd",
			"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd",
			"yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};


	public static final String ENT_TYPE = "entType";/* 企业类型字典项Type */
	public static final String ENT_STATE = "entState";/* 企业状态字典项Type */
	public static final String ENT_INFO_SOURCE_TABLE = "d_ent_info";/* 数据来源表名 */

	@Autowired
	private DictService dictService;

	public EntInfo entInfoCollector(List<CanalEntry.Column> list) {
		//TODO 改为读取配置模式进行信息采集映射

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
					entInfo.setEntTypeName(dictService.searchByValueWithType(ENT_TYPE, e.getValue()).getLabel());/* 行业门类Label */
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
					entInfo.setStateTypeName(dictService.searchByValueWithType(ENT_STATE, e.getValue()).getLabel());/* 企业状态Label */
					break;
				case "promoteStatus":
					entInfo.setPromoteStatus(Integer.parseInt(e.getValue()));
					break;
				case "researchDate":
					entInfo.setResearchDate(dateStrValidator(e.getValue()));
					break;
				case "promoteDate":
					entInfo.setPromoteDate(dateStrValidator(e.getValue()));
					break;
				case "buildDate":
					entInfo.setBuildDate(dateStrValidator(e.getValue()));
					break;
				/* 以下为系统字段 */
				case "createId":
					entInfo.setCreateBy(e.getValue());
					break;
				case "createDate":
					entInfo.setCreateDate(dateStrValidator(e.getValue()));
					break;
				case "operId":
					entInfo.setUpdateBy(e.getValue());
					break;
				case "operDate":
					entInfo.setUpdateDate(dateStrValidator(e.getValue()));
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
					&& ENT_INFO_SOURCE_TABLE.equals(list.get(i).getValue())) {
				flag = false;
				i = 0;
			}
			if(!flag){
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
					&& ENT_INFO_SOURCE_TABLE.equals(list.get(i).getValue())) {
				flag = false;
				i = 0;
			}
			if(!flag){
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
					case "country":
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

	/**
	 * 日期字符串有效性验证
	 * 有效返回转换后的Date对象
	 * 否则返回null
	 *
	 * @param dateStr
	 * @return
	 */
	private Date dateStrValidator(String dateStr) {
		if (StringUtils.isNotBlank(dateStr)) {
			try {
				return DateUtils.parseDate(dateStr, parsePatterns);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}
}