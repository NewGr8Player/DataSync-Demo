package com.xavier.work.base;

import java.util.List;
import com.alibaba.otter.canal.protocol.CanalEntry.Column;
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
