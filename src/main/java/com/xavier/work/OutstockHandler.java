package com.xavier.work;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.service.StcTracePigService;
import com.xavier.work.base.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OutstockHandler extends AbstractHandler {

	@Autowired
	private StcTracePigService stcTracePigService;

	@Override
	public void onInsert(List<CanalEntry.Column> afterList) {
		this.stcTracePigService.save(this.stcTracePigService.stcTracePigSellCollector(afterList));
	}

	@Override
	public void onUpdate(List<CanalEntry.Column> beforeList, List<CanalEntry.Column> afterList) {
		this.stcTracePigService.save(this.stcTracePigService.stcTracePigSellCollector(afterList));
	}

	@Override
	public void onDelete(List<CanalEntry.Column> beforeList) {
		this.stcTracePigService.save(this.stcTracePigService.stcTracePigSellDeleteCollector(beforeList));
	}
}
