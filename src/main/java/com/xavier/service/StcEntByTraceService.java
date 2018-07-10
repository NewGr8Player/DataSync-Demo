package com.xavier.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.stc.StcEntByTrace;

import java.util.List;

/**
 * StcEntByTrace统计
 *
 * @author NewGr8Player
 */
public interface StcEntByTraceService {

	/**
	 * 保存
	 *
	 * @param stcEntByTrace
	 */
	void save(StcEntByTrace stcEntByTrace);

	/**
	 * stcEntByTrace相关日志转换
	 *
	 * @param list
	 * @return
	 */
	StcEntByTrace stcEntByTraceCollector(List<CanalEntry.Column> list);
}
