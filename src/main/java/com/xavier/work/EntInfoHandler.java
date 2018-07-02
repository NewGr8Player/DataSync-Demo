package com.xavier.work;

import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.xavier.service.EntInfoCvtService;
import com.xavier.service.EntInfoService;
import com.xavier.work.base.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 企业信息处理
 *
 * @author NewGr8Player
 */
@Component
public class EntInfoHandler extends AbstractHandler {

	@Autowired
	private EntInfoService entInfoService;
	@Autowired
	private EntInfoCvtService entInfoCvtService;

	@Override
	public void onInsert(List<Column> afterList) {
		this.entInfoService.save(entInfoCvtService.entInfoCollector(afterList));
	}

	@Override
	public void onUpdate(List<Column> beforeList, List<Column> afterList) {
		this.entInfoService.save(entInfoCvtService.entInfoCollector(afterList));
	}

	@Override
	public void onDelete(List<Column> beforeList) {
		//TODO 删除不应当删除主记录 considering about logic delete
	}
}
