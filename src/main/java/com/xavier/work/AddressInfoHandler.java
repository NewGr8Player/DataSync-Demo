package com.xavier.work;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.service.EntInfoService;
import com.xavier.work.base.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 地址信息处理
 *
 * @author NewGr8Player
 */
@Component
public class AddressInfoHandler extends AbstractHandler {

	@Autowired
	private EntInfoService entInfoService;

	@Override
	public void onInsert(List<CanalEntry.Column> afterList) {
		this.entInfoService.save(this.entInfoService.addressInfoCollector(afterList));
	}

	@Override
	public void onUpdate(List<CanalEntry.Column> beforeList, List<CanalEntry.Column> afterList) {
		this.entInfoService.save(this.entInfoService.addressInfoCollector(afterList));
	}

	@Override
	public void onDelete(List<CanalEntry.Column> beforeList) {
		//TODO 从表被删除是否处理?
	}
}
