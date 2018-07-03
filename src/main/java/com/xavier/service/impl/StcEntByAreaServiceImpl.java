package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.EntInfo;
import com.xavier.bean.keys.StcEntByAreaMultiKeys;
import com.xavier.bean.stc.StcEntByArea;
import com.xavier.dao.StcEntByAreaDao;
import com.xavier.service.EntInfoService;
import com.xavier.service.StcEntByAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EntByAreaService实现
 *
 * @author NewGr8Player
 */
@Service
public class StcEntByAreaServiceImpl implements StcEntByAreaService {

	private Logger logger = LoggerFactory.getLogger(StcEntByAreaService.class);

	@Autowired
	private EntInfoService entInfoService;
	@Autowired
	private StcEntByAreaDao stcEntByAreaDao;

	@Override
	public void save(StcEntByArea stcEntByArea) {
		if (null != stcEntByArea && null != stcEntByArea.getStcEntByAreaMultiKeys()) {
			Optional<StcEntByArea> obj = this.stcEntByAreaDao.findById(stcEntByArea.getStcEntByAreaMultiKeys());
			if (obj.isPresent()) {
				stcEntByArea = obj.get();
				stcEntByArea.incEnt_num(1);/* +1 */
			} else {
				stcEntByArea.setEnt_num(1);/* =1 */
			}
			this.stcEntByAreaDao.save(stcEntByArea);
		} else {
			logger.debug("传入无效对象,不进行持久化操作!");
		}
	}

	@Override
	public StcEntByArea stcEntByAreaCollector(List<CanalEntry.Column> list) {
		StcEntByArea stcEntByArea = new StcEntByArea();
		StcEntByAreaMultiKeys multiKeys = new StcEntByAreaMultiKeys();
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
				}
			}
		}
		stcEntByArea.setStcEntByAreaMultiKeys(multiKeys);
		return stcEntByArea;
	}
}
