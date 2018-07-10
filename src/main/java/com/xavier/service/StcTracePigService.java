package com.xavier.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.stc.StcTracePig;

import java.util.List;

/**
 * StcEntByTrace统计
 *
 * @author NewGr8Player
 */
public interface StcTracePigService {

	/**
	 * 保存
	 *
	 * @param stcTracePig
	 */
	void save(StcTracePig stcTracePig);

	/**
	 * stcTracePig新增相关日志转换
	 *
	 * @param afterList 新增结果
	 * @return
	 */
	StcTracePig stcTracePigButcherCollector(List<CanalEntry.Column> afterList);

	/**
	 * stcTracePig删除相关日志转换
	 *
	 * @param beforeList 删除前
	 * @return
	 */
	StcTracePig stcTracePigButcherDeleteCollector(List<CanalEntry.Column> beforeList);

	/**
	 * stcTracePig新增相关日志转换
	 *
	 * @param afterList 新增结果
	 * @return
	 */
	StcTracePig stcTracePigSellCollector(List<CanalEntry.Column> afterList);

	/**
	 * stcTracePig删除相关日志转换
	 *
	 * @param beforeList 删除前
	 * @return
	 */
	StcTracePig stcTracePigSellDeleteCollector(List<CanalEntry.Column> beforeList);
}
