package com.xavier.service.impl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.EntInfo;
import com.xavier.bean.keys.StcTracePigMultiKeys;
import com.xavier.bean.stc.StcTracePig;
import com.xavier.common.DateUtil;
import com.xavier.dao.StcTracePigDao;
import com.xavier.service.EntInfoService;
import com.xavier.service.StcTracePigService;
import com.xavier.util.UpdateTool;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class StcTracePigServiceImpl implements StcTracePigService {

	private Logger logger = LoggerFactory.getLogger(StcTracePigService.class);

	@Autowired
	private StcTracePigDao stcTracePigDao;
	@Autowired
	private EntInfoService entInfoService;

	@Override
	@Transactional
	public void save(StcTracePig stcTracePig) {
		if (null != stcTracePig && null != stcTracePig.getStcTracePigMultiKeys()) {
			Optional<StcTracePig> obj = this.stcTracePigDao.findById(stcTracePig.getStcTracePigMultiKeys());
			StcTracePig entity = new StcTracePig();
			UpdateTool.copyNonNullProperties(stcTracePig, entity);
			if (obj.isPresent()) {
				UpdateTool.copyNonNullProperties(obj.get(), entity);
			}
			this.stcTracePigDao.save(entity);
		} else {
			logger.debug("传入无效对象,不进行持久化操作!");
		}
	}

	@Override
	public StcTracePig stcTracePigButcherCollector(List<CanalEntry.Column> afterList) {
		StcTracePig stcTracePig = new StcTracePig();
		StcTracePigMultiKeys stcTracePigMultiKeys = new StcTracePigMultiKeys();
		for (CanalEntry.Column e : afterList) {
			switch (e.getName()) {
				case "entId":
					String entId = e.getValue();
					stcTracePigMultiKeys.setEntId(entId);
					Optional<EntInfo> entInfoOptional = this.entInfoService.searchById(entId);
					if (entInfoOptional.isPresent()) {
						EntInfo entInfo
								= entInfoOptional.get();
						stcTracePigMultiKeys.setProvince(entInfo.getProvince());
						stcTracePigMultiKeys.setCity(entInfo.getCity());
						stcTracePigMultiKeys.setCounty(entInfo.getCounty());
					}
					break;
				case "createDate":
					stcTracePigMultiKeys.setDate(e.getValue());
					break;
				case "total":
					String num = e.getValue();
					if (StringUtils.isNotBlank(num)) {/* Fixed Blank String */
						stcTracePig.setButcherNum(Integer.parseInt(num));
					} else {
						stcTracePig.setButcherNum(0);
					}
					break;
			}
		}
		try {
			Optional<StcTracePig> stcTracePigOptional = this.stcTracePigDao.findById(
					new StcTracePigMultiKeys(
							stcTracePigMultiKeys.getProvince(),
							stcTracePigMultiKeys.getCity(),
							stcTracePigMultiKeys.getCounty(),
							stcTracePigMultiKeys.getEntId(),
							DateUtil.dateToString(
									DateUtil.offDate(DateUtil.stringToLocalDate(stcTracePigMultiKeys.getDate(), DateUtil.YMD_DASH), -1, ChronoUnit.DAYS),
									DateUtil.YMD_DASH
							)
					)
			);
			if (stcTracePigOptional.isPresent()) {
				stcTracePig.preButcherNumCpm(stcTracePigOptional.get().getButcherNum());/* 与上一天比较 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}


		stcTracePig.setStcTracePigMultiKeys(stcTracePigMultiKeys);
		return stcTracePig;
	}

	@Override
	public StcTracePig stcTracePigButcherDeleteCollector(List<CanalEntry.Column> beforeList) {
		StcTracePig stcTracePig = new StcTracePig();
		StcTracePigMultiKeys stcTracePigMultiKeys = new StcTracePigMultiKeys();
		for (CanalEntry.Column e : beforeList) {
			switch (e.getName()) {
				case "entId":
					String entId = e.getValue();
					stcTracePigMultiKeys.setEntId(entId);
					Optional<EntInfo> entInfoOptional = this.entInfoService.searchById(entId);
					if (entInfoOptional.isPresent()) {
						EntInfo entInfo
								= entInfoOptional.get();
						stcTracePigMultiKeys.setProvince(entInfo.getProvince());
						stcTracePigMultiKeys.setCity(entInfo.getCity());
						stcTracePigMultiKeys.setCounty(entInfo.getCounty());
					}
					break;
				case "createDate":
					stcTracePigMultiKeys.setDate(e.getValue());
					break;
			}
		}
		stcTracePig.setStcTracePigMultiKeys(stcTracePigMultiKeys);
		/* 重置屠宰数量与浮动 */
		stcTracePig.setButcherNum(0);
		stcTracePig.setButcherFlag(0);
		return stcTracePig;
	}

	@Override
	public StcTracePig stcTracePigSellCollector(List<CanalEntry.Column> afterList) {
		StcTracePig stcTracePig = new StcTracePig();
		StcTracePigMultiKeys stcTracePigMultiKeys = new StcTracePigMultiKeys();
		for (CanalEntry.Column e : afterList) {
			switch (e.getName()) {
				case "entId":
					String entId = e.getValue();
					stcTracePigMultiKeys.setEntId(entId);
					Optional<EntInfo> entInfoOptional = this.entInfoService.searchById(entId);
					if (entInfoOptional.isPresent()) {
						EntInfo entInfo
								= entInfoOptional.get();
						stcTracePigMultiKeys.setProvince(entInfo.getProvince());
						stcTracePigMultiKeys.setCity(entInfo.getCity());
						stcTracePigMultiKeys.setCounty(entInfo.getCounty());
					}
					break;
				case "outDate":
					stcTracePigMultiKeys.setDate(e.getValue());
					break;
				case "goodsNum":
					String num = e.getValue();
					if (StringUtils.isNotBlank(num)) {/* Fixed Blank String */
						stcTracePig.setSellNum(Integer.parseInt(num));
					} else {
						stcTracePig.setSellNum(0);
					}
					break;
			}
		}
		Optional<StcTracePig> stcTracePigOptional = this.stcTracePigDao.findById(
				new StcTracePigMultiKeys(
						stcTracePigMultiKeys.getProvince(),
						stcTracePigMultiKeys.getCity(),
						stcTracePigMultiKeys.getCounty(),
						stcTracePigMultiKeys.getEntId(),
						DateUtil.dateToString(
								DateUtil.offDate(DateUtil.stringToLocalDate(stcTracePigMultiKeys.getDate(), DateUtil.YMD_DASH), -1, ChronoUnit.DAYS),
								DateUtil.YMD_DASH
						)
				)
		);
		if (stcTracePigOptional.isPresent()) {
			stcTracePig.preSellNumCpm(stcTracePigOptional.get().getSellNum());/* 与上一天比较 */
		}
		stcTracePig.setStcTracePigMultiKeys(stcTracePigMultiKeys);
		return stcTracePig;
	}

	@Override
	public StcTracePig stcTracePigSellDeleteCollector(List<CanalEntry.Column> beforeList) {
		StcTracePig stcTracePig = new StcTracePig();
		StcTracePigMultiKeys stcTracePigMultiKeys = new StcTracePigMultiKeys();
		for (CanalEntry.Column e : beforeList) {
			switch (e.getName()) {
				case "entId":
					String entId = e.getValue();
					stcTracePigMultiKeys.setEntId(entId);
					Optional<EntInfo> entInfoOptional = this.entInfoService.searchById(entId);
					if (entInfoOptional.isPresent()) {
						EntInfo entInfo
								= entInfoOptional.get();
						stcTracePigMultiKeys.setProvince(entInfo.getProvince());
						stcTracePigMultiKeys.setCity(entInfo.getCity());
						stcTracePigMultiKeys.setCounty(entInfo.getCounty());
					}
					break;
				case "createDate":
					stcTracePigMultiKeys.setDate(e.getValue());
					break;
			}
		}
		stcTracePig.setStcTracePigMultiKeys(stcTracePigMultiKeys);
		stcTracePig.setSellNum(0);
		stcTracePig.setSellFlag(0);
		return stcTracePig;
	}
}
