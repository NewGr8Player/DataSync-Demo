package com.xavier.work.base;

import com.alibaba.otter.canal.protocol.CanalEntry.Column;

import java.util.List;

/**
 * 通用数据库事件处理类
 *
 * @author NewGr8Player
 */
public abstract class AbstractHandler {
	/**
	 * 插入处理
	 *
	 * @param afterList
	 */
	public abstract void onInsert(List<Column> afterList);

	/**
	 * 更新处理
	 *
	 * @param beforeList
	 * @param afterList
	 */
	public abstract void onUpdate(List<Column> beforeList, List<Column> afterList);

	/**
	 * 删除处理
	 *
	 * @param beforeList
	 */
	public abstract void onDelete(List<Column> beforeList);
}
