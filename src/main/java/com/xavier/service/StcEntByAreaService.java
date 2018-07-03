package com.xavier.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.stc.StcEntByArea;

import java.util.List;

/**
 * EntByArea统计Service
 *
 * @author NewGr8Player
 */
public interface StcEntByAreaService {

	/**
	 * StcEntByArea保存
	 *
	 * @param stcEntByArea
	 */
	void save(StcEntByArea stcEntByArea);

	/**
	 * stcEntByArea日志相关转换
	 *
	 * @param list
	 * @return
	 */
	StcEntByArea stcEntByAreaCollector(List<CanalEntry.Column> list);
}
