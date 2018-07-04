package com.xavier.service;


import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.EntInfo;

import java.util.List;
import java.util.Optional;

/**
 * 企业信息Service
 *
 * @author NewGr8Player
 */
public interface EntInfoService {
	/**
	 * 保存
	 *
	 * @param entInfo
	 */
	void save(EntInfo entInfo);

	/**
	 * 根据id查询
	 *
	 * @param id
	 */
	Optional<EntInfo> searchById(String id);

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
