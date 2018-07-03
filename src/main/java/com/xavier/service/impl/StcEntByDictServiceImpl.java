package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.Dict;
import com.xavier.bean.EntInfo;
import com.xavier.bean.keys.StcEntByDictMultiKeys;
import com.xavier.bean.stc.StcEntByDict;
import com.xavier.dao.StcEntByDictDao;
import com.xavier.service.DictService;
import com.xavier.service.EntInfoService;
import com.xavier.service.StcEntByDictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EntByDictService实现
 *
 * @author NewGr8Player
 */
@Service
public class StcEntByDictServiceImpl implements StcEntByDictService {

	private Logger logger = LoggerFactory.getLogger(StcEntByDictService.class);

	@Autowired
	private StcEntByDictDao stcEntByDictDao;
	@Autowired
	private EntInfoService entInfoService;
	@Autowired
	private DictService dictService;

	@Override
	public void save(StcEntByDict stcEntByDict) {
		if (null != stcEntByDict && null != stcEntByDict.getStcEntByDictMultiKeys()) {
			Optional<StcEntByDict> obj = this.stcEntByDictDao.findById(stcEntByDict.getStcEntByDictMultiKeys());
			if (obj.isPresent()) {
				stcEntByDict = obj.get();
				stcEntByDict.incEnt_num(1);/* +1 */
			} else {
				stcEntByDict.setEnt_num(1);/* =1 */
			}
			this.stcEntByDictDao.save(stcEntByDict);
		} else {
			logger.debug("传入无效对象,不进行持久化操作!");
		}
	}

	@Override
	public StcEntByDict stcEntByDictCollector(List<CanalEntry.Column> list) {
		StcEntByDict stcEntByDict = new StcEntByDict();
		StcEntByDictMultiKeys multiKeys = new StcEntByDictMultiKeys();
		int length = list.size();
		boolean flag = true;
		for (int i = 0; i < length; i++) {
			if (flag && "tblName".equals(list.get(i).getName())
					&& list.get(i).getValue().contains("d_ent")) {
				flag = false;
				i = 0;
			}
			if (!flag) {
				switch (list.get(i).getName()) {
					case "tblId":
						Optional<EntInfo> entInfo = this.entInfoService.findById(list.get(i).getValue());
						if (entInfo.isPresent()) {
							EntInfo entity = entInfo.get();
							multiKeys.setProvince(entity.getProvince());
							multiKeys.setCity(entity.getCity());
							multiKeys.setCounty(entity.getCounty());
							multiKeys.setEnt_type(entity.getEntTypeCode());
						}
						break;
					case "dicTypeId":
						multiKeys.setDict_type(list.get(i).getValue());
						break;
					case "dicInfoCode":
						multiKeys.setDict_value(list.get(i).getValue());
						break;
					case "dicTypeName":
						stcEntByDict.setDict_label(list.get(i).getValue());
						break;
				}
			}
		}
		String type = multiKeys.getDict_type();
		String value = multiKeys.getDict_value();
		Dict dict = this.dictService.searchByValueWithType(type, value);
		stcEntByDict.setDict_label(dict.getLabel());
		stcEntByDict.setStcEntByDictMultiKeys(multiKeys);
		return stcEntByDict;
	}
}