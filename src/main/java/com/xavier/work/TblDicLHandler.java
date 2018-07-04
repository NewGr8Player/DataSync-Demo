package com.xavier.work;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xavier.bean.stc.StcEntByTrace;
import com.xavier.service.StcEntByAreaService;
import com.xavier.service.StcEntByDictService;
import com.xavier.service.StcEntByTraceService;
import com.xavier.work.base.AbstractHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * tblDic表内内容处理
 *
 * @author NewGr8Player
 */
@Component
public class TblDicLHandler extends AbstractHandler {

	@Autowired
	private StcEntByAreaService stcEntByAreaService;
	@Autowired
	private StcEntByDictService stcEntByDictService;
	@Autowired
	private StcEntByTraceService stcEntByTraceService;

	@Override
	public void onInsert(List<CanalEntry.Column> afterList) {
		this.stcEntByDictService.save(this.stcEntByDictService.stcEntByDictCollector(afterList));
		this.stcEntByAreaService.save(this.stcEntByAreaService.stcEntByAreaCollector(afterList));
		this.stcEntByTraceService.save(this.stcEntByTraceService.StcEntByTraceCollector(afterList));
	}

	@Override
	public void onUpdate(List<CanalEntry.Column> beforeList, List<CanalEntry.Column> afterList) {
		this.stcEntByDictService.save(this.stcEntByDictService.stcEntByDictCollector(afterList));
		this.stcEntByAreaService.save(this.stcEntByAreaService.stcEntByAreaCollector(afterList));
		this.stcEntByTraceService.save(this.stcEntByTraceService.StcEntByTraceCollector(afterList));
	}

	@Override
	public void onDelete(List<CanalEntry.Column> beforeList) {
		//TODO 表被删除是否处理?
	}
}