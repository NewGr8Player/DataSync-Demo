package com.xavier.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.starter.canal.annotation.CanalEventListener;
import com.xavier.starter.canal.annotation.ListenPoint;
import com.xavier.work.EntInfoHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注解方式
 *
 * @author FengZeming
 */
@CanalEventListener
public class EntInfoListener {

	@Autowired
	private EntInfoHandler entInfoHandler;

	@ListenPoint(destination = "example", schema = "testa", table = {"d_ent_info"})
	public void entInfoListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		if (CanalEntry.EventType.UPDATE.equals(eventType)) {
			entInfoHandler.onUpdate(rowData.getBeforeColumnsList(), rowData.getAfterColumnsList());
		} else if (CanalEntry.EventType.INSERT.equals(eventType)) {
			entInfoHandler.onInsert(rowData.getAfterColumnsList());
		} else {
			entInfoHandler.onDelete(rowData.getBeforeColumnsList());
		}
	}
}
