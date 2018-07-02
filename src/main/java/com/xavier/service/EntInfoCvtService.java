package com.xavier.service;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.EntInfo;

import java.util.List;

/**
 * 企业信息日志数据转换为JavaBean
 *
 * @author NewGr8Player
 */
public interface EntInfoCvtService {
	/**
	 * d_ent_info日志转换成bean
	 *
	 * @param list
	 * @return
	 */
	EntInfo entInfoCollector(List<CanalEntry.Column> list);

	/**
	 * sys_map日志转换成bean
	 *
	 * @param list
	 * @return
	 */
	EntInfo pozMapCollector(List<CanalEntry.Column> list);

	/**
	 * d_address_info日志转成bean
	 *
	 * @param list
	 * @return
	 */
	EntInfo addressInfoCollector(List<CanalEntry.Column> list);
}
