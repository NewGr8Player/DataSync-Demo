package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.Dict;
import com.xavier.bean.EntInfo;
import com.xavier.bean.keys.StcEntByDictMultiKeys;
import com.xavier.bean.stc.StcEntByDict;
import com.xavier.common.ConstVars;
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
				stcEntByDict.setEntNum(1);/* =1 */
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
					&& list.get(i).getValue().contains(ConstVars.ENT_REPATTERNS)) {
				flag = false;
				i = 0;
			}
			if (!flag) {
				switch (list.get(i).getName()) {
					case "tblId":
						Optional<EntInfo> entInfo = this.entInfoService.searchById(list.get(i).getValue());
						if (entInfo.isPresent()) {
							EntInfo entity = entInfo.get();
							multiKeys.setProvince(entity.getProvince());
							multiKeys.setCity(entity.getCity());
							multiKeys.setCounty(entity.getCounty());
							multiKeys.setEntType(entity.getEntTypeCode());
						}
						break;
					case "dicTypeId":
						multiKeys.setDictType(list.get(i).getValue());
						break;
					case "dicInfoCode":
						multiKeys.setDictValue(list.get(i).getValue());
						break;
					case "dicTypeName":
						stcEntByDict.setDictLabel(list.get(i).getValue());
						break;
				}
			}
		}
		String type = multiKeys.getDictType();
		String value = multiKeys.getDictValue();
		Dict dict = this.dictService.searchByValueWithType(type, value);
		stcEntByDict.setDictLabel(dict.getLabel());
		stcEntByDict.setStcEntByDictMultiKeys(multiKeys);
		return stcEntByDict;
	}
}