package com.xavier.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.stc.StcEntByDict;

import java.util.List;

/**
 * StcEntByDict统计
 *
 * @author NewGr8Player
 */
public interface StcEntByDictService {
	/**
	 * StcEntByDict新增
	 *
	 * @param stcEntByDict
	 */
	void save(StcEntByDict stcEntByDict);

	/**
	 * stcEntByDict相关日志转换
	 *
	 * @param list
	 * @return
	 */
	StcEntByDict stcEntByDictCollector(List<CanalEntry.Column> list);
}
