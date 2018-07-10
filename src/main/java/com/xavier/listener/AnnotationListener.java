package com.xavier.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.starter.canal.annotation.CanalEventListener;
import com.xavier.starter.canal.annotation.ListenPoint;
import com.xavier.work.AddressInfoHandler;
import com.xavier.work.EntInfoHandler;
import com.xavier.work.MapHandler;
import com.xavier.work.TblDicLHandler;
import com.xavier.work.base.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 注解方式
 *
 * @author FengZeming
 */
@CanalEventListener
public class AnnotationListener {

	@Autowired
	private EntInfoHandler entInfoHandler;
	@Autowired
	private MapHandler mapHandler;
	@Autowired
	private AddressInfoHandler addressInfoHandler;
	@Autowired
	private TblDicLHandler tblDicLHandler;

	@ListenPoint(destination = "example", schema = "testa", table = "d_ent_info")
	public void entInfoListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		listenerTask(entInfoHandler, eventType, rowData);
	}

	@ListenPoint(destination = "example", schema = "testa", table = "d_address_info")
	public void addressInfoListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		listenerTask(addressInfoHandler, eventType, rowData);
	}

	@ListenPoint(destination = "example", schema = "testa", table = "sys_map")
	public void mapListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		listenerTask(mapHandler, eventType, rowData);
	}

	@ListenPoint(destination = "example", schema = "testa", table = "d_tbl_dic")
	public void tblDicListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		listenerTask(tblDicLHandler, eventType, rowData);
	}

	@ListenPoint(destination = "example", schema = "testa", table = "d_register_info")
	public void registerInfoListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		listenerTask(tblDicLHandler, eventType, rowData);
	}

	@ListenPoint(destination = "example", schema = "testa", table = "d_outstock")
	public void outstockListener(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		listenerTask(tblDicLHandler, eventType, rowData);
	}

	/**
	 * 公用处理方法
	 *
	 * @param service
	 * @param eventType
	 * @param rowData
	 */
	private void listenerTask(AbstractHandler service, CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
		if (CanalEntry.EventType.UPDATE.equals(eventType)) {
			service.onUpdate(rowData.getBeforeColumnsList(), rowData.getAfterColumnsList());
		} else if (CanalEntry.EventType.INSERT.equals(eventType)) {
			service.onInsert(rowData.getAfterColumnsList());
		} else {
			service.onDelete(rowData.getBeforeColumnsList());
		}
	}
}
