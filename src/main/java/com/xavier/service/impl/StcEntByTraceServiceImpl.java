package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.EntButcher;
import com.xavier.bean.EntInfo;
import com.xavier.bean.keys.StcEntByTraceMultiKeys;
import com.xavier.bean.stc.StcEntByTrace;
import com.xavier.common.ConstVars;
import com.xavier.dao.StcEntByTraceDao;
import com.xavier.service.EntButcherService;
import com.xavier.service.EntInfoService;
import com.xavier.service.StcEntByTraceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * StcEntByTraceService实现
 *
 * @author NewGr8Player
 */
@Service
@Transactional(readOnly = true)
public class StcEntByTraceServiceImpl implements StcEntByTraceService {

	private Logger logger = LoggerFactory.getLogger(StcEntByTraceService.class);

	@Autowired
	private StcEntByTraceDao stcEntByTraceDao;
	@Autowired
	private EntInfoService entInfoService;
	@Autowired
	private EntButcherService entButcherService;

	@Override
	@Transactional
	public void save(StcEntByTrace stcEntByTrace) {
		if (null != stcEntByTrace && null != stcEntByTrace.getStcEntByTraceMultiKeys()) {
			Optional<StcEntByTrace> obj = this.stcEntByTraceDao.findById(stcEntByTrace.getStcEntByTraceMultiKeys());
			if (obj.isPresent()) {
				stcEntByTrace = obj.get();
				stcEntByTrace.incEnt_num(1);/* +1 */
			} else {
				stcEntByTrace.setEntNum(1);/* =1 */
			}
			this.stcEntByTraceDao.save(stcEntByTrace);
		} else {
			logger.debug("传入无效对象,不进行持久化操作!");
		}
	}

	@Override
	public StcEntByTrace stcEntByTraceCollector(List<CanalEntry.Column> list) {
		StcEntByTrace stcEntByArea = new StcEntByTrace();
		StcEntByTraceMultiKeys stcEntByTraceMultiKeys = new StcEntByTraceMultiKeys();
		int length = list.size();
		boolean flag = true;
		for (int i = 0; i < length; i++) {
			if (flag && "tblName".equals(list.get(i).getName())
					&& list.get(i).getValue().contains(ConstVars.ENT_BUTCHER)) {
				flag = false;
				i = 0;
			}
			if (!flag) {
				switch (list.get(i).getName()) {
					case "tblId":
						Optional<EntInfo> entInfoOptional = this.entInfoService.searchById(list.get(i).getValue());
						Optional<EntButcher> entButcherOptional = this.entButcherService.findById(list.get(i).getValue());
						if (entInfoOptional.isPresent() && entButcherOptional.isPresent()) {
							EntInfo entInfo = entInfoOptional.get();
							stcEntByTraceMultiKeys.setProvince(entInfo.getProvince());
							stcEntByTraceMultiKeys.setCity(entInfo.getCity());
							stcEntByTraceMultiKeys.setCounty(entInfo.getCounty());
							stcEntByTraceMultiKeys.setPromoteStatus(entInfo.getPromoteStatus());
							EntButcher entButcher = entButcherOptional.get();
							stcEntByTraceMultiKeys.setEntGrade(entButcher.getGrade());
						}
						break;
					case "dicInfoCode":
						stcEntByTraceMultiKeys.setButcherType(list.get(i).getValue());
						break;
				}
			}
		}
		stcEntByArea.setStcEntByTraceMultiKeys(stcEntByTraceMultiKeys);
		return stcEntByArea;
	}
}
